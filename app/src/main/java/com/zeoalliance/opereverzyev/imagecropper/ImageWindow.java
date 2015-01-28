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
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * Created by opereverzyev on 28.01.15.
 */
public class ImageWindow extends Activity {
    public static final String NAME_OF_EXTRA = "PATH";
    private ImageView windowImage;
    private String imagePath;
    private final static String TAG = "myLogs";
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

        Calendar c = Calendar.getInstance();
        int startTime = c.get(Calendar.MILLISECOND);
        Log.i(TAG, "Start of image loading at time...");

        ImageLoader imageLoader = new ImageLoader();
        Bitmap imageBitmap = imageLoader.getImage(imagePath);

        int endTime = c.get(Calendar.MILLISECOND);
        Log.i(TAG, "Stop of image loading at time: " + (endTime - startTime));

        windowImage.setImageBitmap(imageBitmap);
        Log.i(TAG, "set bitmap to image: " + (c.get(Calendar.MILLISECOND) - endTime));
    }

    private String getImagePath() throws FileNotFoundException {
        Intent thisIntent = getIntent();
        String result = thisIntent.getStringExtra(NAME_OF_EXTRA);

        if(result == null || result.isEmpty())
            throw new FileNotFoundException("this path is wrong");

        return result;
    }
}
