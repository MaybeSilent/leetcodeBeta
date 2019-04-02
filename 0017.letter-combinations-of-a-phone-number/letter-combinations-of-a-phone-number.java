/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (48.01%)
 * Total Accepted:    18.3K
 * Total Submissions: 38K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 */
class Solution {
    public List<String> letterCombinations(String digits) {

        if(digits.length() == 0) return new ArrayList<>();
        char[] input = digits.toCharArray();
        
        HashMap<Character,char[]> maps = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        maps.put('2',"abc".toCharArray());
        maps.put('3',"def".toCharArray());
        maps.put('4',"ghi".toCharArray());
        maps.put('5',"jkl".toCharArray());
        maps.put('6',"mno".toCharArray());
        maps.put('7',"pqrs".toCharArray());
        maps.put('8',"tuv".toCharArray());
        maps.put('9',"wxyz".toCharArray());
        generate(maps,0,ans,input,sb);
        return ans;
    }

    private void generate(HashMap<Character,char[]> maps, int index, List ans, char[] input, StringBuilder sb) {
        if (index == input.length) {
            ans.add(sb.toString());
        } else {
            char[] chars = maps.get(input[index]);
            for (int i = 0; i < chars.length; i++) {
                sb.append(chars[i]);
                generate(maps,index+1,ans,input,sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }
}

