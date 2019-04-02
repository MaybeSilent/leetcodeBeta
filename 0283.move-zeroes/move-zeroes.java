/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (52.87%)
 * Total Accepted:    37K
 * Total Submissions: 70K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 说明:
 * 
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 
 * 
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int fastindex = 0, slowindex = 0;
        while (fastindex < nums.length) {
            if (nums[fastindex] != 0) {
                nums[slowindex++] = nums[fastindex];
            }
            fastindex++;
        }
        while (slowindex < nums.length) {
            nums[slowindex++] = 0;
        }
    }
}
