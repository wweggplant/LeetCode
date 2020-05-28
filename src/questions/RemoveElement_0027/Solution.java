package questions.RemoveElement_0027;

import questions.common.CommonUtils;

/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 *
 * https://leetcode-cn.com/problems/remove-element/description/
 *
 * algorithms
 * Easy (56.49%)
 * Likes:    461
 * Dislikes: 0
 * Total Accepted:    123.7K
 * Total Submissions: 216.8K
 * Testcase Example:  '[3,2,2,3]\n3'
 *
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 
 * 示例 1:
 * 
 * 给定 nums = [3,2,2,3], val = 3,
 * 
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 
 * 你不需要考虑数组中超出新长度后面的元素。
 * 
 * 
 * 示例 2:
 * 
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 
 * 注意这五个元素可为任意顺序。
 * 
 * 你不需要考虑数组中超出新长度后面的元素。
 * 
 * 
 * 说明:
 * 
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 
 * 你可以想象内部操作如下:
 * 
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 * 
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * 
 * 
 */

// @lc code=start
class Solution {
    /*
     * 
     * 首尾交换有问题,没法处理 [3,...,3]/n的情况
     */
    /* public int removeElement(int[] nums, int val) {
        int l = nums.length, i = 0, j = l - 1;
        if (l == 1) {
            if(nums[0] == val) return 0;
            else return 1;
        }
        while(j > i) {
            if (val == nums[i]) {
                while(j > -1 && nums[j] == val) j--;
                if (j == -1 ) return 0;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
            i++;
        }
        return i;
    } */
    public int removeElement(int[] nums, int val) {
        int i = 0, l = nums.length;
        for (int j = 0; j < l; j++) {
            if(nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i++;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        CommonUtils<Integer> utils= new CommonUtils<Integer>();
        int[] a1 = new int[]{3,2,2,3};
        int[] a2 = new int[]{2};
        int[] a3 = new int[]{3,3};
        int index = s.removeElement(a1, 3);
        int index2 = s.removeElement(a2, 3);
        int index3 = s.removeElement(a3, 3);
        System.out.println("index:"+ index);
        utils.showArrays(utils.int2Integer(a1));
        System.out.println("index:" + index2);
        utils.showArrays(utils.int2Integer(a2));
        System.out.println("index:" + index3);
        utils.showArrays(utils.int2Integer(a3));
    }
}
// @lc code=end
