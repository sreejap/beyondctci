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
  public static int globalChain = 0;
  public static int getAlignedChain (Node node, int d) {
    if (node == null) {
      return 0;
    }

    int leftChain = getAlignedChain(node.left, d+1);
    int rightChain = getAlignedChain(node.right, d+1);

    int currDist = 0;
    if (node.val == d) { // here we are discarding if the chain is not aligned 
      currDist = 1 + Math.max(leftChain, rightChain);
      globalChain = Math.max(globalChain, currDist);
    }
    return currDist;
  }

  public static void main(String[] args) {
      Node root = new Node (7);
    Node n1 = new Node(1);
    Node n3 = new Node(3);

    root.left = n1;
    root.right = n3;    
    
    Node n2 = new Node(2);
    Node n8 = new Node(8);

    n1.left = n2;
    n1.right = n8;

    Node n21 = new Node(2);
    n3.right = n21;


    Node n31 = new Node(3);
    Node n32 = new Node(3);
    n21.left = n31;
    n21.right = n32;

    Node n4 = new Node(4);
    Node n23 = new Node(3);

    n2.left = n4;
    n2.right = n23;

    globalChain =0;
    int len = getAlignedChain (root,0);
    System.out.println("ans: " + globalChain);
    System.out.println(len);

  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Aligned Chain

// Given a binary tree, we say a node is _aligned_ if its value is equal to its depth (distance from root).
// A _descendant chain_ is a sequence of nodes where each node is the parent of the next node.
// Return the length of the longest descendant chain of aligned nodes. The chain does not need to start at the root.

// Example:
//                 7
//                / \
//               1   3
//              / \   \
//             2   8   2
//            / \     / \
//           4   3   3   3

// Output: 3
// The aligned nodes are the circled ones:
// Depth
//   0             7
//                / \
//   1          (1)   3
//              / \   \
//   2        (2)  8  (2)
//            / \     / \
//   3       4  (3) (3) (3)

// The longest descendant chain of aligned nodes is 1 -> 2 -> 3 on the left subtree.

// Constraints:

// - The number of nodes is at most `10^5`
// - The height of the tree is at most `500`
// - Each node has a value between `0` and `10^9`
