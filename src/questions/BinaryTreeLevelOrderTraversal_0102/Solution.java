package questions.BinaryTreeLevelOrderTraversal_0102;

import java.util.ArrayList;
import java.util.List;

import questions.common.*;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (59.63%)
 * Likes:    343
 * Dislikes: 0
 * Total Accepted:    67.3K
 * Total Submissions: 112K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其层次遍历结果：
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
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
    // 错误!!! 题目要求是按照层次, 这个是按照递归顺序
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        List<Integer> list = new ArrayList<Integer>();
        res.add(list);
        searchTree2(res, list, root);
        return res;
    }
    public void searchTree2(List<List<Integer>> res, List<Integer> list,TreeNode node){
        if (node != null) {
            list.add(node.val);
        }
        List<Integer> l = null;
        if (node.left != null) {
            l = new ArrayList<Integer>();
            res.add(l);
            searchTree2(res, l, node.left);
        }
        if (node.right != null) {
            if (l == null){
                l = new ArrayList<Integer>();
                res.add(l);
            }
            searchTree2(res, l, node.right);
        }
    }
    /*
    * ⁠    1
    * ⁠  /   \
    * ⁠ 2     3
    * ⁠/ \   / \
    *4   5 6   7
    * 1. 把二叉树转换成一维数组,且第0个为空,比如arr = [null,1,2,3,4,5,6,7]
    * 2. 观察可得规律 第n层在数组中的开始索引是 arr[2^(n-1)] 结束为arr[2^n - 1]

    问题是转换成一维数组还是会遇到之前遇到的问题!!!
    */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        searchTree2(root, list);
        int[] arr = new int[list.size() + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = list.get(i - 1);
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int level = (int)Math.ceil(Math.log(arr.length - 1) / Math.log(2));
        int l = arr.length - 1;
        for (int i = 1; i < level; i++) {
            List<Integer> li = new ArrayList<Integer>();
            int start = 2^(i - 1);
            int end = 2^i;
            end = end > l ? l: end;
            for (int j = start; j < end; j++) {
                list.add(arr[j]);
            }
            res.add(li);
        }
        return res;
    }
    /*
        每层的list 是左树+右树
    */
    public void searchTree2(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
        } else {
            list.add(null);
            return;
        }
        searchTree2(node.left, list);
        searchTree2(node.right, list);
    }
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    // 广度优先算法
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return levels;
        }
        searchTree(root, 0);
        return levels;
    }
    public void searchTree(TreeNode node, int level){
        if (levels.size() == level) {
            levels.add(new ArrayList<Integer>());
        }
        levels.get(level).add(node.val);
        if (node.left != null) {
            searchTree(node.left, level + 1);
        }
        if (node.right != null) {
            searchTree(node.right, level + 1);
        }
    }
    public static void main(String[] args) {
        /* [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7); */
        // [null, 1,2,3,4,null,null,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Solution s = new Solution();
        CommonUtils<Integer> utils = new CommonUtils<Integer>();
        List<List<Integer>> list = s.levelOrder(root);
        for (List<Integer> l : list) {
            utils.showArrays(l);
        }
    }
}
// @lc code=end
