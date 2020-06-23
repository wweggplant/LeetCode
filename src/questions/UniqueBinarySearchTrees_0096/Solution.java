package questions.UniqueBinarySearchTrees_0096;

import questions.common.*;
/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 *
 * https://leetcode-cn.com/problems/unique-binary-search-trees/description/
 *
 * algorithms
 * Medium (65.58%)
 * Likes:    523
 * Dislikes: 0
 * Total Accepted:    44.5K
 * Total Submissions: 67.9K
 * Testcase Example:  '3'
 *
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
 * 
 */

// @lc code=start
class Solution {
    // 动态规划, 整理推导公式 G(n)= i=1∑n ​G(i−1)⋅G(n−i)(3)
    // https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode/
    public int numTrees2(int n) {
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[ i - j];
            }
        }
        return G[n];
    }
    
    // 卡塔兰数
    public int numTrees(int n) {
        long C = 1; // 用long型防止溢出
        for (int i = 0; i < n; i++) {
            C = C * 2 * (2 * i + 1)/(i+2);
        }
        return (int) C;
    }
}
// @lc code=end
