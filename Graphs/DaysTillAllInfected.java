/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * This problem uses multi source BFS 
 * Here is the reasoning - By the end of the multi-source BFS, every node has been "reached" (infected) and your distances map contains the minimum number of days it took for the infection to reach each node from any of the initially infected nodes.
 * The maximum of all those distances represents the node that took the longest to get infected - which is exactly when all nodes in the network will be infected.
 * T(C) - O(V+E) since we visit each node and edge once
 * S(C) - O(V) for the map plus O(V) for the queue, because by the end of bfs all nodes will be in the distance map
 */

class Solution {

  public static int daysToInfect (List<List<Integer>> adjList, List<Integer>infectedNodes) {

    Queue <Integer> bfsQ = new LinkedList <>();
    Map <Integer, Integer> distances = new HashMap <>();
    for (Integer e : infectedNodes) {  
      bfsQ.offer(e);
      distances.put(e,0);
    }

    while (!bfsQ.isEmpty()){
      Integer next = bfsQ.poll();

      for (Integer nb: adjList.get(next)) {
        if (!distances.containsKey(nb)) {
          distances.put(nb, distances.get(next)+1);
          bfsQ.offer(nb);
        }
      }
    }

    int res = Integer.MIN_VALUE;
    for (Integer d: distances.values()){
      res = Math.max(res,d);
    }
    return res;
  }

  public static void main(String[] args) {

    List<List<Integer>> adjList = new ArrayList <>();
    adjList.add(new ArrayList<>(Arrays.asList(1,2)));
    adjList.add(new ArrayList<>(Arrays.asList(0,2)));
    adjList.add(new ArrayList<>(Arrays.asList(0,1,3)));
    adjList.add(new ArrayList<>(Arrays.asList(2)));   

    List<Integer>  infectedNodes = new ArrayList <>();
    infectedNodes.add(0);
    int timeTaken = daysToInfect (adjList,infectedNodes);
    System.out.println(timeTaken);
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Days Until All Infected

// Some computers in a network have been infected by a virus. We are given the adjacency list of an undirected, **connected** graph, `graph`, representing the computer network, and an array, `infected`, with the indices of the infected nodes.

// Every day, the virus spreads to all computers directly connected to an infected neighbor computer.

// How many days will it take to infect all computers?

// For example, for this graph:

// https://iio-beyond-ctci-images.s3.us-east-1.amazonaws.com/days-until-all-infected-1.png

// It takes 3 days for the virus to infect all computers.

// ```
// Example 1:
// graph = [
//   [1, 2],       # Node 0
//   [0, 2],       # Node 1
//   [0, 1, 3],    # Node 2
//   [2]           # Node 3
// ]
// infected = [0]

// Output: 2
// On day 1, nodes 1 and 2 get infected
// On day 2, node 3 gets infected

// Example 2:
// graph = [
//   [1],          # Node 0
//   [0, 2],       # Node 1
//   [1, 3],       # Node 2
//   [2, 4],       # Node 3
//   [3],          # Node 4
// ]
// infected = [0, 4]

// Output: 2
// The virus spreads through the line graph from both ends.

// Example 3:
// graph = [
//   [1, 2],       # Node 0
//   [0, 3],       # Node 1
//   [0, 3],       # Node 2
//   [1, 2],       # Node 3
// ]
// infected = [0, 3]

// Output: 1. With two initial infected nodes, all other nodes are infected after one day.
// ```

// Constraints:

// - `1 <= graph.length <= 10^4`
// - `graph[i].length < 10^4`
// - `0 <= graph[i][j] < graph.length`
// - `1 <= infected.length <= graph.length`
// - `0 <= infected[i] < graph.length`
// - `infected` does not contain duplicates
// - The graph is well-formed, with no parallel edges or self-loops
// - The graph is connected
