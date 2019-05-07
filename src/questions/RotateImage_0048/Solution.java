package questions.RotateImage_0048;
/*
* https://leetcode-cn.com/problems/rotate-image/
* */
public class Solution {
    // 先转置在翻转
    public static  void rotate(int[][] matrix) {
        int L = matrix.length;
        for (int i = 0; i < L/2; i++) {
            int start = i;
            int end = L - i - 1;
            for (int j = 0; j < end - start; j++) {
                int temp = matrix[start][start + j];
                matrix[start][start + j] = matrix[end - j][start];
                matrix[end - j][start] = matrix[end][end - j];
                matrix[end][end - j] = matrix[start + j][end];
                matrix[start + j][end] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(m);
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print(m[i][j]);
            }
        }
    }
}
