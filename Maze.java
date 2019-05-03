/**
 * This program will search through a maze that is stored as a 2-D array.
 * @author Alyssa Wang
 * @version 1.0, April 15,2019
 */

public class Maze {
    /**
     * This method searches the 2D array for entrance(s)
     * @param maze 2-D array that acts as the maze
     * @param a row
     * @param b column
     * @return the result of the search for th entrance
     */
    private boolean findEntrance(int[][] maze, int a, int b){
        boolean answer = false;
        if (maze[a][b] == 0){ // if the entrance is found
            maze[a][b] = 5; // entrance is set to 5 so that there is no condusion when searching for a new entrance
            if (a == 0 && b == 0){ // set a b one element right from entrance
                answer = findExit(maze, a, b + 1);
            }   
            else if (a == 0) { // set a b one element down from entrance
                answer = findExit(maze, a + 1, b);
            }
            else if (b == 0){ // set a b one element right from entrance
                answer = findExit(maze, a, b + 1);
            }
        }
        else { // if the entrance is not found, it will search the array
            if (b != 0){ //searches the top row 
                return findEntrance(maze, a,b - 1); 
            }
            else{ //searches the left column
                if (a != 4) {
                    return findEntrance(maze, a + 1, b);
                }
                else{
                    return false; // if not found then there are no more entrance(s)
                }
            }
        }
        if (!answer){ // if result of mazeSearch is false, it's possible to have more entrance(s) so call findEntrance
            return findEntrance(maze, a, b);
        }
        return answer; // return answer
    }

    /**
     * This method checks for paths that reach the exit by looking at all elements next to the current parameter pass of a and b
     * This method runs all paths at the same time by calling the method if a 0 is found next to a,b, which is 0
     * @param maze 2-D array that acts as the maze
     * @param a row
     * @param b column
     * @return false or true depending on whether or not an exit is possible
     */
    private  boolean findExit(int[][] maze, int a, int b) {
        boolean finish = false;
        if (a >= 1 && a <= 3 && b >= 1 && b <= 3) { // search within borders of the maze
            int up = maze[a - 1][b]; // top part of maze
            int right = maze[a][b + 1]; // right part of maze
            int down = maze[a + 1][b]; // bottom part of maze
            int left = maze[a][b - 1]; // left part of maze
            if ((right == 0 && b == 3) || (down == 0 && a == 3)) { // checks whether the bottom or top row contains a 0 since only max values can be an exit
                maze[a][b] = 2; // set to 2 to complete path
                return true; // return true to show that the path is found
            }
            if (maze[a][b] != 5) { // if not accessing start element current position in the maze will be set to 2
                maze[a][b] = 2;
            }
            if (up == 0 && !finish) { // if path not complete then keep searching above
                finish = findExit(maze, a - 1, b);
            }
             if (down == 0 && !finish) { // if path not complete then keep searching below
                finish = findExit(maze, a + 1, b);
            }
            if (right == 0 && !finish) { // if path not complete then keep searching right
                finish = findExit(maze, a, b + 1);
            }

            if (left == 0 && !finish) { // if path not complete then keep searching left
                finish = findExit(maze, a, b - 1);
            }
            if (!finish) { // if not found reset element to 0 and return false
                maze[a][b] = 0;
            }
        }
        return finish; // returns the status of the path
    }
    /**
     * Main method which creates the 2-D array (maze) and prints out the status of the maze by outputting the methods. 
     */
    public static void main (String[] args){
        Maze m = new Maze();
        int[][] maze = {{1,0,1,1,1},
                        {0,0,0,1,1},
                        {1,1,0,0,0},
                        {0,1,1,0,1},
                        {1,1,0,1,1},};
        System.out.println(m.findEntrance(maze, 0, 4));

    }
}
