class Solution {
    public int evalRPN(String[] tokens) {
        Stack st = new Stack<Integer>();
        for(int i = 0  ; i < tokens.length ; i ++){
            int sign = isSignal(tokens[i]);
            if(sign == 0){
                int num1 = (int)st.pop();
                int num2 = (int)st.pop();
                st.push(num1+num2);
            }else if(sign == 1){
                int num1 = (int)st.pop();
                int num2 = (int)st.pop();
                st.push(num2-num1);
            }else if(sign == 2){
                int num1 = (int)st.pop();
                int num2 = (int)st.pop();
                st.push(num1*num2);
            }else if(sign == 3){
                int num1 = (int)st.pop();
                int num2 = (int)st.pop();
                st.push(num2/num1);
            } else {
                st.push(Integer.valueOf(tokens[i]));
            }
        }
        return (int)st.pop();
    }
    private int isSignal(String s){
        if(s.equals("+")) return 0;
        else if(s.equals("-")) return 1;
        else if(s.equals("*")) return 2;
        else if(s.equals("/")) return 3;
        else return 4;
    }
}