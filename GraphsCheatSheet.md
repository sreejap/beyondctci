
---

Here’s your **BFS Cheat Sheet** for quick recall 🚀

---

## **1️⃣ Single-Source BFS (Classic Shortest Path in Unweighted Graph)**

**Use when:** You have **1 start node** and want shortest paths or level order.

```java
Queue<Integer> q = new LinkedList<>();
boolean[] visited = new boolean[n];

q.offer(start);
visited[start] = true;

while (!q.isEmpty()) {
    int node = q.poll();          // Pop
    for (int nbr : graph[node]) { // Visit neighbors
        if (!visited[nbr]) {
            visited[nbr] = true;  // Mark first time
            q.offer(nbr);         // Push
        }
    }
}
```

---

## **2️⃣ Multi-Source BFS (Spread / Infection Problems)**

**Use when:** You have **multiple starting points** spreading simultaneously.

```java
Queue<int[]> q = new LinkedList<>(); // {node, day/level}
boolean[] visited = new boolean[n];

for (int src : sources) {  // Initialize all sources
    q.offer(new int[]{src, 0});
    visited[src] = true;
}

int maxDay = 0;
while (!q.isEmpty()) {
    int[] cur = q.poll();
    int node = cur[0], day = cur[1];
    maxDay = Math.max(maxDay, day);

    for (int nbr : graph[node]) {
        if (!visited[nbr]) {
            visited[nbr] = true;
            q.offer(new int[]{nbr, day + 1});
        }
    }
}
```

---

## **3️⃣ BFS for Shortest Path (with Distance Array)**

**Use when:** You need shortest distance to all nodes.

```java
int[] dist = new int[n];
Arrays.fill(dist, -1);          // -1 = unvisited
Queue<Integer> q = new LinkedList<>();

q.offer(start);
dist[start] = 0;

while (!q.isEmpty()) {
    int node = q.poll();
    for (int nbr : graph[node]) {
        if (dist[nbr] == -1) {  // first time visited
            dist[nbr] = dist[node] + 1;
            q.offer(nbr);
        }
    }
}
```

---

💡 **Key BFS Rules to Avoid Confusion**

1. **Mark visited when enqueuing** → prevents duplicates.
2. **First visit = shortest path** in unweighted graph.
3. **Multi-source BFS** = enqueue all starts with level 0.

---

If you want, I can **add a 4th mini-pattern for Grid BFS** (like rotting oranges, maze problems), which often comes up in interviews.
Do you want me to add that too?



## **4️⃣ Grid BFS (2D Matrix / Maze Problems)**

**Use when:**

* Graph is **implicitly a 2D grid**.
* Movement is usually **up/down/left/right** (or 8 directions if diagonal allowed).

---

### **Template**

```java
int m = grid.length, n = grid[0].length;
boolean[][] visited = new boolean[m][n];
Queue<int[]> q = new LinkedList<>(); // {row, col, steps}

// Directions: 4-way (up, down, left, right)
int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

// Initialize queue (single-source or multi-source)
for (int[] start : starts) {         // e.g., all rotten oranges
    q.offer(new int[]{start[0], start[1], 0});
    visited[start[0]][start[1]] = true;
}

int maxSteps = 0;
while (!q.isEmpty()) {
    int[] cur = q.poll();
    int r = cur[0], c = cur[1], steps = cur[2];
    maxSteps = Math.max(maxSteps, steps);

    for (int[] d : dirs) {
        int nr = r + d[0], nc = c + d[1];
        if (nr >= 0 && nr < m && nc >= 0 && nc < n
            && !visited[nr][nc] && grid[nr][nc] == 1) {
            
            visited[nr][nc] = true;           // mark visited
            q.offer(new int[]{nr, nc, steps+1});
        }
    }
}
```

---

### **Key Points for Grid BFS**

1. **Directions array** is your friend → avoids repeating 4 `if` statements.
2. **Visited\[]\[]** prevents re-adding cells.
3. **Multi-source BFS on grids** is **same pattern**, just enqueue all sources first.
4. Track **maxSteps or steps** for days/time-to-spread problems.

---

✅ **Where this applies:**

* **Rotting Oranges** (LeetCode 994)
* **Shortest Path in Binary Matrix**
* **Number of Islands (BFS variant)**
* **Fire Spread / Zombie Infection / Water Fill**

---
