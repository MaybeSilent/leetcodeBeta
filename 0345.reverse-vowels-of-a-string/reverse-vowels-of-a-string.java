
/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 *
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (46.04%)
 * Total Accepted:    7.1K
 * Total Submissions: 15.5K
 * Testcase Example:  '"hello"'
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 
 * 示例 1:
 * 
 * 输入: "hello"
 * 输出: "holle"
 * 
 * 
 * 示例 2:
 * 
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 
 * 说明:
 * 元音字母不包含字母"y"。
 * 
 */
class Solution {
    public String reverseVowels(String s) {
        boolean[] alpha = new boolean[256];

        alpha['a'] = alpha['A'] = alpha['e'] = alpha['E'] = true;
        alpha['i'] = alpha['I'] = alpha['o'] = alpha['O'] = true;
        alpha['u'] = alpha['U'] = true;

        char[] array = s.toCharArray();
        int start = 0, end = array.length - 1;
        //System.out.println(end);
        while (start < end) {
            while (start < end && !alpha[array[start]]) start ++;
            while (start < end && !alpha[array[end]]) end--;
            if (start < end) {
                //System.out.println(">>>");
                char temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start ++;
                end --;
            }
        }
        return new String(array);
    }
}

