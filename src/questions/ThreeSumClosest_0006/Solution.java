package questions.ThreeSumClosest_0006;

import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 *
 * https://leetcode-cn.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (42.03%)
 * Likes:    314
 * Dislikes: 0
 * Total Accepted:    61.8K
 * Total Submissions: 146K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target
 * 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 *
 */

// @lc code=start
class Solution {
    // 解法2 双指针 滑动窗口
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int diff = Math.abs(nums[0]+ nums[1] + nums[2] - target);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(diff > Math.abs(sum - target)){
                    diff = Math.abs(sum - target);
                    res = sum;
                }
                if(sum - target >= 0) right--;
                else left++;
            }
        }
        return res;
    }
    // 解法1 暴力遍历
    public int threeSumClosest2(int[] nums, int target) {
        int n = nums.length;
        int diff = Math.abs(nums[0] + nums[1] + nums[2] - target);
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i+1; j < n - 1; j++) {
                for (int k = j+1; k < n; k++) {
                    int d = nums[i]+ nums[j]+ nums[k] - target;
                    if (Math.abs(d) <= diff) {
                        diff = Math.abs(d);
                        res = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        assert s.threeSumClosest(new int[]{ 0, 2, 1, -3 }, 1) == 0;
        assert s.threeSumClosest(new int[]{ -1,2,1,-4 }, 1) == 2;
        assert s.threeSumClosest(new int[]{ 0, 1, 2 }, 3) == 3;
    }
}
// @lc code=end
