import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (36.34%)
 * Total Accepted:    46.9K
 * Total Submissions: 128.9K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * 
 * 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "()[]{}"
 * 输出: true
 * 
 * 
 * 示例 3:
 * 
 * 输入: "(]"
 * 输出: false
 * 
 * 
 * 示例 4:
 * 
 * 输入: "([)]"
 * 输出: false
 * 
 * 
 * 示例 5:
 * 
 * 输入: "{[]}"
 * 输出: true
 * 
 */
class Solution {
    public boolean isValid(String s) {
        char[] carray = s.toCharArray();
        char[] stack = new char[s.length()];
        int count = 0 ;
        for(int i = 0 ; i < carray.length ; i++){
            if(carray[i] == '(' || carray[i] == '{' || carray[i] == '[') stack[count++] = carray[i];
            else {
                if(count - 1 >= 0 && match(stack[count - 1]) == carray[i]) count --;
                else{
                    return false;
                }
            }
        }
        if(count != 0) return false;
        return true;
        
    }
    private char match(char in){
        if(in == '(') return ')';
        if(in == '{') return '}';
        if(in == '[') return ']';
        return ' '; //不应该执行
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("{[]}"));
        System.out.println(solution.isValid("()[]{}"));

    }
}

