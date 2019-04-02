import java.util.*;

/*
 * @lc app=leetcode.cn id=500 lang=java
 *
 * [500] 键盘行
 *
 * https://leetcode-cn.com/problems/keyboard-row/description/
 *
 * algorithms
 * Easy (64.53%)
 * Total Accepted:    5.3K
 * Total Submissions: 8.2K
 * Testcase Example:  '["Hello","Alaska","Dad","Peace"]'
 *
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 * 
 * 
 * 
 * 
 * 注意：
 * 
 * 
 * 你可以重复使用键盘上同一字符。
 * 你可以假设输入的字符串将只包含字母。
 * 
 */
class Solution {
    public String[] findWords(String[] words) {
        HashSet<Character> first = new HashSet<>();
        first.add('q');
        first.add('w');
        first.add('e');
        first.add('r');
        first.add('t');
        first.add('y');
        first.add('u');
        first.add('i');
        first.add('o');
        first.add('p');


        HashSet<Character> second = new HashSet<>();
        second.add('a');
        second.add('s');
        second.add('d');
        second.add('f');
        second.add('g');
        second.add('h');
        second.add('j');
        second.add('k');
        second.add('l');
        HashSet<Character> third = new HashSet<>();
        third.add('z');
        third.add('x');
        third.add('c');
        third.add('v');
        third.add('b');
        third.add('n');
        third.add('m');
        

        ArrayList<HashSet<Character>> all = new ArrayList<>();
        all.add(first); all.add(second); all.add(third);
        
        ArrayList<String> array = new ArrayList<>();
        for(String word : words){
            char[] str = word.toLowerCase().toCharArray();
            int count = 0;
            for(int i = 0 ; i < 3 ; i++){
                if(count == 0){
                    while(count < str.length) {
                        if(all.get(i).contains(str[count])){
                            count ++;
                        } else break;
                    }
                }
            }

            if(count == word.length()){
                array.add(word);
            }
        }

        return  array.toArray(new String[array.size()]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = solution.findWords(new String[] {"Hello", "Alaska", "Dad", "Peace"});
        for(String str : strs){
            System.out.println(str);
        }
    }
}

