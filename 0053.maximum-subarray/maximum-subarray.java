/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 *
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (42.50%)
 * Total Accepted:    37.2K
 * Total Submissions: 87.4K
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例:
 * 
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 
 * 
 * 进阶:
 * 
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 
 */
class Solution {
    /**
     * 一种直接遍历 ， 还有一种可以利用分治法求解
     * 
     * 分治法思路：nlog ，左边最大的 + 右边最大的
     */
    public int maxSubArray(int[] nums) {
        //if(nums.length == 0) return 
        int ans = nums[0];
        int tempNum = 0;
        for(int i = 0 ; i < nums.length ;i ++){
            if(tempNum + nums[i] < 0){
                if(ans < 0) ans = Math.max(nums[i], ans);
                tempNum = 0;
            } else {
                tempNum += nums[i];
                ans = Math.max(ans,tempNum);
            }

        }
        return ans;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}

