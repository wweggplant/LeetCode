package questions.LongestPalindromicSubstring_0005;

/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (27.61%)
 * Likes:    1506
 * Dislikes: 0
 * Total Accepted:    146.2K
 * Total Submissions: 528.4K
 * Testcase Example:  '"babad"'
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 
 */

// @lc code=start
class Solution {
    // 回文理解错误, abcba是回文,正读反读都一样
    public String longestPalindrome(String s) {
        if (s == null) return null;
        if ("".equals(s)) return "";
        int i = 0 , j = 1, length = s.length();
        String maxStr = "";
        while (i < length ) {
            char ch = s.charAt(i);
            j = i;
            while (j < length) {
                char ss = s.charAt(j);
                if (ss == ch && j - i >= maxStr.length()) {
                    maxStr = s.substring(i, j+1);
                }
                j++;
            }
            i++;
        }
        if (maxStr.length() == length) {
            return maxStr.substring(0,1);
        }
        return maxStr;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        assert s.longestPalindrome("babad").equals("bab");
        assert s.longestPalindrome("cbbd").equals("bb");
        assert s.longestPalindrome("a").equals("a");
        assert s.longestPalindrome("").equals("");
        assert s.longestPalindrome("ac").equals("a");
        assert s.longestPalindrome("abcda").equals("a");
        assert s.longestPalindrome("bb").equals("b");
        System.out.println("测试完成");
    }
}
// @lc code=end