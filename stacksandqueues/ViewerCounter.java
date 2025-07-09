/*
 * Notes:
 * solution: https://start.interviewing.io/beyond-ctci/part-vii-catalog/stacks-&-queues#viewer-counter-class-solution
 * what I did well: I could write a working solution with some help by AI
 * What I could do improve: Don't panic, think about what data structure would solve the problem best and then think about the algorithm, list out all test cases to be solved, all scenarios and code from there
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class ViewerCounter {

  int window;
  LinkedList <int []> subList = new LinkedList<>();
  LinkedList <int []> guestList = new LinkedList<>();
  LinkedList <int []> followerList = new LinkedList<>();
  
  ViewerCounter (int window) {
    this.window = window; 
  }

  public void join (int t, String viewer) {
    if (viewer.equals("guest")) {
      joinViewer(guestList,t,viewer);
    } else if (viewer.equals("subscriber")) {
      joinViewer(subList,t,viewer);
    } else if (viewer.equals("follower")) {   
      joinViewer(followerList,t,viewer);
    }
  }

  public void joinViewer (LinkedList<int [] > l, int t, String viewer){
    if (l.size()!=0) { 
        int [] el = l.getLast();
        if (el[0] == t){
          el[1]++;
        }else {
          l.addLast(new int []{t,1});
        }
      }else {
        l.add(0, new int []{t,1});
      }
  }

  public int get_viewers (int t, String viewer) {
    int count = 0;
    if (viewer.equals("guest")){
      count = countViewers (guestList, t);
    }else if (viewer.equals("subscriber")) {
      count = countViewers (subList, t);
    }else {
      count = countViewers (followerList, t);
    }
    return count;
  }

  private int countViewers (LinkedList<int []> l, int time) {
    int count = 0;
    while (!l.isEmpty() && l.getFirst()[0] < time - this.window) {
      l.removeFirst();
    }

    Iterator<int[]> itr =  l.iterator();
    while(itr.hasNext()) {      
      count += itr.next()[1] ;
    }

    return count;
  }
}


class Solution {
  public static void main(String[] args) {
    ViewerCounter counter = new ViewerCounter(10);
    counter.join(1, "subscriber");
    counter.join(1, "guest");
    counter.join(2, "follower");
    counter.join(2, "follower");
    counter.join(2, "follower");
    counter.join(3, "follower");    
    
    int subCount = counter.get_viewers(10, "subscriber");  // Returns 1    
    System.out.println("======= " + subCount);

    int guestCount = counter.get_viewers(10, "guest");       // Returns 1
    System.out.println("======= " + guestCount);

    int followerCount = counter.get_viewers(10, "follower");  // Returns 4
    System.out.println("======= " + followerCount);

    followerCount = counter.get_viewers(13, "follower");   // Returns 1
    System.out.println("======= " + followerCount);

  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Viewer Counter Class

// Streamers make money based on the number of views they receive while streaming. Implement a `ViewerCounter` class that tracks the number of viewers within a configurable time window for a live stream event. Viewer types may be "guest", "follower", or "subscriber".

// ViewerCounter:
//   __init__(window): establishes a window size ≥ 1.
//   join(t, v): registers that a viewer of type v joined at time t.
//   get_viewers(t, v): gets the viewer count of viewer type v within the time window of length 'window' ending at timestamp t: [t - window, t], with both endpoints included.

// Both methods accept a timestamp `t` represented by an integer. It is guaranteed that each method call receives a time that is greater than or equal to any timestamp used in previous calls to either `join()` or `get_viewers()`.

// ```
// Example:
// counter = ViewerCounter(10)
// counter.join(1, "subscriber")
// counter.join(1, "guest")
// counter.join(2, "follower")
// counter.join(2, "follower")
// counter.join(2, "follower")
// counter.join(3, "follower")
// counter.get_viewers(10, "subscriber")  # Returns 1
// counter.get_viewers(10, "guest")       # Returns 1
// counter.get_viewers(10, "follower")    # Returns 4
// counter.get_viewers(13, "follower")    # Returns 1
// ```

// Constraints:
// - The number of join and get_viewers operations is at most 10^5
// - 1 ≤ window ≤ 10^5
