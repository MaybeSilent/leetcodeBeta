/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (28.56%)
 * Total Accepted:    93.6K
 * Total Submissions: 326.4K
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count = 0;
        char[] schar = s.toCharArray();

        if (schar.length == 0) return 0;
        boolean[] visited = new boolean[256];
        int start = 0;
        int ans = 0;

        for (int i = 0; i < schar.length; i ++) {
            if (visited[schar[i]] == true) {
                ans = Math.max(i - start, ans);
                for (int j = start; j < i; j++) {
                    if (schar[j] == schar[i]) {
                        start = j + 1 ;
                    }
                }
            } else {
                visited[schar[i]] = true;
            }

        }

        ans = Math.max(schar.length - start, ans);

        return ans;
        
    }
}

