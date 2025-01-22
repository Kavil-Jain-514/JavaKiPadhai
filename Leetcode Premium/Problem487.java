/*
 * Problem URL: https://leetcode.com/problems/max-consecutive-ones-ii/
 * Problem statement: Longest Subarray with Ones After flipping at most one 0.
 * Input - [1,0,1,1,0]
 * Output - 4
 * Explanation: Replace the '0' at index 2 to get the longest subarray of 1s having length 4.
 * Input - [1,0,1,1,0,1]
 * Output - 4
 * Explanation: Replace the '0' at index 4 to get the longest subarray of 1s having length 4.
 * Input - [1,1,1,0,0,0,1,1,1,1,0]
 * Output - 5
 * Explanation: Replace the '0' at index 5 or 10 to get the longest subarray of 1s having length 5.
 */
public class Problem487 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int maxFreq = 0;
        int freq[] = new int[2];
        while(right<nums.length) {
            freq[nums[right]]++;
            maxFreq = Math.max(maxFreq, freq[1]);
            if(right-left+1-maxFreq>1) {
                freq[nums[left]]--;
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println("This is Problem 487.");
        int maxLen = findMaxConsecutiveOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0});
        System.out.println(maxLen);
    }
}