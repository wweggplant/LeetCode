package questions.SumRootToLeafNumbers_0129;

import java.util.ArrayList;
import java.util.List;

import questions.common.TreeNode;

/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根到叶子节点数字之和
 *
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/description/
 *
 * algorithms
 * Medium (63.68%)
 * Likes:    151
 * Dislikes: 0
 * Total Accepted:    30.4K
 * Total Submissions: 47.5K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 
 * 计算从根到叶子节点生成的所有数字之和。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 
 * 示例 2:
 * 
 * 输入: [4,9,0,5,1]
 * ⁠   4
 * ⁠  / \
 * ⁠ 9   0
 * / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private int res = 0;
    public int sumNumbers(TreeNode root) {
        // if (root == null) return 0;
        // List<Integer> path = new ArrayList<>();
        // dfs(root, path);
        return helper(root, 0);
    }
    private void dfs(TreeNode node, List<Integer> path) {
        /*
        1. node.val添加到path队列头部
        2. 是叶子节点
            1. 遍历path,组成一个整数,添加到res中
            2. path删除最后一个元素
        3. 不是叶子节点
            dfs(node.left ? right, path, res)
            path删除最后一个元素(退回到上一个节点)
        */
        path.add(node.val);
        if (node.left == null && node.right == null) {
            // 叶子节点
            int size = path.size();
            String s = "";
            for (int i = 0; i < size; i++) {
                s += path.get(i) + "";
            }
            res += Integer.parseInt(s);
            path.remove(size - 1);
        } else {
            if (node.left != null) {
                dfs(node.left, path);
            }
            if (node.right != null) {
                dfs(node.right, path);
            }
            path.remove(path.size() - 1);
        }
    }
    /* 
    1. 每次递归都是上一次的结果乘以10加上当前节点值,并把计算结果带入下一次递归, 这样的话到达叶子节点就得到了当前路径的值
    2. 返回当前path的计算结果
    3. 最后的结果是左边的加上右边的
    */
    public int helper(TreeNode root, int i) {
        if (root == null)
            return 0;
        int temp = i * 10 + root.val;
        if (root.left == null && root.right == null)
            return temp;
        return helper(root.left, temp) + helper(root.right, temp);
    }
    public static void main(String[] args) {
        // [4,9,0,5,1]
        TreeNode t4 = new TreeNode(4);
        TreeNode t9 = new TreeNode(9);
        TreeNode t0 = new TreeNode(0);
        TreeNode t5 = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);
        t4.left = t9;
        t4.right = t0;
        t9.left = t5;
        t9.right = t1;
        new Solution().sumNumbers(t4);
    }
}
// @lc code=end
