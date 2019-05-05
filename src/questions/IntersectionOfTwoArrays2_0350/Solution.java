package questions.IntersectionOfTwoArrays2_0350;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/*
* source: https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
* */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length || j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]){
                i++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[list.size()];
        int ii = 0;
        for (Integer n: list) {
            result[ii++] = n;
        }
        return result;
    }
}
