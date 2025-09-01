/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * You've done an excellent job working through this problem! You successfully: Identified that topological sorting was the right approach for a DAG
 * Implemented the topological sort correctly using Kahn's algorithm Applied the relaxation technique to compute shortest distances
 * Used a predecessors map to reconstruct the actual path. Debugged the null pointer exception and path reconstruction issues. Correctly analyzed both time O(V + E) and space O(V) complexity
 * This demonstrates strong problem-solving skills and good understanding of graph algorithms. In a real interview setting, you would pass this question.
 * Areas for Improvement
 * Be more confident in your initial algorithmic intuitions. Practice explaining your approach completely before starting to code. Work on getting edge relaxation logic correct on the first try (this is a common pattern in shortest path algorithms)
 * * **What Went Well**  
  * You correctly identified the DAG structure as key to the solution  
  * Your topological sort implementation was solid  
  * You handled the path reconstruction elegantly with the predecessors map  
  * You caught and fixed bugs systematically  
  * Your complexity analysis was accurate and well-reasoned  
  * You demonstrated good learning agility when guided toward the right approach  

* **For E5+ Preparation**  
  You're on the right track for senior roles. Continue focusing on:  
  * Recognizing optimal approaches more quickly without hints  
  * Being more decisive about algorithmic choices upfront  
  * Practicing similar graph problems (DAG longest path, critical path, etc.)  
  * Working on system design alongside algorithms  

* **Final Verdict**  
  Strong performance that would result in a hire recommendation for senior engineering roles. You demonstrated the problem-solving skills, coding ability, and technical communication needed at E5+ level.  
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
  public static List<Integer> getTopologicalOrder (List<List<Edge>> graph) {
    int V = graph.size();
    int [] inDegrees = new int [V];

    for (int i=0; i < graph.size(); i++) {
      List<Edge> edges = graph.get(i);
      for (Edge e: edges) {
        inDegrees[e.node]++;
      }
    }

    List <Integer> zeroDegrees = new ArrayList<>();
    for (int i=0; i < V; i++){
      if (inDegrees[i] == 0) {
        zeroDegrees.add(i);
      }
    }

    List <Integer> topoOrder = new ArrayList<>();

    while (!zeroDegrees.isEmpty())  {
      Integer node = zeroDegrees.remove(zeroDegrees.size()-1);
      topoOrder.add(node);

      for (Edge e : graph.get(node)) {
        inDegrees[e.node]--;
        if (inDegrees[e.node]==0) {
          zeroDegrees.add(e.node);
        }
      }
    }
    if (topoOrder.size()!= V) {
      topoOrder = new ArrayList<>();
    }
    return topoOrder;
  }    

  public static List <Integer> computeShortestPath (List<List<Edge>> graph,int start, int goal) {
    List <Integer> topologicalOrder = getTopologicalOrder(graph);
    List <Integer> shortestPath = new ArrayList<>();
    Map <Integer,Integer> predecessors = new HashMap<>();
    Map <Integer,Integer> distances = new HashMap<>();
    distances.put(start,0); // start to start is 0 distance
    
    for (Integer v : topologicalOrder) {
      List <Edge> edges = graph.get(v);
      for (Edge e : edges) {
        if (!distances.containsKey(v)) {
          continue;
        }
        // notes:  That relaxation condition is the heart of the algorithm: First visit: If we haven't reached e.node before, this is our first path to it, so we take it
        // Better path: If we have reached e.node before, but the path through v is shorter, we update to the better path And you're absolutely right that because we process nodes in topological order in a DAG, when we relax an edge v -> e.node, we're guaranteed that the distance to v is already optimal - it can't be improved later.
        // The predecessor tracking is what makes path reconstruction possible, and your understanding of how it all fits together is spot on. This is exactly the kind of clear reasoning that would impress an interviewer!
        if (!distances.containsKey(e.node) || distances.get(v) + e.weight < distances.get(e.node)) {
          distances.put(e.node, distances.get(v) + e.weight);
          predecessors.put(e.node,v);
        }
      }      
    }

    if (!predecessors.containsKey(goal)) {
      return shortestPath;
    }

    shortestPath.add(goal);
    Integer next = predecessors.get(goal); // goal parent
    while(!shortestPath.contains(start) && predecessors.containsKey(next)) {

      shortestPath.add(next);
      next = predecessors.get(next);
    }
    shortestPath.add(start);
    Collections.reverse(shortestPath);
    return shortestPath;
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
    int goal = 1;

    List <Integer> shortestPath = computeShortestPath (graph,start,goal);

    for (Integer e : shortestPath) {
      System.out.println(e);
    }
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # DAG Path Reconstruction

// Given the adjacency list of a DAG with edge weights, `graph`, and a pair of nodes, `start` and `goal`, return the shortest path from `start` to `goal`, or an empty array if `goal` cannot be reached from `start`. The edge weights can be negative.

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
// goal = 1

// Output: [4, 5, 2, 1]
// The shortest path from node 4 to node 1 is 4 -> 5 -> 2 -> 1.

// Here is the DAG from the example:

// https://iio-beyond-ctci-images.s3.us-east-1.amazonaws.com/dag-distances-1.png

// Constraints:

// - The number of nodes is at most `10^5`
// - The number of edges is at most `10^6`
// - Each node is labeled from `0` to `V-1`
// - The edge weights are integers between `-10^4` and `10^4`
