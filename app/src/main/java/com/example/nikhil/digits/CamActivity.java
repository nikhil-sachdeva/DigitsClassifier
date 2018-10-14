package com.example.nikhil.digits;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nikhil.digits.Utils.ImageClassifier;

import java.io.IOException;

public class CamActivity extends AppCompatActivity {

    Camera camera = null;
    TextView mTextView;
    private static final int REQUEST_CAPTURE_IMAGE = 100;
    ImageView mImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam);
        mImageView=findViewById(R.id.mImageView);
       mTextView = findViewById(R.id.mTextView);

        openCameraIntent();

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == REQUEST_CAPTURE_IMAGE &&
                resultCode == RESULT_OK) {
            if (data != null && data.getExtras() != null) {
                Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
                mImageView.setImageBitmap(imageBitmap);
                try {
                    ImageClassifier imageClassifier = new ImageClassifier(CamActivity.this);
                    String ans = imageClassifier.classifyFrame(imageBitmap);
                    mTextView.setText(ans);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    private void openCameraIntent() {
        Intent pictureIntent = new Intent(
                MediaStore.ACTION_IMAGE_CAPTURE
        );
        if(pictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(pictureIntent,
                    REQUEST_CAPTURE_IMAGE);
        }
    }
}
