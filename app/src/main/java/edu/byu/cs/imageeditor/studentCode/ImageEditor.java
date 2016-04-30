package edu.byu.cs.imageeditor.studentCode;

import android.util.Log;
import android.util.StringBuilderPrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class ImageEditor implements IImageEditor {
    private static final String TAG = "DEBUG";
    public Image mImage;

    @Override
    public void load(BufferedReader bufferedReader) {
        mImage = new Image(bufferedReader);
    }

    @Override
    public String invert() {
        return doEdit(mImage, Constants.INVERT);
    }

    @Override
    public String grayscale() {
        return doEdit(mImage, Constants.GREY);
    }

    @Override
    public String emboss() {
        return doEdit(mImage, Constants.EMBOSS);
    }

    @Override
    public String motionblur(int blurLength) {
        return doEdit(mImage, Constants.BLUR, blurLength);
    }

//    Helper functions
    private String doEdit(Image image, int operatorType, int... blurLength){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Log.d(TAG, "doEdit: start time @ " + sdf.format(cal.getTime()) );

        StringBuilder sb = new StringBuilder(1000);
        printImageHeaderInfo(sb, image);

        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                if (operatorType == Constants.GREY) {
                    printImageBody(sb, GreyScale.makePixelGrey(image.getPixel2dArray(i, j)));
                }
                else if (operatorType == Constants.INVERT) {
                    printImageBody(sb, Invert.makeInverted(image.getPixel2dArray(i, j)));
                }
                else if (operatorType == Constants.EMBOSS) {
                    functionForPrintingEmboss(sb, image, i, j);
                }
                else if (operatorType == Constants.BLUR) {
                    printImageBody(sb, Blur.makePixelBlur(blurLength[0], i, j, image.getWidth(), image.getPixel2dArray()));
                }

            }
        }

        Log.d(TAG, "doEdit: end time @ " + sdf.format(cal.getTime()) );

        return sb.toString();
    }

//    private static Pixel pixelUpperLeft(int i, int j){
//        Pixel pixelUpperLeft = new Pixel(128,128,128);
//
//        if (i != 0 && j != 0){
//            pixelUpperLeft = pixel2dArray[i-1][j-1];
//        }
//
//        return pixelUpperLeft;
//    }
//
//
    private void functionForPrintingEmboss(StringBuilder stringBuilder, Image image, int i, int j) {
        Pixel pixelUpperLeft = new Pixel(128,128,128);

        if (i != 0 && j != 0){
            pixelUpperLeft = image.getPixel2dArray(i-1,j-1);
            printImageBody(stringBuilder, Emboss.makePixelEmboss(image.getPixel2dArray(i,j), pixelUpperLeft));
        }
        else {
            printImageBody(stringBuilder, pixelUpperLeft);
        }
    }
//
//    private static void retrieveUserInput(String[] args) {
//        fileName = args[0];
//        outputFileName = args[1];
//        typeOfImageEdit = args[2];
//
//        if (args.length == 4){
//            blurLength = Integer.parseInt(args[3]);
//        }
//    }

    private int countLine = 0;
    private void printImageBody(StringBuilder stringBuilder, Pixel pixelPrint) {
//        stringBuilder.append(pixelPrint.Red + " " +
//                pixelPrint.Green + " " +
//                pixelPrint.Blue + " ");
//        countLine++;
//
//        if(countLine % 10 == 0){
//            stringBuilder.append("");
//        }
        stringBuilder.append(pixelPrint.Red + "\n" +
                pixelPrint.Green + "\n" +
                pixelPrint.Blue + "\n");
    }

    private static void printImageHeaderInfo(StringBuilder stringBuilder, Image image) {
        stringBuilder.append(image.getMagicNumber() + "\n");
        stringBuilder.append(image.getWidth() + " ");
        stringBuilder.append(image.getHeight() + "\n");
        stringBuilder.append(image.getMaxColorValue() + "\n");

    }

}
