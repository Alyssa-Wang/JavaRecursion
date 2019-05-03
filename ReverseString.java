import java.util.Scanner;

/**
 * This program reverses the order of string input.
 * @author Alyssa Wang
 * @version 1.0, April 15,2019
 */

public class ReverseString {
    /**
     * This is a black box return method that will find the position fo the next space in the sentence and then reverse the order of the words.
     * @param str string array
     * @return reversed string with period starting off the reversal
     */
    private String revString(String sentence){
        if (sentence.indexOf(" ") != -1){
            return revString(sentence.substring(sentence.indexOf(" ") + 1)) + "\n" + sentence.substring(0, sentence.indexOf(" "));
        }
        return ".";
    }

    /**
     * This method will get user input.
     * @return all input combined to be returned in one String
     */
    public String readInput(){
        Scanner s = new Scanner(System.in);
        String string = "";
        final String ENDPOINT = ".";
        String line = "";
        while (!line.equals(ENDPOINT)){
            string += line + " ";
            line = s.nextLine();
        }
        line += ENDPOINT;
        return string;
    }
    /**
     * Main method which outputs the other methods
     */
    public static void main (String[] args){
        ReverseString r = new ReverseString();
        String input = r.readInput();
        String reverse = r.revString(input);
        System.out.println(reverse);
    }
}
