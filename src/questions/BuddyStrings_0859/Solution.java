package questions.BuddyStrings_0859;

/*
 * @lc app=leetcode.cn id=859 lang=java
 *
 * [859] 亲密字符串
 *
 * https://leetcode-cn.com/problems/buddy-strings/description/
 *
 * algorithms
 * Easy (27.15%)
 * Likes:    66
 * Dislikes: 0
 * Total Accepted:    8.6K
 * Total Submissions: 30.9K
 * Testcase Example:  '"ab"\n"ba"'
 *
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false
 * 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入： A = "ab", B = "ba"
 * 输出： true
 * 
 * 
 * 示例 2：
 * 
 * 输入： A = "ab", B = "ab"
 * 输出： false
 * 
 * 
 * 示例 3:
 * 
 * 输入： A = "aa", B = "aa"
 * 输出： true
 * 
 * 
 * 示例 4：
 * 
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 * 
 * 
 * 示例 5：
 * 
 * 输入： A = "", B = "aa"
 * 输出： false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A 和 B 仅由小写字母构成。
 * 
 * 
 */

// @lc code=start
class Solution {
    /* 
     题目要求不符合, 题目是只要交换两个字母
    public boolean buddyStrings(String A, String B) {
        String keyA = getBuddyKey(A);
        String keyB = getBuddyKey(B);
        return keyA.equals(keyB);
    } */
    public String getBuddyKey(String str){
        int[] alphabet = new int[26];
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i]  = 0;
        }
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            alphabet[index]++;
        }
        String result = "";
        for (int i = 0; i < alphabet.length; i++) {
            result += alphabet[i]+"#";
        }
        return result;
    }
    public boolean buddyStrings(String A, String B) {
        String keyA = getBuddyKey(A);
        String keyB = getBuddyKey(B);
        if (!keyA.equals(keyB)) return false;
        if (A.equals(B)) return false;
        else return true;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        assert !s.buddyStrings("ab", "ab");
        assert s.buddyStrings("ab", "ba");
        assert s.buddyStrings("aa", "aa");
        assert s.buddyStrings("aaaaaaabc", "aaaaaaacb");
        assert !s.buddyStrings("", "aa");
    }
}
// @lc code=end
