package questions.BalancedBinaryTree_0110;

import questions.common.TreeNode;

/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 *
 * https://leetcode-cn.com/problems/balanced-binary-tree/description/
 *
 * algorithms
 * Easy (51.89%)
 * Likes:    343
 * Dislikes: 0
 * Total Accepted:    80.9K
 * Total Submissions: 155.7K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 
 * 本题中，一棵高度平衡二叉树定义为：
 * 
 * 
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 
 * 
 * 示例 1:
 * 
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回 true 。
 * 
 * 示例 2:
 * 
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   2
 * ⁠   / \
 * ⁠  3   3
 * ⁠ / \
 * ⁠4   4
 * 
 * 
 * 返回 false 。
 * 
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
     * 使用BST，层次遍历，找出第一个left/right节点为null的节点，记录起所在的层，再找出最后一层的的层数(这个方法有问题，
     * 题目要求子树也要满足平衡的条件)
     *
     */
    public boolean isBalanced2(TreeNode root) {
        if (root == null) return true;
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    private int height(TreeNode node) {
        if (node == null ) {
            return 0;
        }
        return Math.max(height(node.left) , height(node.right)) + 1;
    }
    // 如果一个树是平衡二叉树,那么他是否一定是完全二叉树呢?
    /*
    */
    final class TreeInfo {
        public final int height;
        public final boolean balanced;

        public TreeInfo(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return isBalancedTreeHelper(root).balanced;
    }
    private TreeInfo isBalancedTreeHelper(TreeNode node) {
        if (node == null) {
            return new TreeInfo(-1, true);
        }
        TreeInfo left = isBalancedTreeHelper(node.left);
        if (!left.balanced) {
            return new TreeInfo(-1, false);
        }
        TreeInfo right = isBalancedTreeHelper(node.right);
        if (!right.balanced) {
            return new TreeInfo(-1, false);
        }
        if (Math.abs(left.height - right.height) < 2) {
            return new TreeInfo(Math.max(left.height, right.height) + 1, true);
        } else {
            return new TreeInfo(-1, false);
        }
    }
}
// @lc code=end
