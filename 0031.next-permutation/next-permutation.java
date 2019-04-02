/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 *
 * https://leetcode-cn.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (30.16%)
 * Total Accepted:    9.8K
 * Total Submissions: 32.3K
 * Testcase Example:  '[1,2,3]'
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 
 * 必须原地修改，只允许使用额外常数空间。
 * 
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 */
class Solution {
    public void nextPermutation (int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                for (int j = nums.length - 1; j > 0; j--) {
                    if (nums[j] > nums[i-1]) {
                        swap(nums, i-1, j);
                        int length = (nums.length - i) / 2;
                        //System.out.println(length);
                        for(int k = i; k < i + length; k++){
                            swap(nums, k, nums.length-k-1+i);
                        }
                        return ;
                    }
                }
            }
        }
        reverse(nums);
    }

    private void reverse (int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            swap(nums, i, nums.length - i - 1);
        }
    }

    private void swap(int[] nums, int a, int b) {
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
}

