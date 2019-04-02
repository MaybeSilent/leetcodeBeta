/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 *
 * https://leetcode-cn.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (26.30%)
 * Total Accepted:    13.4K
 * Total Submissions: 50.1K
 * Testcase Example:  '10'
 *
 * 统计所有小于非负整数 n 的质数的数量。
 * 
 * 示例:
 * 
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 
 * 
 */
class Solution {
    public int countPrimes(int n) {
        boolean[] nums = new boolean[n];
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (!nums[i]) {
                ans++;
            }
            for (int j = i * 2 ; j < n; j += i) {
                nums[j] = true;
            }
        }

        return ans;
    }
}
