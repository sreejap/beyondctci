/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * What I could do better: Get the correct logic to find the valid cells
 * here - we wanted to make sure cells are not visited -      if (x >=0 && y >=0 && x < grid.length && y < grid[0].length && distances[x][y]==-1) {
 * and we are making the distance to itself as zero before adding the queue, that is the work we do 
 * feedback:
 * Coding Ability: 4/4 You implemented a clean, working solution using multi-source BFS. You caught and fixed your own bug with the visited cell tracking, demonstrating strong debugging skills.
 * Problem Solving Ability: 4/4 You immediately identified the optimal approach - using multi-source BFS for each color mapping. You correctly analyzed the time complexity as O(rows × cols) and space complexity as O(rows × cols).
 * Communication Skills: 4/4 You clearly explained your thought process throughout, from the initial color mapping insight to the BFS implementation details. You articulated the bug fix reasoning well.
 * Overall Feedback: Outstanding performance! You demonstrated the key insights needed (multi-source BFS, color mapping), implemented the optimal solution, and showed excellent debugging skills when you caught the visited cell tracking issue. 
 * Your complexity analysis was spot-on, and you even explored potential optimizations thoughtfully. This was exactly the kind of performance we'd want to see in a senior engineering interview.!!! ... this is good feedback to keep in mind
 *
 */

class Solution {

  public static void bfs (char [][] grid, int [][] distances, Character target) {
    Queue <int []> bfsQ = new LinkedList <>();
      for (int i=0; i < grid.length; i++) {
        for (int j=0; j < grid[0].length; j++) {
          if (grid[i][j] == target) {
            bfsQ.offer (new int [] {i,j});
            distances[i][j] = 0;
          }
        }
      }

      // we have queue with all target char coordinates

      int [][] directions = new int [][] { {1,0}, {-1,0}, {0,1}, {0,-1} };

      while (!bfsQ.isEmpty()) {
        int [] targetCell = bfsQ.poll();
        for (int[] dir : directions) {
          int x = targetCell[0] + dir[0];
          int y = targetCell[1] + dir[1];
          if (x >=0 && y >=0 && x < grid.length && y < grid[0].length && distances[x][y]==-1) {
            distances[x][y] = distances [targetCell[0]][targetCell[1]] + 1;
            bfsQ.offer(new int []{x,y});
          }
        }
      }
  }

  public static int [][] getTargetDistances (char [][] grid) {
    Map <Character, Character> sources = new HashMap <> ();
    sources.put('R','G');
    sources.put('G','B');
    sources.put('B','R');

    int R = grid.length;
    int C = grid[0].length;

    int [][] output = new int [R][C];

    // Map.Entry <Character, Character> entrySet = sources.entrySet();
    for (Map.Entry <Character, Character> e: sources.entrySet ()) {
      int [][] distances = new int [R][C];
      for (int i=0; i < R; i++){
        Arrays.fill(distances[i],-1);
      }
      bfs(grid,distances,e.getValue());      

      for (int i=0; i < R; i++) {
        for (int j=0; j < C; j++) {
          if (grid[i][j]==e.getKey()) {
            output[i][j] = distances [i][j];
          }
        }
      }
    }
    return output;
  }

  public static void main(String[] args) {
    char [][] grid = new char [5][6];

    grid [0] = new char [] {'R','R','R', 'G', 'R', 'B'};
    grid [1] = new char [] {'B','G','R', 'G', 'R', 'R'};
    grid [2] = new char [] {'R','R','R', 'G', 'R', 'R'};
    grid [3] = new char [] {'R','G','R', 'R', 'R', 'R'};
    grid [4] = new char [] {'G','B','G', 'R', 'G', 'G'};

    int [][] res = getTargetDistances (grid);

    for (int i=0; i < grid.length; i++){
      for (int j=0; j < grid[0].length; j++){
        System.out.println(res[i][j]);
      }
      System.out.println("Row i printed ===");
    }
  }

  // "RRRGRB",
  // "BGRGRR",
  // "RRRGRR",
  // "RGRRRR",
  // "GBGRGG"
  /*
   [2, 1, 1, 2, 1, 1],
  [1, 1, 1, 3, 1, 2],
  [2, 1, 1, 4, 1, 2],
  [1, 1, 1, 1, 1, 1],
  [1, 2, 1, 1, 3, 4]
   */
}
