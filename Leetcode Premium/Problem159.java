/*  159. Longest Substring with At Most Two Distinct Characters (Medium)
    Input - "eceba"
    Output - 3
    Explanation: T is "ece" which its length is 3.
    Input - "ccaabbb"
    Output - 5
    Explanation: T is "aabbb" which its length is 5.
*/

import java.util.*;

public class Problem159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3)
            return n;

        int left = 0;
        int right = 0;
        int maxLen = 2;
        Map<Character, Integer> map = new HashMap<>();

        while (right < n) {
            if (map.size() < 3) {
                map.put(s.charAt(right), right++);
            }

            if (map.size() == 3) {
                int delIdx = Collections.min(map.values());
                map.remove(s.charAt(delIdx));
                left = delIdx + 1;
            }

            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Problem159 problem = new Problem159();
        String s1 = "eceebba";
        String s2 = "ccaabbb";
        System.out.println(problem.lengthOfLongestSubstringTwoDistinct(s1));
        System.out.println(problem.lengthOfLongestSubstringTwoDistinct(s2));
    }
}
