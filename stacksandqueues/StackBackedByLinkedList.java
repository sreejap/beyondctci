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
class Stack {
  Queue <Integer> q;
  Stack () {
    this.q  = new LinkedList<>();
  }

  void push (int v) {
    System.out.println("push");
    q.add(v);
    int sz = q.size();

    while (sz > 1) { // this is the rotationary method
      q.add(q.remove());
      sz--;
    }
  }

  int pop () {
    System.out.println("pop");
    if (this.q.size()!=0) {
      return q.poll();
    }
    return -1;
  }

  int peek () {
    System.out.println("peek");
    if (this.q.size()!=0)   {
      return q.peek();
    }
    return -1;
  }

  int size () {
    System.out.println("size");
    return this.q.size();
  }

  boolean empty () {
    System.out.println("empty??");
    return this.q.isEmpty();
  }
}
class Solution {
  public static void main(String[] args) {
    Stack st = new Stack();
    st.push(1);
    st.push(2);;
    st.push(3);;
    System.out.println(st.peek());
    System.out.println(st.size());
    System.out.println(st.empty());
    System.out.println(st.pop());
    System.out.println(st.pop());
    System.out.println(st.pop());
    System.out.println(st.empty());

    System.out.println("=====st2===");

    Stack st1 = new Stack();
    System.out.println(st1.pop());
    System.out.println(st1.peek());
    System.out.println(st1.size());
    System.out.println(st1.empty());
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Linked-List-Based Stack

// Implement a `Stack` class using a singly linked list.

// It should support the following methods:

// push(v):
//     Adds a value v at the top of the stack.

// pop():
//     Removes the value at the top of the stack and returns its value.
//     If the stack is empty, returns None.

// peek():
//     Returns the value at the top of the stack without removing it.
//     If the stack is empty, returns None.

// size():
//     Returns the number of elements in the stack.

// empty():
//     Returns True if the stack is empty, False otherwise.

// Examples:

// Example 1:
// stack = Stack()
// stack.push(1)    # Stack is now: 1
// stack.push(2)    # Stack is now: 1->2
// stack.push(3)    # Stack is now: 1->2->3
// stack.peek()     # Returns 3
// stack.size()     # Returns 3
// stack.empty()    # Returns False
// stack.pop()      # Returns 3, stack is now: 2->1
// stack.pop()      # Returns 2, stack is now: 1
// stack.pop()      # Returns 1, stack is now empty
// stack.empty()    # Returns True

// Example 2:
// stack = Stack()
// stack.pop()      # Returns None (empty stack)
// stack.peek()     # Returns None (empty stack)
// stack.size()     # Returns 0
// stack.empty()    # Returns True

// Constraints:

// - If your language is typed, you can either make the type of the stack elements generic, or use integers.
// - All the methods should take `O(1)` time if the elements are integers.
// - The stack can contain up to `10^5` elements.
// - Do not use a dynamic array. You have to implement the linked list from scratch.
