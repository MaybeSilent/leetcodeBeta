import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 *
 * https://leetcode-cn.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (59.88%)
 * Total Accepted:    16.8K
 * Total Submissions: 28.1K
 * Testcase Example:  '5'
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 5
 * 输出:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0) return new ArrayList<List<Integer>>();
        ArrayList<Integer> prev = null;
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();

        prev = new ArrayList<Integer>();
        prev.add(1);
        ans.add(prev);
        
        for(int i = 1 ; i < numRows ; i++){
            ArrayList<Integer> sublist = new ArrayList<>();
            for(int j = 0 ; j <= i ; j++){
                int subans = 0;
                if(j - 1 >= 0){
                    subans += prev.get(j - 1);
                }
                if(j < prev.size()){
                    subans += prev.get(j);
                }
                sublist.add(subans);
            }
            ans.add(sublist);
            prev = sublist;
        }

        return ans;
    }
}

