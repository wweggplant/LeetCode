package questions.RemoveNthNodeFromEndOfList_0019;

import questions.common.ListNode;
import questions.common.CommonUtils;

/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
 *
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (36.38%)
 * Likes:    630
 * Dislikes: 0
 * Total Accepted:    103.1K
 * Total Submissions: 280.4K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 
 * 示例：
 * 
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 
 * 
 * 说明：
 * 
 * 给定的 n 保证是有效的。
 * 
 * 进阶：
 * 
 * 你能尝试使用一趟扫描实现吗？
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    // 扫描两次
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int l = 0, m = 0;
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode node = h;
        while(node != null) {
            node = node.next;
            l++;
        }
        m = l - n - 1;
        node = h;
        while(m > 0) {
            node = node.next;
            m--;
        }
        if (node.next.next != null) {
            node.next = node.next.next;
        } else {
            node.next = null;
        }
        return h.next;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        CommonUtils<Integer> utils = new CommonUtils<Integer>();
        ListNode l = utils.Arrays2ListNode(new int[]{1});
        Integer[] a1 = utils.ListNode2Arrays(s.removeNthFromEnd(l, 2));
        utils.showArrays(a1);
    }
}
// @lc code=end
