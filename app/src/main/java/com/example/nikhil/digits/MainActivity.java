package com.example.nikhil.digits;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.divyanshu.draw.widget.DrawView;
import com.joaquimley.faboptions.FabOptions;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    TextView tex;
FabOptions fabOptions;

    private static final String TAG = "ha" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tex=(TextView)findViewById(R.id.tex);
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background);

        fabOptions=(FabOptions)findViewById(R.id.fab_options);
        fabOptions.setButtonsMenu(R.menu.fab_menu);
        startActivity(new Intent(MainActivity.this,DrawActivity.class));



    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.camera){

        }
        if(item.getItemId()==R.id.draw){
            Toast.makeText(this, "touched", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this,DrawActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
