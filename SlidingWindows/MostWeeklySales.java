/*
 * https://start.interviewing.io/interview-ai/code?problemId=most-weekly-sales
 * Time O(n) and space O(1) complexity
 * make sure to include edge case handling
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
  public static int get7DayMaxSales (int [] sales) {
    if (sales == null || sales.length == 0){
      return 0;
    }
    int left  = 0;
    int maxSales = 0;
    int totalSales = sales [left];
    // Map <Integer,Integer> daySales = new HashMap <>();
    for (int right = 1; right < sales.length; right++) {
      totalSales += sales [right];

      if (right - left + 1 == 7) {        
        maxSales = Math.max (totalSales, maxSales);
        // daySales.put (maxSales,left);

        totalSales -= sales [left];
        left++;
      }
    }
    return maxSales;
  }

  public static void main(String[] args) {
    int sales [] = {0, 3, 7, 12, 10, 5, 0, 1, 0, 15, 12, 11, 1};
    int maxSales = get7DayMaxSales (sales);
    System.out.println (maxSales);
  }
}
