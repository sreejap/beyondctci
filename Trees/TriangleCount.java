/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class named Solution.
 * You visit each node exactly once, so the time complexity is O(n) where n is the number of nodes.
 * The space complexity is O(h) where h is the height of the tree, due to the recursion call stack. The arrays you return are constant size, so they don't affect the overall complexity. 
 * If you need more classes, simply define them inline.
 */

class Node {
  public int value;
  public Node left;
  public Node right;

  public Node(int value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

class Solution {

  public static int res;
  // public static int leftSide;
  // public static int rightSide;

  public static int [] solve (Node n) {
    if (n == null) {
      // leftSide = 0;
      // rightSide = 0;
      return new int [] {0,0};
    }

    int [] left =  solve (n.left);    
    int currLeft = left[0];
    
    int [] right = solve (n.right);
    int currRight = right[1];

    res += Math.min(currLeft, currRight);
    // leftSide = leftSide + 1;
    // rightSide = rightSide + 1;
    return new int [] {left[0]+1, right[1]+1};
  }

  public static void main(String[] args) {
    res = 0;
    Node root = new Node (0);
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);
    Node n6 = new Node(6);
    Node n7 = new Node(7);
    Node n8 = new Node(8);
    Node n9 = new Node(9);

    root.left = n1;
    root.right = n2;
    n1.right = n3;
    n3.left  = n6;
    n3.right = n7;
    n2.left = n4;
    n2.right = n5;
    n4.left = n8;
    n5.right = n9;
    solve (root);
    int numOfTriangles = res;
    System.out.println(numOfTriangles);
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Triangle Count

// Given the root of a binary tree, return the number of _triangles_.
// A triangle is a set of three distinct nodes, `a`, `b`, and `c`, where:

// 1. `a` is the _lowest common ancestor_ of `b` and `c`.
// 2. `b` and `c` have the same depth.
// 3. the path from `a` to `b` only consists of left children (the nodes in the path can have right children).
// 4. the path from `a` to `c` only consists of right children (the nodes in the path can have left children).

// Example 1:
//          0
//      /       \
//     1         2
//      \       / \
//       3     4   5
//      / \   /     \
//     6   7 8       9

// Output: 4.
// The triangles are: (0, 1, 2), (3, 6, 7), (2, 4, 5), (2, 8, 9).

// https://iio-beyond-ctci-images.s3.us-east-1.amazonaws.com/trees_fig12.png

// Example 2:
//       0
//    /      \
//   1        4
//  /  \       \
// 2    3       5
// Output: 3.
// The triangles are: (0, 1, 4), (1, 2, 3), (0, 2, 5).

// Constraints:

// - The number of nodes is at most `10^5`
// - The height of the tree is at most `500`
// - The value at each node doesn't matter.
