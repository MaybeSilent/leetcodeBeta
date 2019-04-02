/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 *
 * https://leetcode-cn.com/problems/palindrome-number/description/
 *
 * algorithms
 * Easy (56.07%)
 * Total Accepted:    72K
 * Total Submissions: 128.4K
 * Testcase Example:  '121'
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 
 * 示例 1:
 * 
 * 输入: 121
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 
 * 
 * 示例 3:
 * 
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 
 * 
 * 进阶:
 * 
 * 你能不将整数转为字符串来解决这个问题吗？
 * 
 */
class Solution {
    /**
     * 最直接的方法，转化成字符串进行相应的求解
     */
    public boolean isPalindromefirst(int x) {
        if(x < 0) return false;
        String s = String.valueOf(x);
        int length = s.length() / 2;
        for(int i = 0 ; i < length ; i++){
            if(s.charAt(i) != s.charAt(s.length() - i - 1)){
                return false;
            }
        }

        return true;
    }

    /**
     * 通过不用转化成字符串的方法进行
     */
    public boolean isPalindrome(int x) {
        //
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;

        int compare = 0;
        while(compare < x){
            compare = compare * 10 + x % 10;
            x /= 10;
        }
        if(compare == x || compare /10 == x) return true;
        else return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(100));
        System.out.println(solution.isPalindrome(101));
        System.out.println(solution.isPalindrome(111));
    }
}

