package questions.GroupAnagrams_0049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (59.30%)
 * Likes:    230
 * Dislikes: 0
 * Total Accepted:    42.4K
 * Total Submissions: 70.7K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * 说明：
 * 
 * 
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 
 * 
 */

// @lc code=start
class Solution {
    private Map<String, List<String>> map = new HashMap<String, List<String>>();
    // 方法一：排序数组分类
    public List<List<String>> groupAnagrams(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            String key = this.sortByAlphabet(str);
            List<String> list;
            if(map.containsKey(key))
                list = map.get(key);
            else {
                list = new ArrayList<String>();
                map.put(key, list);
            }
            list.add(str);
        }
        List<List<String>> res = new ArrayList<List<String>>();
        map.forEach((key, list) -> {
            res.add(list);
        });
        return res;
    }
    public String sortByAlphabet(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        // String a = s.sortByAlphabet("cba");
        // assert a.equals("abc");
        String[] str1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = s.groupAnagrams(str1);
    }
}
// @lc code=end
