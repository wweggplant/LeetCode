package questions.RotateArray_189;
import questions.common.ListNode;
/*
  name: 旋转数组
* source: https://leetcode-cn.com/problems/rotate-array/
* */
public class Solution {
    public static void rotate1(int[] nums, int k) {
        int L = nums.length;
        k %= L;
        for (int i = 0; i < k ; i++) {
            int temp = nums[0];
            for (int j = L - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }
    // 链表
    public static void rotate(int[] nums, int k){
        int L = nums.length;
        int moveCount = k % L;
        if (L < 2) {
            return;
        }
        if (moveCount == 0) {
            return;
        }
        ListNode head = new ListNode(0);
        ListNode list = new ListNode(0);
        ListNode tail = list;
        for (int i = 0; i < L; i++) {
            tail.next = new ListNode(nums[i]);
            tail = tail.next;
        }
        head = list;
        for (int i = 0; i <= (L - moveCount); i++) {
            head = head.next;
        }
        tail = head;
        for (int i = 0; i < moveCount - 1; i++) {
            tail = tail.next;
        }
        tail.next = list.next;
        list = head;
        for (int i = 0; i < L; i++) {
            nums[i] = (int)list.val;
            list = list.next;
        }
    }
    // 翻转
    public static void rotate2(int[] nums, int k){
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public static void reverse(int[] nums, int start, int end){
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int[] nums2 = new int[]{-1,-100,3,99};
        int[] nums3 = new int[]{1,2};
        rotate(nums, 3);
        rotate(nums2, 2);
        rotate(nums3, 0);
        System.out.println("input: 1,2,3,4,5,6,7, k = 3:");
        System.out.print("out:");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+",");
        }
        System.out.println("");
        System.out.println("input: -1,-100,3,99: , k = 2");
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i]+",");
        }
        System.out.println("");
        System.out.println("input: 1,2: , k = 0");
        for (int i = 0; i < nums3.length; i++) {
            System.out.print(nums3[i]+",");
        }
    }
}
