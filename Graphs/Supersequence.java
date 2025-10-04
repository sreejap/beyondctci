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
  public static List<Character> getTopoOrder (String [] words) {
    Map <Character, Set <Character>> graph = new HashMap <>();
    List <Character> topoOrder = new ArrayList <>();
    // mapping for all the letters...
    // make the skeleton graph first .. 
    for (String w : words) {
      for (Character c : w.toCharArray()){
        if (!graph.containsKey(c)) {
          graph.put(c,new HashSet<>());
        }
      }
    }

    for (String w : words) {
      for (int i=0; i < w.length()-1; i++) {
        graph.get(w.charAt(i)).add(w.charAt(i+1));
      }
    }

    Map<Character,Integer> inDegrees = new HashMap<>();
    List <Character> degreeZero = new ArrayList<>();
    for (Character node : graph.keySet()){
      inDegrees.put(node,0);
    }

    for (Map.Entry<Character, Set<Character>> entry : graph.entrySet()){
      Character u = entry.getKey();
      for (Character v: graph.get(u)) {
        inDegrees.put(v, inDegrees.get(v)+1);
      }
    }

    for (Map.Entry<Character, Integer> entry : inDegrees.entrySet()){
      if (entry.getValue()==0){
        degreeZero.add(entry.getKey());
      }
    }

    while(!degreeZero.isEmpty()){
      Character u= degreeZero.remove(degreeZero.size()-1);
      topoOrder.add(u);
      for (Character v : graph.get(u)){
        inDegrees.put(v,inDegrees.get(v)-1);
        if (inDegrees.get(v)==0){
          degreeZero.add(v);
        }
      }
    }

    if (topoOrder.size()!=graph.size()){
      topoOrder = new ArrayList<>();
    } 

    return topoOrder;
  }
  public static boolean solve (String [] words) {
    boolean result = false;

    List<Character> topoOrder = getTopoOrder (words);
    result = topoOrder.size() >0 ? true : false;
    return result;
  }
  public static void main(String[] args) {
    String [] arr = new String [] {"aa"};

    boolean isSuperSequence = solve (arr);
    System.out.println(isSuperSequence);
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Supersequence

// A _supersequence_ of a string `s` is another string that contains all the same letters of `s` in the same relative order. For instance, `"aabbcc"` is a supersequence of `"abc"`, but not of `"bca"`.

// Given a non-empty array of strings, `arr`, where each string consists only of lowercase English letters, determine if it is possible to construct a _single_ supersequence of all the strings in `arr` such that no letter appears more than once. Return `true` if such a supersequence exists and `false` otherwise.

// Example 1. arr = ["abc", "bde", "df", "cfe"]
// Output: True. "abcdfe" is a supersequence.

// Example 2. arr = ["ab", "ba"]
// Output: False. Any supersequence would have to
// - include 'a' twice (like "aba") or
// - include 'b' twice (like "bab").

// Example 3. arr = ["aa"]
// Output: False.

// Constraints:

// - The length of each string is at most `100`
// - Each string consists of lowercase English letters
