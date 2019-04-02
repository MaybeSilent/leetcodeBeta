/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (69.00%)
 * Total Accepted:    16.9K
 * Total Submissions: 24.6K
 * Testcase Example:  '3'
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 * 
 */
class Solution {
    private int n ;
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        this.n = n;
        generate(0,0,ans,sb);
        return ans;
    }

    private void generate(int leftNum, int rightNum, List<String> ans, StringBuilder sb) {
        //System.out.println(leftNum + " " + rightNum);
        if (leftNum == rightNum) {
            if (leftNum == n) {
                ans.add(sb.toString());
            } else {
                sb.append('(');
                generate(leftNum+1,rightNum,ans,sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            sb.append(')');
            generate(leftNum,rightNum+1,ans,sb);
            sb.deleteCharAt(sb.length() - 1);
            if (leftNum < n) {
                sb.append('(');
                generate(leftNum+1,rightNum,ans,sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}

