package com.example.nikhil.digits;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.raed.drawingview.DrawingView;
import com.raed.drawingview.brushes.BrushSettings;
import com.raed.drawingview.brushes.Brushes;

import java.io.ByteArrayOutputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

public class DrawActivity extends AppCompatActivity {
    DrawingView drawView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
       drawView=(DrawingView) findViewById(R.id.draw_view);
        BrushSettings brushSettings = drawView.getBrushSettings();

//Change the selected brush
        brushSettings.setSelectedBrush(Brushes.PEN);

//Set the size for the pencil, pass a value between 0 and 1
        brushSettings.setSelectedBrushSize(0.3f);

//Change the color for all brushes
        brushSettings.setColor(0xFF000000);
        button=findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = drawView.exportDrawing();


                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();


                Intent in = new Intent(DrawActivity.this,ResultActivity.class);
                in.putExtra("image",byteArray);

                startActivity(in);

            }
        });
    }
}
