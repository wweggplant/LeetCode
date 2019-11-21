package src.questions.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;
/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    // 暴力法
    public static int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        Set<Character> set = new HashSet<Character>();
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            set.clear();
            set.add(array[i]);
            for (int j = i + 1; j < array.length; j++) {
                if (set.contains(array[j])){
                    break;
                } else{
                    set.add(array[j]);
                }
            }
            if(set.size()>max)
                max = set.size();
        }
        return max;
    }
    // 2
    public static int lengthOfLongestSubstring2(String s) {
        
    }
    public static void main(String[] args) {
        int max = Solution.lengthOfLongestSubstring("     ");
        System.out.println(max);
    }
}
// @lc code=end


