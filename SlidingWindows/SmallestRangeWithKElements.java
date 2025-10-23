// https://start.interviewing.io/interview-ai/code?problemId=smallest-range-with-k-elements
class Solution {
  public static int [] getRange (int [] arr, int k){
        Arrays.sort(arr);  // Step 0: sort the array first

        int left = 0;
        int bestLow = 0;
        int bestHigh = Integer.MAX_VALUE;

        for (int right = 0; right < arr.length; right++) {
            // Step 1: Expand window
            // Nothing extra to do here; 'right' is moving

            // Step 2: Shrink window if it has more than k elements
            while ((right - left + 1) > k) {
                left++;
            }

            // Step 3: Update the best range if window has exactly k elements
            if ((right - left + 1) == k && (arr[right] - arr[left] < bestHigh - bestLow)) {
                bestLow = arr[left];
                bestHigh = arr[right];
            }
        }

        return new int[]{bestLow, bestHigh};
  }
  public static void main(String[] args) {
    int [] arr =  new int [] {1, 2, 5, 7, 8};
    int k = 3;
    int [] range = getRange (arr,k);
    System.out.println(range[0] + ", " + range[1]);
  }
}
