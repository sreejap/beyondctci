/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * * Overall Result: PASS ✅  
* You successfully solved this problem with an optimal solution and demonstrated strong technical interview skills throughout.  

* Coding Ability: 4/4  
* Your code is clean, well-structured, and correctly implements the optimal solution. The inorder traversal and merge logic are both implemented properly, and you handled the edge cases correctly in your merging step.  

* Problem Solving Ability: 4/4  
* You immediately recognized the key insight that inorder traversal of a BST yields sorted elements, then correctly identified this as a merge-two-sorted-arrays problem. Your approach was both optimal and elegantly simple.  

* Communication Skills: 4/4  
* You clearly articulated your approach before coding, explained your reasoning well, and accurately analyzed the time and space complexity when prompted. Your explanations were concise and showed good understanding.  

* Strengths:  
* Identified the optimal O(n1 + n2) solution immediately  
* Clean implementation with proper variable naming  
* Accurate complexity analysis  
* No hints needed - you solved it independently  

* Areas for Growth:  
* Minor: Initially mentioned "merge sort" when you meant merging sorted arrays, but you quickly self-corrected  

* This was an excellent performance that would definitely result in a passing grade at a top tech company. You demonstrated exactly the kind of problem-solving approach and coding skills interviewers look for. Well done! * 
 *
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
  public static List<Integer> solve  (Node r1, Node r2) {
    List<Integer> arr1 = new ArrayList <>();
    inorder (r1,arr1);
    List<Integer> arr2 = new ArrayList <>();
    inorder (r2,arr2);

    List <Integer> res = new ArrayList <>();

    int i=0; 
    int j=0; 
    while (i < arr1.size() && j < arr2.size())  {
      if (arr1.get(i) <= arr2.get(j)) {
        res.add(arr1.get(i));
        i++;
      }else {
        res.add(arr2.get(j));
        j++;
      }
    }

    while (i < arr1.size()) {
      res.add(arr1.get(i));
      i++;
    }

    while (j < arr2.size()) {
      res.add(arr2.get(j));
      j++;
    }
    return res;
  }

  public static void inorder (Node n, List<Integer> al) {
    if (n==null) {
      return;
    }

    inorder (n.left,al);
    al.add(n.val);
    inorder (n.right,al);
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

    Node r2 = new Node (3);
    Node n21= new Node (2);
    r2.left = n21;
    Node n211 = new Node (1);
    n21.left = n211;
    Node n7 = new Node (7);
    Node n6 = new Node (6);
    Node n8 = new Node (8);
    r2.right = n7;
    n7.left = n6;
    n7.right = n8;

    List <Integer> res = solve(root, r2);

    for (Integer e : res) {
      System.out.println(e);
    }

    Node rx1 = new Node (2);
    rx1.left = new Node (2);
    rx1.right = new Node (2);

    Node rx2 = new Node (2);
    rx2.left = new Node (2);
    rx2.right = new Node (2);

    List <Integer> res1 = solve(rx1, rx2);

    System.out.println ("============");

    for (Integer e : res1) {
      System.out.println(e);
    }
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # BST Merge Into Array

// A binary search tree (BST) is a binary tree where, for _every_ node:

// - All the values on its **left** subtree are _less than or equal_ to the node's value.
// - All the values on its **right** subtree are _greater than or equal_ to the node's value.

// Given the roots of two binary search trees, return an array containing all elements from both trees in sorted order. The trees may contain duplicate values.

// Example:
// root1 =
//               5
//             /    \
//            2      9
//             \    / \
//              4  9   11
// root2 =
//               3
//             /    \
//            2      7
//           /      / \
//          1      6   8

// Output: [1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 9, 11]

// Example 2:
// root1 =
//               2
//             /    \
//            2      2

// root2 =
//               2
//             /    \
//            2      2

// Output: [2, 2, 2, 2, 2, 2]

// Constraints:

// - The number of nodes of each tree is at most `10^5`
// - The height of each tree is at most `500`
// - The value at each node is between `0` and `10^9`
