/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 * Time: O(V + E) for topological sort and path count. Extra space: O(V).
 * Why do we need to use topological sorting - If you processed a node before all its predecessors, you wouldn't have the complete count of paths to that node yet, so when you propagate paths to its neighbors, you'd be using an incomplete count.
 * The topological order ensures that when you process any node, you've already processed all nodes that can reach it, so you have the final count of paths to that node.
 */

class Solution {
  public static List <Integer> getTopoOrder (ArrayList <ArrayList<Integer>> graph) {
    int V = graph.size();
    int [] degrees = new int [V];
    List <Integer> topoOrder = new ArrayList <>();
    List <Integer> degreeZero = new ArrayList <>();
    for (int u=0; u < V; u++) {
      List <Integer> edges = graph.get(u);
      for (Integer v : edges) {
        degrees[v]++; // incrementing the degrees 
      }
    }

    for (int n = 0; n < degrees.length; n++) {
      if (degrees[n] ==0) {
        degreeZero.add(n);
      }
    }

    while (!degreeZero.isEmpty()) {
      int next = degreeZero.remove(degreeZero.size()-1);
      topoOrder.add(next);
      for (Integer e : graph.get(next)) {
        degrees[e]--;
        if(degrees[e]==0){
          degreeZero.add(e);
        }
      }
    }

    if (topoOrder.size() < V) {
      topoOrder = new ArrayList <>();
    }
    return topoOrder;
  }

  public static List <Integer> countPaths (ArrayList <ArrayList<Integer>> graph, int start) {
    List <Integer> topoOrder = getTopoOrder (graph);
    List <Integer> paths = new ArrayList <>();
    for (int i=0; i < graph.size(); i++){
      paths.add(0);
    }

    paths.set(start,1);
    for (Integer u : topoOrder) {
      List <Integer> edges = graph.get(u);
      for (Integer v : edges) {
        paths.set(v, paths.get(v)+paths.get(u));
      }
    }
    return paths;
  }

  public static void main(String[] args) {    
    ArrayList <ArrayList<Integer>> graph = new ArrayList <>();
    graph.add(new ArrayList<>(Arrays.asList(1)));
    graph.add(new ArrayList<>());
    graph.add(new ArrayList<>(Arrays.asList(1)));
    graph.add(new ArrayList<>(Arrays.asList(4)));
    graph.add(new ArrayList<>(Arrays.asList(1,2,5)));
    graph.add(new ArrayList<>(Arrays.asList(2)));

    int start = 4;
    List <Integer> paths = countPaths (graph, start);

    for (Integer e : paths) {
      System.out.println(e);
    }

  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Counting Paths

// Given the adjacency list of an **unweighted** DAG, `graph`, and a node, `start`, return an array of length `V` (the number of nodes) with the number of different paths from `start` to every node.

// Example:
// graph = [
//   [1],        # Neighbors of node 0
//   [],         # Neighbors of node 1
//   [1],        # Neighbors of node 2
//   [4],        # Neighbors of node 3
//   [1, 2, 5],  # Neighbors of node 4
//   [2]         # Neighbors of node 5
// ]
// start = 4

// Output: [0, 3, 2, 0, 1, 1]
// Nodes 0 and 3 are unreachable from node 4.
// There is a single path from 4 to itself, the empty path.
// There are 3 paths from node 4 to node 1:
//     4 -> 1,
//     4 -> 2 -> 1,
//     4 -> 5 -> 2 -> 1

// Constraints:

// - The number of nodes is at most `10^5`
// - The number of edges is at most `10^6`
// - Each node is labeled from `0` to `V-1`
