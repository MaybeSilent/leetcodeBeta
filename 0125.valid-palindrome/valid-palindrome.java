/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 *
 * https://leetcode-cn.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (38.04%)
 * Total Accepted:    25.7K
 * Total Submissions: 67K
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 
 * 示例 1:
 * 
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "race a car"
 * 输出: false
 * 
 * 
 */
class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;
        char[] strchar = s.toCharArray();
        for (int i = 0; i < strchar.length; i++) {
            if (strchar[i] >= 'A' && strchar[i] <= 'Z') {
                strchar[i] = (char) (strchar[i] + 32);
            }
        }
        int begin = 0, end = strchar.length - 1;
        while (begin < end) {
            while ((strchar[begin] < 'a' || strchar[begin] > 'z') && (strchar[begin] < '0' || strchar[begin] > '9')
                    && begin < end) {
                begin++;
            }
            while ((strchar[end] < 'a' || strchar[end] > 'z') && (strchar[end] < '0' || strchar[end] > '9')
                    && begin < end) {
                end--;
            }
            if (strchar[begin] != strchar[end]) {
                return false;
            } else {
                begin++;
                end--;
            }
        }
        return true;
    }
}
