/*
 * question: https://start.interviewing.io/interview-ai?problemId=longest-balanced-subsequence
 * What I could do better - write cleaner logic, use the correct construct if vs while
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static String longestBalancedSubSequence (String s) {
    ArrayDeque <Integer> st = new ArrayDeque<>();
    Set<Integer> indices = new HashSet<>();
    for (int i=0; i < s.length(); i++){      
      Character ch = s.charAt(i);

      if (ch == ('(')) {
        st.push(i);
      } else if (st.isEmpty()) {
        indices.add(i);
      } else {
        st.pop();
      }

      // if (ch.equals(')')) {
      //   if (!st.isEmpty()) {        
      //     Integer index = st.peek();
      //     if (s.charAt(index)!= '(') {
      //       indices.add(i);
      //     } else {
      //       st.pop();
      //     }
      //   }else {
      //     indices.add(i);
      //   }  
      // }else {
      //   st.push(i);
      // }
    }


    // bug -- use while here instead of if
    while (!st.isEmpty()) {
      indices.add(st.pop());
    }

    Iterator <Integer> itr = indices.iterator();
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }

    int size = s.length() - indices.size();
    char [] chars = new char [size];
    int j = 0;
    for (int i=0; i < s.length(); i++){
      if (!indices.contains(i)) {         
        chars[j++] = s.charAt(i);
      }
    }

    for (int i=0; i < chars.length; i++){
      System.out.println(chars[i]);
    }
    return new String(chars);
  }
  public static void main(String[] args) {
    String s = "(()(()(";
    // "))(())(()";
    String res = longestBalancedSubSequence(s);
    System.out.println(res);
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Longest Balanced Subsequence

// Given a string of parentheses, `s`, return the longest balanced _subsequence_. A subsequence of `s` (not a subarray) is a string obtained by removing some of the letters in `s`. In other words, you have to delete the smallest number of characters necessary to make `s` balanced and return the resulting string.

// ```
// Example 1: s = "))(())(()"
// Output: "(())()". We removed the following characters:

//    "))(())(()".
//     ^^    ^
// We could have also removed

//    "))(())(()".
//     ^^     ^

// Example 2: s = "(()(()("
// Output: "()()". We removed the following characters:

//    "(()(()("
//     ^  ^  ^

// Example 3: s = "())(()"
// Output: "()()". We removed the following characters:

//    "())(()"
//       ^^

// Example 4: s = "("
// Output: ""
// ```

// Constraints:

// - The length of s is at most 10^5
// - s consists only of '(' and ')'
