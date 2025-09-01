/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * T(c) - O(V+E)
 * S(C) - O(V)
 *  * distances array - O(V) space  
* topoOrder list - O(V) space  
* inDegrees array - O(V) space  
* degreeZero list - O(V) space in worst case  
* The key insight is that we're not storing the graph itself - it's given to us as input. We're only using additional data structures that scale with the number of vertices.  
* Now, if the graph were given as an edge list instead of an adjacency list (which is common in some interviews), then we'd need O(V+E) space to convert it to an adjacency list first. But in this problem, the graph is already provided in adjacency list format, so we don't need that conversion.  
* The above clarifies why it's O(V) extra space rather than O(V+E)
// An edge list would be:

edges = [
  [0, 1, 10],    # edge from node 0 to node 1 with weight 10
  [2, 1, 10],    # edge from node 2 to node 1 with weight 10
  [3, 4, 12],    # edge from node 3 to node 4 with weight 12
  [4, 1, 11],    # edge from node 4 to node 1 with weight 11
  [4, 2, 21],    # edge from node 4 to node 2 with weight 21
  [4, 5, 14],    # edge from node 4 to node 5 with weight 14
  [5, 2, -30]    # edge from node 5 to node 2 with weight -30
]
* If you're given an edge list, you'd need to convert it to the adjacency list format (like what you have in your code) before you can run your algorithm.  
* The conversion would involve:  
* Creating an empty adjacency list with V empty lists (one for each vertex)  
* Going through each edge in the edge list and adding it to the appropriate vertex's neighbor list  
* This conversion process requires you to store all E edges in the new adjacency list format, which is why the space complexity becomes O(V+E) instead of just O(V).  
* But since this problem already gives you the graph in adjacency list format, you don't need that conversion step, so your space complexity remains O(V).  

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
  public static List <Double> getDistances(List<List<Edge>> graph, int start) {
    List <Double> distances = new ArrayList <>();
    // compute topological sorting
    List <Integer> topoOrder = getTopoOrder(graph);    
    int V = graph.size();
    for (int i=0; i < V; i++) {
      distances.add(Double.POSITIVE_INFINITY);
    }

    distances.set(start, 0.0);
    for (Integer node : topoOrder){
      if (distances.get(node) == Double.POSITIVE_INFINITY) {
        continue;
      } else {
        for (Edge edge : graph.get(node)) {
          if (distances.get(node) + edge.weight < distances.get(edge.node)) {
            distances.set(edge.node, distances.get(node) + edge.weight);
          }
        }
      }
    }

    return distances;
  }

  public static List <Integer> getTopoOrder (List<List<Edge>> graph) {
    List <Integer> topo = new ArrayList<>();
    int V = graph.size();
    int [] inDegrees = new int [V];
    List<Integer> degreeZero = new ArrayList<>();

    // we made indegrees
    for (int node = 0; node < V ; node++) {
      for (Edge e: graph.get(node)){
        inDegrees[e.node]++;
      }
    }

    for (int node=0; node < V; node++){
      if (inDegrees[node]==0) {
        degreeZero.add(node);
      }
    }

    while (!degreeZero.isEmpty()) {
      int node = degreeZero.remove(degreeZero.size()-1);
      topo.add(node); // add to topo order
      // get all Neighbors
      for (Edge e : graph.get(node)) {
        inDegrees[e.node]--;
        if (inDegrees[e.node]==0) {
          degreeZero.add(e.node);
        }
      }
    }

    if (topo.size() < V) {
      return new ArrayList<>();
    }
    return topo;
  }

  public static void main(String[] args) {
    List<List<Edge>> graph = new ArrayList<>();
    List <Edge> e1 = new ArrayList<>(Arrays.asList(new Edge(1, 10)));
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
    List <Double> distanceFromStart = getDistances (graph,start);
    for (Double d : distanceFromStart) {
      System.out.println(d);
    }
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # DAG Distances

// Given the adjacency list of a DAG (Directed Acyclic Graph) with edge weights, `graph`, and a node, `start`, return the distances from `start` to every other node in an array of length `V` (the number of nodes). Element `i` should be the distance from `start` to node `i`. If `i` cannot be reached from `start`, that element should be `infinity`. The edge weights can be negative.

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

// Output: [infinity, -6, -16, infinity, 0, 14]
// Nodes 0 and 3 are unreachable from node 4.
// ode 4 is at distance 0 from itself.
// The shortest path from node 4 to node 1 is 4 -> 5 -> 2 -> 1.

// Here is the DAG from the example:

// https://iio-beyond-ctci-images.s3.us-east-1.amazonaws.com/dag-distances-1.png

// Constraints:

// - The number of nodes is at most `10^5`
// - The number of edges is at most `10^6`
// - Each node is labeled from `0` to `V-1`
// - The edge weights are integers between `-10^4` and `10^4`
