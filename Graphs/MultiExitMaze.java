/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * What I could do to improve -  Since you initialize all distances to -1 and only update them when you first visit a cell, checking distances[x][y] == -1 effectively serves as your "not visited" check.
 * This is actually a nice optimization - you're using the distances array to serve double duty as both your result storage and your visited tracking. Great insight! Your solution is working correctly and efficiently. Well done on implementing the multi-source BFS approach!
 * T(c) -  o(m*n) - m is number of rows, n is number of cols, each cell is visited at most once
 * S(c) - o(mxn) - same as size of given grid
 * Feedback -  You demonstrated strong algorithmic intuition by recognizing the multi-source BFS pattern immediately, implemented it flawlessly with O(m×n) time and space complexity, and showed excellent problem-solving skills. 
 * Your insight about using the distances array as both result storage and visited tracking was particularly impressive. This is exactly the kind of performance that would lead to a strong hire recommendation.
 */

class Solution {
  public static int [][] getDistanceToExit (char [][] grid) {

    Queue <int []> bfsQ = new LinkedList <>();
    int R = grid.length;
    if (R == 0) {
      return new int [] [] { {-1,-1}, {-1,-1}};
    }
    int C = grid[0].length;
    
    // boolean [][] visited = new boolean [R][C];
    // for (int i=0; i < R; i++) {
    //   for (int j=0; j < C; j++) {
    //     visited[i][j] = false;
    //   }
    // }

    int [][] distances = new int [R][C];

    for (int[] row : distances) {
      Arrays.fill(row, -1);
    }
    int [][] directions = new int [][] {{0,1}, {0,-1}, {1,0}, {-1,0}};

    for (int i=0; i < R; i++){
      for (int j=0; j < C; j++){
        if (grid[i][j] == 'O') {
          distances[i][j] = 0;
          bfsQ.offer(new int [] {i,j});
        }
      }
    }

    while (!bfsQ.isEmpty()) {
      int [] cell = bfsQ.poll();
      // visited[cell[0]][cell[1]] = true;

      for (int []dir : directions) {
        int x = cell[0] + dir[0];
        int y = cell[1] + dir[1];
        if (x >=0 && y >=0 && x < R && y < C &&  grid[x][y]!='X' && distances[x][y] == -1) {        
            distances[x][y] = distances[cell[0]][cell[1]] + 1;
            bfsQ.offer(new int [] {x,y});          
        } 
      }
    }

    return distances;    
  }

  public static void main(String[] args) {
    char [][] grid = new char [5][6];
    grid [0] = new char [] {'.', '.', '.', 'X', '.', 'O'};
    grid [1] = new char [] {'O', 'X', '.', 'X', '.', '.'};
    grid [2] = new char [] {'.', '.', '.', 'X', '.', '.'};
    grid [3] = new char [] {'.', 'X', '.', '.', '.', '.'};
    grid [4] = new char [] {'X', 'O', 'X', '.', 'X', 'X'};

    int [][] dist = getDistanceToExit (grid);

    for (int i=0; i < dist.length; i++){
      for (int j=0; j < dist[0].length; j++) {
        System.out.println ("->> " + dist[i][j]);
      }
      System.out.println ("=========================");
    }
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Multi-Exit Maze

// A few friends are trapped on a maze represented by a grid of letters:

// - `'X'` represents a wall.
// - `'O'` represents an exit. There may be multiple exits.
// - `'.'` represents a walkable space.

// Given the grid, `maze`, return a grid with the same dimensions.
// Each cell `(r, c)` should contain the minimum number of steps needed to go from position `(r, c)` in the maze to the closest exit.
// If `(r, c)` is a wall in the maze, return `-1` at that position.
// It is guaranteed that every walkable cell can reach an exit.

// ```
// Example 1:
// maze = [
//   "...X.O",
//   "OX.X..",
//   "...X..",
//   ".X....",
//   "XOX.XX"
// ]
// Output: [
//   [ 1,  2,  3, -1,  1,  0],
//   [ 0, -1,  4, -1,  2,  1],
//   [ 1,  2,  3, -1,  3,  2],
//   [ 2, -1,  4,  5,  4,  3],
//   [-1,  0, -1,  6, -1, -1]
// ]

// Example 2:
// maze = [
//   "...",
//   ".O.",
//   "..."
// ]
// Output: [
//   [2, 1, 2],
//   [1, 0, 1],
//   [2, 1, 2]
// ]
// ```

// Constraints:

// - `1 <= maze.length <= 1000`
// - `1 <= maze[i].length <= 1000`
// - `maze[i][j]` is either `'.'`, `'X'`, or `'O'`
// - All the rows have the same length
