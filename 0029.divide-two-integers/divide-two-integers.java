/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 *
 * https://leetcode-cn.com/problems/divide-two-integers/description/
 *
 * algorithms
 * Medium (17.63%)
 * Total Accepted:    9.5K
 * Total Submissions: 53.8K
 * Testcase Example:  '10\n3'
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 
 * 示例 1:
 * 
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 
 * 示例 2:
 * 
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 
 * 说明:
 * 
 * 
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 * 
 * 
 */
class Solution {
    public int divide(int dividend, int divisor) {

        long ans = 0;
        long a = dividend;
        long b = divisor;

        a = Math.abs(a);
        b = Math.abs(b);
        while (a >= b) {

            long subNum = b;
            long added = 1;
            while (a >= subNum) {
                a -= subNum;
                ans += added;
                subNum <<= 1;
                added <<= 1;
            }
            
        }

        return ((dividend>>31) ^ (divisor>>31)) != 0 ? (int)(ans*-1) : ans > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)ans ;
        
    }
}

