class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        return canReserve(s1.toCharArray(),s2.toCharArray(),0,0,s1.length());
    }
    private boolean canReserve(char[] str1, char[] str2, int start1, int start2, int length){
        boolean[] visited = new boolean[length];
        for(int i = 0; i < length; i++){
            boolean found = false; //标记是否找到
            for(int j = 0; j < length; j++){
                if(!visited[j] && str1[start1+i] == str2[start2+j]){
                    visited[j] = true;
                    found = true;
                    break;
                } 
            }
            if(!found) return false;
        }
        if(length <= 3) return true;
        for(int i = 1; i < length; i++){
            boolean flag1 = canReserve(str1,str2,start1,start2,i)&&canReserve(str1,str2,start1+i,start2+i,length-i);
            boolean flag2 = canReserve(str1,str2,start1,start2+length-i,i)&&canReserve(str1,str2,start1+i,start2,length-i);
            if(flag1||flag2) return true;
        }
        return false;
    }
}