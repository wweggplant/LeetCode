package src.questions.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (31.97%)
 * Likes:    2717
 * Dislikes: 0
 * Total Accepted:    272.2K
 * Total Submissions: 850.7K
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 

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
    /*
        使用Set作为滑动窗口, 滑动窗口的关键在于如何设计start
    */
    public static int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<Character>();
        int i = 0, j = 0, max = 0, n = s.length();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
    /**
     * 使用Set的滑动窗口,需要对每一个i进行检查. 实际上检查过得子串可以直接从重复的地方开始计算start
     * 使用Map<String, Integer> 记录start的位置
     */
    public static int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int i = 0, j = 0, max = 0 , n = s.length();
        while(j < n) {
            if (map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)), i);
            }
            max = Math.max(j - i + 1, max);
            map.put(s.charAt(j), j++ + 1);
        }
        return max;
    }
    // 错误方法1: 这个错误的方法问题在于错误的认为找到的子数组就是最大子序列
    public static int errorLengthOfLongestSubstring1(String s) {
        char[] array = s.toCharArray();
        Set<Character> set = new HashSet<Character>();
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (!set.contains(array[i]))
                set.add(array[i]);
        }
        char[] subQue = set.toArray();
        int i = 1, j = 1, start = 0, end = 0;
        while(i < subQue.length){
            if (subQue[i] == array[j]){
                if (i - start > end - start) {
                    start = end;
                    end = i;
                }
                j++;
                i++;
            } else {
                j++;
            }
        }
        return end - start + 1;
    } 
    public static void main(String[] args) {
        assert 3 == Solution.lengthOfLongestSubstring("abcabcbb");
        assert 1 == Solution.lengthOfLongestSubstring("bbbbbbbbb");
        assert 3 == Solution.lengthOfLongestSubstring("pwwkew");
        assert 3 == Solution.lengthOfLongestSubstring2("abcabcbb");
        assert 1 == Solution.lengthOfLongestSubstring2("bbbbbbbbb");
        assert 3 == Solution.lengthOfLongestSubstring2("pwwkew");
        assert 3 == Solution.lengthOfLongestSubstring3("abcabcbb");
        assert 1 == Solution.lengthOfLongestSubstring3("bbbbbbbbb");
        assert 3 == Solution.lengthOfLongestSubstring3("pwwkew");
        System.out.println("end");
    }
}
// @lc code=end
