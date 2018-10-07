package com.example.nikhil.digits;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.divyanshu.draw.widget.DrawView;

public class DrawActivity extends AppCompatActivity {
    DrawView drawView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        drawView=findViewById(R.id.draw_view);
        drawView.setStrokeWidth(20);
        drawView.setColor(getResources().getColor(R.color.color_blue));


        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DrawActivity.this,MainActivity.class));

            }
        });
    }
}
