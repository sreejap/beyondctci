/*
 * What I could do better: make the code efficient by using half powers
 * time complexity is number of steps - O*(log p), space complexity is O(log p ) as well...
 * this problem shows to avoid integer overflow by using mod p
 * this is a pattern - (int)(((long) x * y) % m) - Do the multiplication carefully in a bigger bucket, then pour it into the modulo bucket, then convert to int again.
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

  public static int powersModM (int a, int p, int m) {

    if (p==0) {
      return 1;
    }

    if (p%2 ==0) {
      long half = powersModM (a,p/2,m);
      return (int) ((half * half) %m );
    }
    return (int) (((long) a * powersModM(a,p-1,m)) % m); 
    // convert a to long to preserve correctness , multiply by the return value and then do mod m to avoid bigger values and then convert back to int
    // mod m helps in avoiding storing intermediate values much larger than `m`.
  }

  public static void main(String[] args) {
    int a = 2;
    int p = 5;
    int m = 100;

    int ans = powersModM(a, p, m);

    System.out.println ("=========");

    System.out.println (ans);

    System.out.println (powersModM(2, 5, 30));

    System.out.println (powersModM(123456789, 987654321, 1000000007));
    System.out.println (powersModM(3, 1, 5));

    System.out.println (powersModM(5, 3, 7));
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Powers Mod M

// Given three integers `a > 1`, `p ≥ 0`, and `m > 1`, compute `a^p % m` while avoiding storing intermediate values much larger than `m`.

// The basic recurrence relation for powers is:

// - `a^0 = 1`
// - For `p > 0`, `a^p = a * a^(p-1)`

// When it comes to the modulo operation, we can apply it at each step without affecting the result:

// - `a^0 % m = 1`
// - For `p > 0`, `a^p % m = (a * (a^(p-1) % m)) % m`

// ```
// Example 1: a = 2, p = 5, m = 100
// Output: 32

// Example 2: a = 2, p = 5, m = 30
// Output: 2

// Example 3: a = 123456789, p = 987654321, m = 1000000007
// Output: 652541198

// Example 4: a = 3, p = 1, m = 5
// Output: 3

// Example 5: a = 5, p = 3, m = 7
// Output: 6
// ```

// Constraints:

// - `1 < a ≤ 10^9`
// - `0 ≤ p ≤ 10^9`
// - `1 < m ≤ 10^9`
