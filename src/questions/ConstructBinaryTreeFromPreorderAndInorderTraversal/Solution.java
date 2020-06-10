package questions.ConstructBinaryTreeFromPreorderAndInorderTraversal;

import questions.common.TreeNode;
/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (67.13%)
 * Likes:    524
 * Dislikes: 0
 * Total Accepted:    85.2K
 * Total Submissions: 127K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder != null && preorder.length > 0) {
            int size = preorder.length;
            return buildTree(preorder, inorder,0 , size - 1, 0 , size - 1);
        } else {
            return null;
        }
    }
    // 递归方法, 注意不要把preorder和inorder的索引混淆着用
    private TreeNode buildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if(preorderLeft > preorderRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        // 这里的查询索引可以使用HashMap加速查询
        int inorderRootIndex = getArrayIndex(inorder, root.val);
        int sizeLeftSubtree = inorderRootIndex - inorderLeft;
        root.left = buildTree(preorder, inorder, preorderLeft + 1, preorderLeft + sizeLeftSubtree, inorderLeft, inorderRootIndex - 1);
        root.right = buildTree(preorder, inorder, preorderLeft + sizeLeftSubtree + 1, preorderRight, inorderRootIndex + 1, inorderRight);
        return root;
    }
    private int getArrayIndex(int[] arr, int query) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == query) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        // int[] preorder = new int[]{3,9,20,15,7};
        // int[] inorder = new int[]{ 9, 3, 15, 20, 7};
        int[] preorder = new int[]{ 1, 2, 4, 5, 3};
        int[] inorder = new int[]{ 4,2,5,1,3};
        new Solution().buildTree(preorder, inorder);
    }
}
// @lc code=end
