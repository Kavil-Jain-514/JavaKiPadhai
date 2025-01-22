/*
 * Problem: Longest Substring with At Most K Distinct Characters
 * Input - "eceba", k = 2
 * Output - 3
 * Explanation: T is "ece" which its length is 3.
 * Input - "ccaabbb", k = 2
 * Output - 5
 * Explanation: T is "aabbb" which its length is 5.
 */

import java.util.*;

public class Problem340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int start = 0;
        int end = 0;
        int maxLen = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        while (end < n) {
            if (map.size() <= k) {
                map.put(s.charAt(end), end++);
            }
            if (map.size() > k) {
                int deleteIdx = Collections.min(map.values());
                map.remove(s.charAt(deleteIdx));
                start = deleteIdx + 1;
            }
            maxLen = Math.max(maxLen, end - start);
        }
        return maxLen;

    }

    public static void main(String[] args) {
        Problem340 problem = new Problem340();
        String s1 = "aaabbccd";
        String s2 = "ccaabbb";
        System.out.println(problem.lengthOfLongestSubstringKDistinct(s1, 3));
        System.out.println(problem.lengthOfLongestSubstringKDistinct(s2, 3));
    }
}