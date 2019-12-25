package questions.common;

import java.util.ArrayList;
import java.util.List;

public class CommonUtils<T> {
    public void showArrays(T[] arrays) {
        String str = "[";
        for (int i = 0; i < arrays.length; i++) {
            str +=arrays[i] + ",";
        }
        str += str.substring(0, str.length() - 1);
        str += "]";
        System.out.println(str);
    }
    public static boolean isSort(ListNode head) {
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            if (next != null && (int)next.val < (int)node.val) {
                return false;
            }
        }
        return true;
    }
    public static ListNode Arrays2ListNode(int[] array) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for (int i : array) {
            tail.next = new ListNode(i);
            tail = tail.next;
        }
        return head.next;
    }
    public Integer[] ListNode2Arrays(ListNode head) {
        ListNode n = head;
        List<Integer> list = new ArrayList<Integer>();
        while (n != null) {
            list.add(n.val);
            n = n.next;
        }
        Integer[] array = new Integer[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
