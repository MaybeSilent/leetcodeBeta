/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 *
 * https://leetcode-cn.com/problems/longest-palindrome/description/
 *
 * algorithms
 * Easy (46.49%)
 * Total Accepted:    4K
 * Total Submissions: 8.5K
 * Testcase Example:  '"abccccdd"'
 *
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * 
 * 示例 1: 
 * 
 * 
 * 输入:
 * "abccccdd"
 * 
 * 输出:
 * 7
 * 
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 
 * 
 */
class Solution {
    public int longestPalindrome(String s) {
        char[] strs = s.toCharArray();
        int[] counts = new int[256];
        int ans = 0;
        for (int i = 0; i < strs.length; i++) {
            counts[strs[i]]++ ;
            if (counts[strs[i]] == 2){
                counts[strs[i]] = 0;
                ans += 2;
            }
        }
        if (ans < strs.length) {
            ans += 1;
        }

        return ans;
    }
}
