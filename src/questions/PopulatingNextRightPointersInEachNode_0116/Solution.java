package questions.PopulatingNextRightPointersInEachNode_0116;

import java.util.Deque;
import java.util.LinkedList;

import questions.common.Node;
/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
 *
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/description/
 *
 * algorithms
 * Medium (59.79%)
 * Likes:    186
 * Dislikes: 0
 * Total Accepted:    36.8K
 * Total Submissions: 61K
 * Testcase Example:  '[1,2,3,4,5,6,7]'
 *
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * 
 * struct Node {
 * ⁠ int val;
 * ⁠ Node *left;
 * ⁠ Node *right;
 * ⁠ Node *next;
 * }
 * 
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 
 * 
 * 输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 * 
 * 
 * 输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
 * 
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * 
 * 
 */

// @lc code=start

// Definition for a Node.


class Solution {
    // 使用队列模拟,层次遍历
    public Node connect2(Node root) {
        if (root == null) return root;
        Deque<Node> levelList = new LinkedList<>(); // 保存一层的
        levelList.add(root);
        while(levelList.size() > 0) {
            int size = levelList.size();
            for(int i = 0;i < size;i++) {
                Node current = levelList.remove();
                if (i < size - 1) {
                    current.next = levelList.peek();
                }
                if (current.left != null) {
                    levelList.add(current.left);
                }
                if (current.right != null) {
                    levelList.add(current.right);
                }
            }
        }
        return root;
    }
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node leftmost = root;
        while (leftmost.left != null) {
            Node head = leftmost;
            while (head != null) {
                // 一个节点内
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                // 相邻节点,next连接
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
    // 使用层次遍历
    private Node dfs(Node node) {
        if (node.left == null) {
            // 完美二叉树,只需要检测left即可
            return node;
        }
        Node left = dfs(node.left);
        Node right = dfs(node.right);
        // 跨节点链接
        if (right != null && left != null) {
            Node n = left;
            while (n.next != null) {
                n = n.next;
            }
            n.next = right;
        }
        node.left.next = node.right;
        return node.left;
    }
    // public static void main(String[] args) {
    //     Node n1 = new Node(1);
    //     Node n2 = new Node(2);
    //     Node n3 = new Node(3);
    //     Node n4 = new Node(4);
    //     Node n5 = new Node(5);
    //     Node n6 = new Node(6);
    //     Node n7 = new Node(7);
    //     Node n8 = new Node(8);
    //     Node n9 = new Node(9);
    //     Node n10 = new Node(10);
    //     Node n11 = new Node(11);
    //     Node n12 = new Node(12);
    //     Node n13 = new Node(13);
    //     Node n14 = new Node(14);
    //     Node n15 = new Node(15);
    //     n1.left = n2;
    //     n1.right = n3;
    //     n2.left = n4;
    //     n2.right=n5;
    //     n3.left = n6;
    //     n3.right = n7;
    //     n4.left = n8;
    //     n4.right = n9;
    //     n5.left = n10;
    //     n5.right = n11;
    //     n6.left = n12;
    //     n6.right = n13;
    //     n7.left = n14;
    //     n7.right = n15;
    //     new Solution().connect(n1);
    // }
}
// @lc code=end
