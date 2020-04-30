


// Shannon Mellin

/* Assume there is an array named calendar that is an array of Day objects:
 * The Day class has a method that returns a boolean indicating if that day is a holiday:
 * There is also a toString() method that prints out the day.
 * Write a for loop that traverses through the calendar array and prints out 
 each day that is a holiday. */

public class Tweak11
{
  public static void main(String[] args)
  { 
    boolean holiday;
    int i = 0;
    // Day[] calendar = new Day[365];
    for(i = 1; i <= 365; i++)
    {
      
      if (i==1 || i==33 || i==45 || i==76 || i==185 || i==304 || i==315 || i==359  || i==365)
        holiday = true;
      else
        holiday = false;
      
      System.out.println(i + " holdiay is " + holiday);
      
    }
  }
}



