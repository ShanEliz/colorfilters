


// Shannon Mellin

/**
 * Change a picture.
 */

import java.awt.Color;

public class Homework6
{
  public static void main(String[] args)
  { 
    String filename;
    filename = "/Users/Shannon/Desktop/CMPT201/mediasources/grayMotorcycle.jpg";
    System.out.println(filename);
    Picture pict;
    pict = new Picture(filename);
    
    // This is where we call Picture methods
    pict.xRay();
    
    pict.explore();
    pict.write("/Users/Shannon/Desktop/CMPT201/Homework/HW6/grayMotorcycleXRay.jpg");
    // Change picture name to save a new picture
  }
}




