package questions.PartitionList_0086;

import questions.common.ListNode;

/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 *
 * https://leetcode-cn.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (57.97%)
 * Likes:    222
 * Dislikes: 0
 * Total Accepted:    42.4K
 * Total Submissions: 72.5K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 
 * 示例:
 * 
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 *
 * https://leetcode-cn.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (57.97%)
 * Likes:    222
 * Dislikes: 0
 * Total Accepted:    42.4K
 * Total Submissions: 72.5K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 
 * 示例:
 * 
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {
        ListNode temp = new ListNode(x);
        ListNode node = head;
        ListNode pre  = new ListNode(0);
        ListNode hair = pre;
        ListNode append = temp;
        while (node != null) {
            ListNode next = node.next;
            node.next = null;
            if (node.val >= x){
                append.next = node;
                append = append.next;
            }
            if (node.val < x) {
                pre.next = node;
                pre = pre.next;
            }
            node = next;
        }
        append.next = null;
        pre.next = temp.next;
        return hair.next;
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n2.next  = n1;
        new Solution().partition(n2, 2);
    }
}
// @lc code=end
