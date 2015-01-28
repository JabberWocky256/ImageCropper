package com.zeoalliance.opereverzyev.imagecropper;

import android.graphics.Bitmap;

/**
 * Created by alexander on 28.01.15.
 */
public interface ImageLoaderInterface {
    Bitmap getImage(String imagePath, int width, int height);

    Bitmap getImage(String imagePath);
}
