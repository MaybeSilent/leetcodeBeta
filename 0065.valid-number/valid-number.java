class Solution {
    public boolean isNumber(String s) {
        if(s.isEmpty()) return false;
        while(!s.isEmpty() && s.charAt(0) == ' ') s = s.substring(1);
        if(!s.isEmpty() && (s.charAt(0) == '+' || s.charAt(0) == '-')) s = s.substring(1);
        return FSM(s);
    }
    private boolean FSM(String s){
        int state = 0;
        int input = 0;
        
        int[][] transist = {
            {1,5,-1,-1,-1},   // 0 init state
            {1,6,2,4,-1},     // 1 number state
            {3,-1,-1,-1,-1},  // 2 e
            {3,-1,-1,4,-1},   // e + number
            {-1,-1,-1,4,-1},  // space   
            {6,-1,-1,-1,-1},
            {6,-1,2,4,-1}
        };
        
        while(!s.isEmpty()){
            char firstChar = s.charAt(0);
            /**
            input: 0 number
            input: 1 .
            input: 2 e
            input: 3 space
            input: 4 other
            **/
            if(firstChar >= '0' && firstChar <= '9') input = 0;
            else if(firstChar == '.') input = 1;
            else if(firstChar == 'e') input = 2;
            else if(firstChar == ' ') input = 3;
            else input = 4;
            
            state = transist[state][input];
            
            if(state == -1) break;
            s = s.substring(1);
            if(input == 2 && !s.isEmpty() && (s.charAt(0) == '+' || s.charAt(0) == '-')) s = s.substring(1);
        }
        return state == 1 || state == 3 || state == 4 || state == 6;
    }
}