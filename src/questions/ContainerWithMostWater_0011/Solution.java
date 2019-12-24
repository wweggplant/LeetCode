package questions.ContainerWithMostWater_0011;

/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 *
 * https://leetcode-cn.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (59.31%)
 * Likes:    941
 * Dislikes: 0
 * Total Accepted:    108.9K
 * Total Submissions: 182.4K
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为
 * (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 
 * 
 * 
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * 
 */

// @lc code=start
class Solution {
    // 暴力法
    public int maxArea2(int[] height) {
        int n = height.length;
        int maxArea = 0;
        for (int i = 0; i < n - 1; i++) {
            int h1 = height[i];
            for (int j = i+1; j < n; j++) {
                int area = (h1 > height[j] ? height[j] : h1) * (j - i);
                if (area > maxArea) maxArea = area;
            }
        }
        return maxArea;
    }
    /*
        相向双指针法
    */
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int max = 0;
        while(l < r) {
            int a = Math.min(height[l], height[r]) * (r - l);
            if(a > max) max = a;
            if (height[l] > height[r])
                r--;
            else
                l++;
        }
        return max;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int height = s.maxArea2(new int[]{ 1, 8, 6, 2, 5, 4, 8, 3, 7});
        assert height == 49;
    }
}
// @lc code=end

