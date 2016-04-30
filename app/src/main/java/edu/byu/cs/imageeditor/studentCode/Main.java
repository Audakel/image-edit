//package edu.byu.cs.imageeditor.studentCode;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.URISyntaxException;
//
///**
// */
//public class Main {
//
//    private static Image image = new Image();
//    private static Pixel[][] pixel2dArray;
//    private static int count, blurLength;
//    private static GreyScale greyScale;
//    private static Emboss emboss;
//    private static Blur blur;
//    private static Invert invert;
//    private static Pixel mPrintPixel;
//    private static String fileName, outputFileName, typeOfImageEdit;
//    private static PrintWriter writer;
//
//    public static void main(String[] args) throws IOException, URISyntaxException {
//        pixel2dArray = new Pixel[image.width][image.height];
//        greyScale = new GreyScale();
//        emboss = new Emboss();
//        blur = new Blur();
//        invert = new Invert();
//
//        retrieveUserInput(args);
//        pixel2dArray = image.readInImage(fileName);
//        writer = new PrintWriter(outputFileName, "UTF-8");
//        printImageHeaderInfo(writer);
//
//        for (int i = 0; i < image.height; i++) {
//            for (int j = 0; j < image.width; j++) {
//                if (typeOfImageEdit.equals("grayscale")) {
//                    printImageBody(writer, greyScale.makePixelGrey(pixel2dArray[i][j]));
//                }
//                else if (typeOfImageEdit.equals("invert")) {
//                    printImageBody(writer, invert.makeInverted(pixel2dArray[i][j]));
//                }
//                else if (typeOfImageEdit.equals("reorder")) {
//                    printImageBody(writer, (pixel2dArray[i][j]));
//                }
//                else if (typeOfImageEdit.equals("emboss")) {
//                    functionForPrintingEmboss(writer, i, j);
//                }
//                else if (typeOfImageEdit.equals("motionblur")) {
//                    printImageBody(writer, blur.makePixelBlur(blurLength, i, j, image.width, pixel2dArray));
//                }
//                else {
//                    System.out.println("java ImageEditor in-file out-file " +
//                            "(grayscale|invert|emboss|motionblur motion-makePixelBlur-height)");
//                }
//            }
//        }
//        writer.close();
//    }
//
//
//
//
//
//
//
//    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
//    private static void functionForPrintingEmboss(PrintWriter writer, int i, int j) {
//        Pixel pixelUpperLeft = new Pixel(128,128,128);
//
//        if (i != 0 && j != 0){
//            pixelUpperLeft = pixel2dArray[i-1][j-1];
//            printImageBody(writer, emboss.makePixelEmboss(pixel2dArray[i][j], pixelUpperLeft(i, j)));
//        }
//        else {
//            printImageBody(writer, pixelUpperLeft);
//        }
//    }
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
//
//    private static int countLine = 0;
//    private static void printImageBody(PrintWriter writer, Pixel pixelPrint) {
//        writer.print(pixelPrint.Red + " " +
//                pixelPrint.Green + " " +
//                pixelPrint.Blue + " ");
//        countLine++;
//
//        if(countLine % 10 == 0){
//            writer.println("");
//        }
//
//
//    }
//
//    private static void printImageHeaderInfo(PrintWriter writer) {
//        writer.println(image.magicNumber);
//        writer.println(image.width);
//        writer.println(image.height);
//        writer.println(image.maxColorValue);
//        writer.println("");
//
//    }
//
//    private static String recieveInputFileFromUser() throws IOException {
//        System.out.print("What file would you like to import? ");
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String inputFileName = in.readLine();
//        return inputFileName;
//    }
//}
