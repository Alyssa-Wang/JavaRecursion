/**
 * This program reverses the integer input of the user.
 * @author Alyssa Wang
 * @version 1.0, April 15,2019
 */

public class ReverseNumber 
{
    /**
     * This method will reverse the digits
     * @param num a number with one digit removed
     * @return digits that are reversed
     */
    private int revNumber(int num)
    {
        if (num != 0)
          return num%10*(int) Math.pow(10,(double) (int)Math.log10(num))+revNumber(num/10);
        return 0;
    }
    /**
     * The main method which outputs a test case using the method revNumber. 
     */
    public static void main (String[] args)
    {
        ReverseNumber r = new ReverseNumber();
        System.out.println (r.revNumber(345));
    }
}
