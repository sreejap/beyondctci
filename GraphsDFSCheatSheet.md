Absolutely! DFS can feel trickier because it involves **backtracking and recursion**, and unlike BFS, you don’t see the layers as clearly. Here’s your **DFS Cheat Sheet** with the core patterns and mental models.

---

## **DFS Cheat Sheet (Core Patterns)**

---

### **1️⃣ Recursive DFS on Graph (Adjacency List)**

**Use when:**

* Graph traversal, connected components, cycle detection.

```java
void dfs(int node, List<Integer>[] graph, boolean[] visited) {
    visited[node] = true;            // Mark visited

    for (int nbr : graph[node]) {    // Explore neighbors
        if (!visited[nbr]) {
            dfs(nbr, graph, visited);
        }
    }
}
```

**Key Points:**

* Mark **visited immediately** to avoid infinite loops.
* No queue needed, recursion handles the stack.

---

### **2️⃣ DFS on Grid (Backtracking Style)**

**Use when:**

* Maze problems, number of islands, flood fill.

```java
void dfsGrid(int r, int c, int[][] grid, boolean[][] visited) {
    int m = grid.length, n = grid[0].length;
    if (r < 0 || r >= m || c < 0 || c >= n) return;  // Out of bounds
    if (visited[r][c] || grid[r][c] == 0) return;     // Blocked or visited

    visited[r][c] = true;  // Mark visited

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    for (int[] d : dirs) {
        dfsGrid(r+d[0], c+d[1], grid, visited);
    }
}
```

**Key Points:**

* Always check **bounds + visited + valid cell**.
* Can be used to count components like islands or regions.

---

### **3️⃣ DFS with Backtracking (Path or Combination Problems)**

**Use when:**

* Need to **explore all paths** (like word search, permutations, subsets).

```java
void dfsBacktrack(int node, List<Integer> path, boolean[] visited, List<List<Integer>> result) {
    path.add(node);               // Choose
    visited[node] = true;

    // Record or explore
    for (int nbr : graph[node]) {
        if (!visited[nbr]) {
            dfsBacktrack(nbr, path, visited, result);
        }
    }

    visited[node] = false;        // Un-choose (backtrack)
    path.remove(path.size()-1);
}
```

**Key Points:**

* **Backtracking = choose → explore → un-choose**.
* Used in **Hamiltonian paths, word search, combinations**.

---

### **4️⃣ Iterative DFS (Using Stack)**

**Use when:**

* You want DFS but **no recursion** (or stack overflow risk).

```java
Stack<Integer> stack = new Stack<>();
boolean[] visited = new boolean[n];

stack.push(start);
while (!stack.isEmpty()) {
    int node = stack.pop();
    if (visited[node]) continue;
    visited[node] = true;

    for (int nbr : graph[node]) {
        if (!visited[nbr]) stack.push(nbr);
    }
}
```

**Key Points:**

* Works like recursive DFS but with **manual stack**.
* Popping from stack → “deep” exploration first.

---

💡 **Mental Model for DFS**

* **BFS = wave / spreading** → shortest paths.
* **DFS = diving deep** → exploring paths or components.
* Always think in terms of **visited** and **call stack (implicit or explicit)**.

---

**Work Timing Patterns**
Here’s a **quick reference on DFS “when to do work”**—this will clear up the **pre-order vs post-order** confusion.

---

## **DFS Work Timing Patterns**

When you call DFS on a node, there are **3 main spots** where you can do work:

1️⃣ **Before visiting neighbors** → **Pre-order**
2️⃣ **While exploring neighbors** → Rare, but used for pruning
3️⃣ **After visiting neighbors** → **Post-order**

---

### **1️⃣ Pre-order DFS (Do work before exploring neighbors)**

**Use when:**

* You want to **record paths, count nodes, mark order of discovery**.
* Example: **Collect all nodes in a component** or **record DFS traversal path**.

```java
void dfs(int node) {
    visited[node] = true;
    
    // Pre-order work: do something with the node
    result.add(node);  

    for (int nbr : graph[node]) {
        if (!visited[nbr]) {
            dfs(nbr);
        }
    }
}
```

**Output example:** `[root, left, right]` for trees.

---

### **2️⃣ Post-order DFS (Do work after exploring neighbors)**

**Use when:**

* You need results from **children/subtrees first**.
* Example:

  * **Topological sort** (add node after processing all children)
  * **Compute subtree size or sum**

```java
void dfs(int node) {
    visited[node] = true;
    
    for (int nbr : graph[node]) {
        if (!visited[nbr]) {
            dfs(nbr);
        }
    }
    
    // Post-order work
    topo.add(node);  // Add after all children are processed
}
```

**Output example:** `[left, right, root]` for trees.

---

### **3️⃣ Work while exploring neighbors (Rare)**

**Use when:**

* You want to **prune** or **count edges** as you traverse.
* Example: Counting back edges in cycle detection.

---

💡 **Mental Model:**

* **Pre-order → when you care about entering a node.**
* **Post-order → when you care about finishing a node.**
* **BFS → naturally “pre-order only”** because you process level by level.

---
