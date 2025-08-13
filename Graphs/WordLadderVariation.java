/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class  named Solution.
 * If you need more classes, simply define them inline.
 * important to understand below: 
//  That's an excellent question! You're absolutely right to ask - this is the subtle part of the solution.

// You're not explicitly coding the alternating logic in your traversal. Instead, you're implicitly enforcing the alternating constraint by how you build your graphs.

// Look at your buildGraph calls:

// buildGraph(words, l1, l1+1) - creates a graph with only words of length l and l+1
// buildGraph(words, l1, l1-1) - creates a graph with only words of length l and l-1
// Here's the key insight: If your graph only contains words of two specific lengths, then any path through that graph automatically alternates operations!

// For example, in the (l, l+1) graph:

// If you're at a word of length l, you can only go to words of length l+1 (that's adding a character)
// If you're at a word of length l+1, you can only go to words of length l (that's removing a character)
// So when your DFS traverses this graph, it's forced to alternate between adding and removing at each step - not because you coded that rule explicitly, but because the graph structure makes it impossible to do anything else!
* s(c) - o(n2)
* t(c) - o(n2)
 */

class Solution {
  public static Map <String, List<String>> buildGraph (String [] words, int l1, int l2) {
      Map <String, List<String>> graph = new HashMap <>();

      for (String w: words) {
        for (String w1: words) {
          if (!w.equals(w1) && Math.abs(w.length() - w1.length()) == 1)  {
            graph.put(w,new ArrayList<>());
            graph.put(w1,new ArrayList<>());
          }
        }
      }      
 
      for (String key : graph.keySet()) {
        for (String key1 : graph.keySet()) {
          if (!key.equals(key1)) {
            if (key.length() > key1.length()) {
              String temp = key1;
              key1 = key;
              key = temp;
            }
            for (int i=0; i < key1.length(); i++) {
              String s = key1.substring(0,i) + key1.substring(i+1);
              if (s.equals(key)) {
                graph.get(key).add(key1);
                graph.get(key1).add(key);
              }
            }
          }
        }
      }
      return graph;
  }

  public static boolean hasPath (Map <String, List<String>> graph, Set <String> visited, String w1, String w2) {

    if (w1.equals(w2)) {
      return true;
    }  
    List <String> neighbors = graph.get(w1);
    for (String nb : neighbors) {
      if (nb.equals(w2)) {
        return true;
      }
      if (!visited.contains(nb)) {
        visited.add(nb);
        if (hasPath(graph, visited, nb, w2)){
          return true;
        }
      }
    }
    return false;
  }
  public static boolean isGamePossible (String word1, String word2, String [] words) {

    int l1 = word1.length();
    int l2 = word2.length();

    Map <String, List<String>> graph1 = buildGraph (words,l1,l1+1);

    if (hasPath(graph1, new HashSet <String> (), word1,word2)){
      return true;
    }

    Map <String, List<String>> graph2 = buildGraph (words,l1,l1-1);
    if (hasPath(graph2,new HashSet <String> (),word1,word2)){
      return true;
    }
    
    return false;
  }
  public static void main(String[] args) {
    String word1 = "bounce";
    String word2 = "ounce";

    String [] words = new String []{
"fare", "hug", "car", "vibes", "once", "sop", "far", "ounce", "slap",
    "sap", "cart", "hung", "art", "shop", "fart", "lap", "soap", "are",
   "hop", "care", "leap", "bounce", "beyond", "cracking"
    };

    Boolean game = isGamePossible (word1, word2, words);
    System.out.println("game: " + game);

    // Example 1:
// word1 = "leap"
// word2 = "hop"
// words = [
//    "fare", "hug", "car", "vibes", "once", "sop", "far", "ounce", "slap",
//     "sap", "cart", "hung", "art", "shop", "fart", "lap", "soap", "are",
//    "hop", "care", "leap", "bounce", "beyond", "cracking"
// ]

  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Word Ladder Game Variation

// Two friends are playing a game. The first one says a word. Then, the other friend has to form another word by adding or removing a letter. The first friend then needs to find a new word (repetitions are not allowed) by doing the **opposite** operation (addition or removal). The game goes on, with each friend finding a new word and alternating additions and removals.

// These are two examples of games:

// - `leap, lap, slap, sap, soap, sop, shop, hop`
// - `car, care, are, fare, far, fart, art, cart`

// However, these are not valid games:

// - `bounce, ounce, once` (we removed a letter twice in a row)
// - `hung, hug, hung` (we repeated a word)
// - `car, race` (we reordered the letters)
// - `vibes, vibess` (`vibess` is not a real word)

// Given two words (strings), `word1` and `word2`, and a list of valid words, `words`, which contains `word1` and `word2`, return whether it is possible to start the game at `word1` and get to `word2` using only words from `words`.

// Example 1:
// word1 = "leap"
// word2 = "hop"
// words = [
//    "fare", "hug", "car", "vibes", "once", "sop", "far", "ounce", "slap",
//     "sap", "cart", "hung", "art", "shop", "fart", "lap", "soap", "are",
//    "hop", "care", "leap", "bounce", "beyond", "cracking"
// ]
// Output: True
// The game can proceed as:
// leap -> lap -> slap -> sap -> soap -> sop -> shop -> hop

// Example 2:
// word1 = "car"
// word2 = "cart"
// words = [
//    "fare", "hug", "car", "vibes", "once", "sop", "far", "ounce", "slap",
//     "sap", "cart", "hung", "art", "shop", "fart", "lap", "soap", "are",
//    "hop", "care", "leap", "bounce", "beyond", "cracking"
// ]
// Output: True
// The game can proceed as:
// car -> care -> are -> fare -> far -> fart -> art -> cart

// Example 3:
// word1 = "bounce"
// word2 = "once"
// words = [
//    "fare", "hug", "car", "vibes", "once", "sop", "far", "ounce", "slap",
//     "sap", "cart", "hung", "art", "shop", "fart", "lap", "soap", "are",
//    "hop", "care", "leap", "bounce", "beyond", "cracking"
// ]
// Output: False

// Constraints:

// - All words contain only lowercase English letters
// - All the words in `words` are unique
// - `1 <= words.length <= 1000`
// - `1 <= words[i].length <= 30`
// - `word1` and `word2` are in `words`
// - `word1` and `word2` are different
