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
  public static long findTheNode(Node n, int target) {
    Node currNode = n;
    long NEXT_ABOVE = Long.MAX_VALUE;
    long NEXT_BELOW = Long.MIN_VALUE;

    while (currNode!=null) {
      if (target ==currNode.val) {
        return currNode.val;
      }else if (target <currNode.val){
        NEXT_ABOVE = currNode.val;
        currNode = currNode.left;
      }else {
        NEXT_BELOW = currNode.val;
        currNode = currNode.right;
      }
    }

    if (NEXT_BELOW == Long.MIN_VALUE) {
      return NEXT_ABOVE;
    }

    else if (NEXT_ABOVE == Long.MAX_VALUE) {
      return NEXT_BELOW;
    }

    else if (NEXT_ABOVE - target < target - NEXT_BELOW) {
      return NEXT_ABOVE;
    }

    else {
      return NEXT_BELOW;
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
    long res = findTheNode(root, 3);
    System.out.println(res);
    
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # BST Nearest Value

// A binary search tree (BST) is a binary tree if, for _every_ node:

// - All the values on its **left** subtree are _less than or equal_ to the node's value.
// - All the values on its **right** subtree are _greater than or equal_ to the node's value.

// Given the root of a non-empty binary search tree and a value, `target`, find the closest value to `target` in the tree. In case of a tie, return the smaller value.

// Example 1:
//               5
//             /    \
//            2      9
//             \    / \
//              4  9   11
//                  \
//                   9
// target = 4
// Output: 4

// Example 2:
// Same tree, target = 3
// Output: 2

// Constraints:

// - `1 <= number of nodes <= 10^4`
// - `-10^9 <= node.val <= 10^9`
// - `-10^9 <= target <= 10^9`
// - The tree is a valid binary search tree
