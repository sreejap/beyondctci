/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * Coding Ability: 3/4 Score: 3/4 Justification: Strong algorithmic implementation with proper inorder traversal. One issue: missing null check for root node could cause runtime error.
* Problem-Solving: 4/4  
* Score: 4/4  
* Justification: Immediately identified optimal inorder traversal approach. Recognized BST property enables sorted traversal for duplicate detection.  

* Communication: 3.5/4  
* Score: 3.5/4  
* Justification: Clearly explained approach and reasoning throughout. Minor confusion on initial complexity analysis but corrected well.  

* Overall Feedback:  
* Excellent work! You identified the optimal O(n) inorder traversal solution immediately and implemented it correctly. You handled the Integer.MIN_VALUE edge case well and added proper early returns. Only missing a null root check. Strong technical performance overall - you'd definitely pass a real interview at a top tech company!  

* Key Strengths:  
* Immediately recognized the BST property advantage  
* Clean, readable code structure  
* Proper complexity analysis (after clarification)  
* Good problem-solving instincts  

* Minor Improvement:  
* Add null check for the root parameter to handle empty tree edge case  

* Great job! This was a solid technical interview performance.  


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
  public static int lastVal;

  public static boolean findDuplicates(Node n) {

    boolean isLeftDuplicate = false ;
    if (n.left!=null) {
      isLeftDuplicate = findDuplicates(n.left);
      if (isLeftDuplicate) {
        return true;
      }
    }
    if (lastVal == n.val) {
      return true;
    }
    lastVal = n.val;

    boolean isRightDuplicate = false;
    if (n.right!=null) {
      isRightDuplicate = findDuplicates(n.right);
      if(isRightDuplicate) {
        return true;
      }
    }

    return isLeftDuplicate || isRightDuplicate;
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

    lastVal = Integer.MIN_VALUE;
    boolean res = findDuplicates(root);
    System.out.println(res);

  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # BST Duplicate Detection

// A binary search tree (BST) is a binary tree where, for _every_ node:

// - All the values on its **left** subtree are _less than or equal_ to the node's value.
// - All the values on its **right** subtree are _greater than or equal_ to the node's value.

// Given the root of a binary search tree, determine if it contains any duplicate values.

// Example:
//               5
//             /    \
//            2      9
//             \    / \
//              4  9   11
//                  \
//                   9
// Output: True

// Constraints:

// - The number of nodes is at most `10^5`
// - The height of the tree is at most `500`
// - The value at each node is between `0` and `10^9`
