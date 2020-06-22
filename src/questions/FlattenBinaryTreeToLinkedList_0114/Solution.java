package questions.FlattenBinaryTreeToLinkedList_0114;

import java.util.ArrayList;
import java.util.List;

import questions.common.TreeNode;

/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 *
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/description/
 *
 * algorithms
 * Medium (69.12%)
 * Likes:    383
 * Dislikes: 0
 * Total Accepted:    46.2K
 * Total Submissions: 66.7K
 * Testcase Example:  '[1,2,5,3,4,null,6]'
 *
 * 给定一个二叉树，原地将它展开为一个单链表。
 * 
 * 
 * 
 * 例如，给定二叉树
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   5
 * ⁠/ \   \
 * 3   4   6
 * 
 * 将其展开为：
 * 
 * 1
 * ⁠\
 * ⁠ 2
 * ⁠  \
 * ⁠   3
 * ⁠    \
 * ⁠     4
 * ⁠      \
 * ⁠       5
 * ⁠        \
 * ⁠         6
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        List<TreeNode> list = new ArrayList<>();
        helper(root, list);
        root.left = null;
        root.right = null;
        TreeNode node = root;
        for (TreeNode n : list.subList(1, list.size())) {
            node.right = n;
            node = node.right;
        }
    }
    // 笨办法, 把树变成链表再,转换成树, 题目的意思应该是原地对树进行修改
    private void helper(TreeNode node, List<TreeNode> list) {
        if (node == null) return;
        list.add(node);
        helper(node.left, list);
        helper(node.right, list);
        node.left = null;
        node.right = null;
    }
}
// @lc code=end
