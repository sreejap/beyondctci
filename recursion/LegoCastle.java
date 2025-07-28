/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * Post mortem: 
 * Time to design the algorithm:
 * Time to code:
 * What solutions did I consider / miss?
 * Analysis: Was my solution optimal?
 * What triggers did I find / miss?
 * Any mistaks I keep making? Any bugs to add to the bug list?
 * What could I have done differently?
 * Takeaways:
 * Anything to add to my cheat sheet:
 * Rubric self rating: 
 * problems solving
 * coding
 * verification:
 * communication: Did I think out loud?
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static int numBlocks (int n) {
    if ( n ==1 ) {
      return 1;
    }
    return 2 * numBlocks (n-1) + roof(n);
  }

  public static int roof(int n){
    if (n == 1) {
      return 1;
    }    
    return roof (n-1) * 2 + 1;
  }

  public static void main(String[] args) {
    int [] arr = new int [] {1,2,3,4,5};
    for ( int n: arr) {
    int blocks = numBlocks (n);
    System.out.println("Input: " + n + " blocks: " + blocks);
    }
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Lego Castle

// You're building an `n`-story 2D Lego castle following these instructions:
// - A 1-story castle is just a `1x1` block.
// - An `n`-story castle is made with two `(n-1)`-story castles, side by side, one unit apart, with a row of blocks above them connecting them.

// Given `n > 0`, return the number of `1x1` blocks in an `n`-story castle.

// ```
// Example 1: n = 1
// Output: 1

// Example 2: n = 2
// Output: 5

// Example 3: n = 3
// Output: 17

// Example 4: n = 4
// Output: 49

// Example 5: n = 5
// Output: 129
// ```

// Constraints:
// - 1 ≤ n ≤ 1000
