package questions.RemoveDuplicatesFromSortedListII_0082;

import questions.common.ListNode;

/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (47.87%)
 * Likes:    309
 * Dislikes: 0
 * Total Accepted:    53.2K
 * Total Submissions: 110.2K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 
 * 示例 1:
 * 
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 
 * 
 * 示例 2:
 * 
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(0);
        ListNode hair = new ListNode(0);
        pre.next = head;
        hair = pre;
        ListNode node = head;
        ListNode next;
        while(node != null) {
            next = node.next;
            if (next == null || next.val != node.val) {
                // 不相等的情况,把之前相等的元素去掉, pre.next必定存在
                if (pre.next.next == next) {
                    pre = node;
                } else {
                    ListNode t = node;
                    node = node.next;
                    t.next = null;
                    pre.next = next;
                    continue;
                }
            }
            node = node.next;
        }
        return hair.next;
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        /* ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5; */
        new Solution().deleteDuplicates(n1);
    }
}
// @lc code=end
