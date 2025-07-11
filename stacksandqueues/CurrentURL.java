/*
 * Problem: https://start.interviewing.io/interview-ai?problemId=current-url
 * Click `Run` to execute the snippet below!
 * start with simple logic and run it through examples
 * think loud
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
  public static String currentURL (ArrayList<ArrayList<String>> actions) {
    Deque <String> st = new ArrayDeque<>();
    String currentUrl = new String(); 
    for (ArrayList<String> a : actions) {
      if (a.get(0).equals("go")){
        st.push(a.get(1));
        // System.out.println("stack peek url:" + st.peek());  
      }else {
        // _back        
        int count = Integer.parseInt(a.get(1));

        getUrl(st,count);
        // System.out.println("Back: " + count + " times " + " curr url: " + currentUrl);
      }
    }

    return st.peek();
  }

  public static String getUrl (Deque<String> st, int count) {
    while(st.size()>1 && count >0) {
      st.pop();
      count--;
    }
    return st.peek();
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<String>> actions = new ArrayList<>();
    actions.add(new ArrayList<>(Arrays.asList("go", "google.com"))) ;
    actions.add(new ArrayList<>(Arrays.asList("go", "wikipedia.com"))) ;
    actions.add(new ArrayList<>(Arrays.asList("go", "amazon.com"))) ;
    actions.add(new ArrayList<>(Arrays.asList("back", "4"))) ;
    actions.add(new ArrayList<>(Arrays.asList("go", "youtube.com"))) ;
    actions.add(new ArrayList<>(Arrays.asList("go", "netflix.com"))) ;
    actions.add(new ArrayList<>(Arrays.asList("back", "1"))) ;    

    String res = currentURL(actions);
    System.out.println(res);
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Current URL

// You are implementing the _back arrow_ functionality of a browser. You are given a non-empty array, `actions`, with the actions that the user has done so far. Each element in `actions` consists of two elements. The first is the action type, "go" or "back".

// - When the action is "go", the second element is a URL string. The first action is always "go".
// - When the action is "back", the second element is a number ≥ 1 with the number of times we want to go back. Going back once means returning to the previous URL we went to with a "go" action. If there are no previous URLs, going back stays at the current one.

// Return the current URL the user is on after all actions are performed.

// ```
// Example: actions = [["go", "google.com"],
//                     ["go", "wikipedia.com"],
//                     ["go", "amazon.com"],
//                     ["back", 4],
//                     ["go", "youtube.com"],
//                     [],
//                     ["back", 1]]
// Output: "youtube.com"
// ```

// Constraints:

// - The length of `actions` is at most `10^5`
// - Each URL is a non-empty string
