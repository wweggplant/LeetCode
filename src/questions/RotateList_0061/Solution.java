package questions.RotateList_0061;

import questions.common.ListNode;
/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 *
 * https://leetcode-cn.com/problems/rotate-list/description/
 *
 * algorithms
 * Medium (39.42%)
 * Likes:    244
 * Dislikes: 0
 * Total Accepted:    57.2K
 * Total Submissions: 142.3K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 *
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode rotateRight(ListNode l, int k) {
        if (l == null) return l;
        ListNode tail = l;
        ListNode head = l;
        int length = 1;
        while(tail.next != null) {
            length++;
            tail = tail.next;
        }
        tail.next = head; // 收尾相连
        int n = length - k % length; // k大于length,说明转了一圈,使用
        while (n > 0) {
            n--;
            head = head.next;
            tail = tail.next;
        }
        tail.next = null;
        return head;
    }
}
// @lc code=end
