package edu.byu.cs.imageeditor.studentCode;


public class GreyScale {
    // Variables and constants
    public  static  Pixel[][] mPixel2dArray;
    private static int PIXEL_DEPTH = 3;


    public static Pixel makePixelGrey(Pixel pixelToChange){
        int rgbSum = pixelToChange.Red + pixelToChange.Blue + pixelToChange.Green;
        int rgbAverage = rgbSum / PIXEL_DEPTH;
        pixelToChange.Red = rgbAverage;
        pixelToChange.Green = rgbAverage;
        pixelToChange.Blue = rgbAverage;

        return pixelToChange;
    }


}
