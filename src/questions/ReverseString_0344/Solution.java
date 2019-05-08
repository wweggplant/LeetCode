package questions.ReverseString_0344;
import questions.common.CommonUtils;
/*
* source: https://leetcode-cn.com/problems/reverse-string/
* */
public class Solution {
    public static void reverseString(Character[] s) {
        for (int i = 0; i < s.length /2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }
    public static void reverseString2(Character[] s) {
        int i = 0;
        int j = s.length - 1;
        while(i< j) {
            // 利用了异或的交换律,优点是不用使用额外的变量,缺点是可读性差,需要类型转换
            s[i] = (char)((int)s[i] ^ (int)s[j]);
            s[j] = (char)((int)s[i] ^ (int)s[j]);
            s[i] = (char)((int)s[i] ^ (int)s[j]);
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        Character[] s = {'h','e','l','l','o'};
        Character[] s2 = {'H','a','n','n','a','h'};
        reverseString2(s);
        reverseString2(s2);
        CommonUtils<Character> utils = new CommonUtils();
        utils.showArrays(s);
        utils.showArrays(s2);
    }
}
