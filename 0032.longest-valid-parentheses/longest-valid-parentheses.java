class Solution {
    public int longestValidParentheses(String s) {
        Stack st = new Stack<Integer>();
        Stack right = new Stack<Integer>();
        int result = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '(') st.push(i);
            else{
                if(st.isEmpty()) right.push(i);
                else st.pop();
            }
        }
        if(st.isEmpty()&&right.isEmpty()) result = s.length();
        else{
            int afterIndex = s.length();
            int beforeIndex = 0;
            int n = st.size();
            for(int j = 0 ; j < n ; j++){
                beforeIndex = (int)st.pop();
                if(afterIndex - beforeIndex - 1 > result) result = afterIndex - beforeIndex - 1;
                afterIndex = beforeIndex;
            }
            n = right.size();
            for(int j = 0 ; j < n ; j++){
                beforeIndex = (int)right.pop();
                if(afterIndex - beforeIndex - 1 > result) result = afterIndex - beforeIndex - 1;
                afterIndex = beforeIndex;
            }
            if(beforeIndex > result) result = beforeIndex;
        }
        return result;
    }
}