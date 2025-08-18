/*
 * 
 */

import java.io.*;
import java.util.*;

/*
 * time complexity is O(h) where h is the height of the tree, and space complexity is also O(h) due to the recursive call stack. In a balanced tree, h = O(log n), but in the worst case (completely unbalanced), h = O(n). * 
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
  public static boolean findTheNode (Node n, int target) {
    if (n.val == target) {
      return true;
    }

    else if (target < n.val && n.left!=null) {
      return findTheNode(n.left, target);
    }else if (target > n.val && n.right!=null) {
      return findTheNode(n.right, target);
    } else {
      return false;
    }    
  }

  public static void main(String[] args) {
    Node root = new Node (5);
    Node n2 = new Node (2);
    Node n4 = new Node (4);
    Node n91 = new Node (9);
    Node n92 = new Node (9);
    Node n93 = new Node (9);
    Node n11 = new Node (11);
    root.left = n2;
    n2.right = n4;

    root.right = n91;
    n91.left = n92;
    n92.right = n93;
    n91.right = n11;
    boolean res = findTheNode(root, 3);
    System.out.println(res);
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # BST Search

// A binary search tree (BST) is a binary tree if, for _every_ node:

// - All the values on its **left** subtree are _less than or equal_ to the node's value.
// - All the values on its **right** subtree are _greater than or equal_ to the node's value.

// Given the root of a binary search tree and a value, `target`, return `true` if the tree contains the target value, and `false` otherwise.

// Example 1:
//               5
//             /    \
//            2      9
//             \    / \
//              4  9   11
//                  \
//                   9
// target = 4
// Output: true

// Example 2:
// Same tree, target = 3
// Output: false
// The value 3 does not exist in the tree.

// Constraints:

// - The number of nodes is at most `10^5`
// - The value at each node is between `0` and `10^9`
