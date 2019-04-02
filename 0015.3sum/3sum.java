/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * algorithms
 * Medium (21.41%)
 * Total Accepted:    42.2K
 * Total Submissions: 196.3K
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为：
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //直接暴力求解，算法复杂度为n^3，所以需要优化
        //用hashMap存数据，可以优化到n^2
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) return ans;
        Arrays.sort(nums);

        
        for (int i = 0; i < nums.length - 2; i++){
            if (i - 1 >= 0 && nums[i] == nums[i-1]) continue;
            int num = nums[i];
            if (num > 0) return ans;
            int target = nums[i] * -1;
            for (int j = i + 1, k = nums.length - 1; j < k; ){
                if(nums[j] + nums[k] < target) {
                    j ++;
                    while (j < k && nums[j] == nums[j-1]) j++;
                } else if(nums[j] + nums[k] > target) {
                    k --;
                    while (j < k && nums[k] == nums[k+1]) k--;
                } else {
                    //System.out.println(i + " " + j + " " + k);
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j ++;
                    while (j < k && nums[j] == nums[j-1]) j++;
                    k --;
                    while (j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }

        return ans;
        
    }
}

