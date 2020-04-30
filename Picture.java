


// Shannon Mellin and Destin West

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  
  
  
  
  // Gets rid of all Red in the picture
  public void clearRed() {
    Pixel[] pixelArray = this.getPixels();
    System.out.println(pixelArray.length);
    for (int i=0; i<pixelArray.length; i++) {
      pixelArray[i].setRed(0);
    }
  }
  
  // Gets rid of all Green in the picture
  public void clearGreen() {
    Pixel[] pixelArray = this.getPixels();
    System.out.println(pixelArray.length);
    for (int i=0; i<pixelArray.length; i++) {
      pixelArray[i].setGreen(0);
    }
  }
  
  // Gets rid of all Blue in the picture
  public void clearBlue() {
    Pixel[] pixelArray = this.getPixels();
    System.out.println(pixelArray.length);
    for (int i=0; i<pixelArray.length; i++) {
      pixelArray[i].setBlue(0);
    }
  }
  
  // Makes the picture slightly brighter
  public void lighten() {
    Pixel[] pixelArray = this.getPixels();
    System.out.println(pixelArray.length);
    for (int i=0; i<pixelArray.length; i++) {
      int currentRed = pixelArray[i].getRed();
      int currentGreen = pixelArray[i].getGreen();
      int currentBlue = pixelArray[i].getBlue();
      Color lighten = new Color(currentRed, currentGreen, currentBlue);
      lighten = pixelArray[i].getColor();
      lighten = lighten.brighter();
      pixelArray[i].setColor(lighten);
    }
  }
  
  // Can ajust colors to prefrence
  public void changeColors(double redFactor, double greenFactor, double blueFactor){
    Pixel[] pixelArray = this.getPixels();
    System.out.println(pixelArray.length);
    for (int i=0; i<pixelArray.length; i++){
      int currentRed = pixelArray[i].getRed(); //set to the current value of red for a pixel (obtained from getRed() )
      int newRed = (int)(currentRed * redFactor); // will be set to the new value of red (will be used with setRed() )
      int currentGreen = pixelArray[i].getGreen();
      int newGreen = (int)(currentGreen * greenFactor);
      int currentBlue = pixelArray[i].getBlue();
      int newBlue = (int)(currentBlue * blueFactor);
      /*Color colorRed, colorGreen, colorBlue;
       colorRed = 
       colorGreen = 
       colorBlue = */
      pixelArray[i].setRed(newRed);
      pixelArray[i].setGreen(newGreen);
      pixelArray[i].setBlue(newBlue);
    }
  }
  
  // Makes it look like you are out during a sunset
  public void sunset(){
    this.changeColors(1.0,0.8,0.5);
  }
  
  // Extra Credit takes colors away from the image making it look pixelated
  public void posterize(){
    Pixel[] pixelArray = this.getPixels();
    System.out.println(pixelArray.length);
    for (int i=0; i<pixelArray.length; i++) {
      
      int currentRed = pixelArray[i].getRed();
      if (currentRed >= 0 && currentRed <= 63)
        pixelArray[i].setRed(31);
      else if (currentRed >= 64 && currentRed <= 127)
        pixelArray[i].setRed(95);
      else if (currentRed >= 128 && currentRed <= 191)
        pixelArray[i].setRed(159);
      else 
        pixelArray[i].setRed(223);
      
      int currentGreen = pixelArray[i].getGreen();
      if (currentGreen >= 0 && currentGreen <= 63)
        pixelArray[i].setGreen(31);
      else if (currentGreen >= 64 && currentGreen <= 127)
        pixelArray[i].setGreen(95);
      else if (currentGreen >= 128 && currentGreen <= 191)
        pixelArray[i].setGreen(159);
      else 
        pixelArray[i].setGreen(223);
      
      int currentBlue = pixelArray[i].getBlue();
      if (currentBlue >= 0 && currentBlue <= 63)
        pixelArray[i].setBlue(31);
      else if (currentBlue >= 64 && currentBlue <= 127)
        pixelArray[i].setBlue(95);
      else if (currentBlue >= 128 && currentBlue <= 191)
        pixelArray[i].setBlue(159);
      else 
        pixelArray[i].setBlue(223);
    }
  }
  
  // Adjustable posturize?
  /*  public void posterizeNum(int numLevels){
   this.posterize();
   Pixel[] pixelArray = this.getPixels();
   System.out.println(pixelArray.length);
   for (int i=0; i<pixelArray.length; i++) {
   for (int 255/4, 2(255/4), 3(255/4), 4(255/4)){
   if (numLevels >= 0 && numLevels <= 255){
   pixelArray[i].setRed(numLevels);
   pixelArray[i].setGreen(numLevels);
   pixelArray[i].setBlue(numLevels);
   }
   else{
   }
   }
   }
   }*/
  
  // takes out all red and green
  public void blueOnly(){
    this.clearRed();
    this.clearGreen();
  }
  
  // Maximizes all Blue in the picture
  public void maxBlue() {
    Pixel[] pixelArray = this.getPixels();
    System.out.println(pixelArray.length);
    for (int i=0; i<pixelArray.length; i++) {
      pixelArray[i].setBlue(255);
    }
  }
  
  // reverse colors
  public void negate(){
    Pixel[] pixelArray = this.getPixels();
    System.out.println(pixelArray.length);
    for (int i=0; i<pixelArray.length; i++){
      int currentRed = pixelArray[i].getRed();
      int newRed = (int)(255 - currentRed);
      int currentGreen = pixelArray[i].getGreen();
      int newGreen = (int)(255 - currentGreen);
      int currentBlue = pixelArray[i].getBlue();
      int newBlue = (int)(255 - currentBlue);
      pixelArray[i].setRed(newRed);
      pixelArray[i].setGreen(newGreen);
      pixelArray[i].setBlue(newBlue);
    }
  }
  
  // Makes the picture slightly darker
  public void darken() {
    Pixel[] pixelArray = this.getPixels();
    System.out.println(pixelArray.length);
    for (int i=0; i<pixelArray.length; i++) {
      Color darken;
      darken = pixelArray[i].getColor();
      darken = darken.darker();
      pixelArray[i].setColor(darken);
    }
  }
  
  // black and white picture
  public void grayScale() {
    Pixel[] pixelArray = this.getPixels();
    System.out.println(pixelArray.length);
    for (int i=0; i<pixelArray.length; i++){
      int currentRed = pixelArray[i].getRed();
      int currentGreen = pixelArray[i].getGreen();
      int currentBlue = pixelArray[i].getBlue();
      int average = (currentRed+currentGreen+currentBlue)/3;
      int newRed = (int)(average);
      int newGreen = (int)(average);
      int newBlue = (int)(average);
      pixelArray[i].setRed(newRed);
      pixelArray[i].setGreen(newGreen);
      pixelArray[i].setBlue(newBlue);
    }
  }
  
  // Picture appears in brown
  public void makeSepia() {
    this.grayScale();
    Pixel[] pixelArray = this.getPixels();
    System.out.println(pixelArray.length);
    for (int i=0; i<pixelArray.length; i++){
      int currentRed = pixelArray[i].getRed();
      int newRed, newGreen, newBlue;
      if (currentRed < 60){
        newRed = (int)(currentRed * 0.9);
        newGreen = (int)(currentRed * 0.9);
        newBlue = (int)(currentRed * 0.9);
        pixelArray[i].setRed(newRed);
        pixelArray[i].setGreen(newGreen);
        pixelArray[i].setBlue(newBlue);
      }
      else if (currentRed > 60 || currentRed < 190){
        newBlue = (int)(currentRed * 0.7);
        pixelArray[i].setBlue(newBlue);
      }
      else{
        newBlue = (int)(currentRed * 0.8);
        pixelArray[i].setBlue(newBlue);
      }
    }
  }
  
  // Extra Credit X-Ray filter. (This was compared to the filter in PhotoBooth)
  public void xRay() {
    this.negate();
    this.grayScale();
    Pixel[] pixelArray = this.getPixels();
    System.out.println(pixelArray.length);
    for (int i=0; i<pixelArray.length; i++){
      int currentRed = pixelArray[i].getRed();
      int newRed, newGreen, newBlue;
      if (currentRed < 60){
        newRed = (int)(currentRed * 0.9);
        newGreen = (int)(currentRed * 0.9);
        newBlue = (int)(currentRed * 0.9);
        pixelArray[i].setRed(newRed);
        pixelArray[i].setGreen(newGreen);
        pixelArray[i].setBlue(newBlue);
      }
      else if (currentRed > 60 || currentRed < 190){
        newGreen = (int)(currentRed / 0.8);
        pixelArray[i].setGreen(newGreen);
        newBlue = (int)(currentRed / 0.8);
        pixelArray[i].setBlue(newBlue);
      }
      else{
        newGreen = (int)(currentRed / 0.9);
        pixelArray[i].setGreen(newGreen);
        newBlue = (int)(currentRed / 0.9);
        pixelArray[i].setBlue(newBlue);
      }
    }
  }
} // this } is the end of class Picture, put all new methods before this




