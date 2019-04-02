/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 *
 * https://leetcode-cn.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (46.53%)
 * Total Accepted:    16.6K
 * Total Submissions: 35.7K
 * Testcase Example:  '"11"\n"1"'
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 
 * 输入为非空字符串且只包含数字 1 和 0。
 * 
 * 示例 1:
 * 
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 
 * 示例 2:
 * 
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 
 */
class Solution {
    public String addBinary(String a, String b) {
        char[] achar = a.toCharArray();
        char[] bchar = b.toCharArray();

        int[] result = new int[Math.max(achar.length, bchar.length) + 1] ;
        int count = 0 ;

        int alen = achar.length - 1;
        int blen = bchar.length - 1;
        while(alen >= 0 && blen >= 0){
            //System.out.println(achar[alen] + " " + bchar[blen] + " " + (achar[alen] + bchar[blen] - 96));
            result[count++] = achar[alen--] + bchar[blen--] - 96; 
        } 
        if(alen < 0){
            while(blen >= 0) result[count ++] = bchar[blen --] - 48;
        } else {
            while(alen >= 0) result[count ++] = achar[alen --] - 48;
        }
        
        //System.out.println(count);
        for(int i = 0 ; i < count ; i++ ){
            //System.out.println(result[i]);
            if(result[i] > 1){
                //System.out.println(i+1 + " " + result.length);
                result[i+1] += result[i] / 2 ;
                result[i] %= 2 ;
            }
            
        }
        if(count < result.length && result[count] != 0 ) count ++;

        char[] ans = new char[count];
        for(int i = 0 ; i < count ; i++ ){
            ans[i] = (char)(result[count - i - 1] + '0');
        }

        return String.valueOf(ans);
        
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("11", "1"));
    }
}

