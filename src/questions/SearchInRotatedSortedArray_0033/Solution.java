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
            1. 如何判断那边有序,那边无序?nums[mid]>left的话左边是有序的, 否则是无序的(画图可知)
            2. 判断target是否在有序的一遍,如果是,则在有序一边直接使用二分法得出结果
            3. 如果在无序一边,则对这一边使用递归,重复以上步骤
    */
    public int search(int[] nums, int target) {
        
    }
}
// @lc code=end

