/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (24.83%)
 * Total Accepted:    44.5K
 * Total Submissions: 179.4K
 * Testcase Example:  '"babad"'
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 
 */
class Solution {
    public String longestPalindrome(String s) {
        /* 
        char[] sarray = s.toCharArray();
        if (sarray.length == 0) return new String();
        boolean[][] isSortted = new boolean[sarray.length][sarray.length];
        int ans = 0 , start = 0  , end = 0;
        for (int i = 0; i < sarray.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if (sarray[j] == sarray[i] && (isSortted[j+1][i-1] || i - j <= 2) ) {
                    isSortted[j][i] = true;
                    if ( i - j > ans) {
                        start = j;
                        end = i;
                        ans = i - j;
                    }
                }
            }
        }

        return s.substring(start, end+1);
        动态规划算法，比较好理解，同时写起来比较方便
        */
        if(s.length() == 0) return new String();
        char[] sarray = s.toCharArray();
        char[] addedArray = new char[s.length()*2 + 1];

        int[] Len = new int[addedArray.length];
        
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            addedArray[count ++] = '#';
            addedArray[count ++] = sarray[i];
        }
        addedArray[count ++] = '#';

        int maxRight = 0;
        int pos = 0;

        int maxMid = 0;
        int max = 0;

        for (int i = 0; i < count; i++) {
            if (i < maxRight) {
                Len[i] = Math.min(maxRight - i, Len[pos*2 - i]);
            } else {
                Len[i] = 1;
            }
            while(i - Len[i] >= 0 && i + Len[i] < count) {
                if (addedArray[i-Len[i]] == addedArray[i+Len[i]]) {
                    if (Len[i] + i > maxRight) {
                        maxRight = Len[i] + i;
                        pos = i;
                    }
                    Len[i] += 1;
                } else {
                    break;
                }
            }

            if (Len[i] > max) {
                max = Len[i];
                maxMid = i;
            }
        }

        int halfLen = Len[maxMid] - 1;
        return s.substring((maxMid-halfLen) / 2,(maxMid+halfLen) / 2);

    }
}

