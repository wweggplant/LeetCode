package questions.SameTree_0100;

import java.util.Stack;

import questions.common.TreeNode;

/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
 *
 * https://leetcode-cn.com/problems/same-tree/description/
 *
 * algorithms
 * Easy (57.69%)
 * Likes:    368
 * Dislikes: 0
 * Total Accepted:    90.4K
 * Total Submissions: 156.4K
 * Testcase Example:  '[1,2,3]\n[1,2,3]'
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 
 * 示例 1:
 * 
 * 输入:       1         1
 * ⁠         / \       / \
 * ⁠        2   3     2   3
 * 
 * ⁠       [1,2,3],   [1,2,3]
 * 
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入:      1          1
 * ⁠         /           \
 * ⁠        2             2
 * 
 * ⁠       [1,2],     [1,null,2]
 * 
 * 输出: false
 * 
 * 
 * 示例 3:
 * 
 * 输入:       1         1
 * ⁠         / \       / \
 * ⁠        2   1     1   2
 * 
 * ⁠       [1,2,1],   [1,1,2]
 * 
 * 输出: false
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private boolean res = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        traverse(p, q);
        return res;
    }
    public void traverse(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val != q.val) {
                res = false;
            } else {
                traverse(p.left, q.left);
                traverse(p.right, q.right);
            }
        } else if (p != null || q != null) {
            res = false;
        }
    }
}
// @lc code=end
