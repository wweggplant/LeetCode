package questions.PlusOne_0066;
/*
* source: https://leetcode-cn.com/problems/plus-one/
* */
public class Solution {
    public static int[] plusOne(int[] digits) {
        int plus = 1;
        int L = digits.length;
        int[] result = new int[L+1];
        for (int i = L - 1; i >= 0; i--) {
            int t = digits[i] + plus;
            result[i+1] = t % 10;
            plus = t/10;
        }

        if(plus == 1) {
            result[0] = 1;
        } else {
            // 首位不能为0
            int[] result2 = result;
            result = new int[L];
            for (int i = 1; i < result2.length; i++) {
                result[i-1] = result2[i];
            }
        }
        return result;
    }
    /*
    *  分治法: 逻辑简化,只处理9的情况,抓住了进位的情况必须是最后数为9,加一后,最后次位就得加一,形成了循环
    *  但是有时候结果会不一致, 有时返回全新的数组有时候是返回原地修改的数组
    *
    * */
    public static int[] plusOne1(int[] digits) {
        for (int i=digits.length-1;i>=0;i--) {
            if (digits[i]!=9) {
                digits[i]+=1;
                return digits;
            }else {
                digits[i]=0;
            }
        }
        // 处理999...9的情况
        int newDigits[]=new int[digits.length+1];
        newDigits[0]=1;
        return newDigits;
    }

    public static void main(String[] args) {
        int[] digits1 = new int[]{4,3,2,1};
        int[] list1 = plusOne1(digits1);
        System.out.print("input: [4,3,2,1], out:");
        for (int i = 0; i < list1.length; i++) {
            System.out.print(list1[i]+",");
        }
        System.out.println("");
        int[] digits2 = new int[]{1,2,9};
        int[] list2 = plusOne1(digits2);
        System.out.print("input: [1,2,3], out:");
        for (int i = 0; i < list2.length; i++) {
            System.out.print(list2[i]+",");
        }
        System.out.println("");
        int[] digits3 = new int[]{9,9,9};
        int[] list3 = plusOne(digits3);
        System.out.print("input: [9,9,9], out:");
        for (int i = 0; i < list3.length; i++) {
            System.out.print(list3[i]+",");
        }
        System.out.println("");
    }
}
