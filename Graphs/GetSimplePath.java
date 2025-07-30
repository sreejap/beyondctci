/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * Understand dfs logic and pseudocode better
 * 
 */

class Solution {
  public static ArrayList<Integer> getSimplePath (List<ArrayList<Integer>> adjList, int n1, int n2) {
    Map<Integer,Integer> predecessors = new HashMap <>();

    predecessors.put(n2,null); // normally we use set but here we need predecessors so we are using a map
    dfs(n2,predecessors,adjList); // we are starting dfs from node2 so that we don't have reverse the answer in the end
    ArrayList<Integer> res = new ArrayList <>();
    if (!predecessors.containsKey(n2)) {
      return res;
    }
    
    res.add(n1);
    while(res.get(res.size()-1)!=n2) {
      res.add(predecessors.get(res.get(res.size()-1)));
    }
    return res;
  }

  public static void dfs (int n, Map <Integer,Integer> predecessors, List<ArrayList<Integer>> adjList) {

    for (Integer node : adjList.get(n)){
      if (!predecessors.containsKey(node)){
        predecessors.put(node,n);
        dfs(node,predecessors,adjList);
      }
    }

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
    int node2 = 4;

    ArrayList<Integer> path = getSimplePath (adjList, node1, node2);
    for (Integer p : path) {
      System.out.println(p);
    }
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Graph Path

// Given the adjacency list of an undirected graph, `graph`, and two distinct nodes, `node1` and `node2`, return a simple path from `node1` to `node2`.

// A _simple path_ does not repeat any nodes. Return an empty array if there is no path from `node1` to `node2`.

// ```
// Example 1:
// graph = [
//   [1],
//   [0, 2, 5, 4],
//   [1, 4, 5],
//   [],
//   [5, 2, 1],
//   [1, 2, 4]
// ]
// node1 = 0
// node2 = 4

// Output: [0, 1, 4]
// There are other valid answers, like [0, 1, 2, 5, 4].

// Example 2:
// graph = [
//   [1],
//   [0, 2, 5, 4],
//   [1, 4, 5],
//   [],
//   [5, 2, 1],
//   [1, 2, 4]
// ]
// node1 = 0
// node2 = 3

// Output: []
// There is no path to node 3.

// Example 3:
// graph = [
//   [1],
//   [0, 2],
//   [1]
// ]
// node1 = 0
// node2 = 2

// Output: [0, 1, 2]
// A simple path through all nodes.
// ```

// Here is a drawing of the graph from Example 1:

// https://iio-beyond-ctci-images.s3.us-east-1.amazonaws.com/graph-path-1.png

// Constraints:

// - `graph.length ≤ 1000`
// - `graph[i].length < 1000`
// - `0 ≤ graph[i][j] < graph.length`
// - `0 ≤ node1, node2 < graph.length`
// - `node1 != node2`
// - The adjacency list is properly formatted, with no parallel edges or self-loops
