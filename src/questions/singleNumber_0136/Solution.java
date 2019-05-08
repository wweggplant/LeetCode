package questions.singleNumber_0136;

import java.util.Arrays;

/*
* source: https://leetcode-cn.com/problems/single-number/
* 根据题目给的条件, 数组的长度必定是奇数
*
* */
public class Solution {
    // 参考了重复数字的解题思路
    // 执行用时 : 10 ms, 在Single Number的Java提交中击败了27.73% 的用户
    // 内存消耗 : 39.7 MB, 在Single Number的Java提交中击败了91.21% 的用户
    public static int singleNumber1(int[] nums) {
        int index = 0;
        if(nums.length < 2){
            return nums[index];
        }
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length ; i += 2) {
            // 不重复元素是最大值,排序到了最后
            if (i == nums.length) {
                index = i - 1;
                break;
            }
            if (nums[i -1] != nums[i]) {
                index =  i - 1;
                break;
            }
        }
        return nums[index];
    }
    // 直接查找, ps:应该是最慢的
    public static int singleNumber2(int[] nums) {
        int L = nums.length;
        int index = L - 1;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                if (i != j) {
                    if (nums[j] == nums[i]) {
                        break;
                    } else if (j == L -1){
                        index = i;
                    }
                }
            }
        }
        // 执行到这里只有最后一个元素就是要找的元素了
        return nums[index];
    }
    // 异或方法
    /*
    * 异或的规律:
    * 1.a^b = b^a
    * 2.0^a = a
    * 3.a^a = 0
    * [1,2,3,1,2,3,4] => 1^1^2^2^3^3^4 = 4;
    * */
    public static int singleNumber3(int[] nums) {
        int num = 0;
        for (int i = 0 ; i<nums.length; i++){
            num ^= nums[i];
        }
        return num;
    }
    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,1,2,4};
//        int num1 = singleNumber1(nums);
//        System.out.println(num1);
//        int[] nums2 = new int[]{1,2,2};
//        int num2 = singleNumber2(nums2);
//        System.out.println(num2);
        int[] nums3 = new int[]{1,2,1,2,4};
        int num3 = singleNumber3(nums3);
        System.out.println(num3);
    }
}
