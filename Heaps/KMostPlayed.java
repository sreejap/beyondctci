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

class Song {
  String name;
  int count;
  Song (String s, int c) {
    name = s;
    count = c;
  }
}

class Solution {
  public static List <String> getKMostPlayed (List <List <Object>> tuples, int k) {
    if (tuples == null || tuples.size()==0){
      return new ArrayList<>();
    }

    List <String> res = new ArrayList<>();   

    PriorityQueue <Song> pq = new PriorityQueue<>(k, (a,b) -> (a.count - b.count));

    if (k >=tuples.size()) {
      for (List<Object> s : tuples) {
        res.add((String)s.get(0));
      }
      return res;
    }

    // for (Song s : songs) {
    for (List <Object> t : tuples) {
      Song s = new Song ((String)t.get(0), (int)t.get(1));
      if (pq.size() < k) {        
        pq.add(s);
      }else {
        int minSongCount = pq.peek().count;
        if (s.count > minSongCount) {
          pq.poll();
          pq.add(s);
        }
      }
    }

    while (pq.size()!=0) {
      res.add(pq.poll().name);
    }
    return res;
  }

  public static void main(String[] args) {
    List <List <Object>> tuples = new ArrayList<>();
    tuples.add(new ArrayList<>(Arrays.asList("All the Single Brackets", 132)));
    tuples.add(new ArrayList<>(Arrays.asList("Oops! I Broke Prod Again", 274)));
    tuples.add(new ArrayList<>(Arrays.asList("Coding In The Deep", 146)));
    tuples.add(new ArrayList<>(Arrays.asList("Boolean Rhapsody", 193)));
    tuples.add(new ArrayList<>(Arrays.asList("Here Comes The Bug", 291)));
    tuples.add(new ArrayList<>(Arrays.asList("All About That Base Case", 291)));

    List <String> res = getKMostPlayed (tuples,3);

    for (String name : res) {
      System.out.println(name);
    }
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # K Most Played

// You are given a list of `(title, plays)` tuples where the first element is the name of a song, and the second is the number of times the song has been played. You are also given a positive integer `k`. Return the `k` most played songs from the list, in any order.

// - If the list has fewer than `k` songs, return all of them.
// - Break ties in any way you want.
// - You can assume that song titles have a length of at most `50`.

// Example:
// songs = [["All the Single Brackets", 132],
//          ["Oops! I Broke Prod Again", 274],
//          ["Coding In The Deep", 146],
//          ["Boolean Rhapsody", 193],
//          ["Here Comes The Bug", 291],
//          ["All About That Base Case", 291]]
// k = 3
// Output: ["All About That Base Case", "Here Comes The Bug", "Oops! I Broke Prod Again"]. Any order of these (excellent) songs would be valid.

// Follow-up: Can you solve it using only `O(k)` space?

// Constraints:

// - The length of `songs` is at most `10^5`
// - Each element in `songs` is a tuple with a string and an integer
// - All song titles are unique
// - The length of the string in each song is at most `50`
// - `1 <= k <= 10^5`
