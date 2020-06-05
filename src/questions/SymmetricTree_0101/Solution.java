package questions.SymmetricTree_0101;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

import questions.common.TreeNode;
/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 *
 * https://leetcode-cn.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (51.08%)
 * Likes:    825
 * Dislikes: 0
 * Total Accepted:    156.2K
 * Total Submissions: 299.7K
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 
 * 
 * 
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠/ \ / \
 * 3  4 4  3
 * 
 * 
 * 
 * 
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠  \   \
 * ⁠  3    3
 * 
 * 
 * 
 * 
 * 进阶：
 * 
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
     public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }
    // 递归法(官方题解): 如果两个树是左右对称的，那么必然满足两个条件两个数的根节点值相同；每个树的右子树和另一个树的左子树镜像对称
    public boolean check2(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left , q.right) && check(p.right, q.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }
    // 遍历法 
    public boolean check(TreeNode p, TreeNode q) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(p);
        deque.offer(q);
        while(!deque.isEmpty()) {
            p = deque.poll();
            q = deque.poll();
            if (p == null && q == null) {
                continue;
            }
            if ((p ==null || q == null) || (p.val != q.val)) {
                return false;
            }
            deque.offer(p.left);
            deque.offer(q.right);

            deque.offer(p.right);
            deque.offer(q.left);
        }
        return true;
    }

    // 遍历法 有问题
    public boolean isSymmetric3(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> pStack = new ArrayDeque<>();
        Deque<TreeNode> qStack = new ArrayDeque<>();
        TreeNode pCurr = root.left;
        TreeNode qCurr = root.right;
        boolean needToPop = false;
        do{
            if (pCurr == null && qCurr == null) {
                pCurr = pStack.remove().right;
                qCurr = qStack.remove().left;
                continue;
            }
            if (pCurr == null || qCurr == null) {
                return false;
            }
            if(pCurr.val != qCurr.val) {
                return false;
            }
            pStack.add(pCurr);
            qStack.add(qCurr);
            if(needToPop) {
                pCurr = pStack.remove().right;
                qCurr = qStack.remove().left;
                needToPop = false;
            } else {
                pCurr = pCurr.left;
                qCurr = qCurr.right;
                needToPop = true;
            }
        }while (!pStack.isEmpty() && !qStack.isEmpty());
        return true;
    }
}
// @lc code=end
