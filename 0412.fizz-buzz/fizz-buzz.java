import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=412 lang=java
 *
 * [412] Fizz Buzz
 *
 * https://leetcode-cn.com/problems/fizz-buzz/description/
 *
 * algorithms
 * Easy (58.35%)
 * Total Accepted:    10.8K
 * Total Submissions: 18.5K
 * Testcase Example:  '1'
 *
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * 
 * 示例：
 * 
 * n = 15,
 * 
 * 返回:
 * [
 * ⁠   "1",
 * ⁠   "2",
 * ⁠   "Fizz",
 * ⁠   "4",
 * ⁠   "Buzz",
 * ⁠   "Fizz",
 * ⁠   "7",
 * ⁠   "8",
 * ⁠   "Fizz",
 * ⁠   "Buzz",
 * ⁠   "11",
 * ⁠   "Fizz",
 * ⁠   "13",
 * ⁠   "14",
 * ⁠   "FizzBuzz"
 * ]
 * 
 * 
 */
class Solution {
    public List<String> fizzBuzz(int n) {
        String[] ans = new String[n+1];
        for (int i = 1; i <= n; i++) {
            ans[i] = String.valueOf(i);
        }

        for (int j = 3; j <= n; j += 3) {
            ans[j] = "Fizz";
        }

        for (int j = 5; j <= n; j += 5) {
            if (ans[j].equals("Fizz")) {
                ans[j] = "FizzBuzz";
            } else {
                ans[j] = "Buzz";
            }
        }
        ArrayList<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            result.add(ans[i]);
        }
        return result;

    }
}
