package com.example.nikhil.digits;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.divyanshu.draw.activity.DrawingActivity;
import com.divyanshu.draw.widget.DrawView;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;


import org.tensorflow.lite.Interpreter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    ImageView imageView;
    TextView textView;
    private static final int REQUEST_CODE_DRAW = 1;
    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3;



    private static final String TAG = "ha" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        imageView=findViewById(R.id.imageView);
        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2);
        floatingActionButton3 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item3);


        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, DrawingActivity.class),REQUEST_CODE_DRAW);
                //startActivityForResult(new Intent(MainActivity.this,DrawActivity.class),REQUEST_CODE_DRAW);

            }
        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CamActivity.class));

            }
        });



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.d(TAG, "onActivityResult: worked");
        byte[] result = data.getByteArrayExtra("bitmap");
        Bitmap bitmap = BitmapFactory.decodeByteArray(result, 0, result.length);
        imageView.setImageBitmap(bitmap);
        try {
            ImageClassifier imageClassifier = new ImageClassifier(MainActivity.this);
            String ans = imageClassifier.classifyFrame(bitmap);
            textView.setText(ans);
            Log.d(TAG, "onActivityResult: " + ans);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(requestCode==REQUEST_CODE_DRAW){
            if(requestCode==Activity.RESULT_OK && data!=null) {
                Log.d(TAG, "onActivityResult: worked");
//                byte[] result = data.getByteArrayExtra("bitmap");
//                Bitmap bitmap = BitmapFactory.decodeByteArray(result, 0, result.length);
//                try {
//                    ImageClassifier imageClassifier = new ImageClassifier(MainActivity.this);
//                    String ans = imageClassifier.classifyFrame(bitmap);
//                    Log.d(TAG, "onActivityResult: " + ans);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}
