import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=414 lang=java
 *
 * [414] 第三大的数
 *
 * https://leetcode-cn.com/problems/third-maximum-number/description/
 *
 * algorithms
 * Easy (30.81%)
 * Total Accepted:    6K
 * Total Submissions: 19.6K
 * Testcase Example:  '[3,2,1]'
 *
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [3, 2, 1]
 * 
 * 输出: 1
 * 
 * 解释: 第三大的数是 1.
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1, 2]
 * 
 * 输出: 2
 * 
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: [2, 2, 3, 1]
 * 
 * 输出: 1
 * 
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 * 
 * 
 */
class Solution {
    public int thirdMax(int[] nums) {
        HashSet<Integer> sets = new HashSet<>();
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sets.add(nums[i]);
            if (nums[i] >= first) {
                if (nums[i] == first) continue;
                third = second;
                second = first;
                first = nums[i];
            } else if (nums[i] >= second) {
                if (nums[i] == second) continue;
                third = second;
                second = nums[i];
            } else if (nums[i] > third) {
                third = nums[i];
            }
        }
        if (sets.size() < 3) return first;
        return third;
    }
}
