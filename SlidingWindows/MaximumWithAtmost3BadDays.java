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
  public static int getMostConsecutiveBadays (int [] sales, int k) {
    if (sales == null || sales.length == 0) {
      return 0;
    }
    int l=0;
    int r=0;

    boolean canGrow = false;
    int windowBadDays = 0;
    int mostConsecutiveBadays = 0;
    while ( r < sales.length) {
      canGrow = (sales[r] >=10 || windowBadDays < k);
      if (canGrow) {
        if (sales[r] < 10) {
          windowBadDays++;
        }
        r++;
        mostConsecutiveBadays = Math.max(r-l,mostConsecutiveBadays);
      }else {
        if (sales[l] < 10) {
          windowBadDays--;
        }
        l++;
      }  
    }
    return mostConsecutiveBadays;
  }
  

  public static void main(String[] args) {
    int [] sales = new int [] { 0, 14, 7, 9, 0, 20, 10, 0, 10};
    int mostConsecutiveWithAtmostKBadDays = 
    getMostConsecutiveBadays (sales,3);
    System.out.println(mostConsecutiveWithAtmostKBadDays);
  }
}
// # Maximum With At Most 3 Bad Days

// Given an array `sales`, where `sales[i]` is the number of sales on the `i`-th day, find the most consecutive days with at most `3` bad days.

// A _bad day_ is a day with fewer than `10` sales.

// Example 1: sales = [0, 14, 7, 9, 0, 20, 10, 0, 10]
// Output: 6.
// There are two 6-day periods with at most 3 bad days:
//   - [14, 7, 9, 0, 20, 10]
//   - [9, 0, 20, 10, 0, 10]

// Example 2: sales = [10, 10, 10]
// Output: 3. All days are good days.

// Example 3: sales = [5, 5, 5, 5]
// Output: 3. We can include at most 3 bad days.

// Constraints:

// - `0 <= len(sales) <= 10^5`
// - `0 <= sales[i] <= 10^3`
