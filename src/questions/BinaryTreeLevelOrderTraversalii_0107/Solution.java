package questions.BinaryTreeLevelOrderTraversalii_0107;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import questions.common.TreeNode;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (65.62%)
 * Likes:    242
 * Dislikes: 0
 * Total Accepted:    62.1K
 * Total Submissions: 94.6K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其自底向上的层次遍历为：
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    // 使用DFS
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Map<Integer, List<Integer>> depthMap = new HashMap<>(); // 记录每层的节点的Map
        List<List<Integer>> list = new ArrayList<>();
        int depth = 0;
        if (root == null) return list;
        dfs(root, depth, depthMap);
        for (int i = depthMap.size() - 1; i >= 0; i--) {
            list.add(depthMap.get(i));
        }
        return list;
    }
    private void dfs(TreeNode node,int depth, Map<Integer, List<Integer>> depthMap) {
        List<Integer> list;
        if (depthMap.containsKey(depth)) {
            list = depthMap.get(depth);
        } else {
            list = new ArrayList<>();
            depthMap.put(depth, list);
        }
        list.add(node.val);
        TreeNode left = node.left;
        TreeNode right = node.right;
        if (left != null || right != null) {
            int newDepth = depth + 1;
            if (left != null) {
                dfs(left, newDepth, depthMap);
            }
            if (right != null) {
                dfs(right, newDepth, depthMap);
            }
        }
    }
}
// @lc code=end
