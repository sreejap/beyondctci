/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * Total time complexity is O(2^n * n) - You have O(2^n) leaf nodes, and at each leaf you're doing O(n) work to copy the solution.
 * Total space complexity is O(2^n * n) for storing all the subsets, plus O(n) for the recursion stack depth, which gives you O(2^n * n) overall.
 * 
 *
 * 
 */

class Solution {

  // public static List <List<Character>> res; // this is the res
  // public static List <Character> path; // this is partial solution
  public static void subsets (char [] chs, int pos,List <List<Character>> res,List <Character> path ) {
    if (pos == chs.length){
      res.add(new ArrayList <>(path));
      return;
      // return res;
    }

    // we iterate through two choices - include the char and exclude the char
    // but because there are only 2 we write them down
    path.add(chs[pos]);
    subsets(chs, pos+1,res,path);
    path.remove(path.size()-1);
    subsets(chs,pos+1,res,path);

  }
  public static void main(String[] args) {
    char [] chs = new char [] {'x', 'y', 'z'};
    List <List<Character>> res = new ArrayList <>();
    subsets (chs,0,res, new ArrayList<>());
    // res = new ArrayList <>();
    // path = new ArrayList <>();
    for (List <Character> set : res) {
      System.out.println("=========" + set.size());
      for (Character c : set) {
        System.out.println("c:" + c);
      }
      System.out.println("=========");
    }
  }
}

// Your previous Plain Text content is preserved below:

// Hello! Your interview question is below. Write code in this pad just like you would normally – your AI Interviewer will be able to see it.

// # Subset Enumeration

// Given a set of elements, `S`, a subset of `S` is another set obtained by removing any number of elements from `S` (including none or all of them). As usual with sets, order does not matter.

// Given an array of unique characters, `S`, return all possible subsets in any order.

// Example: S = ['x', 'y', 'z']
// Output: [[],
//          ['x'],
//          ['y'],
//          ['z'],
//          ['x', 'y'],
//          ['x', 'z'],
//          ['y', 'z'],
//          ['x', 'y', 'z']]

// Constraints:

// - The elements in `S` are unique.
// - The length of `S` is at most 12.
