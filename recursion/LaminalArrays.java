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
  public static int maxLaminalSubArraySum (int [] arr) {
    int[] maxSum = helper(arr,0,arr.length);
    return maxSum[0];
  }

  public static int [] helper(int []arr, int left, int right) {
    if (right - left == 1) {
      return new int [] {arr[left], arr[left]};
    }

    int mid = (left + right) / 2;
    int [] leftSum = helper(arr,left,mid);
    int [] rightSum = helper(arr,mid,right);
    
    int option1 = leftSum[0];
    int option2 = rightSum[0];
    int option3 = leftSum[1] + rightSum[1];

    int[] ans = new int []{ Math.max(Math.max(option1,option2),option3), option3};
    return ans;
  }

  public static void main(String[] args) {
    int [] arr = new int [] {3, -9, 2, 4, -1, 5, 5, -4};
    int res = maxLaminalSubArraySum (arr);
    System.out.println("======");
    System.out.println(res);
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Laminal Arrays

// We are given an array, `arr`, whose **length is a power of 2**. We determine if an array is *laminal* as follows:
// - The array `arr` is laminal.
// - Each half of a laminal array is laminal.
// - A subarray of `arr` with a single element is laminal.

// Find the laminal subarray in `arr` with maximum sum and return its sum.

// ```
// Example 1: arr = [3, -9, 2, 4, -1, 5, 5, -4]
// Output: 6
// The laminal arrays are:
// [3, -9, 2, 4, -1, 5, 5, -4],
// [3, -9, 2, 4], [-1, 5, 5, -4],
// [3, -9], [2, 4], [-1, 5], [5, -4],
// [3], [-9], [2], [4], [-1], [5], [5], [-4]
// The one with the maximum sum is [2, 4].

// Example 2: arr = [1]
// Output: 1

// Example 3: arr = [-1, -2]
// Output: -1

// Example 4: arr = [1, 2, 3, 4]
// Output: 10

// Example 5: arr = [-2, -1, -4, -3]
// Output: -1
// ```

// Constraints:
// - The length of arr is a power of 2
// - 1 ≤ len(arr) ≤ 10^5
// - -10^9 ≤ arr[i] ≤ 10^9
