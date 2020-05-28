package questions.RemoveNthNodeFromEndOfList_0019;

import questions.common.ListNode;

import java.util.ArrayList;
import java.util.List;

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
    public ListNode removeNthFromEnd2(ListNode head, int n) {
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
    // 双指针的妙用
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
    // 使用ArrayList
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int l = list.size();
        node = list.get(l - n - 1);
        if (node.next.next != null) {
            node.next = node.next.next;
        } else {
            node.next = null;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        CommonUtils<Integer> utils = new CommonUtils<Integer>();
        ListNode l = utils.Arrays2ListNode(new int[]{1,2,3,4,5});
        Integer[] a1 = utils.ListNode2Arrays(s.removeNthFromEnd(l, 2));
        utils.showArrays(a1);
    }
}
// @lc code=end
