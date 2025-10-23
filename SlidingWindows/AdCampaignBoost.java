/*
 * https://start.interviewing.io/interview-ai/code?problemId=ad-campaign-boost
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
  public static int getMaxGoodDays (int [] nums, int k){

    int l=0;
    int r=0;

    int maxGoodDays = 0;
    int badDays = 0;
    while (r < nums.length) {
      if (nums[r] < 10) {
        badDays ++;
      }
      r++;
      while (badDays >k ) {
        if (nums[l] < 10) {          
          badDays--;                
        }
        l++;
      }
      maxGoodDays = Math.max(maxGoodDays, r-l);
    }

    return maxGoodDays;
  }

  public static void main(String[] args) {
    int [] projected_sales = new int [] {5, 5, 5};
    int k = 3;
    int maxGoodDays = getMaxGoodDays (projected_sales,k);
    System.out.println(maxGoodDays);
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Ad Campaign Boost

// Imagine that you have a little bookstore. We have an array, `projected_sales`, with the projected number of sales per day in the future.

// We are trying to pick `k` days for an advertising campaign, which we expect to boost the sales on those specific days by at least `20`.

// If we pick the days for the advertising campaign correctly, what is the maximum number of consecutive good days in a row we can get?

// A _good day_ is a day with at least `10` sales.

// Example 1: projected_sales = [5, 0, 20, 0, 5], k = 2
// Output: 3.
// The only good day is day 2. We can boost:
//   - days 0 and 1,
//   - days 1 and 3, or
//   - days 3 and 4.
// For instance, if we boost days 0 and 1, the projected sales become:
// [25, 20, 20, 0, 5], with 3 consecutive good days.

// Example 2: projected_sales = [0, 10, 0, 10], k = 1
// Output: 3. We can boost day 2; boosting day 0 is suboptimal.

// Example 3: projected_sales = [5, 5, 5], k = 3
// Output: 3. We can boost all days to make them good days.

// Constraints:

// - `1 <= k <= len(projected_sales) <= 10^5`
// - `0 <= projected_sales[i] <= 10^3`
