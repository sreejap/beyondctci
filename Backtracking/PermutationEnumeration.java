/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * * Overall Result: You would PASS this interview.
* 
* Here are your ratings:
* 
* Coding Ability: 4/4 You implemented a clean, optimal backtracking solution using the swapping technique. Your code correctly handles the recursive structure, properly creates deep copies for the result, and maintains state correctly with the swap/unswap pattern.
* 
* Problem Solving Ability: 4/4 You immediately recognized this as a backtracking problem and chose the optimal approach. You understood the recursive structure perfectly and implemented an efficient O(n! * n) solution without needing any hints.
* 
* Communication Skills: 4/4 You clearly articulated your approach, explained the algorithm step-by-step, and correctly analyzed both time and space complexity. Your explanations were concise and demonstrated deep understanding.
* 
* Strengths:
* Optimal algorithm choice and implementation
* Perfect complexity analysis (O(n! * n) time and space)
* Clear communication throughout
* No hints needed
* 
* Areas for improvement:
* Consider testing with edge cases like empty arrays
* Remember: Your current test only uses a single character - testing with the full example would strengthen confidence
* 
* You demonstrated excellent technical skills and interview performance. This would be a strong pass in any top-tier tech company interview!
 *
 * 
 */

class Solution {

  public static void permutations (ArrayList <Character> chars, int index, ArrayList <ArrayList <Character>> res) {
      if (index == chars.size()-1) {
        res.add(new ArrayList<>(chars));
        return;
      }

      for (int i=index; i < chars.size(); i++) {
        Collections.swap(chars, i, index);
        permutations(chars, index+1, res);
        Collections.swap(chars, i, index); // revert it back
      }
  }

  public static void main(String[] args) {
    ArrayList <Character> chars = new ArrayList<>();
    chars.add('x');
    // chars.add('y');
    // chars.add('z');
    

    ArrayList <ArrayList <Character>> res = new ArrayList<>();    
    permutations (chars,0,res);

    for (ArrayList<Character> chs : res) {
      for (Character c: chs){
        System.out.println(c);
      }
      System.out.println("------------");
    }
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Permutation Enumeration

// A _permutation_ of a list is a list with the same elements but in any order. Finding all permutations means finding all possible orderings of the input elements.

// Given an array of unique characters, `arr`, return all possible permutations, in any order.

// Example 1: arr = ['x', 'y', 'z']
// Output: [['x', 'y', 'z'],
//          ['x', 'z', 'y'],
//          ['y', 'x', 'z'],
//          ['y', 'z', 'x'],
//          ['z', 'x', 'y'],
//          ['z', 'y', 'x']]

// Example 2: arr = ['x']
// Output: [['x']]

// Constraints:

// - The elements in `arr` are unique.
// - The length of `arr` is at most `10`.
