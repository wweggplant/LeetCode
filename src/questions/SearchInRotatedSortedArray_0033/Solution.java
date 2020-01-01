package questions.SearchInRotatedSortedArray_0033;

/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (36.21%)
 * Likes:    458
 * Dislikes: 0
 * Total Accepted:    63K
 * Total Submissions: 173.8K
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *  
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 
 * 你可以假设数组中不存在重复的元素。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 示例 1:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * 
 */

// @lc code=start
class Solution {
    /* 
        递归二分法:每次二分,肯定有一边是有序,另一边是无序的
            1. 如何判断哪边有序,哪边无序?nums[mid]>nums[start]的话左边是有序的, 否则是左边无序的(画图可知)
            2. 判断target是否在有序的一遍,如果是,则在有序一边直接递归调用查找得出结果,否则的话对另一边使用递归
            3. 都没有找到返回-1
    */
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return -1;
        int start = 0;
        int end = n - 1;
        return binarySearch(nums, start, end, target);
    }
    public int binarySearch(int[] nums, int start, int end, int target) {
        if ( start > end ) return -1; 
        int mid = (end + start)/2;
        if (nums[mid] == target ) return mid;
        if(nums[mid] >= nums[start]) {
            // 左边有序
            if(target < nums[mid] && target >= nums[start]) //判断target是否在有序一边(左侧)
                return binarySearch(nums, start, mid-1, target);
            else
                return binarySearch(nums, mid+1, end, target);
        } else {
            // 右边有序
            if(target > nums[mid] && target <= nums[end]) //判断target是否在有序一边(右侧)
                return binarySearch(nums, mid+1, end, target);
            else
                return binarySearch(nums, start, mid-1, target);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = new int[]{4,5,6,7,0,1,2};
        int[] a1 = new int[]{};
        int[] a2 = new int[]{1};
        int[] a3 = new int[]{1,3};
        int[] a4 = new int[]{3,1};
        int[] a5 = new int[]{5,1,3};
        assert s.search(a, 0) == 4;
        assert s.search(a, 3) == -1;
        assert s.search(a1, 5) == -1;
        assert s.search(a2, 1) == 0;
        assert s.search(a3, 2) == -1;
        assert s.search(a3, 2) == -1;
        assert s.search(a4, 1) == 1;
        assert s.search(a5, 0) == -1;
        assert s.search(a5, 3) == 2;
    }
}
// @lc code=end

