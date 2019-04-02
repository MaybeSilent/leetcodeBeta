/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (35.90%)
 * Total Accepted:    18.2K
 * Total Submissions: 50.5K
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 
 * 你可以假设数组中不存在重复的元素。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 示例 1:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * 
 */
class Solution {
    //先利用二分查找出哪段内容是已经排好序的
    //然后在相应的内容里面进行二分查找
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int left = 0, middle = 0, right = 0;
        int start = 0, end = nums.length - 1, mid = (end - start) / 2 + start;
        while (start <= end) {
            if (nums[mid] > nums[start]) {
                start = mid;
            } else if (nums[mid] < nums[start]) {
                end = mid;
            } else {
                break;
            }

            mid = (end - start) / 2 + start;
        }

        if (start + 1 < nums.length && nums[start] < nums[start + 1]){
            start ++;
        }

        //System.out.println(start);

        if (target > nums[0]) {
            return binarySearch(nums, 0, start, target);
        }

        else if (target < nums[0]) {
            return binarySearch(nums, start+1, nums.length-1, target);
        } else {
            return 0;
        }
        
    }

    private int binarySearch (int[] nums, int start, int end, int target) {
        int mid = (end - start) / 2 + start;
        while (start <= end) {
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
            mid = (end-start) / 2 + start;
        }

        return -1;
    }
}

