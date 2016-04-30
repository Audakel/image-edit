package edu.byu.cs.imageeditor.studentCode;


public class Emboss {

    private static int redDifference;
    private static int greenDifference;
    private static int blueDifference;

    public static Pixel makePixelEmboss(Pixel pixel, Pixel pixel2) {
        redDifference = (pixel.Red - pixel2.Red);
        greenDifference = (pixel.Green - pixel2.Green);
        blueDifference = (pixel.Blue - pixel2.Blue);

        int largestDiff = 0;
        largestDiff = redDifference;

        if (Math.pow(greenDifference,2) > Math.pow(redDifference,2)){
            largestDiff = greenDifference;
        }

        if (Math.pow(blueDifference,2) > Math.pow(largestDiff, 2)){
            largestDiff = blueDifference;
        }
        int newPixelColor = largestDiff + 128;

        if (newPixelColor > 255){
            newPixelColor = 255;
        }
        if (newPixelColor < 0){
            newPixelColor = 0;
        }
        Pixel returnPixel = new Pixel(newPixelColor,newPixelColor,newPixelColor);

        return returnPixel;
    }
}
