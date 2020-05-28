package questions.SortList_0148;

import questions.common.CommonUtils;
import questions.common.ListNode;
/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 *
 * https://leetcode-cn.com/problems/sort-list/description/
 *
 * algorithms
 * Medium (62.53%)
 * Likes:    335
 * Dislikes: 0
 * Total Accepted:    31.2K
 * Total Submissions: 49.8K
 * Testcase Example:  '[4,2,1,3]'
 *
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 
 * 示例 1:
 * 
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 
 * 
 * 示例 2:
 * 
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
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
    // 参考解法1 自顶向下
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null ) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        return merge(left, right);
    }
    public ListNode merge(ListNode left, ListNode right) {
        ListNode res = new ListNode(0);
        ListNode n = res;
        while(left != null && right != null ){
            if (less(right, left)) {
                n.next = right;
                right = right.next;
            } else {
                n.next = left;
                left = left.next;
            }
            n = n.next;
        }
        n.next = left != null ? left : right;
        return res.next;
    }
    public ListNode cut(ListNode start, int size) {
        ListNode n = start;
        while(--size > 0 && n != null) {
            n = n.next;
        }
        if (n == null) return null;
        ListNode next = n.next;
        n.next = null;
        return next;
    }
    public boolean less(ListNode a, ListNode b) {
        return (int)a.val < (int)b.val;
    }
    
    /**
     * 参考解法2 自底向上
     * -1->5->3->4->0 curr:当前操作的节点
     * 1. size = 1,2,4,5..... <length
     * 2. right <= cut(h, size) curr <= cut(right, size) 下一个要操作的节点
     * 3. merge(left,right)
     * 4 tail => 处理好的结尾的节点
     * @param head
     * @return
     */
    public  ListNode sortList2(ListNode head) {
        int length = 0;
        ListNode res = new ListNode(0);
        ListNode h = head;
        res.next = head;
        // 获得总的长度
        while (h != null) {
            h = h.next;
            length++;
        }
        for (int size = 1; size < length ; size += size) {
            h = res.next;
            ListNode tail = res;
            while(h != null){
                ListNode left = h;
                ListNode right = cut(left, size);
                h = cut(right, size);
                tail.next = merge(left, right);
                while(tail.next != null) {
                    tail = tail.next;
                }
            }
        }
        return res.next;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n4.next = n2;
        n2.next = n1;
        n1.next = n3;
        ListNode l1 = CommonUtils.Arrays2ListNode(new int[]{-1,5,3,4,0});
        ListNode res = s.sortList(n4);
        l1 = s.sortList(l1);
        assert CommonUtils.isSort(l1);
        System.out.print("排序完成");
    }
}
// @lc code=end

