package edu.byu.cs.imageeditor.studentCode;

public class Invert {

    public static Pixel makeInverted(Pixel pixel){
        Pixel mPixel = new Pixel(0,0,0);

        mPixel.Red = 255 - pixel.Red;
        mPixel.Green = 255 - pixel.Green;
        mPixel.Blue = 255 - pixel.Blue;

        return mPixel;
    }
}
