package questions.MergeTwoSortedLists__0021;

import questions.common.*;

/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (58.26%)
 * Likes:    802
 * Dislikes: 0
 * Total Accepted:    163.5K
 * Total Submissions: 276.9K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 *
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    // 迭代法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        ListNode ln1 = l1;
        ListNode ln2 = l2;
        while(ln1 != null && ln2 != null){
            if(ln1.val > ln2.val) {
                head.next = ln2;
                ln2 = ln2.next;
                head = head.next;
            } else {
                head.next = ln1;
                ln1 = ln1.next;
                head = head.next;
            }
        }
        if (ln1 != null) {
            head.next = ln1;
        }
        if (ln2 != null) {
            head.next = ln2;
        }
        return dummy.next;
    }
    // 递归法
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        else if(l2 == null) return l1;
        else if (l1.val > l2.val){
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        CommonUtils<Integer> utils = new CommonUtils<Integer>();
        ListNode l1 = utils.Arrays2ListNode(new int[]{1,2,4});
        ListNode l2 = utils.Arrays2ListNode(new int[]{1,3,4,5,6,7,8,9});
        ListNode l1l2 = s.mergeTwoLists(l1, l2);
    }
}
// @lc code=end
