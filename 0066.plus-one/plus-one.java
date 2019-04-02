/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 *
 * https://leetcode-cn.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (37.49%)
 * Total Accepted:    37.3K
 * Total Submissions: 99.5K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * 
 * 
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1 ;
        digits[index] += 1 ;
        while( digits[index] >= 10 ){
            if(index == 0){
                int[] result = new int[digits.length + 1];
                System.arraycopy( digits, 0 , result, 1 , digits.length) ;
                result[0] += 1;
                result[1] -= 10;
                return result;
            } else {
                digits[index] -= 10;
                digits[--index] += 1;
            }
        }

        return digits ;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = solution.plusOne(new int[]{ 9 , 9 , 9 , 9 } );
        for(int num : arr){
            System.out.println(num);
        }
    }
}

