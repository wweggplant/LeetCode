package questions.LowestCommonAncestorOfaBinarySearchTree_0235;

import questions.common.TreeNode;

/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 *
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 *
 * algorithms
 * Easy (63.99%)
 * Likes:    321
 * Dislikes: 0
 * Total Accepted:    62.3K
 * Total Submissions: 97.1K
 * Testcase Example:  '[6,2,8,0,4,7,9,null,null,3,5]\n2\n8'
 *
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x
 * 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * 
 * 
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6 
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 
 * 
 * 示例 2:
 * 
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    /* 
        注意题目中是二茬搜索树,留意其性质,到达最近祖先节点的条件是,p和q的值卡住当前节点的值,如果都小于当前节点值,则进入左节点,否则进入右节点
    
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        // return helper(root, p,q);
        return helper2(root, p, q);
    }
    // 递归法
    private TreeNode helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return null;
        if (p.val <= node.val && q.val >= node.val) {
            return node;
        }else if (p.val <= node.val && q.val <= node.val){
            return helper(node.left, p, q);
        }else {
            return helper(node.right, p, q);
        }
    }
    // 迭代法, 最后只要找到节点即可,不用模拟堆栈
    private TreeNode helper2(TreeNode node, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        while (node != null) {
            if (node.val > pVal && node.val > qVal) {
                node = node.left;
            } else if (node.val < pVal && node.val < qVal) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }
}
// @lc code=end
