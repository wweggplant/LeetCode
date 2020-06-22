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
    public void flatten1(TreeNode root) {
        if (root == null) return;
        List<TreeNode> list = new ArrayList<>();
        helper1(root, list);
        root.left = null;
        root.right = null;
        TreeNode node = root;
        for (TreeNode n : list.subList(1, list.size())) {
            node.right = n;
            node = node.right;
        }
    }
    // 1. 笨办法, 把树变成链表再,转换成树, 题目的意思应该是原地对树进行修改
    private void helper1(TreeNode node, List<TreeNode> list) {
        if (node == null) return;
        list.add(node);
        helper1(node.left, list);
        helper1(node.right, list);
        node.left = null;
        node.right = null;
    }
    public void flatten2(TreeNode root) {
        if (root == null)
            return;
        helper2(root);
    }
    // 2. 每次都返回子树处理后的头和尾组成的数组
    private TreeNode[] helper2(TreeNode node) {
        if (node == null) {
            return new TreeNode[] {};
        }
        if (node.left == null && node.right == null) {
            // 叶子节点, 头尾相同
            return new TreeNode[] { node, node };
        }
        TreeNode temp = node.right;
        TreeNode[] leftArr = helper2(node.left);
        if (leftArr.length != 0) {
            // 处理左子树
            node.left = null;
            node.right = leftArr[0];
            TreeNode[] rightArr = helper2(temp);
            if (rightArr.length != 0) {
                leftArr[1].right = rightArr[0];
                return new TreeNode[] { node, rightArr[1] };
            }
            // 右子树为空, 直接返回左子树
            return new TreeNode[] { node, leftArr[1] };
        } else {
            // 没有左子树,返回右子树的结果
            TreeNode[] rightArr = helper2(node.right);
            node.right = rightArr[0];
            return new TreeNode[] { node, rightArr[1] };
        }
    }
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        helper3(root);
    }
    // 3. 根据题解, 每次都把左子树换成右子树, 然后找到新右子树最右下的节点,把老的右子树连接上去,然后找到下一个right节点,带入递归式,继续这个操作下去
    // 递归的终止条件是,left 和 right节点为null
    private void helper3(TreeNode node) {
        TreeNode left = node.left;
        TreeNode right = node.right;
        if (node.left != null) {
            node.right = left; // 左子树 => 右子树
            node.left = null;
            TreeNode rightNode = findRightTreeNode(node); // 找到右下角的节点
            rightNode.right = right; // 旧的右子树接上去
        } else if (right == null) {
            // 到叶子节点了
            return;
        }
        helper3(node.right);
    }
    private TreeNode findRightTreeNode(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public static void main(String[] args) {
        /* TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t1.right= t5;
        t2.left = t3;
        t2.right = t4;
        t5.right = t6; */
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t2.left = t3;
        new Solution().flatten(t1);
    }
}
// @lc code=end
