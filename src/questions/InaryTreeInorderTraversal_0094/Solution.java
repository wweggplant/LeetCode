package questions.InaryTreeInorderTraversal_0094;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import questions.common.*;
/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (68.85%)
 * Likes:    504
 * Dislikes: 0
 * Total Accepted:    161.7K
 * Total Submissions: 226.2K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的中序 遍历。
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
 * 输出: [1,3,2]
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
    /* List<Integer> list = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return list;
    }
    public void traverse(TreeNode node) {
        if (node != null) {
            traverse(node.left);
            this.list.add(node.val);
            traverse(node.right);
        }
    } */
    // 基于栈的遍历
    /* public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null || !deque.isEmpty()) {
            while (curr != null) {
                deque.push(curr);
                curr = curr.left;
            }
            curr = deque.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    } */
    // 不破坏原有结构
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode prev = null;
        while(curr != null) {
            /*
                if curr == prev 说明之前遇到了节点1的情况,
                    curr指向右子树
                else if curr 的左子树为不空
                    prev指向curr节点, curr指向左子树
                else 为空情况
                    输出 curr
                    if curr的右子树不为空
                        curr指向右子树
                    else 为空情况
                        curr指向prev节点 节点1
            */
            if (curr == prev) {
            }
        }
        return res;
    }
}
// @lc code=end
