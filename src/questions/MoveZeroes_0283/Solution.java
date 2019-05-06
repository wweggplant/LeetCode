package questions.MoveZeroes_0283;
import questions.common.CommonUtils;
/*
* source: https://leetcode-cn.com/problems/move-zeroes/
* */
public class Solution {
    // 双指针
    public static void moveZeroes(Integer[] nums) {
        int i =0;
        int j = 0;
        int temp = 0;
        while (i < nums.length){
            if (nums[i] != 0) {
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
            i++;
        }
    }
    // 相比双指针,多了一遍循环,没有交换
    public static void moveZeroes3(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
    // 快慢指针,个人认为的目前最佳的方法,查询和交换最少
    public static void moveZeroes2(Integer[] nums) {
        int L = nums.length;
        int i = 0;
        int j = 0;
        while(i < L && j < L){
            while(i < L && nums[i] == 0){
                i++;
            }
            while(j < i && nums[j] != 0){
                j++;
            }
            if(i < L && j < L) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j++] = temp;
            }
        }
    }
    public static void main(String[] args) {
        Integer[] nums1 = new Integer[]{1,0};
        moveZeroes2(nums1);
        CommonUtils<Integer> utils = new CommonUtils();
        utils.showArrays(nums1);
    }
}
