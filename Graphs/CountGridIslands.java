/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/* https://start.interviewing.io/interview-ai?problemId=count-grid-islands
 * T(C) - time complexity is o(mxn) m is rows, n is columns in the grid
 * S(C) - space complexity is O(m×n) for both the visited array and potentially the call stack in the worst case.
 */

class Solution {

  public static int countIslands (List<List <Integer>> grid) {
    int rows = grid.size();
    if (rows == 0) return 0; // important - edge case - your code would crash on empty grids due to accessing grid.get(0).size() without checking if the grid is empty first.
    int cols = grid.get(0).size();

    List<List<Boolean>> visited = new ArrayList <>();

    int count = 0;
    for (int i=0; i < rows; i++) {
      List<Boolean> cells = new ArrayList<>();
      for (int j=0; j < cols; j++){
        cells.add(false);
      }
      visited.add(cells);
    }

    // int [][] directions = new int [] [] {{0,1}, {0,-1}, {1,0}, {-1,0}};

    for (int i=0; i < rows; i++) {      
      for (int j=0; j < cols; j++) {
        int val = grid.get(i).get(j);
        if (val == 1 && !visited.get(i).get(j)) {
          // visited.get(i).set(j, true);
          dfs(i,j,grid,visited);
          count++;
        }
      }
    }
    return count;
  }

  public static void dfs (int x, int y, List<List<Integer>> grid, List<List<Boolean>> visited) {

    // check if the cell is valid
    if (x <0 || y <0 || x >= grid.size() || y >= grid.get(0).size()) {
      return;
    }

    // check if the cell is 0

    // check if visited

    if (grid.get(x).get(y) == 0 ) {
      return;
    }

    if (visited.get(x).get(y)) {
      return;
    }

    visited.get(x).set(y, true);
    dfs (x+1,y,grid,visited);
    dfs (x,y+1,grid,visited);
    dfs (x-1,y,grid,visited);
    dfs (x,y-1,grid,visited);          
  }

  public static void main(String[] args) {

    List<List <Integer>> grid = new ArrayList <>();
    grid.add(new ArrayList <>(Arrays.asList(0, 0, 1, 0)));
    grid.add(new ArrayList <>(Arrays.asList(1, 1, 0, 1)));
    grid.add(new ArrayList <>(Arrays.asList(0, 0, 1, 1)));

    int islands = countIslands (grid);
    System.out.println(islands);
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Count Grid Islands

// In this classic problem, you are given a binary grid, `grid`, where `0` represents water and `1` represents solid ground. The goal is to count the number of _islands_ in the grid, where an island is a four-directionally contiguous land region.

// Return the number of islands in the grid.

// ```
// Example 1: grid = [
//   [0, 0, 1, 0],
//   [1, 1, 0, 1],
//   [0, 0, 1, 1]
// ]
// Output: 3

// Example 2: grid = [
//   []
// ]
// Output: 0

// Example 3: grid = [
//   [1]
// ]
// Output: 1

// Example 4: grid = [
//   [1, 0, 1],
//   [0, 0, 0],
//   [1, 0, 1]
// ]
// Output: 4
// ```

// Constraints:

// - `0 <= grid.length <= 1000`
// - `0 <= grid[i].length <= 1000`
// - `grid[i][j]` is either `0` or `1`
// - All the rows have the same length
// - Each island contains at most `500` cells
