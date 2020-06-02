package questions.ValidateBinarySearchTree_0098;

import java.util.Stack;

import questions.common.*;
/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 *
 * https://leetcode-cn.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (31.24%)
 * Likes:    592
 * Dislikes: 0
 * Total Accepted:    122.8K
 * Total Submissions: 393K
 * Testcase Example:  '[2,1,3]'
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 
 * 假设一个二叉搜索树具有如下特征：
 * 
 * 
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * ⁠   5
 * ⁠  / \
 * ⁠ 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 * 
 * 
 */


// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    /* 
    private boolean res = true;
    public boolean isValidBST(TreeNode root) {
        traverse(root);
        return res;
    }
    // 注意:这个方法错在 整体的孩子树也要满足条件
    public void traverse(TreeNode node) {
        if (node != null && this.res) {
            TreeNode left = node.left;
            TreeNode right = node.right;
            int val = node.val;
            if (left != null && left.val >= val) {
                this.res = false;
                return;
            }
            if (right != null && right.val <= val) {
                this.res = false;
                return;
            }
            traverse(left);
            traverse(right);
        }
    }
    */
    /* 
        思路1: 使用栈,递归BST树, 按照中序遍历把所有的节点放入栈里。然后检查栈里数据的顺序是否是从大到小排列。
        可以优化的点：在中序遍历的过程中，可以对当前节点进行局部范围检测，提前找出局部不满足的节点。

        根据官方提示, 在中序遍历的过程中,如果是BST,那么当前节点的值必然大于上一个遍历的节点的值
    */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = - Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
// @lc code=end
