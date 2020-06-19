package questions.pathSum;

import java.util.ArrayDeque;
import java.util.Deque;

import javafx.util.Pair;
import questions.common.TreeNode;

/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
 *
 * https://leetcode-cn.com/problems/path-sum/description/
 *
 * algorithms
 * Easy (49.77%)
 * Likes:    318
 * Dislikes: 0
 * Total Accepted:    83.3K
 * Total Submissions: 167.2K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,null,1]\n22'
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   8
 * ⁠          /   / \
 * ⁠         11  13  4
 * ⁠        /  \      \
 * ⁠       7    2      1
 * 
 * 
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    
    public boolean hasPathSum(TreeNode root, int sum) {
        // return dfs(root, 0, sum);
        if (root == null) return false;
        Deque<Pair<TreeNode, Integer>> deque = new ArrayDeque<>();
        deque.offer(new Pair(root, sum - root.val));
        return it(deque);
    }
    private boolean dfs(TreeNode node, int prevSum, int sum) {
        if (node == null) return false;
        // !!! 注意题目是必须从根节点到叶子节点
        if(node.left == null && node.right == null) {
            // 到了叶子节点
            return node.val + prevSum == sum;
        } else {
            int current = node.val + prevSum;
            return dfs(node.left, current, sum) || dfs(node.right, current, sum);
        }
    }
    // 迭代法,使用dfs
    private boolean it(Deque<Pair<TreeNode, Integer>> deque) {
        while (!deque.isEmpty()) {
            Pair<TreeNode, Integer> current = deque.pop();
            TreeNode currNode = current.getKey();
            int currVal = current.getValue();
            if (currVal == 0 && currNode.left == null && currNode.right == null) {
                return true;
            } else {
                if (currNode.left != null) {
                    deque.offer(new Pair(currNode.left, currVal - currNode.left.val));
                }
                if (currNode.right != null) {
                    deque.offer(new Pair(currNode.right, currVal - currNode.right.val));
                }
            }
        }
        return false;
    }

}
// @lc code=end