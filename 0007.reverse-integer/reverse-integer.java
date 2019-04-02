/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 *
 * https://leetcode-cn.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (31.53%)
 * Total Accepted:    82.2K
 * Total Submissions: 260.6K
 * Testcase Example:  '123'
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * 示例 1:
 * 
 * 输入: 123
 * 输出: 321
 * 
 * 
 * 示例 2:
 * 
 * 输入: -123
 * 输出: -321
 * 
 * 
 * 示例 3:
 * 
 * 输入: 120
 * 输出: 21
 * 
 * 
 * 注意:
 * 
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 
 */
class Solution {

    /**
     * 通过判断除以最小的值
     */
    public int reverse(int x) {
        int result = 0;
        while( x != 0 ){
            if(result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10){
                return 0;
            }
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }
    /**
     * 利用long来处理溢出问题
     * 对于整数处理的溢出方式
     */
    public int reversejudge(int x) {
        long result = 0;
        //boolean flag = x < 0 ? true : false ;
        while(x != 0){
            result = result *10 + x % 10;
            x /= 10;
        }
        
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
        return (int)result ; //flag ? result*-1 : result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.reverse(-123));
    }
}

