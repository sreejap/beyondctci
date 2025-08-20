/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
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
  public static int counter ;
  public static int res = -1;
  public static void findKthSmallest (Node n, int k) {   

    if (n== null || res!=-1) {
      return;
    }

    if (n.left!=null) {    
      findKthSmallest(n.left,k);
    }
    
    if (counter == k){ 
      res = n.val;
      return;
    }
    counter ++;
    // curr = n;    
    System.out.println("counter: " + counter + "-- "+n.val);

    if (n.right!=null) {
      findKthSmallest(n.right, k);
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
    counter = 0;

     findKthSmallest (root,4);
    System.out.println("kth: "+ res);
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # BST Kth Element

// A binary search tree (BST) is a binary tree where, for _every_ node:

// - All the values on its **left** subtree are _less than or equal_ to the node's value.
// - All the values on its **right** subtree are _greater than or equal_ to the node's value.

// Given the root of a binary search tree with `n` nodes, find the `k`-th smallest element (0-indexed), where `0 ≤ k ≤ n-1`.

// Example 1:
//               5
//             /    \
//            2      9
//             \    / \
//              4  9   11
// k = 4
// Output: 9.

// Example 2:
// Same tree, k = 0
// Output: 2.

// Constraints:

// - The number of nodes is at most `10^5`
// - The height of the tree is at most `500`
// - The value at each node is between `0` and `10^9`
// - `0 ≤ k ≤ n-1`
