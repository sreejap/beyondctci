/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Edge {
  int node;
  int weight;
  Edge (int n, int w) {
    node = n;
    weight = w;
  }


}

class Solution {
  public static List <Integer> getTopologicalOrder (List <List <Edge>> graph) {
    // get degree for each and start with indegree zero
    int V = graph.size();
    int [] inDegrees = new int [V];
    List <Integer> degreeZero = new ArrayList<>();

    for (int i=0; i < graph.size(); i++) {
      for (Edge e: graph.get(i)) {
        int n = e.node;
        inDegrees[n]++;         
      }      
    }

    List <Integer> topoOrder = new ArrayList <>();
    for (int i=0; i < inDegrees.length; i++) {
      if (inDegrees[i]==0){
        degreeZero.add(i);        
      }
    }

    while(!degreeZero.isEmpty()) {
      // get edges and remove them
      int next = degreeZero.remove(degreeZero.size()-1);
      List <Edge> edges = graph.get(next);
      topoOrder.add(next);
      for (Edge e : edges) {
        inDegrees [e.node]--;
        if (inDegrees[e.node] == 0){
          degreeZero.add(e.node);          
        }
      }
    }

    if (topoOrder.size()!=V) {
      topoOrder = new ArrayList<>();
    }

    return topoOrder;
  }

  public static List <Integer> getLongestPathNodes (List<List <Edge>> graph, int start) {
      
      List <Integer> topologicalOrder = getTopologicalOrder (graph);
              // System.out.println(graph.size());
      
      // List<Integer> distances = new ArrayList<>(graph.size()); ... only sets the capacity
      // it doesn't create the list

      List<Integer> distances = new ArrayList<>(Collections.nCopies(graph.size(), Integer.MIN_VALUE)); // this would create the list and fills it with values ...       

      for (int i=0; i < distances.size(); i++) {
        if (i==start) {
          distances.set(start,0); // SETTING all nodes as max distances
          // except to self
        }
      }
      

      // for (int i=0; i < distances.size();i++){
      //   System.out.println(distances.get(i));
      // }

      for (Integer u : topologicalOrder) {
        if (distances.get(u) == Integer.MIN_VALUE) {
          continue; 
        }

        List <Edge> edges = graph.get(u);

        for (Edge e : edges) {
          Integer v = e.node;
          Integer w = e.weight;
          if (distances.get(u) + w > distances.get(v)) {
            distances.set(v, distances.get(u)+w);
          }
        }
      }
      return distances;
  }
  public static void main(String[] args) {
    List <List <Edge>> graph = new ArrayList <>();
    List <Edge> e1= new ArrayList <> (Arrays.asList (new Edge(1,10)));

    // creating a new edge to node and with weight, then make it a fixed size list of 
    // one element and then wrap it in ArrayList to make it 
    // resizable list

    List <Edge> e2 = new ArrayList<>();
    List <Edge> e3 = new ArrayList<>(Arrays.asList(new Edge(1, 10)));
    List <Edge> e4 = new ArrayList<>(Arrays.asList(new Edge(4, 12)));
    List <Edge> e5 = new ArrayList<>(Arrays.asList(new Edge(1, 11), new Edge(2, 21), new Edge(5, 14)));
    List <Edge> e6 = new ArrayList<>(Arrays.asList(new Edge(2, -30)));

    graph.add(e1);
    graph.add(e2);
    graph.add(e3);
    graph.add(e4);
    graph.add(e5);
    graph.add(e6);

    int start = 4;
    List <Integer> longestPathnodes = getLongestPathNodes (graph,start);
    for (Integer e : longestPathnodes){
      System.out.println(e);
    }
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # DAG Longest Path

// Given the adjacency list of a DAG with edge weights, `graph`, and a node, `start`, return an array of length `V` (the number of nodes) with the length of the longest path from `start` to every other node (or `-infinity` if the node is unreachable). The edge weights can be negative.

// Example:
// graph = [
//   [[1, 10]],                    # Neighbors of node 0
//   [],                           # Neighbors of node 1
//   [[1, 10]],                    # Neighbors of node 2
//   [[4, 12]],                    # Neighbors of node 3
//   [[1, 11], [2, 21], [5, 14]],  # Neighbors of node 4
//   [[2, -30]]                    # Neighbors of node 5
// ]
// start = 4

// Output: [-infinity, 31, 21, -infinity, 0, 14]
// Nodes 0 and 3 are unreachable from node 4.
// The longest path from node 4 to node 1 is 4 -> 2 -> 1.

// Here is the DAG from the example:

// https://iio-beyond-ctci-images.s3.us-east-1.amazonaws.com/dag-distances-1.png

// Constraints:

// - The number of nodes is at most `10^5`
// - The number of edges is at most `10^6`
// - Each node is labeled from `0` to `V-1`
// - The edge weights are integers between `-10^4` and `10^4`
