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

class Solution {
  public static int nestedArraySum (Object arr) {
   
    if (arr instanceof Integer) {
      return (Integer)arr;        
    } else if (arr instanceof List) {
        int res = 0;
        for (Object o1: (List<?>) arr) {
          res += nestedArraySum( o1);
        }
        return res;
    }

    throw new IllegalArgumentException("Input must be Integer or List");
  }

  public static void main(String[] args) {
    
    ArrayList <Object> objs = new ArrayList <>();
    objs.add(1);

    ArrayList <Object> objs1 = new ArrayList <>();
    objs1.add(2);
    objs1.add(3);

    objs.add(objs1);

    ArrayList <Object> objs3 = new ArrayList <>();
    objs3.add(4);

    ArrayList <Object> objs4 = new ArrayList <>();
    objs4.add(5);
    objs3.add(objs4);

    objs.add(objs3);

    objs.add(6);
    int ans = nestedArraySum(objs);
    System.out.println(ans);
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Nested Array Sum

// A *nested array* is an array where each element is either:
// 1. An integer, or
// 2. A nested array (note that this is a recursive definition).

// The *sum* of a nested array is defined recursively as the sum of all its elements.
// Given a nested array, `arr`, return its sum.

// ```
// Example 1: arr = [1, [2, 3], [4, [5]], 6]
// Output: 21

// Example 2: arr = [[[[1]], 2]]
// Output: 3

// Example 3: arr = []
// Output: 0

// Example 4: arr = [[], [1, 2], [], [3]]
// Output: 6

// Example 5: arr = [-1, [-2, 3], [4, [-5]], 6]
// Output: 5
// ```

// Constraints:
// - The array can be nested to any depth
// - Each integer in the array is between -10^9 and 10^9
// - The total number of integers in the array (counting nested ones) is at most 10^5
