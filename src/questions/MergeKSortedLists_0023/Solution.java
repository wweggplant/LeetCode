package questions.MergeKSortedLists_0023;

import questions.common.ListNode;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (47.86%)
 * Likes:    638
 * Dislikes: 0
 * Total Accepted:    114.6K
 * Total Submissions: 223.2K
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length ==0 ) return null;
        ListNode res = new ListNode(0);
        ListNode node = res;
        ListNode min = findMinNode(lists);
        while (min != null) {
            node.next = min;
            node = node.next;
            min = findMinNode(lists);
        }
        return res.next;
    }
    private ListNode findMinNode(ListNode[] lists) {
        ListNode min = lists[0];
        int index = 0;
        for (int i = 0; i < lists.length; i++) {
            // 转到下一个链表的节点
            if (min == null && i < lists.length - 1) {
                min = lists[i + 1];
                index = i + 1;
                continue;
            }
            // 最后min需要判断一下null, min == null,循环结束
            if (min == null) return null;
            // 正常处理
            if (lists[i] != null && lists[i].val < min.val) {
                min = lists[i];
                index = i;
            }
        }
        // 最小的链表移动一位
        lists[index] = min.next;
        return min;
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n4;
        n4.next = n5;

        ListNode n11 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        ListNode n44 = new ListNode(4);
        n11.next = n3;
        n3.next = n44;

        ListNode n2 = new ListNode(2);
        ListNode n6 = new ListNode(6);
        n2.next = n6;

        ListNode[] lists = new ListNode[]{};
        new Solution().mergeKLists(lists);
    }
}
// @lc code=end
