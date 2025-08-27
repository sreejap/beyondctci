/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * * Exactly! You've mapped your implementation perfectly to the backtracking recipe:
* partial_solution: Your partial list that builds up the current combination of words
* apply_choice: When you do partial.add(tokens.get(i)) (include) or when you implicitly don't add anything (exclude)
* visit(child): Your recursive calls to shakespearify(tokens, i+1, partial, res)
* full_solution check: Your base case if (i == tokens.size())
* process leaf: Your res.add(String.join(" ", partial))
* And you're also doing the cleanup properly - after exploring the "include" branch, you remove the word with partial.remove(partial.size()-1) before exploring the "exclude" branch.
* This is a textbook example of how the backtracking template translates into actual code.
* about pruning:
* In this specific problem (generating all possible subsequences of words), there actually isn't much opportunity for pruning because we genuinely want to explore all 2^k possible combinations.
* Pruning typically happens when you can determine early that a partial solution cannot lead to any valid complete solutions.
* For example, in problems like:
* N-Queens: if placing a queen creates an immediate conflict, you can prune that branch
* Sudoku: if a number placement makes the puzzle unsolvable, you can backtrack immediately
* Path finding with constraints: if you've already exceeded a maximum cost, you can stop exploring that path
* But in the Shakespearify problem, every combination of including/excluding words is a valid result we want to collect, so there's no logical reason to prune any branches.
* The pruning step in the recipe template is more relevant for constraint satisfaction problems or optimization problems where you can eliminate branches that won't lead to valid or optimal solutions.

* You've implemented it very cleanly!
 * T(c) - O(2^k * n) complexity, S(c) - O(2^k * n)
 * Coding Ability: 4/4 Justification: You implemented a clean, correct backtracking solution with proper recursive structure and handled edge cases appropriately.
* Problem-Solving: 4/4 Justification: You immediately recognized this as a backtracking problem and implemented the optimal approach without needing hints.
* Communication: 4/4 Justification: You clearly articulated your thought process, explained your approach step-by-step, and correctly analyzed time/space complexity.
* Overall Feedback: Excellent performance! You demonstrated strong algorithmic thinking by recognizing the backtracking pattern, implemented a working solution efficiently, and accurately analyzed O(2^k * n) complexity. You handled edge cases well and communicated clearly throughout. This would be a passing interview performance.
* Final Result: PASS
* You met all the criteria - you described and implemented the optimal solution, needed zero hints, explained your approach clearly, and correctly identified the time and space complexity. Well done!
 *
 * 
 */

class Solution {
  public static void shakespearify (List<String> tokens, int i, List<String> partial, List <String> res) {
    if (i == tokens.size()) {
      res.add(String.join(" ", partial));
      return;
    }

    // for choices - here include, exclude and prune where needed
    // include the token
    partial.add(tokens.get(i));
    shakespearify(tokens, i+1, partial, res);

    // exclude the token
    partial.remove(partial.size()-1);
    shakespearify(tokens, i+1, partial, res);

  }

  public static void main(String[] args) {
    String sentence = " ";
    StringTokenizer st = new StringTokenizer(sentence);
    ArrayList <String> ar = new ArrayList<>();
    while (st.hasMoreTokens()) {
      ar.add(st.nextToken());
    }
    List <String> res = new ArrayList<>();
    List <String> partial = new ArrayList<>();
    shakespearify(ar, 0 , partial, res); // partial solution and empty solution

    for (String s : res) {
      System.out.println(" >>>>  " + s + " === " ) ;
    }
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # To Be or Not to Be

// Inspired by Shakespeare's iconic line, you decide to write a function, `shakespearify()`, which takes in a string, `sentence`, consisting of lowercase letters and spaces. For each word in the string, the function chooses if it should "be" or "not be" included in the sentence, returning all possible outcomes. The order of the output strings does not matter.

// Example 1: sentence = "I love dogs"
// Output: [
//          "",
//          "I",
//          "love",
//          "dogs",
//          "I love",
//          "I dogs",
//          "love dogs",
//          "I love dogs"
//         ]

// Example 2: sentence = "hello"
// Output: ["", "hello"]

// Example 3: sentence = ""
// Output: [""]

// Constraints:

// - The sentence consists of lowercase letters and spaces.
// - The sentence has at most 12 words and at most 100 characters.
