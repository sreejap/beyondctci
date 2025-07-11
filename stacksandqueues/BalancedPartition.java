/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 * What I could do to improve: Learn about the trick - height of nested levels...talk about edge cases during the interview
 * If you need more classes, simply define them inline.
 */

class Solution {

  public static int getSubstring (String s) {
    int count = 0;

    int h = 0;
    for (int i=0; i < s.length(); i++){
      if (s.charAt(i)=='(') {
        h++;
      }else {
        h--;
        if (h==0) {
          count ++;
        }
      }
    }

    return count;
  }

  public static void main(String[] args) {
    String  s = "((()))(()())()(()(()))";
    System.out.println("count " + getSubstring(s));
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Balanced Partition

// Given a balanced parentheses string, `s`, a *balanced partition* is a partition of `s` into substrings, each of which is itself balanced. Return the maximum possible number of substrings in a balanced partition.

// ```
// Example: s = "((()))(()())()(()(()))"
// Output: 4. The balanced partition with the most substrings is "((()))", "(()())", "()", "(()(()))".
// ```

// Constraints:
// - The length of s is at most 10^5
// - s consists only of '(' and ')'
