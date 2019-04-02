import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (66.11%)
 * Total Accepted:    15.7K
 * Total Submissions: 23.6K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */
class Solution {
    private ArrayList<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0) return ans;
        permute(nums , new boolean[nums.length] , new LinkedList<>() );
        return ans;
    }

    public void permute(int[] nums , boolean[] visited , LinkedList<Integer> list){
        if(list.size() == nums.length){
            ArrayList<Integer> array = new ArrayList<>();
            for(int i = 0 ; i < nums.length ; i++){
                array.add(list.get(i));
            }
            ans.add(array);
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(nums[i]);
                permute(nums,visited,list);
                list.removeLast();
                visited[i] = false;
            }
        }
    }
}

