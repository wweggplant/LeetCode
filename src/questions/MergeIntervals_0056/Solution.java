package questions.MergeIntervals_0056;

import java.util.Random;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 *
 * https://leetcode-cn.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (39.13%)
 * Likes:    216
 * Dislikes: 0
 * Total Accepted:    38.2K
 * Total Submissions: 97.5K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 
 * 示例 1:
 * 
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * 
 * 示例 2:
 * 
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 */

// @lc code=start
class Solution {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        sort(intervals);
        int i = 1, j = 0, start = intervals[0][0], end = intervals[0][1], n = intervals.length;
        int[][] mergeArray = new int[n][];
        int[][] mergeArrayResult;
        while (i < n) {
            if (intervals[i][0] > end) {
                mergeArray[j++] = new int[] { start, end };
                start = intervals[i][0];
                end = intervals[i][1];
            } else if (intervals[i][0] <= end && intervals[i][1] > end) {
                end = intervals[i][1];
            }
            if (i == n - 1) {
                mergeArray[j] = new int[] { start, end };
            }
            i++;
        }
        int length = j+1;
        if(length > 0) {
            mergeArrayResult = new int[length][];
        } else {
            return new int[0][];
        }
        for(int k = 0;k<length;k++) {
            mergeArrayResult[k] = mergeArray[k];
        }
        return mergeArrayResult;
    }

    private static Random rand = new Random();

    public static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static <T> void shuffle(T[] arr) {
        int length = arr.length;
        for (int i = length; i > 0; i--) {
            int randInd = rand.nextInt(i);
            swap(arr, randInd, i - 1);
        }
    }

    public static void sort(int[][] intervals) {
        shuffle(intervals); // 有效降低出现最差情况:最多需要约 N^2/2次比较
        sort(intervals, 0, intervals.length - 1);
    }

    private static void sort(int[][] intervals, int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = partition(intervals, lo, hi);
        sort(intervals, lo, mid - 1);
        sort(intervals, mid + 1, hi);
    }

    private static int partition(int[][] intervals, int lo, int hi) {
        int[] v = intervals[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(intervals[++i], v))
                if (i >= hi)
                    break;
            while (less(v, intervals[--j]))
                if (j <= lo)
                    break;
            if (i >= j)
                break;
            exch(intervals, i, j);
        }
        exch(intervals, j, lo);
        return j;
    }

    private static void exch(int[][] a, int i, int j) {
        int[] temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(int[] a, int[] b) {
        return ((int[]) a)[0] < ((int[]) b)[0];
    }

    private static boolean isSort(int[][] a) {
        for (int i = 1; i < a.length; i++) {
            if (!less(a[i - 1], a[i])) {
                return false;
            }
        }
        return true;
    }
    private static void show(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print("a["+i+"][0]:"+a[i][0]+", a["+i+"][1]:"+a[i][1]+";");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // sort( new int[][] { { 2, 6 }, { 15, 18 }, { 1, 3 }, { 8, 10 } });
        // assert isSort(arr);
        // System.out.println("排序成功");
        show(merge(new int[][] { { 2, 6 }, { 15, 18 }, { 1, 3 }, { 8, 10 } }));
        show(merge(new int[][] {{1,4},{4,5}}));
        
    }
}
// @lc code=end
