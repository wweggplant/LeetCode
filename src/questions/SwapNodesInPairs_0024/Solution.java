package questions.SwapNodesInPairs_0024;

import questions.common.*;
/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (62.85%)
 * Likes:    365
 * Dislikes: 0
 * Total Accepted:    59.4K
 * Total Submissions: 93.7K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 *
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    /* 双指针法+哑节点
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        ListNode second = first.next;
        ListNode n = dummy;
        while (first != null && first.next != null) {
            first.next = second.next;
            n.next = second;
            second.next = first;
            first = first.next;
            if (first != null) // 这个时候的first其实是交换后的second
                second = first.next;
            n = n.next.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        CommonUtils<Integer> utils = new CommonUtils<Integer>();
        int[] a = new int[]{1,2,3,5};
        ListNode a1 = utils.Arrays2ListNode(a);
        ListNode a1r = s.swapPairs(a1);
        Integer[] a1s = utils.ListNode2Arrays(a1r);
        utils.showArrays(a1s);
    }
}
// @lc code=end
