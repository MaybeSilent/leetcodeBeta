/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (31.84%)
 * Total Accepted:    52K
 * Total Submissions: 162.8K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 
 * 
 * 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 * 
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        //StringBuilder strbu = new StringBuilder();
        if( strs.length == 0 ) return "";
        int commonlen = strs[0].length();
        char[] fisrt = strs[0].toCharArray();
        for(int i = 1 ; i < strs.length ; i++){
            char[] temp = strs[i].toCharArray();
            int tempCount = 0;
            int bound = temp.length < commonlen ? temp.length : commonlen ;
            for(int j = 0 ; j < bound ; j++){
                if(temp[j] == fisrt[j]) tempCount ++;
                else break;
            }
            if(tempCount < commonlen) commonlen = tempCount;
        }
        
        return strs[0].substring( 0 , commonlen );
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"aca","cba"}));
    }
}

