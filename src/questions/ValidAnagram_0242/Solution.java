package questions.ValidAnagram_0242;

import java.util.Arrays;

/*
* source: https://leetcode-cn.com/problems/valid-anagram/
* */
public class Solution {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return String.valueOf(sc).equals(String.valueOf(tc));
    }
    // 定义一个字母表
    public static boolean isAnagram2(String s, String t) {
        if(s.length() != t.length())
            return false;
        char[] alphabet = new char[26];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            alphabet[sc[i] - 'a']++;
            alphabet[tc[i] - 'a']--;
        }
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] > 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isAnagram2("anagram", "nagaram"));
        System.out.println(isAnagram2("rat", "car"));
    }
}
