/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * What I could do to improve: understand the flow better, I think I got it solving the question :)
 
 *
 * If you need more classes, simply define them inline.
 */

class Solution {

  public static String getRobotInstructions (String s) {

    ArrayList<Character> chars = new ArrayList<>();
    helper(s,0,chars);

    StringBuilder sb = new StringBuilder();
    for (Character c : chars){
      sb.append(c);
    }
    return sb.toString();
  }

  public static void helper (String s, int pos, ArrayList<Character> chars) {
    if (pos == s.length()){
      return; 
    }

    if (s.charAt(pos) == '2') {
      helper(s,pos+1,chars);
      helper(s,pos+2,chars);
    }else {
      chars.add(s.charAt(pos));
      helper(s,pos+1,chars);      
    }
  }

  public static void main(String[] args) {
    String [] seq = new String [] {"LL", "2LR", "2L", "22LR", "LL2R2L"};

    for (String s: seq) {
      System.out.println ("Input : " + s + " Res:" + getRobotInstructions(s));
    }
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Robot Instructions

// We are given a string, `seq`, with a sequence of instructions for a robot. The string consists of characters `'L'`, `'R'`, and `'2'`. The letters `'L'` and `'R'` instruct the robot to move left or right. The character `'2'` (which never appears at the end of the string) means "perform all the instructions after this `'2'` twice, but skip the instruction immediately following the `'2'` during the second repetition." Output a string with the final list of left and right moves that the robot should do.

// ```
// Example 1: seq = "LL"
// Output: "LL"

// Example 2: seq = "2LR"
// Output: "LRR". The '2' indicates that we need to do "LR" first and then "R".

// Example 3: seq = "2L"
// Output: "L". The '2' indicates that we need to do "L" first and then "" (the empty string).

// Example 4: seq = "22LR"
// Output: "LRRLR". The first '2' indicates that we need to do "2LR" first and then "LR".

// Example 5: seq = "LL2R2L"
// Output: "LLRLL"
// ```

// Constraints:

// - The length of seq is at most 10^4
// - seq consists only of the characters 'L', 'R', and '2'
// - '2' never appears at the end of seq
