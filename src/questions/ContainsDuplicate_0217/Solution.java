package questions.ContainsDuplicate_0217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
* source: https://leetcode-cn.com/problems/contains-duplicate/
* */
public class Solution {
    // set1
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Boolean result = false;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                result = true;
                break;
            } else {
                set.add(nums[i]);
            }
        }
        return result;
    }
    // 排序后,前后比较
    public boolean containsDuplicate1(int[] nums) {
        if(nums == null || nums.length < 2){
            return false;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i -1 ] == nums[i]) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
