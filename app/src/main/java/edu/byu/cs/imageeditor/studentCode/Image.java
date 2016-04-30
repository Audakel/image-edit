package edu.byu.cs.imageeditor.studentCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class Image {

    private  int height, width, maxColorValue;
    private int redIntPixel, greenIntPixel, blueIntPixel;
    private  String magicNumber;
    private Scanner scanner;
    private Pixel[][] pixel2dArray;


    public Image(BufferedReader bufferedReader) {
        // Initialize all Image variables here
        scanner = new Scanner(bufferedReader);
        scanner.useDelimiter("(\\s+)(#[^\\n]*)?(\\s*)|(#[^\\n]*\\n)(\\s*)");

        magicNumber = scanner.next();
        width = scanner.nextInt();
        height = scanner.nextInt();
        maxColorValue = scanner.nextInt();
        pixel2dArray = new Pixel[height][width];
        int j = 0;
        int i = 0;

        while (scanner.hasNextInt()) {
            redIntPixel = scanner.nextInt();
            greenIntPixel = scanner.nextInt();
            blueIntPixel = scanner.nextInt();
            Pixel pixel = new Pixel(redIntPixel, greenIntPixel, blueIntPixel);

            if (j < width - 1) {
                pixel2dArray[i][j++] = pixel;
            }

            else {
                pixel2dArray[i][j] = pixel;
                j = 0;
                i++;
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getMaxColorValue() {
        return maxColorValue;
    }

    public void setMaxColorValue(int maxColorValue) {
        this.maxColorValue = maxColorValue;
    }

    public int getRedIntPixel() {
        return redIntPixel;
    }

    public void setRedIntPixel(int redIntPixel) {
        this.redIntPixel = redIntPixel;
    }

    public int getGreenIntPixel() {
        return greenIntPixel;
    }

    public void setGreenIntPixel(int greenIntPixel) {
        this.greenIntPixel = greenIntPixel;
    }

    public int getBlueIntPixel() {
        return blueIntPixel;
    }

    public void setBlueIntPixel(int blueIntPixel) {
        this.blueIntPixel = blueIntPixel;
    }

    public String getMagicNumber() {
        return magicNumber;
    }

    public void setMagicNumber(String magicNumber) {
        this.magicNumber = magicNumber;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Pixel[][] getPixel2dArray() {
        return pixel2dArray;
    }

    public Pixel getPixel2dArray(int row, int col) {
        return pixel2dArray[row][col];
    }

    public void setPixel2dArray(Pixel[][] pixel2dArray) {
        this.pixel2dArray = pixel2dArray;
    }


}
