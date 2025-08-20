/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * * You successfully implemented the optimal solution using level-order traversal with depth tracking.  
* Your code is clean, handles edge cases properly, and demonstrates a solid understanding of the problem.  

* Ratings:  

* Coding Ability: 4/4 Your implementation is excellent - clean structure, proper edge case handling with null check, and efficient use of Java collections.  

* Problem-Solving: 4/4 You identified the optimal approach immediately and implemented it correctly without needing algorithmic hints.  

* Communication: 3/4 You explained your approach well and engaged thoughtfully with complexity analysis, though some responses were quite brief.  

* Strengths:  

* Immediately recognized this as a level-order traversal problem  
* Implemented the optimal O(n) time, O(n) space solution  
* Clean, readable code with proper edge case handling  
* Good understanding of the algorithm mechanics when we discussed it  

* Areas for improvement:  

* Could be more verbose in explaining your thought process upfront  
* Consider discussing trade-offs or alternative approaches  

* You demonstrated strong technical skills and would definitely pass a real interview with this performance. Well done!  

 *
 */

class Node {
  int val;
  Node left;
  Node right;
  Node (int x) {
    val = x;
  }
}

class Solution {
  public static List <Integer> getLeftView (Node n) {
    if (n == null) {
      return Collections.emptyList();
    }

    List <Integer> res = new ArrayList <>();
    Queue <Map.Entry<Node,Integer>> q = new LinkedList <>();
    q.offer(new AbstractMap.SimpleEntry<> (n,0));

    int currDepth = -1;
    while (q.size()!=0) {
      Map.Entry<Node,Integer> el = q.poll();

      Node node = el.getKey();
      int depth = el.getValue();

      if (depth == currDepth + 1) {
        res.add(node.val);
        currDepth++;
      }

      if (node.left!=null) q.offer(new AbstractMap.SimpleEntry<> (node.left,depth+1));

      if (node.right!=null) q.offer(new AbstractMap.SimpleEntry<> (node.right,depth+1));
    }

    return res;
  }
  public static void main(String[] args) {
    Node root = new Node (1);
    Node n2 = new Node (2);
    Node n3 = new Node (3);
    Node n5 = new Node (5);
    Node n6 = new Node (6);
    Node n7 = new Node (7);

    root.left = n2;
    n2.right = n5;
    root.right = n3;
    n3.right = n6;
    n6.right = n7;   
    List <Integer> res = getLeftView(root);
    for (Integer e : res) {
      System.out.println(e);
    }
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Left View

// Given the root of a binary tree, return its _left view_. The left view is an array with the value of the first node on each layer, ordered from top to bottom.

// Example:

// Input:
//     1
//    / \
//   2   3
//    \   \
//     5   6
//          \
//           7

// Output: [1, 2, 5, 7]

// https://iio-beyond-ctci-images.s3.us-east-1.amazonaws.com/trees_fig17.png

// Constraints:

// - The number of nodes is at most `10^5`
// - Each node has a value between `0` and `10^9`
