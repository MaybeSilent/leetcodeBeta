import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词模式
 *
 * https://leetcode-cn.com/problems/word-pattern/description/
 *
 * algorithms
 * Easy (37.40%)
 * Total Accepted:    5.2K
 * Total Submissions: 13.9K
 * Testcase Example:  '"abba"\n"dog cat cat dog"'
 *
 * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
 * 
 * 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
 * 
 * 示例1:
 * 
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 
 * 示例 3:
 * 
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 
 * 示例 4:
 * 
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 * 
 */
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        char[] patternChar = pattern.toCharArray();
        HashMap<Character, String> maps = new HashMap<>();
        if (strs.length != patternChar.length) {
            return false;
        } 
        for (int i = 0; i < strs.length; i++) {
            if (!maps.containsKey(patternChar[i])) {
                if (maps.values().contains(strs[i])){
                    return false;
                }
                else maps.put(patternChar[i], strs[i]);
            } else {
                if (!strs[i].equals(maps.get(patternChar[i]))){
                    return false;
                }
            }
        }
        return true;
    }
}

