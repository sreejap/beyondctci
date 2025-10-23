# 📝 Sliding Window Cheat Sheet (Java) by ChatGPT

**Template Pattern:**

1. **Step 1 — Expand**: move `right` pointer, include new element into the window  
2. **Step 2 — Shrink**: move `left` pointer until the window is valid  
3. **Step 3 — Update**: compute / update the answer based on current window  

---

### 1️⃣ Longest Subarray / Substring with at most K “bad” things

> Example: Max consecutive good days with at most K bad days  

```java
int left = 0, badCount = 0, maxLen = 0;

for (int right = 0; right < nums.length; right++) {
    if (nums[right] < 10) badCount++;  // Step 1: expand
    while (badCount > k) {             // Step 2: shrink
        if (nums[left] < 10) badCount--;
        left++;
    }
    maxLen = Math.max(maxLen, right - left + 1); // Step 3: update
}
```

---

### 2️⃣ Longest substring with at most K distinct characters

```java
Map<Character, Integer> count = new HashMap<>();
int left = 0, maxLen = 0;

for (int right = 0; right < s.length(); right++) {
    count.put(s.charAt(right), count.getOrDefault(s.charAt(right), 0) + 1); // Step 1
    while (count.size() > k) { // Step 2
        char ch = s.charAt(left);
        count.put(ch, count.get(ch) - 1);
        if (count.get(ch) == 0) count.remove(ch);
        left++;
    }
    maxLen = Math.max(maxLen, right - left + 1); // Step 3
}
```

---

### 3️⃣ Smallest range with K elements

> After sorting, find smallest range containing K elements

```java
Arrays.sort(arr);
int left = 0;
int bestLow = 0, bestHigh = Integer.MAX_VALUE;

for (int right = 0; right < arr.length; right++) { // Step 1
    while ((right - left + 1) > k) left++;         // Step 2
    if ((right - left + 1) == k && arr[right] - arr[left] < bestHigh - bestLow) { // Step 3
        bestLow = arr[left];
        bestHigh = arr[right];
    }
}
```

---

### 4️⃣ Max sum / min sum subarray of size at most / exactly K

```java
int left = 0, sum = 0, maxSum = Integer.MIN_VALUE;

for (int right = 0; right < nums.length; right++) {
    sum += nums[right];       // Step 1
    while (right - left + 1 > k) { // Step 2
        sum -= nums[left];
        left++;
    }
    maxSum = Math.max(maxSum, sum); // Step 3
}
```

---

### ⚡ Key Notes

- **Pointers only move forward** → O(n) time, not O(n²)  
- Inner `while` is **shrinking window**; outer `for` is **expanding window**  
- Update your result **only after the window is valid**  
- Works for arrays, strings, sums, counts, etc. — just change the “bad” condition  
