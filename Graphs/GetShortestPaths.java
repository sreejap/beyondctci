/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * Time complexity - O(V + E + n*V), where n is the number of queries.
*  Space complexity -   o(V) for the predecessors map + o(n*V) ... where n is number of queries and V is the max number of predecessors , simplified to O(n*V)
 * This is a good question
 * 
 */

class Solution {

  public static List <List<Integer>> getShortestPaths (List<ArrayList<Integer>> adjList, int start, int [] queries) {

    Queue <Integer> bfsQ = new LinkedList<>();
    Map <Integer, Integer> predecessors = new HashMap <>();

    bfsQ.offer(start);
    predecessors.put(start,null);

    while (bfsQ.size()!=0) {      
      // we pop from the q here
      int node = bfsQ.poll();  
      // we process only neighbors here
      ArrayList<Integer> nbrs = adjList.get(node);
      for ( Integer nb: nbrs){
        if (!predecessors.containsKey(nb))  {
          bfsQ.offer(nb);        
          predecessors.put (nb,node);
        }
      }
    }

    List <List<Integer>> res = new ArrayList<>();
    for (int q : queries) {
      if (!predecessors.containsKey(q)) {
        res.add(new ArrayList<>());
      }else {
        List <Integer>path  = new ArrayList<>();
        path.add(q);
        while (path.get(path.size()-1)!=start) {
          path.add(predecessors.get(path.get(path.size()-1)));
        }
        Collections.reverse(path);
        res.add(path);
      }
    }    

    return res;
  }



  public static void main(String[] args) {
    List<ArrayList<Integer>> adjList = new ArrayList <>();
    adjList.add(new ArrayList<>(Arrays.asList(1))); // 0
    adjList.add(new ArrayList<>(Arrays.asList(0,2,5,4))); // 1
    adjList.add(new ArrayList<>(Arrays.asList(1,4,5))); // 2
    adjList.add(new ArrayList<>()); // 3
    adjList.add(new ArrayList<>(Arrays.asList(5,2,1))); // 4
    adjList.add(new ArrayList<>(Arrays.asList(1,2,4))); // 5
  
    int node1 = 0;
    int [] queries =new int [] { 1, 0, 3, 4 };

    List <List<Integer>> res = getShortestPaths (adjList, node1, queries);

    for (List <Integer> l : res) {
      System.out.println("Printing next query path: " + l.size());
      for (Integer p : l) {
        System.out.println(p);
      }
    }
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Shortest Path Queries

// You are given the adjacency list of an undirected graph, `graph`, a node index, `start`, and an array, `queries`, where each element is a node index.

// Return an array with the same length as `queries`, where the `i`-th element is an array with the shortest path from `start` to `queries[i]`.

// If there is no path from `start` to `queries[i]`, return an empty array for the `i`-th element.

// ```
// Example 1:
// graph = [
//    [1],           # Node 0
//    [0, 2, 5, 4],  # Node 1
//    [1, 4, 5],     # Node 2
//    [],            # Node 3
//    [5, 2, 1],     # Node 4
//    [1, 2, 4]      # Node 5
// ]
// start = 0
// queries = [1, 0, 3, 4]

// Output: [[0, 1], [0], [], [0, 1, 4]]
// Node 3 cannot be reached from node 0

// Example 2:
// graph = [
//    [1],           # Node 0
//    [0, 2],        # Node 1
//    [1]            # Node 2
// ]
// start = 0
// queries = [1, 2]

// Output: [[0, 1], [0, 1, 2]]

// Example 3:
// graph = [
//    [1],           # Node 0
//    [0],           # Node 1
//    [3],           # Node 2
//    [2]            # Node 3
// ]
// start = 0
// queries = [1, 2, 3]

// Output: [[0, 1], [], []]
// Can only reach node 1 from node 0
// ```

// Graph from example 1:

// https://iio-beyond-ctci-images.s3.us-east-1.amazonaws.com/shortest-path-queries-1.png

// Constraints:

// - `graph.length <= 10^4`
// - `graph[i].length < 10^4`
// - `0 <= graph[i][j] < graph.length`
// - `0 <= start < graph.length`
// - `queries.length <= 10^3`
// - `0 <= queries[i] < graph.length`
// - The graph is well-formed, with no parallel edges or self-loops
