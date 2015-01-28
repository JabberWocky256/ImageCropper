package com.zeoalliance.opereverzyev.imagecropper;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by opereverzyev on 28.01.15.
 */
public class ImageWindow extends Activity {
    public static final String NAME_OF_EXTRA = "PATH";
    private ImageView windowImage;
    private String imagePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.window_image);
        windowImage = (ImageView) findViewById(R.id.image);

        try {
            imagePath = getImagePath();
        } catch (FileNotFoundException e) {
            //TODO: throw message that file not found
            finish();
        }

        getImageBitmap(imagePath);

    }

    private String getImagePath() throws FileNotFoundException {
        Intent thisIntent = getIntent();
        String result = thisIntent.getStringExtra(NAME_OF_EXTRA);

        if(result == null || result.isEmpty())
            throw new FileNotFoundException("this path is wrong");

        return result;
    }

    private Bitmap getImageBitmap(String imagePath){
        File file = new File(imagePath);

        Long length = file.length();
        Log.i("file length: ", length.toString());

        return null;
    }
}
