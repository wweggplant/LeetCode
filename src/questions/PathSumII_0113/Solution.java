package questions.PathSumII_0113;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import questions.common.TreeNode;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 *
 * https://leetcode-cn.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (59.73%)
 * Likes:    244
 * Dislikes: 0
 * Total Accepted:    52.9K
 * Total Submissions: 88.4K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   8
 * ⁠          /   / \
 * ⁠         11  13  4
 * ⁠        /  \    / \
 * ⁠       7    2  5   1
 * 
 * 
 * 返回:
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return  res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(root, sum, path, res);
        return res;
    }

    private void dfs(TreeNode node, int sum, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终止
        if (node == null) return;
        // 递归子内容
        // 1. 沿途节点添加进入路径, 注意不能使用push, 会把当前节点放在前面的位置
        sum -= node.val;
        path.addLast(node.val);
        // 判断是否找到合适的路径
        if (sum == 0 && node.left == null && node.right == null) {
            // 由于java是使用值传递, 使用当前path的一份拷贝
            res.add(new ArrayList<>(path));
            // 路径退回到上一个节点
            path.removeLast();
            // 递归终止
            return;
        }
        // 启动递归, 这里注意路径回溯到上一个节点
        dfs(node.left, sum, path, res);
        dfs(node.right, sum, path, res);

        // 当前节点处理完成, 退回到上一个节点
        path.removeLast();
    }
}
// @lc code=end
