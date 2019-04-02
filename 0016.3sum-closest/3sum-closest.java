/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 *
 * https://leetcode-cn.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (39.19%)
 * Total Accepted:    19.2K
 * Total Submissions: 48.7K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target
 * 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ansfirst = 0, anssecond = 1, ansthird = 2;
        int ans = Math.abs(target - (nums[0] + nums[1] + nums[2]));
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            int resultans = target - nums[i];
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int result = resultans - nums[j] - nums[k];

                if (Math.abs(result) < ans) {
                    ans = Math.abs(result);
                    ansfirst = i ; anssecond = j; ansthird = k;
                }

                if (result > 0) {
                    j ++;
                    while (j < k && nums[j] == nums[j-1]) j++;
                } else if (result < 0) {
                    k --;
                    while (j < k && nums[k] == nums[k+1]) k--;
                } else {
                    return target;
                }
            }
        }

        return nums[ansfirst] + nums[anssecond] + nums[ansthird];


    }
}

