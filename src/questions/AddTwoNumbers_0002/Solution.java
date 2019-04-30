package questions.AddTwoNumbers_0002;
import questions.common.ListNode;
/*
* source: https://leetcode-cn.com/problems/add-two-numbers/
*
* */
public class Solution {
    public ListNode<Integer> addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode list  = new ListNode(0);
        ListNode tail = list;
        int carry = 0;
        while(p1 != null || p2 != null) {
            int n1 =(p1 != null) ? (int)p1.val : 0;
            int n2 = (p2 != null)  ? (int)p2.val : 0;
            int current = n1 + n2 + carry;
            if (current >= 10) {
                current = current % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            tail.next = new ListNode(current);
            tail = tail.next;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return list.next;
    }
}
