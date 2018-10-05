package com.example.nikhil.digits;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.divyanshu.draw.widget.DrawView;

public class DrawActivity extends AppCompatActivity {
    DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        drawView=findViewById(R.id.draw_view);
        drawView.setStrokeWidth(20);
        drawView.setColor(getResources().getColor(R.color.color_blue));

    }
}
