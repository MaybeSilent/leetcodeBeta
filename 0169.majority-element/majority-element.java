import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 求众数
 *
 * https://leetcode-cn.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (57.13%)
 * Total Accepted:    26.4K
 * Total Submissions: 45.5K
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 
 * 示例 1:
 * 
 * 输入: [3,2,3]
 * 输出: 3
 * 
 * 示例 2:
 * 
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * 
 * 
 */
class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1) return nums[0];
        int halfNum = nums.length / 2;
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!maps.containsKey(nums[i]))
                maps.put(nums[i], 1);
            else {
                int count = maps.get(nums[i]) + 1;
                if (count > halfNum) {
                    return nums[i];
                }
                maps.put(nums[i], count);
            }
        }
        return 0;
    }
}
