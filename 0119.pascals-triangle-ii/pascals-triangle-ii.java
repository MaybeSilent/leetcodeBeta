import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 *
 * https://leetcode-cn.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (54.01%)
 * Total Accepted:    10.3K
 * Total Submissions: 19K
 * Testcase Example:  '3'
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出: [1,3,3,1]
 * 
 * 
 * 进阶：
 * 
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * 
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        int lastNum = 0;
        ArrayList<Integer> ans = new ArrayList<>(rowIndex+1);
        ans.add(1);
        for (int i = 1; i < rowIndex+1; i++) {
            ans.add(0);
            lastNum = 0;
            for (int j = 0; j < i + 1 ; j++) {
                int temp = ans.get(j);
                ans.set(j, temp + lastNum);
                lastNum = temp;
            }
        }
        return ans;
    }
}
