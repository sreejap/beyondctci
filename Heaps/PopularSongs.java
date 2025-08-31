/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * * Coding Ability: Score: 3/4 Justification: There's a casting bug on line 47 that truncates the median incorrectly, affecting accuracy.  
* Problem-Solving: Score: 4/4 Justification: You identified the optimal two-heap approach and implemented the balancing logic correctly without excessive hints.  
* Communication: Score: 3/4 Justification: You clearly explained your approach and reasoning, though initially struggled with heap naming conventions.  
* Overall Feedback: You successfully solved a challenging dynamic median problem using the optimal two-heap approach. The solution has correct time complexity (O(log n) register, O(1) query) and space complexity (O(n)). The main issue is the median calculation bug on line 47 - remove the (int) cast to preserve decimal precision. You demonstrated strong problem-solving skills and persistence through the tricky balancing logic.  
* Final Result: PASS - You achieved the optimal solution with mostly working code, correct complexity analysis, and clear communication.   
 * NOTE: This is a tricky problem, practise more
 * 
 */


class PopularSongs {
  PriorityQueue <Integer> lowerMaxHeap = new PriorityQueue<>(Collections.reverseOrder()); 
  PriorityQueue <Integer> upperMinHeap = new PriorityQueue<>();
  Map <String, Integer> playCounts = new HashMap <>();

  void register_plays (String title, int plays) {
    playCounts.put(title, plays);
     if (lowerMaxHeap.isEmpty() || plays <=lowerMaxHeap.peek()) {
      lowerMaxHeap.add(plays);
     } else {
      upperMinHeap.add(plays);
     }

     if (lowerMaxHeap.size() > upperMinHeap.size()+1) {
      upperMinHeap.add(lowerMaxHeap.poll());
     } else if (upperMinHeap.size() > lowerMaxHeap.size()) {
      lowerMaxHeap.add(upperMinHeap.poll());
     } 
  }

  boolean is_popular (String title) {
    int titlePlay = playCounts.getOrDefault(title,0);
    
    if ( lowerMaxHeap.size() == upperMinHeap.size()) {
      double median =  ((lowerMaxHeap.peek() + upperMinHeap.peek()) / 2.0);
      return titlePlay > median;
    }else {
      if (lowerMaxHeap.isEmpty()){
        return false;
      }
      return titlePlay > lowerMaxHeap.peek();
    }    
  }
}
class Solution {
  public static void main(String[] args) {
    PopularSongs p = new PopularSongs();
    p.register_plays("Boolean Rhapsody", 193);
    boolean b1 = p.is_popular("Boolean Rhapsody");
    System.out.println(b1);
    p.register_plays("Coding In The Deep", 140);
    p.register_plays("All the Single Brackets", 132);
    boolean b2 = p.is_popular("Boolean Rhapsody");
    System.out.println(b2);
    boolean b3 = p.is_popular("Coding In The Deep");
    System.out.println(b3);
    boolean b4 = p.is_popular("All the Single Brackets");
    System.out.println(b4);
    p.register_plays("All About That Base Case", 291);
    p.register_plays("Oops! I Broke Prod Again", 274);
    p.register_plays("Here Comes The Bug", 223);
    boolean b5 = p.is_popular("Boolean Rhapsody");
    System.out.println(b5);
    boolean b6 = p.is_popular("Here Comes The Bug");
    System.out.println(b6);
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Popular Songs Class

// Implement a `PopularSongs` class that has two methods:

// - `register_plays(title, plays)` indicates that a song was played a given number of times. It returns nothing. The method is never called with the same title twice.
// - `is_popular(title)` returns whether the given song is popular. A song is _popular_ if its play count is strictly higher than the median play count.

// The median of a collection of integers with odd size is the middle element in sorted order; if the size is even, the median is the average of the two middle elements.

// Example:

// p = PopularSongs()
// p.register_plays("Boolean Rhapsody", 193)
// p.is_popular("Boolean Rhapsody")                   # Returns False
// p.register_plays("Coding In The Deep", 140)
// p.register_plays("All the Single Brackets", 132)
// p.is_popular("Boolean Rhapsody")                   # Returns True
// p.is_popular("Coding In The Deep")                 # Returns False
// p.is_popular("All the Single Brackets")            # Returns False
// p.register_plays("All About That Base Case", 291)
// p.register_plays("Oops! I Broke Prod Again", 274)
// p.register_plays("Here Comes The Bug", 223)
// p.is_popular("Boolean Rhapsody")                   # Returns False
// p.is_popular("Here Comes The Bug")                 # Returns True

// Analyze the space and runtime of each operation in terms of the number of songs registered so far. The goal is to minimize the total runtime assuming we will make the same number of operations of each type.

// Constraints:

// - Song titles are unique and have at most `50` characters.
// - The number of plays is at least `1` and at most `10^9`.
// - The number of registered songs is at most `10^5`.
