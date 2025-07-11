/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * What I could do to improve: think of the edge cases, understand the operations such as back and forward
 *       use two stacks if needed
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static String currentURL (ArrayList<ArrayList<String>> actions) {
    Deque <String> backSt = new ArrayDeque<>();
    Deque <String> fwdSt = new ArrayDeque<>();
    
    for (ArrayList<String> a : actions) {
      if (a.get(0).equals("go")){
        backSt.push(a.get(1)); 
        fwdSt.clear();
        // System.out.println("stack peek url:" + st.peek());  
      }else if (a.get(0).equals("back")) {
        // _back        
        int count = Integer.parseInt(a.get(1));
        getUrl(backSt,count, backSt);
      }else {
        // forward
        int count = Integer.parseInt(a.get(1));
        getFwdUrl (backSt, fwdSt,count);
      }
    }
    return backSt.peek();
  }

  public static void clearForwardHistory (Deque <String> fwdSt) {
    while (!fwdSt.isEmpty()){
      fwdSt.remove();
    }
  }

  public static String getUrl (Deque<String> backSt, int count, Deque <String> fwdSt) {
    while(backSt.size()>1 && count >0) {
      fwdSt.add(backSt.pop());
      count--;
    }
    return backSt.peek();
  }

  public static void getFwdUrl (Deque<String> backSt, Deque<String> fwdSt, int count) {
    while(!fwdSt.isEmpty() && count >0) {
      backSt.add(fwdSt.pop());
      count--;
    }
    return ;
  }



  public static void main(String[] args) {
    ArrayList<ArrayList<String>> actions = new ArrayList<>();
    actions.add(new ArrayList<>(Arrays.asList("go", "google.com"))) ;
    actions.add(new ArrayList<>(Arrays.asList("go", "wikipedia.com"))) ;    
    actions.add(new ArrayList<>(Arrays.asList("back", "1"))) ;
    actions.add(new ArrayList<>(Arrays.asList("forward", "1"))) ;
    actions.add(new ArrayList<>(Arrays.asList("back", "3"))) ;    
    actions.add(new ArrayList<>(Arrays.asList("go", "netflix.com"))) ;
    actions.add(new ArrayList<>(Arrays.asList("forward", "3"))) ;
    String res = currentURL(actions);
    System.out.println(res);
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Current URL With Forward

// You are implementing the _back arrow_ functionality of a browser with an additional "forward" action. You are given a non-empty array, `actions`, with the actions that the user has done so far. Each element in `actions` consists of two elements. The first is the action type, "go", "back", or "forward".

// - When the action is "go", the second element is a URL string. The first action is always "go".
// - When the action is "back", the second element is a number ≥ 1 with the number of times we want to go back. Going back once means returning to the previous URL we went to with a "go" action. If there are no previous URLs, going back stays at the current one.
// - When the action is "forward", the second element is a number ≥ 1 with the number of times we want to go forward. Going forward past the last page that we have gone to does nothing.

// Return the current URL the user is on after all actions are performed.

// ```
// Example: actions = [["go", "google.com"],
//                     ["go", "wikipedia.com"],
//                     ["back", 1],
//                     ["forward", 1],
//                     ["back", 3],
//                     ["go", "netflix.com"],
//                     ["forward", 3]]
// Output: "netflix.com"
// ```

// Constraints:

// - The length of `actions` is at most `10^5`
// - Each URL is a non-empty string
