/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 *
 * https://leetcode-cn.com/problems/4sum/description/
 *
 * algorithms
 * Medium (34.55%)
 * Total Accepted:    14.1K
 * Total Submissions: 40.7K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c
 * + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 
 * 注意：
 * 
 * 答案中不可以包含重复的四元组。
 * 
 * 示例：
 * 
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 
 * 满足要求的四元组集合为：
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) return ans;
        Arrays.sort(nums);
        //if (nums[0] > target) return ans;

        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue ;
        
            int threenum = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j-1]) continue;
                int k = j+1, l = nums.length - 1;
                int twonum = threenum - nums[j];
                while (k < l) {
                    int result = nums[k] + nums[l];
                    if (result < twonum) {
                        k ++;
                        while (k < l && nums[k] == nums[k-1]) k++; 
                    } else if (result > twonum) {
                        l --;
                        while (k < l && nums[l] == nums[l+1]) l--;
                    } else {
                        ans.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k ++;
                        while (k < l && nums[k] == nums[k-1]) k++; 
                        l --;
                        while (k < l && nums[l] == nums[l+1]) l--;
                    }
                }
            }
        }
        return ans;
    }
}

