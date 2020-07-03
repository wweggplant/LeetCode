package questions.ReverseNodesInkGroup_0025;

import questions.common.ListNode;

/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 *
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (54.91%)
 * Likes:    456
 * Dislikes: 0
 * Total Accepted:    52.4K
 * Total Submissions: 90.1K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 
 * 
 * 
 * 示例：
 * 
 * 给你这个链表：1->2->3->4->5
 * 
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 
 * 
 * 
 * 说明：
 * 
 * 
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        ListNode tail = head;
        ListNode pre = hair;
        int i = 1;
        // 分割
        while(tail != null) {
            if (i == k) {
                i = 1;
                ListNode nextTemp = tail.next;
                ListNode newHead = helper(head, tail);
                pre.next = newHead;
                pre = head;
                head = nextTemp;
                tail = nextTemp;
            }
            if (tail != null) {
                tail = tail.next;
                i++;
            }
        }
        pre.next = head;
        return hair.next;
    }
    // 翻转链表
    private ListNode helper(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode end = tail.next;
        while (curr != null && curr != end) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        // new Solution().helper(l1, l2);
        new Solution().reverseKGroup(l1, 2);
    }
}
// @lc code=end