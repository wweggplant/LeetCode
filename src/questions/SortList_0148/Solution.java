package questions.SortList_0148;

import src.common.ListNode;
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
    public ListNode sortList(ListNode head) {
        ListNode n = head;
        for (int size = 1; n != null; size +=size) {
            for (int i = 0; i < array.length; i++) {
                
            }
        }
    }
    public void merge(ListNode lo, ListNode hi) {
        // int i = 0 ,k = 0, mid = size - 1, j = mid + 1, hi = 2 * size - 1;
        // ListNode n = head;
        // ListNode midNode = head;
        // ListNode hiNode = null;
        // ListNode loNode = head;
        // // 找到中点
        // while(i < size - 1){
        //     midNode = midNode.next;
        // }
        // hiNode = midNode.next;
        // i = 0;
        ListNode res = new ListNode(0);
        while(lo != null || hi != null ){
            if(lo == null) {
                res.next = hi;
                hi = hi.next;
            } else if (hi == null){
                res.next = lo;
                lo = lo.next;
            } else if (less(hi, lo)) {
                res.next = hi;
                hi = hi.next;
            } else {
                res.next = lo;
                lo = lo.next;
            }
        }
        return res.next;
    }
    public void exch(ListNode a, ListNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
    public void less(ListNode a, ListNode b) {
        return a.val < b.val;
    }
}
// @lc code=end

