package questions.BinaryTreePreorderTraversal_0144;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import questions.common.TreeNode;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (65.76%)
 * Likes:    285
 * Dislikes: 0
 * Total Accepted:    121.5K
 * Total Submissions: 184.5K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]  
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3 
 * 
 * 输出: [1,2,3]
 * 
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // List<Integer> list = new ArrayList<>();
        // helper(root, list);
        // return list;
        return helper2(root);
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        helper(node.left, list);
        helper(node.right, list);
    }
    // 迭代
    public List<Integer> helper2(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (node != null)
            deque.add(node);
        while (!deque.isEmpty()) {
            TreeNode current = deque.pollLast();
            list.add(current.val);
            if (current.right != null)
                deque.add(current.right);
            if (current.left != null)
                deque.offer(current.left);
        }
        return list;
    }
}
// @lc code=end
