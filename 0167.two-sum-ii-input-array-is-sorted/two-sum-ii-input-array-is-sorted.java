/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 *
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * algorithms
 * Easy (47.05%)
 * Total Accepted:    17.7K
 * Total Submissions: 37.1K
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 
 * 说明:
 * 
 * 
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 
 * 
 * 示例:
 * 
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * 
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int indexOfnext = 1;
        int start = 0;
        while(start < indexOfnext){
            int targetNum = target - numbers[start];
            if(numbers[indexOfnext] == targetNum){
                return new int[]{start + 1 , indexOfnext + 1};
            } else if(numbers[indexOfnext] < targetNum){
                if(indexOfnext < numbers.length - 1) indexOfnext ++;
                else start ++ ;
            } else {
                if(start < indexOfnext && numbers[indexOfnext - 1] < targetNum){
                    start ++ ;
                } else {
                    indexOfnext -- ;
                }
            }
        }
        return null ;
    }
}

