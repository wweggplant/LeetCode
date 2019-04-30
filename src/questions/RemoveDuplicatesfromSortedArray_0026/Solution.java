package questions.RemoveDuplicatesfromSortedArray_0026;

/*
* source: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
* */
class Solution {
    private  int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            if(nums[i] != nums[j]){
                nums[++j] = nums[i];
            }
            i++;
        }
        return j + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a1 = new int[]{1,1,2};
        int[] a2 = new int[]{0,0,1,1,1,2,2,3,3,4};
        s.removeDuplicates(a1);
        s.removeDuplicates(a2);
    }
}