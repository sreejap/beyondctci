### Cheat sheet
- [Python sample cheat sheet](https://docs.google.com/document/d/1LtXh1oew6pZ9D4s5mw_33jzA2UwBfnv9jWh1bkSRTCc/edit?tab=t.0#heading=h.3enwkjss5q83)

## Graphs
- First step in many graph questions is transforming an edge list to an adjacency list
- Adjacency list is default but we use Adjacency matrix in case we know that graph is dense
- One advantage of adjacecny matrix over the adjacency list is that we can check if two nodes, a and b, are neighbors in O(1) time - we simply check if matrix[a][b] is true. However, as mentioned, we can achieve the same with an adjacency list if we turn the inner lists in sets.
- Graph DFs
-   def graph_DFS(graph, start):
  visited = {start}
  def visit(node):
    # Do something with node. 
    for nbr in graph[node]:
      if not nbr in visited:
        visited.add(nbr)
        visit(nbr)
  visit(start)
