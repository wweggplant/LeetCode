package questions.FirstUniqueCharacterInString_0387;

/*
* source: https://leetcode-cn.com/problems/first-unique-character-in-a-string/
* */

public class Solution {
    public static int firstUniqChar(String s) {
        char[] alphabet = new char[26];
        for (char l: s.toCharArray())
            alphabet[l - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (alphabet[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
    // 使用java的lastIndexOf和IndexOf,关键在于外层循环是很小的26次,但是竟然比之前一种的要快,有点不敢相信
    public static int firstUniqChar2(String s) {
        int result = s.length();
        for (char c = 'a';c<='z';c++) {
            int first = s.indexOf(c);
            if(first != -1 && first == s.lastIndexOf(c)) {
                result = Math.min(result, first);
            }
        }
        return result == s.length() ? -1 : result;
    }
    public static void main(String[] args) {
        System.out.println(firstUniqChar2("leetcode"));
        System.out.println(firstUniqChar2("loveleetcode"));
        System.out.println(firstUniqChar2("dddccdbba"));
    }
}
