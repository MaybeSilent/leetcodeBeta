/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 报数
 *
 * https://leetcode-cn.com/problems/count-and-say/description/
 *
 * algorithms
 * Easy (48.10%)
 * Total Accepted:    21.2K
 * Total Submissions: 44.1K
 * Testcase Example:  '1'
 *
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 
 * 注意：整数顺序将表示为一个字符串。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: "1"
 * 
 * 
 * 示例 2:
 * 
 * 输入: 4
 * 输出: "1211"
 * 
 * 
 */
class Solution {
    public String countAndSay(int n) {
        if(n <= 0) return "";
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        ans.append("1");
        while(n > 1){
            int i = 0;
            for(i = 0 ; i < ans.length() - 1 ; i++){
                if(ans.charAt(i) == ans.charAt(i+1)){
                    int count = 2;
                    while(i + count < ans.length() && ans.charAt(i) == ans.charAt(i+count)){
                        count ++;
                    }
                    i = i + count - 1;
                    //System.out.println(count + ">>>>>>>>>>>");
                    temp.append(String.valueOf(count) + ans.charAt(i));
                } else {
                    temp.append("1" + ans.charAt(i));
                }
            }
            if( i == ans.length() - 1){
                temp.append("1" + ans.charAt(i));
            }

            ans = temp;
            temp = new StringBuilder();
            n --;
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(6));
    }
}

