package questions.NextPermutation_0031;

import java.util.Arrays;

import questions.common.*;
/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 *
 * https://leetcode-cn.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (32.23%)
 * Likes:    342
 * Dislikes: 0
 * Total Accepted:    35.4K
 * Total Submissions: 109.2K
 * Testcase Example:  '[1,2,3]'
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 
 * 必须原地修改，只允许使用额外常数空间。
 * 
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= i && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
    public void reverse(int[] nums, int start) {
        int n = nums.length - 1;
        while(n > start) {
            swap(nums, start, n);
            start++;
            n--;
        }
    }
    public void swap(int[] nums,int i, int j) {
        int temp =  nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        CommonUtils<Integer> utils = new CommonUtils<Integer>();
        int[] a1 = new int[]{1,2,3};
        int[] a2 = new int[]{1,1,5};
        int[] a3 = new int[]{3,2,1};
        int[] a4 = new int[]{1};
        s.nextPermutation(a1);
        s.nextPermutation(a2);
        s.nextPermutation(a3);
        s.nextPermutation(a4);
        utils.showArrays(utils.int2Integer(a1));
        utils.showArrays(utils.int2Integer(a2));
        utils.showArrays(utils.int2Integer(a3));
        utils.showArrays(utils.int2Integer(a4));
    }
}
// @lc code=end

