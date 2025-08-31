/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * T(c) - o(klogm) - k is size of output list, m is number of genres
 * S(c) - o(k+m)
 */

class Song {
  String name;
  int plays;
  Song (String s, int n) {
    name = s;
    plays = n;
  }
}

class SongMap {
  int genreIndex;
  int songIndex;
  SongMap (int g, int s) {
    genreIndex = g;
    songIndex = s;
  }
}

class Solution {
  public static List <String> getKMostListened (List <List<Song>> songs, int k) {
      PriorityQueue <SongMap> pq = new PriorityQueue<>((a,b) -> (songs.get(b.genreIndex).get(b.songIndex).plays-(songs.get(a.genreIndex).get(a.songIndex).plays)));
      List<String> kMostListened = new ArrayList<>();

      for (int i=0; i < songs.size(); i++) {
        if (songs.get(i).size() > 0) {
          pq.offer(new SongMap(i, (0)));
        }
      }

      while (kMostListened.size() < k && !pq.isEmpty()) {
        SongMap next = pq.poll();
        kMostListened.add(songs.get(next.genreIndex).get(next.songIndex).name);

        int gIndex = next.genreIndex;
        int sIndex = next.songIndex;

        if (sIndex+1 < songs.get(gIndex).size()) {        
          SongMap nextEntry = new SongMap(next.genreIndex, sIndex+1);
          pq.offer(nextEntry);
        }
      }

      return kMostListened;
  }
  public static void main(String[] args) {
    List <List<Song>> songs = new ArrayList<>();
    List <Song> popSongs = new ArrayList<>();
    List <Song> countrySongs = new ArrayList<>();
    List <Song> rockSongs = new ArrayList<>();

    popSongs.add(new Song("Coding in the Deep", 123));
    popSongs.add(new Song("Someone Like GNU", 99));
    popSongs.add(new Song("Hello World", 98));

    countrySongs.add(new Song("Ring of Firewalls", 217));

    rockSongs.add(new Song("Boolean Rhapsody", 184));
    rockSongs.add(new Song("Merge Together", 119));
    rockSongs.add(new Song("Hey Queue", 102));

    songs.add(popSongs);
    songs.add(countrySongs);
    songs.add(rockSongs);

    List <String> mostListened = getKMostListened (songs,5);

    for (String s : mostListened) {
      System.out.println(s);
    }
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Most Listened Across Genres

// You are given an array, `genres`, of length `m`, where each element is an array of songs from a given genre. Each song consists of a `[title, plays]` pair.

// - Each list is non-empty and **already sorted** from most to least played songs.
// - There are `n > 0` songs in total, and each song appears in at most one list.

// You are also given a positive integer `k` satisfying `1 <= k <= n`. Return the titles of the top `k` most-listened songs across all genres, in order from most to least listened. It doesn't matter how you break ties.

// Example:
// genres = [
//   [ # Pop
//     ["Coding In The Deep", 123],
//     ["Someone Like GNU",    99],
//     ["Hello World",         98]
//   ],
//   [ # Country
//     ["Ring Of Firewalls",  217]
//   ],
//   [ # Rock
//     ["Boolean Rhapsody",   184],
//     ["Merge Together",     119],
//     ["Hey Queue",          102]
//   ]
// ]
// k = 5
// Output: [
//   "Ring Of Firewalls",
//   "Boolean Rhapsody",
//   "Coding In The Deep",
//   "Merge Together",
//   "Hey Queue"
// ]

// Constraints:

// - The length of `genres`, `m`, is at least `1` and at most `10^5`.
// - The total number of songs, `n`, is at least `1` and at most `10^5`.
// - Song titles are unique and have at most `50` characters.
// - Each genre list is already sorted from most to least played songs (there can be ties).
// - `1 <= k <= n`.
