/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * What can I do to improve:
 *  it's a common mistake to forget to add nodes to the BFS queue when you discover them and add them to the distances map.
 * 
 */

class Solution {

  public static Map <Integer, Integer> bfs (List<List<Integer>> adjList, int n) {
    Queue <Integer> bfsQ = new LinkedList<>();
    bfsQ.offer(n);

    Map <Integer,Integer> distances = new HashMap<>();
    distances.put(n,0);
    while (bfsQ.size()!=0){
      int node = bfsQ.poll();
      for (Integer e : adjList.get(node)) {
        if (!distances.containsKey(e)) {
          distances.put(e, distances.get(node)+1);
          bfsQ.offer(e); // we have to add to the queue
        }
      }
    }

    for (Integer key : distances.keySet() ){
      System.out.println("Key: " + key + " val: " + distances.get(key));
    }

    return distances;
  }

  public static int getMinEdges(List<List<Integer>> adjList, int n1, int n2,int n3) {

    Map <Integer,Integer> d1 = bfs (adjList,n1);
    Map <Integer,Integer> d2 = bfs (adjList,n2);
    Map <Integer,Integer> d3 = bfs (adjList,n3);

    int res = Integer.MAX_VALUE;

    for (int i=0; i < adjList.size(); i++) {
      res = Math.min(res, d1.get(i) + d2.get(i) + d3.get(i));
    }

    return res;
  }

  public static void main(String[] args) {
    List<List<Integer>> adjList = new ArrayList<>();
    adjList.add(new ArrayList<>(Arrays.asList(1,4)));
    adjList.add(new ArrayList<>(Arrays.asList(0,2)));
    adjList.add(new ArrayList<>(Arrays.asList(1,3)));
    adjList.add(new ArrayList<>(Arrays.asList(2,4)));
    adjList.add(new ArrayList<>(Arrays.asList(0,3)));
    int res = getMinEdges(adjList, 0,2,4);

    System.out.println("res " + res);
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Graph Hangout

// Three friends want to meet. They live in nodes in a connected, undirected graph.

// You are given the adjacency list, `graph`, and the nodes where they start, `node1`, `node2`, and `node3`.

// Return the minimum number of edges they need to traverse in total between the three to meet at _any_ node in the graph.

// For example, for this graph:

// https://iio-beyond-ctci-images.s3.us-east-1.amazonaws.com/graph-hangout-1.png

// If the three friends start at the nodes labeled `1`, `2` and `3`, they can each get to the middle node by traversing `3` edges. The next closest meeting point is at one of the starting nodes, where the other two friends have to traverse `5` edges each. Thus, the answer is `9`.

// ```
// Example 1:
// graph = [
//     [1, 4],   # Node 0
//     [0, 2],   # Node 1
//     [1, 3],   # Node 2
//     [2, 4],   # Node 3
//     [0, 3]    # Node 4
// ]
// node1 = 0
// node2 = 2
// node3 = 4

// Output: 3
// They can meet at node 0 or 4 in combined 3 steps

// Example 2:
// graph = [
//     [1, 2, 3],  # Node 0
//     [0, 2, 3],  # Node 1
//     [0, 1, 3],  # Node 2
//     [0, 1, 2]   # Node 3
// ]
// node1 = 0
// node2 = 1
// node3 = 2

// Output: 2
// In a complete graph, they can meet at any node
// ```

// Constraints:

// - `graph.length <= 10^4`
// - `graph[i].length < 10^4`
// - `0 <= graph[i][j] < graph.length`
// - `0 <= node1, node2, node3 < graph.length`
// - The graph is well-formed, with no parallel edges or self-loops
