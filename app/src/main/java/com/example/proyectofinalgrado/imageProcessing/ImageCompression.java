package com.example.proyectofinalgrado.imageProcessing;

import android.graphics.Bitmap;

public class ImageCompression{

    private final static long MAX_SIZE = 307200; // Size for 640x480
    private static long THUMB_SIZE = 6553;

    /**
     * Methot for get an scalated image into 640x480
     * @param bitmap : Image that we want to compress
     * @return : Image compressed
     */
    public static Bitmap reduceBitmapSize(Bitmap bitmap){
        double ratioSquare;
        int bitmapHeight, bitmapWidth;
        //Acquire Data
        bitmapHeight = bitmap.getHeight();
        bitmapWidth = bitmap.getWidth();
        ratioSquare = (bitmapHeight * bitmapWidth)/MAX_SIZE;
        //If the reduction is lower or equals to the original
        if(ratioSquare<=1) return bitmap;
        double ratio = Math.sqrt(ratioSquare);

        int requiredHeight = (int) Math.round(bitmapHeight/ratio);
        int requiredWidth = (int) Math.round(bitmapWidth / ratio);
        return Bitmap.createScaledBitmap(bitmap,requiredWidth,requiredHeight,true);
    }

    /**
     * Method for get a Thumbnail of an image.
     * @param bitmap : Image that we want to scale
     * @return thumbnail.
     */
    public static Bitmap generateThumb(Bitmap bitmap){
        double ratioSquare;
        int bitmapHeight, bitmapWidth;
        //Acquire Data.
        bitmapHeight = bitmap.getHeight();
        bitmapWidth = bitmap.getWidth();
        ratioSquare = (bitmapHeight * bitmapWidth)/THUMB_SIZE;
        if(ratioSquare <=1) return bitmap;
        double ratio = Math.sqrt(ratioSquare);

        int requiredHeight = (int) Math.round(bitmapHeight/ratio);
        int requiredWidth = (int) Math.round(bitmapWidth /ratio);
        return Bitmap.createScaledBitmap(bitmap,requiredWidth,requiredHeight,true);
    }
}
