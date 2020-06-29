package questions.BinarySearchTreeIterator_0173;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

import questions.common.TreeNode;

/*
 * @lc app=leetcode.cn id=173 lang=java
 *
 * [173] 二叉搜索树迭代器
 *
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/description/
 *
 * algorithms
 * Medium (73.28%)
 * Likes:    200
 * Dislikes: 0
 * Total Accepted:    22.4K
 * Total Submissions: 30.4K
 * Testcase Example:  '["BSTIterator","next","next","hasNext","next","hasNext","next","hasNext","next","hasNext"]\n' +
  '[[[7,3,15,null,null,9,20]],[null],[null],[null],[null],[null],[null],[null],[null],[null]]'
 *
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * 
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
/* class BSTIterator {
    private Deque<TreeNode> list;
    public BSTIterator(TreeNode root) {
        list = new ArrayDeque<>();
        dfs(root);
    }
    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        list.add(node);
        dfs(node.right);
    }
    public int next() {
        return list.poll().val;
    }

    public boolean hasNext() {
        return list.peekFirst() != null;
    }
} */
// 方法2 使用自定义栈,模仿系统的栈,自定义的栈是可以暂停的,这就达到迭代器的效果
// 这个栈始终存放的就是中序遍历的路径: 先把嘴左边的路径节点push进去,然后一个节点一个节点回溯,当遇到当前节点有右节点的情况,再套入辅助函数把右子树push到栈里.
class BSTIterator {
    Deque<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        _leftmostInorder(root);
    }

    private void _leftmostInorder(TreeNode node) {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode n = stack.pop();
        if (n.right != null) {
            _leftmostInorder(n.right);
        }
        return n.val;
    }

    public boolean hasNext() {
        return stack.peek() != null;
    }
}
/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */
// @lc code=end
