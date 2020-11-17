package questions.MaximumDepthOfBinaryTree;

import java.util.Deque;
import java.util.LinkedList;

import questions.common.Pair;
import questions.common.TreeNode;

/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 *
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (73.34%)
 * Likes:    556
 * Dislikes: 0
 * Total Accepted:    185K
 * Total Submissions: 252.3K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，找出其最大深度。
 * 
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回它的最大深度 3 。
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return height(root);
    }
    // 递归
    private int height(TreeNode node) {
        if (node == null)
            return 0;
        else
            return Math.max(height(node.left), height(node.right)) + 1;
    }
    // 遍历, BFS 广度优先
    private int height2(TreeNode node) {
        // 使用了这个pair结构, 作为遍历过程中的记录
        Deque<Pair<TreeNode, Integer>> deque = new LinkedList<>();
        if (node == null) return 0;
        int depth = 0;
        deque.add(new Pair<TreeNode,Integer>(node, 1));
        while (!deque.isEmpty()) {
            Pair<TreeNode,Integer> current = deque.poll();
            node = current.getKey();
            int currentDepth = current.getValue();
            if (node != null)  {
                depth = Math.max(depth, currentDepth);
                deque.add(new Pair<TreeNode, Integer>(node.left, currentDepth + 1));
                deque.add(new Pair<TreeNode, Integer>(node.right, currentDepth + 1));
            }
        }
        return depth;
    }
}
// @lc code=end
