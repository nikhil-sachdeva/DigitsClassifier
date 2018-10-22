package com.example.nikhil.digits.Utils;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class SaveImage {
    private static final String TAG = "wow";
    int n=10000;
    String root = Environment.getExternalStorageDirectory().toString();
    Random generator = new Random();

    public void saveDigitImage(String digit, int d, Bitmap bm){
        File myDir = new File(root + "/dataset/"+d);
        myDir.mkdirs();
        n = generator.nextInt(n);
        String fname = digit+"-" + n + ".jpg";
        File file = new File(myDir, fname);
        if (file.exists())
            file.delete();
        Log.i(TAG, "" + file);
        try {
            FileOutputStream out = new FileOutputStream(file);
            bm.compress(Bitmap.CompressFormat.JPEG, 20, out);
            out.flush();
            out.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
