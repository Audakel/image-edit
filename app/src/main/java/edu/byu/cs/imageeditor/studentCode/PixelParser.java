package edu.byu.cs.imageeditor.studentCode;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class PixelParser {

    public static ArrayList<Pixel> parseToArrayOfPixels(String stringToScan){
        Scanner scanner = new Scanner(stringToScan);
        int redIntPixel, greenIntPixel, blueIntPixel;
        ArrayList<Pixel> pixelArrayList = new ArrayList<Pixel>();

        while (scanner.hasNextInt()) {
            redIntPixel = scanner.nextInt();
            greenIntPixel = scanner.nextInt();
            blueIntPixel = scanner.nextInt();
            Pixel pixel = new Pixel(redIntPixel, greenIntPixel, blueIntPixel);
            pixelArrayList.add(pixel);
        }

        return pixelArrayList;
    }
}
