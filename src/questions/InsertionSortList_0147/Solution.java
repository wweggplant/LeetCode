package questions.InsertionSortList_0147;

import java.util.ArrayList;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
 *
 * https://leetcode-cn.com/problems/insertion-sort-list/description/
 *
 * algorithms
 * Medium (61.19%)
 * Likes:    97
 * Dislikes: 0
 * Total Accepted:    15K
 * Total Submissions: 24.4K
 * Testcase Example:  '[4,2,1,3]'
 *
 * 对链表进行插入排序。
 * 
 * 
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * 
 * 
 * 
 * 插入排序算法：
 * 
 * 
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 
 * 
 * 示例 2：
 * 
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
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
    Comparator<Integer> c = new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return a > b ? 1 : (a < b ? -1 : 0);
        }
    };
    // 使用list默认的排序,跑两趟完成
    public ListNode insertionSortList2(ListNode head) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode node = head;
        while (node !=null) {
            list.add(node.val);
            node = node.next;
        }
        list.sort(this.c);
        node = head;
        int i = 0;
        while (node != null) {
            node.val = list.get(i++);
            node = node.next;
        }
        return head;
    }
    /*
     回溯法
    */
    public static ListNode insertionSortList(ListNode head) {
        ListNode n = null;
        ListNode t = head;
        while (t != null) {
            ListNode next = t.next;
            n = insertioinNode(n, t);
            t = next;
        }
        return n;
    }
    public static ListNode insertioinNode(ListNode head, ListNode node) {
        if (head == null || head.val > node.val){
            node.next = head;
            return node;
        }
        head.next = insertioinNode(head.next, node);
        return head;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public static boolean isSort (ListNode head) {
        ListNode node = head;
        while(node != null) {
            ListNode next = node.next;
            if (next != null && next.val < node.val){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

