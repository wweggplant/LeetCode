package questions.FindFirstAndLastPositionOfElementInSortedArray_0034;

/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (38.11%)
 * Likes:    276
 * Dislikes: 0
 * Total Accepted:    51.8K
 * Total Submissions: 135.1K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 
 * 示例 1:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 
 * 示例 2:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * 
 */

// @lc code=start
class Solution {
    /*
    先用二分找到target的index,然后以index向左/右二分法找到边界值
    */
    public int[] searchRange(int[] nums, int target) {
        int[] r = {-1, -1};
        int l = nums.length;
        int i = binarySearch(nums, 0, l -1, target);
        if(i > -1) {
            int left = i, right = i;
            while (left > 0 && nums[left] == target && nums[left - 1] == target) {
                left--;
            }
            while (right < l - 1 && nums[right] == target && nums[right + 1] == target) {
                right++;
            }
            r[0] = left;
            r[1] = right;
        }
        return r;
    }
    public int binarySearch(int[] nums, int low, int high, int target){
        if(low > high) return -1;
        int mid = (high + low) / 2;
        int midVal = nums[mid];
        if(target > midVal)
            return binarySearch(nums, mid+1, high, target);
        else if (target < midVal)
            return binarySearch(nums, low, mid - 1, target);
        else
            return mid;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a1 = new int[]{5,7,7,8,8,10};
        int[] a2 = new int[]{5,6,7,7,8,8,10};
        int[] a3 = new int[]{5,6,7,7,8,8,8,8,8,8,10};
        int[] r1 = s.searchRange(a1, 8);
        int[] r2 = s.searchRange(a1, 6);
        int[] r3 = s.searchRange(a2, 6);
        int[] r4 = s.searchRange(a3, 8);
        assert r1[0] == 3 && r1[1] == 4;
        assert r2[0] == -1 && r2[1] == -1;
        assert r3[0] == 1 && r3[1] == 1;
        assert r4[0] == 4 && r4[1] == 9;
    }
}
// @lc code=end
