package com.zeoalliance.opereverzyev.imagecropper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.io.File;

/**
 * Created by opereverzyev on 28.01.15.
 */
public class MainActivity extends Activity{
    private static final String IMAGE_PATH = "Download/img.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ((Button) findViewById(R.id.btnCrop)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImageWindow.class);
                intent.putExtra(ImageWindow.NAME_OF_EXTRA, Environment.getExternalStorageDirectory() + File.separator + IMAGE_PATH);
                startActivity(intent);
            }
        });
    }
}
