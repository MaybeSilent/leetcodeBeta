/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 *
 * https://leetcode-cn.com/problems/search-insert-position/description/
 *
 * algorithms
 * Easy (42.61%)
 * Total Accepted:    29.2K
 * Total Submissions: 68.4K
 * Testcase Example:  '[1,3,5,6]\n5'
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 
 * 你可以假设数组中无重复元素。
 * 
 * 示例 1:
 * 
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 
 * 
 * 示例 3:
 * 
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 
 * 
 * 示例 4:
 * 
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * 
 * 
 */
class Solution {
    //典型的二分插入问题
    public int searchInsert(int[] nums, int target) {
        int start = 0 , end = nums.length - 1  , mid = (end - start) / 2 + start ;
        while( start <= end ){
            mid = (end - start) / 2 + start ;
            if(nums[mid] < target){
                start = mid + 1;
            } else if(nums[mid] > target){
                end = mid - 1;
            } else {
                return mid;
            }
        }

        //System.out.println(start + " " + end);
        return start;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(new int[]{1,3,5,6} , 7));
        System.out.println(solution.searchInsert(new int[]{1,3,5,6} , 0));
        System.out.println(solution.searchInsert(new int[]{1,3} , 2));
    }
}
