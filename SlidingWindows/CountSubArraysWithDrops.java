/*
 * https://start.interviewing.io/interview-ai/code?problemId=count-subarrays-with-drops
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
  public static int getAtmostKDrops (int [] arr, int k) {
    if (arr == null || arr.length == 0){
      return 0;
      
    }
    int l = 0;
    int r = 0;

    int len = arr.length;
    int count = 0;
    int drops = 0;
    while ( r < len) {
      // expand the window 
      if (r > 0 && arr[r-1] > arr [r]) {
        drops++;
      }

      while (drops > k) {
        if (l+1 < len && arr[l] > arr[l+1]) {
          drops--;
        }
        l++;
      }
      r++;
      count += r-l;
    }

    return count;
  }

  public static void main(String[] args) {
    int [] arr = new int [] {1, 2, 3};
    int k = 1;
    int n = arr.length;
    int atMostKDrops = getAtmostKDrops (arr,k);
    int atMostKMinusOneDrops = getAtmostKDrops (arr,k-1);;
    int exactlyKDrops = getAtmostKDrops (arr,k) - getAtmostKDrops (arr,k-1);
    int atLeastKDrops = (n*(n+1))/2 - atMostKMinusOneDrops;

    System.out.println("atMostKDrops:" + atMostKDrops);
    System.out.println("exactlyKDrops:" + exactlyKDrops);
    System.out.println("atLeastKDrops:" + atLeastKDrops);
    
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Count Subarrays With Drops

// Given an array, `arr`, of integers and a number `k`, count how many subarrays have:

// 1. at most `k` drops
// 2. exactly `k` drops
// 3. at least `k` drops

// A _drop_ is a sequence of two consecutive numbers where the first is larger than the second.

// Return an array with the three values.

// Example 1: arr = [1, 2, 3], k = 1
// Output: [6, 0, 0]
// - The array has 6 subarrays: [1], [2], [3], [1, 2], [2, 3], and [1, 2, 3].
// - At most k drops:  6. The array has no drops, so every subarray has 0 drops.
// - Exactly k drops:  0. The array has no drops.
// - At least k drops: 0. The array has no drops.

// Example 2: arr = [3, 2, 1], k = 1
// Output: [5, 2, 3]
// - The array has 6 subarrays: [3], [2], [1], [3, 2], [2, 1], and [3, 2, 1].
// - At most k drops:  5. [3, 2] and [2, 1] have 1 drop and [3], [2], and [1] have 0 drops.
// - Exactly k drops:  2. [3, 2] and [2, 1] have exactly 1 drop.
// - At least k drops: 3. [3, 2] and [2, 1] have 1 drop and [3, 2, 1] has 2 drops.

// Example 3: arr = [5, 4, 3, 2, 1], k = 2
// Output: [12, 3, 6]
// - The array has 5 + 4 + 3 + 2 + 1 = 15 subarrays.
// - At most k drops: 12. All the subarrays with 1, 2, or 3, elements.
// - Exactly k drops:  3. All the subarrays with 3 elements: [5, 4, 3], [4, 3, 2], and [3, 2, 1].
// - At least k drops: 6. All the subarrays with 3, 4, or 5 elements.

// Constraints:

// - `0 <= arr.length <= 10^5`
// - `-10^9 <= arr[i] <= 10^9`
// - `0 <= k <= 10^5`
