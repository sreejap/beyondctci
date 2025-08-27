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

  public static void replacements(List <String> words, int i, Map <String, List <String>> synonyms, List <String> partial, List <String> res) {
    if (i == words.size()) {
      res.add(String.join(" ", partial));
      return;
    }

    String w = words.get(i);
    if (synonyms.containsKey(w)) {
      List <String> syn = synonyms.get(w);
      for (String sy : syn) {
        partial.add(sy);
        replacements (words,i+1, synonyms, partial, res);
        partial.remove(partial.size()-1);
      }
    }else {
      partial.add(w);
      replacements (words,i+1, synonyms, partial, res);
      partial.remove(partial.size()-1);
    }
  }

  public static void main(String[] args) {
    String sentence = "one does not simply walk into mordor";
    StringTokenizer st = new StringTokenizer(sentence);

    List <String> tokens = new ArrayList <> ();
    while (st.hasMoreTokens()) {
      tokens.add(st.nextToken());
    }


    Map <String, List <String>> synonyms = new HashMap <>();
    List<String> l1 = new ArrayList <>(Arrays.asList("stroll", "hike", "wander"));
    List <String> l2 = new ArrayList <>(Arrays.asList("just", "merely"));
    synonyms.put("walk", l1);
    synonyms.put("simply", l2);
    List <String> res = new ArrayList <>();
    List <String> partial = new ArrayList <>();

    replacements (tokens,0,synonyms,partial,res);

    for (String s : res) {
      System.out.println(s);
      System.out.println("-----");
    }
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Thesaurusly

// Given a non-empty string, `sentence`, and a non-empty map, `synonyms`, where each key is a single word in the sentence, and its value is a non-empty list of synonyms, return all possible sentences that can be created by replacing the words in the sentence with their synonyms. Words without synonyms should remain unchanged. The input `sentence` only contains lowercase letters and spaces, while the words in `synonyms` only contain lowercase letters. The order of the generated sentences in the output does not matter.

// Example 1:
// sentence = "one does not simply walk into mordor"
// synonyms = {
//   "walk": ["stroll", "hike", "wander"],
//   "simply": ["just", "merely"]
// }
// Output: [
//           "one does not just stroll into mordor",
//           "one does not just hike into mordor",
//           "one does not just wander into mordor",
//           "one does not merely stroll into mordor",
//           "one does not merely hike into mordor",
//           "one does not merely wander into mordor"
//         ]

// Example 2:
// sentence = "walk"
// synonyms = {
//   "walk": ["stroll"]
// }
// Output: ["stroll"]

// Constraints:

// - `sentence` consists of lowercase letters and spaces.
// - The length of `sentence` is at most `500` characters.
// - `sentence` contains at most `100` words.
// - The synonyms map contains at most `8` entries.
// - The length of each synonym list is at most `6`.
// - Each word in `sentence` or in the synonym lists is at most `10` characters.
