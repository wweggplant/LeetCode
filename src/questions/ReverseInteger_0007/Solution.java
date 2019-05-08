package questions.ReverseInteger_0007;

public class Solution {
    public static int reverse(int x) {
        char[] chars = (x + "").toCharArray();
        int i = 0;
        int L = chars.length;
        int j = L - 1;
        int plus = -1;
        if (x < 0) {
            i++;
            plus = 0;
        }
        while(i < j) {
            char temp = chars[i];
            chars[i] = chars[L - i + plus];
            chars[L - i + plus] = temp;
            i++;
            j--;
        }
        try {
            return Integer.parseInt(String.valueOf(chars));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    /*
     * int类型的范围是 -2147483648 ~ 2147483647
     * 如果res > Integer.MAX_VALUE / 10 则一定溢出,如果res = Integer.MIN_VALUE / 10,pop是最后一位,pop>7才会溢出,负数类似.
     * */
    public static int reverse2(int x) {
        int res = 0;
        while(x != 0) {
            int pop = x % 10;
            res = res * 10 + pop;
            x /=  10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE && pop > 7)) return 0;
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE && pop < -8)) return 0;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(reverse2(123));
        System.out.println(reverse2(-123));
        System.out.println(reverse2(120));
        System.out.println(reverse2(1534236469));

    }
}
