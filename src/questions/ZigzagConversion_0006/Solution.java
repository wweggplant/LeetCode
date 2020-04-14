package questions.ZigzagConversion_0006;

/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 *
 * https://leetcode-cn.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (45.61%)
 * Likes:    466
 * Dislikes: 0
 * Total Accepted:    76.7K
 * Total Submissions: 167.8K
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * 
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 
 * 
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 
 * 请你实现这个将字符串进行指定行数变换的函数：
 * 
 * string convert(string s, int numRows);
 * 
 * 示例 1:
 * 
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * 
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * 
 */

// @lc code=start
class Solution {
    /*
     * 题目理解错误 Z字是去有回的
     */
    public String convertError1(String s, int numRows) {
        int start = 0;
        int length = s.length();
        String result = "";
        for (int i = numRows; i > 0; i--) {
            int size = i - 1;
            int j = start;
            int index = j;
            if(i > 1){
                while (index < length) {
                    result += s.charAt(index);
                    index = index + 2 * size;
                }
            } else {
                size = numRows - 1;
                while (index < length) {
                    result += s.charAt(index);
                    index = index + 2 * size;
                }
            }
            start++;
        }
        return result;
    }

    public String convert(String s, int numRows) {
        if(numRows < 2) {
            return s;
        }
        int start = 0;
        int length = s.length();
        String result = "";
        for (int backCount = 0; backCount < numRows; backCount++) {
            int toCount = numRows - backCount - 1;
            if (start >= length) {
                return result;
            }
            int index = start;
            result += s.charAt(start);
            while (index < length) {
                if(toCount > 0){
                    if (index + 2 * toCount < length) {
                        index += 2 * toCount;
                        result += s.charAt(index);
                    } else {
                        break;
                    }
                }
                if(backCount > 0) {
                    if (index + 2 * backCount < length) {
                        index += 2 * backCount;
                        result += s.charAt(index);
                    } else {
                        break;
                    }
                }
            }
            start++;
        }
        return result;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        assert s.convert("LEETCODEISHIRING", 3).equals("LCIRETOESIIGEDHN");
        assert s.convert("LEETCODEISHIRING", 4).equals("LDREOEIIECIHNTSG");
        assert s.convert("A",2).equals("A");
        System.out.println("测试完成");
    }
}
// @lc code=end

