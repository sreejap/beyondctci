Here’s a **quick reference on DFS and BFS “when to do work”**—this will clear up the **pre-order vs post-order** confusion.

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

Do you want me to create **DFS cheat sheet + timing diagram in one image** like your BFS one?
