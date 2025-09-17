### Cheat sheet
- [Python sample cheat sheet](https://docs.google.com/document/d/1LtXh1oew6pZ9D4s5mw_33jzA2UwBfnv9jWh1bkSRTCc/edit?tab=t.0#heading=h.3enwkjss5q83)

## Java programming snippets
Here is how to initialize list of lists:

      List<ArrayList<Integer>> adjList = new ArrayList <>();
      adjList.add(new ArrayList<>(Arrays.asList(1))); // 0
      adjList.add(new ArrayList<>(Arrays.asList(0,2,5,4))); // 1
      adjList.add(new ArrayList<>(Arrays.asList(1,4,5))); // 2
      adjList.add(new ArrayList<>()); // 3
      adjList.add(new ArrayList<>(Arrays.asList(5,2,1))); // 4
      adjList.add(new ArrayList<>(Arrays.asList(1,2,4))); // 5

## Graphs
- First step in many graph questions is transforming an edge list to an adjacency list
- Adjacency list is default but we use Adjacency matrix in case we know that graph is dense
- One advantage of adjacecny matrix over the adjacency list is that we can check if two nodes, a and b, are neighbors in O(1) time - we simply check if matrix[a][b] is true. However, as mentioned, we can achieve the same with an adjacency list if we turn the inner lists in sets.
- [Graph DFS](https://start.interviewing.io/beyond-ctci/part-vii-catalog/graphs#recipe-1)
- [Graph Connected component loop](https://start.interviewing.io/beyond-ctci/part-vii-catalog/graphs#recipe-2)
- [Connected component loop recipe. This technique of tracking predecessors during a graph traversal and then reconstructing the path by following them is a reusable idea in graph algorithms.](https://github.com/sreejap/beyondctci/blob/master/Graphs/GetSimplePath.java)
- [Graphs tips](https://interviewing.io/graphs-interview-questions)

