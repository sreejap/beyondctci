/*
 * T(C) - O(n), S(C) - o(k) ;  since the HashMap will contain at most k distinct books.
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
  public static boolean isDifferentBestSellingBook (String [] bestSellers, int k) {
    // boolean isDifferentBestSeller = false;
    if (bestSellers == null || bestSellers.length == 0){
      return false;
    }

    int left = 0;
    Map<String,Integer> bookCount = new HashMap <>();
    bookCount.put(bestSellers[0],1);
    for (int right = 1; right < bestSellers.length; right++) {
      bookCount.put(bestSellers[right],bookCount.getOrDefault(bestSellers[right],0)+1);
      if (right - left +1 == k) {
        if (bookCount.size() == k) {
          return true;
        }
        int leftBook = bookCount.get(bestSellers[left]);
        bookCount.put(bestSellers[left], leftBook-1);
        if (bookCount.get(bestSellers[left]) == 0) {
          bookCount.remove(bestSellers[left]);
        }
        left++;
      }
    }

    return false;
  }
  public static void main(String[] args) {
    String [] bestSellers = new String[] {"book3", "book1", "book3", "book3", "book2", "book3", "book4", "book3"};
    System.out.println(isDifferentBestSellingBook(bestSellers,3));
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Unique Best Seller Streak

// We are given an array, `best_seller`, with the title of the most sold book for each day over a given period. We are also given a number `k` with `1 ≤ k ≤ len(sales)`.

// We need to return whether there is any k-day period where each day has a **different** best-selling title.

// Example 1:
// best_seller = ["book3", "book1", "book3", "book3", "book2", "book3", "book4", "book3"]
// k = 3

// Output: True
// There is a 3-day period without a repeated value: ["book2", "book3", "book4"]

// Example 2:
// best_seller = ["book3", "book1", "book3", "book3", "book2", "book3", "book4", "book3"]
// k = 4

// Output: False
// There are no 4-day periods without a repeated value

// Example 3:
// best_seller = ["book1", "book2", "book3"]
// k = 3

// Output: True
// The entire array has no repeated values

// Constraints:

// - The length of `best_seller` is at most `10^6`
// - Each book title has length at most `100`
// - `1 <= k <= len(best_seller)`
