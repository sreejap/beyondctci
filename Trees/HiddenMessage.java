/*
 * what I could improve - always make sure base cases are handled, go left subtree or right subtree depending on the problem 
 * The space complexity is O(n) because you're storing the decoded message which contains one character from each node, plus O(h) for the recursion stack. Since O(n) dominates, the overall space complexity is O(n).
 * time complexity is o(n) .. n is number of nodes in the tree
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
  char [] ch;
  Node left;
  Node right;
  Node (char [] cs) {
    ch = cs;
  }
}

class Solution {
  public static StringBuilder sb = new StringBuilder();
  public static void getHiddenMessage (Node n) {

    if (n==null) {
      return;
    }

    if (n.ch[0]=='b') {
      sb.append(n.ch[1]);
      // System.out.println(sb.toString());
      getHiddenMessage(n.left);
      getHiddenMessage(n.right);
    }else if (n.ch[0]=='a'){
      getHiddenMessage(n.left);
      getHiddenMessage(n.right);
      sb.append(n.ch[1]);
      // System.out.println(sb.toString());
    }else {
      getHiddenMessage(n.left);
      sb.append(n.ch[1]);
      getHiddenMessage(n.right);
      // System.out.println(sb.toString());
    }    
  }

  public static void main(String[] args) {
    Node root = new Node(new char[] {'b','n'});
    Node left = new Node(new char[] {'i','_'});
    Node l1 = new Node(new char[] {'a','e'});
    Node l2 = new Node(new char[] {'i','t'});
    Node l21 = new Node(new char[] {'b','i'});
    Node l22 = new Node(new char[] {'b','c'});

    Node right = new Node(new char[] {'a','!'});
    Node r1 = new Node(new char[] {'b','r'});
    Node r2 = new Node(new char[] {'a','y'});

    root.left = left;
    root.right = right;

    left.left = l1;
    left.right = l2;

    l1.left = l21;
    l1.right = l22;

    right.left = r1;
    r1.right = r2;    

    sb = new StringBuilder();
    getHiddenMessage (root);
    System.out.println("========");
    System.out.println(sb.toString());
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Hidden Message

// The self-proclaimed 'cryptography expert' in your friend group has devised their own schema to hide messages in binary trees. Each node has a text field with exactly two characters. The first character is either `'b'`, `'i'`, or `'a'`. The second character is part of the hidden message. To decode the message, you have to read the hidden-message characters in the following order:

// - If the first character in a node is `'b'`, the node goes before its left subtree, and the left subtree goes before the right subtree.
// - If it is `'a'`, the node goes after its right subtree, and the right subtree goes after the left subtree.
// - If it is `'i'`, the node goes after its left subtree and before its right subtree.

// Given the root of the binary tree, return the hidden message as a string.

// Example:

//                  bn
//                /    \
//              i_      a!
//             /  \     /
//           ae    it  br
//          /  \         \
//        bi    bc        ay

// Output: "nice_try!"

// https://iio-beyond-ctci-images.s3.us-east-1.amazonaws.com/trees_fig10.png

// Constraints:

// - Assume we have a binary tree node class with a `left` and `right` fields, and a `text` field.
// - The number of nodes is at most `10^5`
// - The height of the tree is at most `500`
// - The text field is a string of length `2`. The first character is either `'b'`, `'i'`, or `'a'`. The second character is a letter or number.
