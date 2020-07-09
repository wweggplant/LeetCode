package questions.LowestCommonAncestorOfAbinaryTree_0236;

import java.util.Stack;

import questions.common.TreeNode;

/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 *
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (63.88%)
 * Likes:    629
 * Dislikes: 0
 * Total Accepted:    94.3K
 * Total Submissions: 146.8K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n1'
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x
 * 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 
 * 
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p.val, q.val);
        return result;
    }
    // 递归,从顶向下,这种办法会产生重复计算, 可以用Map来存储计算结果
    // 一开始这个方法有问题,只能处理q和p分别在左子树和右子树的情况,对于q和p本身就是祖先关系的情况解决不了
    private boolean helper(TreeNode node, int pVal, int qVal) {
        if (node == null) return false;
        boolean left = helper(node.left, pVal, qVal);
        boolean right = helper(node.right, pVal, qVal);
        if ((left && right) || ((node.val == pVal || node.val == qVal) && (left || right))) {
            // 左右同时找到, 或者在一边都找到
            result = node;
        }
        return  (left || right) || (node.val == pVal || node.val == qVal);
    }
}
// @lc code=end