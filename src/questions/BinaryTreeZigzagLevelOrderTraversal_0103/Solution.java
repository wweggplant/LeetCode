package questions.BinaryTreeZigzagLevelOrderTraversal_0103;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import questions.common.TreeNode;
/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (54.43%)
 * Likes:    191
 * Dislikes: 0
 * Total Accepted:    50.7K
 * Total Submissions: 93K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回锯齿形层次遍历如下：
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode node) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> list = new LinkedList<>();
        boolean fromHead = true;
        deque.offer(node);
        while(!deque.isEmpty()){
            List<Integer> l = new LinkedList<>();
            int currentSize = deque.size();
            int i = 0;
            while(!deque.isEmpty() && currentSize > i) {
                TreeNode n = deque.poll();
                if(n == null) continue;
                l.add(n.val);
                if (fromHead) {
                    deque.push(n.left);
                    deque.push(n.right);
                } else {
                    deque.offer(n.right);
                    deque.offer(n.left);
                }
                i++;
            }
            fromHead = !fromHead;
            if (l.size() > 0)
                list.add(l);
        }
        return list;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t2.right = t4;
        new Solution().zigzagLevelOrder(root);
    }
}
// @lc code=end