/**
 * This program will traverse an array of elements that are comparable and returns true if found.
 * @author Alyssa Wang
 * @version 1.0, April 15,2019
 */

public class Search {
    /**
     * This method compares each element
     * @param arr this is the array
     * @param x the element that is currently being checked
     * @return will return a boolean base on whether or not the array contains the element arr[arr.length - 1]
     */
    private boolean searchItem(Comparable[] arr, int x){
        if (x != arr.length - 1){
            if (arr[x].equals(arr[arr.length - 1])){
                return true;}
            return searchItem(arr, x + 1);}
        return false;
    }
    /**
     * This method outputs the other methods and creates an array as the test case
     * @param args
     */
    public static void main(String[] args){
        Search s = new Search();
        Comparable[] array = {Integer.valueOf(5), Integer.valueOf(7), Integer.valueOf(2), Integer.valueOf(5)};
        boolean answer = s.searchItem(array, 0);
        System.out.println(answer);
    }
}
