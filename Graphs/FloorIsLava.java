/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
* Coding Ability: 4/4
* Clean, well-structured code with good method organization
* Proper handling of data structures (ArrayList, HashSet)
* Correct implementation of both graph construction and DFS traversal
* Problem Solving Ability: 4/4
* Immediately recognized this as a graph connectivity problem
* Correctly identified nodes (furniture) and edges (reachable pairs)
* Implemented the optimal approach without needing hints
* Handled the tricky distance calculation between rectangles perfectly
* Communication Skills: 4/4
* Clearly explained your approach from the beginning
* Walked through your thinking process step by step
* Accurately analyzed time and space complexity
* Explained the distance calculation logic thoroughly
* You demonstrated strong technical skills by recognizing the graph pattern, implementing an efficient solution, and explaining your reasoning clearly throughout.
* Your distance calculation was particularly impressive - correctly handling both overlapping and separated rectangles.
* Great work!
 *
 * If you need more classes, simply define them inline.
 */

class Solution {  

  public static double distance(List <Integer> f1, List <Integer> f2) {
    // important to understand below logic
    //  I am computing the xGap and yGap --- if they don't share an edge or corner, xGap is the difference of their Maximum start values and Minimum end values ... if they share an edge or corner we get negative value for the differnce so I return 0 in that case...Similarly 
    // , yGap is either 0 if they share an edge or corner or the difference of their maximum starting y values and minimum ending y values ... then the distance is euclidean distance between the xgap and ygap which is Square root of xgap*xgap + ygap*ygap
    int xGap = Math.max(0, Math.max(f1.get(0), f2.get(0)) - Math.min(f1.get(2), f2.get(2))) ; // max of start x coordinates - min of start y coordinates
    int yGap = Math.max(0,Math.max(f1.get(1),f2.get(1)) - Math.min(f1.get(3),f2.get(3)));
    double distance = Math.sqrt((xGap*xGap) + (yGap*yGap));
    return distance;
  }

  public static List<List<Integer>> createGraph (List<List<Integer>> furniture,int d) {
    List<List<Integer>> graph = new ArrayList<>();

    // initialize the graph
    for (int i=0; i < furniture.size(); i++){
      graph.add(new ArrayList<>());
    }

    for (int i=0; i < furniture.size(); i++) {
      for (int j=i+1; j < furniture.size(); j++) {
        if (distance(furniture.get(i),furniture.get(j)) <= d) {
          graph.get(i).add(j);
          graph.get(j).add(i);
        }
      }
    }
    return graph;
  }

  public static boolean isReachable (List<List<Integer>> furniture, int distance) {
    List<List<Integer>> graph = createGraph (furniture,distance);
    Set <Integer> visited = new HashSet<>();    
    dfs(graph,0,visited);
    return visited.contains(furniture.size()-1);
  }

  public static void dfs (List<List<Integer>> graph,int f, Set <Integer> visited) {
    if (visited.contains(f)) {
      return;
    }

    visited.add(f);
    for (Integer e : graph.get(f)) {
      if (!visited.contains(e)) {
        dfs(graph, e, visited);
      }
    }
  }
  
  public static void main(String[] args) {
    List<List<Integer>> furniture = new ArrayList <>();
    furniture.add(new ArrayList<>(Arrays.asList(1,1,9,5)));
    furniture.add(new ArrayList<>(Arrays.asList(12, 9, 20, 13)));
    furniture.add(new ArrayList<>(Arrays.asList(16, 2, 22, 7)));
    furniture.add(new ArrayList<>(Arrays.asList(24, 9, 26, 11)));
    furniture.add(new ArrayList<>(Arrays.asList(29, 1, 31, 5)));
    int distance = 5;   



    //   [1, 1, 9, 5],
//   [12, 9, 20, 13],
//   [16, 2, 22, 7],
//   [24, 9, 26, 11],
//   [29, 1, 31, 5]

    boolean res1 = isReachable (furniture,4);
    boolean res2 = isReachable (furniture,5);
    System.out.println("res1 " +  res1);
    System.out.println("res2 " +  res2);
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # The Floor Is Lava

// We are given an array, `furniture`, where each element consists of four integer coordinates, `[x_min, y_min, x_max, y_max]`, indicating the boundary of a rectangular piece of furniture. The furniture pieces are non-overlapping (they can share an edge or a corner).

// We are playing the game 'the floor is lava,' where we have to reach from the first piece of furniture (the one at index `0` in `furniture`) to the last one without touching the floor, only jumping on furniture. If we can jump at most a distance of `d`, where `d` is an integer, can we win?

// Recall that:

// `distance((x1, y1), (x2, y2)) = sqrt((x1 - x2)^2 + (y1 - y2)^2)`.

// For example, if this is the furniture and `d` is `5`, we can jump from the furniture labeled `0` to the one labeled `4` with the indicated jumps:

// https://iio-beyond-ctci-images.s3.us-east-1.amazonaws.com/the-floor-is-lava-1.png

// However, if `d` is `4` for the same furniture, we can't do it.

// ```
// Example 1:
// furniture = [
//   [1, 1, 9, 5],
//   [12, 9, 20, 13],
//   [16, 2, 22, 7],
//   [24, 9, 26, 11],
//   [29, 1, 31, 5]
// ]
// d = 5

// Output: True
// See the image above

// Example 2:
// furniture = [
//   [1, 1, 9, 5],
//   [12, 9, 20, 13],
//   [16, 2, 22, 7],
//   [24, 9, 26, 11],
//   [29, 1, 31, 5]
// ]
// d = 4
// Output: False
// See the image above
// ```

// Constraints:

// - `2 <= furniture.length <= 1000`
// - `furniture[i]` is a list of `4` integers
// - `0 <= furniture[i][0] < furniture[i][2] < 10^9`
// - `0 <= furniture[i][1] < furniture[i][3] < 10^9`
// - The furniture pieces are non-overlapping
// - `0 < d <= 10^9`
// - All coordinates and distances are floating-point numbers
