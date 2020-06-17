package questions.MinimumDepthOfBinaryTree_0111;

import java.util.ArrayDeque;
import java.util.Deque;

import questions.common.TreeNode;

/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (42.55%)
 * Likes:    271
 * Dislikes: 0
 * Total Accepted:    82.3K
 * Total Submissions: 193.2K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，找出其最小深度。
 * 
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回它的最小深度  2.
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    /* 
        经过上一道题目的教训, 要先读懂题目在思考
        这个说的是找到第一个叶子节点所在的层次, 用层次遍历效率比较好的一种办法
    */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        return bfs(1, deque);
    }
    private int bfs(int depth, Deque<TreeNode> deque) {
        int currentLevelSize = deque.size();
        while (!deque.isEmpty() && currentLevelSize > 0) {
            TreeNode node = deque.poll();
            if (node.left == null && node.right == null) { // 检测到子节点
                return depth;
            }
            if (node.left != null) {
                deque.add(node.left);
            }
            if (node.right != null) {
                deque.add(node.right);
            }
            currentLevelSize--;
        }
        return bfs(depth + 1, deque);
    }
}
// @lc code=end
