/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 *
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (36.36%)
 * Total Accepted:    23.2K
 * Total Submissions: 63.7K
 * Testcase Example:  '"leetcode"'
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 
 * 案例:
 * 
 * 
 * s = "leetcode"
 * 返回 0.
 * 
 * s = "loveleetcode",
 * 返回 2.
 * 
 * 
 * 
 * 
 * 注意事项：您可以假定该字符串只包含小写字母。
 * 
 */
class Solution {
    public int firstUniqChar(String s) {
        char[] array = s.toCharArray();
        int[] numbers = new int[256];

        for (int i = 0; i < array.length; i++) {
            numbers[array[i]]++;
        }

        for (int i = 0; i < array.length; i++) {
            if (numbers[array[i]] == 1){
                return i;
            }
        }

        return -1;
    }
}
