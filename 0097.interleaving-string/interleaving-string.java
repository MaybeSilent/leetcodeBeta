class Solution {
    private int length1;
    private int length2;
    private int length3;
    private boolean flag;
    public boolean isInterleave(String s1, String s2, String s3) {
        length1 = s1.length();
        length2 = s2.length();
        length3 = s3.length();
        if(length3 != length1 + length2) return false;
        
        return dfs(s1,s2,s3,0,0,0);
        
    }
    
    private boolean dfs(String s1, String s2, String s3, int i, int j, int index){
        if(index == length3){
            return true;
        } else {
            if(i < length1 && s3.charAt(index) == s1.charAt(i)){
                if(dfs(s1,s2,s3,i+1,j,index+1)) return true;
            }
            if(j < length2 && s3.charAt(index) == s2.charAt(j)){
                if(dfs(s1,s2,s3,i,j+1,index+1)) return true;
            }
        }
        return false;
    }
}