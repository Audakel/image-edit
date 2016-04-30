package edu.byu.cs.imageeditor.studentCode;

public class Blur {

    private static int redAverage, greenAverage, blueAverage;
    private static int redSum, greenSum, blueSum;
    private static int actualBlurDistance;

    public static Pixel makePixelBlur(int blurLength, int i, int j, int width, Pixel[][] pixel2dArray) {

        if (j + blurLength > width) {
            actualBlurDistance = width - j;
        }
        else{
            actualBlurDistance = blurLength;
        }

        redSum = 0;
        greenSum = 0;
        blueSum = 0;

        for (int k = 0; k < actualBlurDistance; k++) {
            redSum += pixel2dArray[i][j+k].Red;
            greenSum += pixel2dArray[i][j+k].Green;
            blueSum += pixel2dArray[i][j+k].Blue;
        }

        redAverage = redSum / actualBlurDistance;
        greenAverage = greenSum / actualBlurDistance;
        blueAverage = blueSum / actualBlurDistance;
        Pixel blurPixel = new Pixel(redAverage,greenAverage,blueAverage);

        return blurPixel;

    }

}
