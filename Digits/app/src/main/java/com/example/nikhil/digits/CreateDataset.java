package com.example.nikhil.digits;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikhil.digits.Utils.SaveImage;
import com.raed.drawingview.DrawingView;
import com.raed.drawingview.brushes.BrushSettings;
import com.raed.drawingview.brushes.Brushes;

import java.util.Random;

public class CreateDataset extends AppCompatActivity {
    private static final String TAG = "wow";
    DrawingView draw_digits;
    Button  zero,one,two,three,four,five,six,seven,eight,nine;
    int n = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_dataset);
        draw_digits=findViewById(R.id.draw_digits);
        BrushSettings brushSettings = draw_digits.getBrushSettings();

        brushSettings.setSelectedBrush(Brushes.PEN);


        brushSettings.setSelectedBrushSize(0.3f);

        brushSettings.setColor(0xFF000000);

        String root = Environment.getExternalStorageDirectory().toString();
        Random generator = new Random();
        one = findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        zero=findViewById(R.id.zero);





        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               SaveImage saveImage = new SaveImage();
                Bitmap bm = draw_digits.exportDrawing();
               saveImage.saveDigitImage("One",1,bm);
                draw_digits.clear();
                Toast.makeText(CreateDataset.this, "Digit saved", Toast.LENGTH_SHORT).show();
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveImage saveImage = new SaveImage();
                Bitmap bm = draw_digits.exportDrawing();
                saveImage.saveDigitImage("Two",2,bm);
                draw_digits.clear();
                Toast.makeText(CreateDataset.this, "Digit saved", Toast.LENGTH_SHORT).show();
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveImage saveImage = new SaveImage();
                Bitmap bm = draw_digits.exportDrawing();
                saveImage.saveDigitImage("Three",3,bm);
                draw_digits.clear();
                Toast.makeText(CreateDataset.this, "Digit saved", Toast.LENGTH_SHORT).show();
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveImage saveImage = new SaveImage();
                Bitmap bm = draw_digits.exportDrawing();
                saveImage.saveDigitImage("Four",4,bm);
                draw_digits.clear();
                Toast.makeText(CreateDataset.this, "Digit saved", Toast.LENGTH_SHORT).show();
            }
        });




        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveImage saveImage = new SaveImage();
                Bitmap bm = draw_digits.exportDrawing();
                saveImage.saveDigitImage("Five",5,bm);
                draw_digits.clear();
                Toast.makeText(CreateDataset.this, "Digit saved", Toast.LENGTH_SHORT).show();
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveImage saveImage = new SaveImage();
                Bitmap bm = draw_digits.exportDrawing();
                saveImage.saveDigitImage("Six",6,bm);
                draw_digits.clear();
                Toast.makeText(CreateDataset.this, "Digit saved", Toast.LENGTH_SHORT).show();
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveImage saveImage = new SaveImage();
                Bitmap bm = draw_digits.exportDrawing();
                saveImage.saveDigitImage("Seven",7,bm);
                draw_digits.clear();
                Toast.makeText(CreateDataset.this, "Digit saved", Toast.LENGTH_SHORT).show();
            }
        });


        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveImage saveImage = new SaveImage();
                Bitmap bm = draw_digits.exportDrawing();
                saveImage.saveDigitImage("Eight",8,bm);
                draw_digits.clear();
                Toast.makeText(CreateDataset.this, "Digit saved", Toast.LENGTH_SHORT).show();
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveImage saveImage = new SaveImage();
                Bitmap bm = draw_digits.exportDrawing();
                saveImage.saveDigitImage("Nine",9,bm);
                draw_digits.clear();
                Toast.makeText(CreateDataset.this, "Digit saved", Toast.LENGTH_SHORT).show();
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveImage saveImage = new SaveImage();
                Bitmap bm = draw_digits.exportDrawing();
                saveImage.saveDigitImage("Zero",0,bm);
                draw_digits.clear();
                Toast.makeText(CreateDataset.this, "Digit saved", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
