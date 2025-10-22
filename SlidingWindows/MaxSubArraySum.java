/*
 * https://start.interviewing.io/interview-ai/code?problemId=max-subarray-sum
 * T(C) - O(n), S(C) - O(1)
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
  public static int getMaxSubArraySum (int [] nums) {
    // int left = 0;
    int right = 0;
    // if all elements are negative, return the max 

    

    if (nums == null || nums.length ==0) {
      return 0;
    }

    int maxSubArraySum = Integer.MIN_VALUE;
    
    for (int n : nums) {
      maxSubArraySum = Math.max(maxSubArraySum,n);
    }

    if (maxSubArraySum <=0){
      return maxSubArraySum;
    }

    
    int currSum = 0;
    while (right < nums.length) {
      currSum += nums[right];
      if (currSum >=0) {
        maxSubArraySum = Math.max(currSum, maxSubArraySum);        
      }else {
        currSum = 0;
      }
      right++;
    }

    return maxSubArraySum;
  }

  public static void main(String[] args) {
    int [] arr = new int [] {1, -3, 2,1,-1};
    int maxSubArraySum = getMaxSubArraySum (arr);

    System.out.println(maxSubArraySum);
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Max Subarray Sum

// Given a non-empty array `arr` of integers (which can be negative), find the non-empty subarray with the maximum sum and return its sum.

// Example 1: arr = [1, 2, 3, -2, 1]
// Output: 6. The subarray with the maximum sum is [1, 2, 3].

// Example 2: arr = [1, 2, 3, -2, 7]
// Output: 11. The subarray with the maximum sum is the whole array.

// Example 3: arr = [1, 2, 3, -8, 7]
// Output: 7. The subarray with the maximum sum is [7].

// Example 4: arr = [-2, -3, -4]
// Output: -2. The subarray cannot be empty.

// Constraints:

// - `1 <= len(arr) <= 10^5`
// - Each element in `arr` is an integer between `-10^6` and `10^6`
