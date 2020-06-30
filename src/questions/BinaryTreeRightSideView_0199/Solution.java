package questions.BinaryTreeRightSideView_0199;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import questions.common.TreeNode;

/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 *
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (63.72%)
 * Likes:    267
 * Dislikes: 0
 * Total Accepted:    51.5K
 * Total Submissions: 80.6K
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 
 * 示例:
 * 
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * 
 * ⁠  1            <---
 * ⁠/   \
 * 2     3         <---
 * ⁠\     \
 * ⁠ 5     4       <---
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // BFS打印每层
        Deque<TreeNode> levels = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        levels.add(root);
        while(!levels.isEmpty()) {
            TreeNode rightMost = null;
            int i = levels.size() - 1;
            while (i >= 0) {
                TreeNode n = levels.poll();
                if (n.right != null)
                    levels.add(n.right);
                if (n.left != null)
                    levels.add(n.left);
                if(rightMost == null) rightMost = n;
                i--;
            }
            list.add(rightMost.val);
        }
        return list;
    }
}
// @lc code=end
