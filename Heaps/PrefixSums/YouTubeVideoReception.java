/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * Understand the recipe well - this is a good one
 * * Coding Ability: 4/4 Your implementation is clean, correct, and uses appropriate data structures. The logic in lines 20-24 correctly identifies positive days, lines 28-32 properly build the prefix sum, and lines 35-43 handle range queries correctly with proper edge case handling.  

* Problem Solving Ability: 4/4 You immediately recognized this as a range sum query problem and applied the optimal prefix sum technique. You arrived at the correct O(n + p) solution without needing hints and demonstrated strong algorithmic thinking.  

* Communication Skills: 3/4 You explained your approach clearly and walked through your solution methodically. Minor deduction for initially being less precise with complexity analysis, but you corrected well when prompted.  

* Overall Feedback: Excellent performance! You demonstrated strong technical skills by identifying the pattern, implementing an efficient solution, and correctly analyzing complexity. Your code is well-structured and handles all cases properly. To reach perfect communication, be more precise in initial complexity discussions.  

 *
 */

class Solution {
  public static int [] getRes (int [] likes,int [] dislikes, int [][] periods) {
    int [] res = new int [periods.length];
    // get positive days info
    int [] positiveDays = new int [likes.length];
    for (int i=0; i < likes.length; i++){
      if (likes[i] > dislikes[i]) {
        positiveDays [i] = 1;
      }
    }

    // recipe for range sum
    // this is prefix sum for positive days 
    int [] prefixSum = new int [positiveDays.length];
    prefixSum[0] = positiveDays[0];
    for (int i=1; i < prefixSum.length; i++) {
      prefixSum[i] = prefixSum[i-1] + positiveDays[i];
    }

    // now we compute range query for the periods...
    for (int i=0; i < res.length; i++) {
      int l = periods[i][0];
      int r = periods[i][1];
      if (l == 0 ){
        res[i] = prefixSum[r];
      }else {
        res[i] = prefixSum[r] - prefixSum[l-1];
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int [] likes = new int [] {6, 3, 4, 8, 7, 2, 6, 5, 0, 1};
    int [] dislikes = new int [] {6, 0, 8, 0, 0, 0, 1, 8, 0, 2};
    int [][] periods = new int [][] {{0,1}, {0,5}, {5,8}, {3,3}};

    int [] res = getRes(likes, dislikes,periods);
    for ( int i: res) {
      System.out.println(i);
    }
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # YouTube Video Reception

// A YouTuber has fetched the number of likes and dislikes of a video each day since its publication. We say a day is _positive_ if it has more likes than dislikes.

// We are given:

// - Two arrays, `likes` and `dislikes`, of length `n`, representing the likes and dislikes on each day.
// - An array `periods` of length `p`, where each element is a pair `[l, r]` with `0 ≤ l ≤ r < n`. Each pair represents a time period from day `l` to day `r` _inclusive_.

// Return an array, `results`, of length `p`, where `results[i]` is the number of positive days during `period[i]`.

// Example:
// likes    = [6, 3, 4, 8, 7, 2, 6, 5, 0, 1]
// dislikes = [6, 0, 8, 0, 0, 0, 1, 8, 0, 2]
// periods  = [[0, 1], [0, 5], [5, 8], [3, 3]]

// Output: [1, 4, 2, 1]
// For instance, element 0 (for the period [0, 1]) is 1 because
// day 0 doesn't have more likes than dislikes, but day 1 does.

// Constraints:

// - The length of `likes` and `dislikes` is the same and is at most `10^5`
// - Each element in `likes` and `dislikes` is a non-negative integer less than `10^4`
// - The length of `periods` is at most `10^5`
// - `periods[i].length == 2`
// - `0 <= periods[i][0] <= periods[i][1] < n`
