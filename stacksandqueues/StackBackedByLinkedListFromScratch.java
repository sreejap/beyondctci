/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * 
 * Postmortem:
 * * What went really well:
* You correctly identified the optimal approach (using head as stack top)
* Your core algorithm and logic were spot-on
* You handled all edge cases properly (empty stack returning null)
* Time and space complexity analysis was perfect
* You showed great adaptability by recognizing the inefficiency in your initial queue approach and pivoting
* Areas for improvement:
* Code cleanliness: Your solution had debug print statements and commented-out code that should be removed in a real interview
* Initial approach: While exploring the queue rotation was interesting, recognizing the O(n) inefficiency sooner would have been better
* Variable naming: Using q for your head node was a bit confusing since it's not actually a queue
* Key takeaway: Your problem-solving and technical skills were excellent. The main area to focus on for future interviews is writing cleaner, more production-ready code from the start. Remove debug statements and commented code before presenting your final solution.
* Overall, this was a strong interview performance that demonstrated exactly the kind of technical thinking and adaptability we look for in candidates!
* Postmortem end ... 
 * * Let me give you my assessment: You would definitely pass this interview! Here's how I'd rate you:
* Coding ability: 4/4 - You wrote clean, correct code and handled all the edge cases properly. Your implementation is exactly what we'd expect for an optimal solution.
* Problem solving ability: 4/4 - You initially explored a different approach with the queue rotation, recognized the efficiency issues, and then pivoted to the optimal linked list solution. That shows great problem-solving flexibility.
* Communication skills: 4/4 - You clearly explained your thought process throughout, asked good clarifying questions, and walked me through your reasoning step by step.
* You met all the key criteria: you described the optimal solution, implemented it correctly, needed minimal hints, communicated clearly, and got the time/space complexity analysis right.
* The way you handled the transition from your initial approach to the optimal one was particularly impressive - that's exactly the kind of adaptability we look for in strong candidates. Well done!
 * 
 */
class Node {
  int val;
  Node next;
  Node () {    
  }
  Node (int x) {
    val = x;
  }
}
class Stack {
  Node q;
  Stack () {   
    
  }
  int size;

  void push (int v) {
    System.out.println("push");
    Node n = new Node(v);
    n.next = q;
    q = n;
    this.size++;
    //q.add(v);
    // int sz = q.size();

    // while (sz > 1) {
    //   q.add(q.remove());
    //   sz--;
    // }
  }

  Integer pop () {
    System.out.println("pop");
    if (this.q!=null) {
      int res = q.val;
      q = q.next;
      this.size--;
      return res;
    }
    // if (this.q.size()!=0) {
    //   return q.poll();
    // }
    return null;
  }

  Integer peek () {
    System.out.println("peek");
    if (this.q!=null) {
      int res = q.val;
      return res;
    }
    // if (this.q.size()!=0)   {
    //   return q.peek();
    // }
    return null;
  }

  int size () {
    System.out.println("size");
    return this.size;
  }

  boolean empty () {
    System.out.println("empty??");
    
    return this.q == null;
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
