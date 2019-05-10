package questions.ValidPalindrome_0125;

/*
* source: https://leetcode-cn.com/problems/valid-palindrome/
* */

public class Solution {
    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] ss = s.toCharArray();
        boolean result = true;
        while(start < end && result) {
            char sStart = ss[start];
            char sEnd = ss[end];
            if((!(sStart>='A' && sStart <= 'Z') && !(sStart>='a' && sStart <= 'z'))  && !(sStart >= '0' && sStart <= '9')) {
                start++;
                continue;
            }
            if((!(sEnd>='A' && sEnd <= 'Z') && !(sEnd>='a' && sEnd <= 'z'))  && !(sEnd >= '0' && sEnd <= '9')) {
                end--;
                continue;
            }
            if ((sStart>='A' && sStart <= 'Z')) {
                sStart  = (char)(sStart - 'A' + 'a');
            }
            if ((sEnd>='A' && sEnd <= 'Z')) {
                sEnd  = (char)(sEnd - 'A' + 'a');
            }
            if(sStart == sEnd) {
                start++;
                end--;
            } else {
                result = false;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }
}
