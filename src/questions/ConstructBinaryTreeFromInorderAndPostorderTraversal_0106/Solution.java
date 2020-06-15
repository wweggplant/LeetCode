package questions.ConstructBinaryTreeFromInorderAndPostorderTraversal_0106;

import java.util.HashMap;
import java.util.Map;

import questions.common.TreeNode;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (68.66%)
 * Likes:    221
 * Dislikes: 0
 * Total Accepted:    38.7K
 * Total Submissions: 56.4K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder != null && postorder.length > 0) {
            this.createMap(inorder);
            int size = postorder.length;
            return buildTree(inorder, postorder, 0, size - 1, 0, size - 1);
        } else {
            return null;
        }
    }
    private TreeNode buildTree(int[] inorder, int[] postorder, int inorderLeft, int inorderRight, int postorderLeft,
            int postorderRight) {
        if (postorderLeft > postorderRight) {
            return null;
        }
        int rootVal = postorder[postorderRight];
        TreeNode root = new TreeNode(rootVal);
        int inorderRootIndex = map.get(rootVal);
        int sizeLeftSubtree = inorderRootIndex - inorderLeft;
        root.left = buildTree(inorder, postorder, inorderLeft, inorderRootIndex - 1, postorderLeft, postorderLeft + sizeLeftSubtree - 1);
        root.right = buildTree(inorder, postorder, inorderRootIndex + 1, inorderRight,  postorderLeft + sizeLeftSubtree, postorderRight - 1);
        return root;
    }
    private void createMap(int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
    }
    public static void main(String[] args) {
        int[] inorder= new int[] { 9, 3, 15, 20, 7 };
        int[] postorder = new int[] { 9, 15, 7, 20, 3 };
        new Solution().buildTree(inorder, postorder);
    }
}
// @lc code=end
