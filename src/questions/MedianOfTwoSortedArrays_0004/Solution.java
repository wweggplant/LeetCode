package questions.MedianOfTwoSortedArrays_0004;

/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 *
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (36.30%)
 * Likes:    1819
 * Dislikes: 0
 * Total Accepted:    117.2K
 * Total Submissions: 322.7K
 * Testcase Example:  '[1,3]\n[2]'
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * 示例 1:
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * 则中位数是 2.0
 * 
 * 
 * 示例 2:
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * 则中位数是 (2 + 3)/2 = 2.5
 * 
 * 
 */

// @lc code=start
class Solution {
    // 暴力法
    /* public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] list = new int[nums1.length + nums2.length];
        int nums1Length = nums1.length, nums2Length = nums2.length, i = 0, j = 0, k = 0;
        while (i < nums1Length || j <  nums2Length) {
            if (i == nums1Length) {
                list[k++] = nums2[j++];
            } else if (j == nums2Length){
                list[k++] = nums1[i++];
            }else if (nums1[i] > nums2[j]) {
                list[k++] = nums2[j++];
            } else {
                list[k++] = nums1[i++];
            }
        }
        if (list.length % 2 == 0) {
            double result = list[list.length/2 - 1] + list[list.length/2];
            return  result / 2;
        } else {
            return  list[list.length / 2];
        }
    } */

    /*
     * 折半删除法, 用反证法可以证明
     * 设n < m, n,m为A,B的长度, k为合并数组的所求的中间索引,所对应的的元素为K, 假设K在要删除的一侧
     * 
     * 则有k = (n+m)/2
     * 
     * 对于A至多(n - k/2)个比K大的数, B至少(m - k/2)个比K大的数, 设x为比K大的数,且有x = (n+m)/2,
     * 
     * 由上可得, x >  n+m-k = (n+m)/2, 与已知明显矛盾, 所以假设不
     * 
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = nums1.length + nums2.length;
        int k = l/2;
        return 0.0;
    }
}
// @lc code=end
