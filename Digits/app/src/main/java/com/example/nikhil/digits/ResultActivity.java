package com.example.nikhil.digits;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nikhil.digits.Utils.ImageClassifier;

import java.io.IOException;

public class ResultActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    TextView finaltext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textView=findViewById(R.id.textView);

        imageView=findViewById(R.id.imageView);
        finaltext=findViewById(R.id.finaltext);
        Intent in = getIntent();
      //  Bitmap bitmap = (Bitmap) in.getExtras().get("data");
      byte[] byteArray = in.getByteArrayExtra("image");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        try {
            ImageClassifier imageClassifier = new ImageClassifier(ResultActivity.this);
            String ans = imageClassifier.classifyFrame(bmp);
            textView.setText(ans);
            finaltext.setText("The figure you drew was closest to: "+ans.substring(1,2));
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageView.setImageBitmap(bmp);
        imageView.setImageBitmap(bmp);

    }
}
