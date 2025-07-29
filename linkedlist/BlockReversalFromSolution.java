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
  Node next;
  Node (int x) {
    val = x;
  }
}


class Solution {
  public static Node reverse (Node head) {
    Node prev = null;
    Node curr = head;

    while (curr!=null) {
      Node temp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = temp;      
    }
    return prev;
  }


  public static Node blockReversal (Node n, int k) {
    // have some dummy nodes
    Node dummyNode = new Node (0);
    dummyNode.next = n;
    Node groupPrev = dummyNode;

    while (true) {
      Node kthNode = groupPrev;
      for (int i=0; i < k; i++) {        
        kthNode = kthNode.next;
        if (kthNode == null) {
          return dummyNode.next;
        }
      }

      Node groupNext = kthNode.next;

      // detach from the main list
      kthNode.next = null;
      Node groupHead = groupPrev.next;

      // reverse the block
      Node reverseHead = reverse (groupHead); 

      // re attach the block
      groupPrev.next = reverseHead;
      groupHead.next = groupNext;
      // move the pointer to the next node
      groupPrev = groupHead;    

    }

  }
  public static void main(String[] args) {
    Node n1 = new Node (1);
    Node n2 = new Node (2);
    Node n3 = new Node (3);
    Node n4 = new Node (4);
    Node n5 = new Node (5);
    Node n6 = new Node (6);

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;

    Node n = blockReversal (n1,2);

    System.out.println(n.val);

  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Linked List Block Reversal

// Given the head of a singly linked list, `head`, and a number `k > 0`, reverse blocks of `k` nodes of the linked list. If the last block has size less than `k`, do not reverse it.

// ```
// Example 1:
// head = 1 -> 2 -> 3 -> 4 -> null
// k = 2

// Output: 2 -> 1 -> 4 -> 3 -> null

// Example 2:
// head = 1 -> 2 -> 3 -> 4 -> 5 -> null
// k = 3

// Output: 3 -> 2 -> 1 -> 4 -> 5 -> null

// Example 3:
// head = 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
// k = 2

// Output: 2 -> 1 -> 4 -> 3 -> 6 -> 5 -> null
// ```

// Constraints:

// - You have to create the `Node` class with an integer `val` field and a `next` pointer.
// - The list can contain up to `10^5` nodes.
