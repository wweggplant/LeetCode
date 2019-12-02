package questions.SortColors_0075;

/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 *
 * https://leetcode-cn.com/problems/sort-colors/description/
 *
 * algorithms
 * Medium (53.76%)
 * Likes:    267
 * Dislikes: 0
 * Total Accepted:    43.9K
 * Total Submissions: 81.5K
 * Testcase Example:  '[2,0,2,1,1,0]'
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * 
 * 示例:
 * 
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 
 * 进阶：
 * 
 * 
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * 初始想法，可以合成一趟
     */
    public static void sortColors(int[] nums) {
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) a++;
            if (nums[i] == 1) b++;
            if (nums[i] == 2) c++;
        }
        int j = 0;
        for (; j < a; j++) {
            nums[j] = 0;
        }
        for (; j < a+b; j++) {
            nums[j] = 1;
        }
        for (;j < a+b+c; j++) {
            nums[j] = 2;
        }
    }
    // 2 pass
    public static void sortColors2(int[] nums) {
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) a++;
            if (nums[i] == 1) b++;
            if (nums[i] == 2) c++;
        }
        int j = 0;
        while(j < nums.length) {
            if(j < a) nums[j] = 0;
            else if(j < a+b ) nums[j] = 1;
            else nums[j] = 2;
            j++;
        }
    }
    public static void main(String[] args) {
        int[] a = new int[]{2,0,2,1,1,0};
        sortColors(a);
    }
}
// @lc code=end

