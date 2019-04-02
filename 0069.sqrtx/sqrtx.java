/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 *
 * https://leetcode-cn.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (34.58%)
 * Total Accepted:    23.7K
 * Total Submissions: 68.5K
 * Testcase Example:  '4'
 *
 * 实现 int sqrt(int x) 函数。
 * 
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 
 * 示例 1:
 * 
 * 输入: 4
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842..., 
 * 由于返回类型是整数，小数部分将被舍去。
 * 
 * 
 */
class Solution {
    public int mySqrt(int x) {
        if(x == 1) return x;
        int start = 0 , end = x / 2 + 1 , mid = (end - start) / 2 + start;
        while(start + 1 < end){
            //System.out.println(mid);
            mid = ( end - start ) / 2  + start ;
            //System.out.println(start + " " + mid + " " + end );
            if( mid != 0 && mid*mid / mid != mid){
                // System.out.println(mid + " " + mid * mid);
                end = mid ;
                continue ;
            }
            if( mid * mid > x ){
                end = mid ;
            } else if(mid * mid < x){
                start = mid ;
            } else {
                return mid;
            }
            
        }
        return start ; 
    }
    public int mySqrts(int x) {
        int i;
        for(i = 0 ; i * i < x ; i++) ;
        if(i * i == x) return i ;
        return i - 1 ;
    }
    public int mySqrtss(int x) {
        return (int)Math.sqrt(x);
    }

    public int mySqrt_ans(int x) {
        
        if(x<2){
            return x;
        }
        int low=0,high=x/2;
        while(low+1<high){
            int mid=low+((high-low)>>1);
            int val=mid*mid;
            if(val/mid!=mid){
                high=mid;
            } else if(mid*mid==x){
                return mid;
            }else if(mid*mid<x){
                low=mid;
            }else{
                high=mid;
            }
        }
        if(high*high<=x && high*high/high==high){
            return high;
        }
        return low;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(2147483647));
        System.out.println(solution.mySqrtss(2147483647));
        System.out.println(solution.mySqrt(4));
    }
}

