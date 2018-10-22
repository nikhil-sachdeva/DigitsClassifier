package com.example.nikhil.digitsv2;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.raed.drawingview.DrawingView;
import com.raed.drawingview.brushes.BrushSettings;
import com.raed.drawingview.brushes.Brushes;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    DrawingView drawView;
    Button button;
    TextView result,pred;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawView=findViewById(R.id.draw_view);
        button=findViewById(R.id.button);
        result=findViewById(R.id.result);
        pred=findViewById(R.id.pred);
        imageView=findViewById(R.id.imageView);


        BrushSettings brushSettings = drawView.getBrushSettings();
        brushSettings.setSelectedBrush(Brushes.PEN);
        brushSettings.setSelectedBrushSize(0.3f);
        brushSettings.setColor(0xFF000000);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap=drawView.exportDrawing();
                try {
                    ImageClassifier imageClassifier = new ImageClassifier(MainActivity.this);
                    String ans = imageClassifier.classifyFrame(bitmap);
                    result.setText(ans);
                    pred.setText("The figure you drew was closest to : "+ans.substring(1,2));
                    imageView.setImageBitmap(bitmap);
                    drawView.clear();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });



    }
}
