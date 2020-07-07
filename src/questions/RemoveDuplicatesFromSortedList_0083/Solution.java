package questions.RemoveDuplicatesFromSortedList_0083;

import questions.common.ListNode;

/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (48.22%)
 * Likes:    295
 * Dislikes: 0
 * Total Accepted:    94.6K
 * Total Submissions: 188.8K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 
 * 示例 1:
 * 
 * 输入: 1->1->2
 * 输出: 1->2
 * 
 * 
 * 示例 2:
 * 
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode next = head.next;
        while (next != null) {
            if (head.val == next.val) {
                head.next = next.next;
            } else {
                head = next;
            }
            next = next.next;
        }
        return pre.next;
    }
}
// @lc code=end
