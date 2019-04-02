class Solution {
    public int minCut(String s) {
        int length = s.length();
        if(length == 0) return -1;
        boolean[][] isValid = new boolean[length][length];
        for(int i = 0 ; i < length ; i++){
            for(int count = 1 ; count + i < length && i - count >= 0 ; count++){
                if(s.charAt(count+i) == s.charAt(i-count)){
                    isValid[i-count][count+i] = true;                
                } else break;
            }
            for(int j = i + 1 , count = 0 ; i - count >= 0 && j + count < length ; count ++){
                if(s.charAt(i-count) == s.charAt(j+count)){
                    isValid[i-count][j+count] = true;
                } else break;
            }
        }
        
        int[] dp = new int[length];
        dp[0] = 0;
        
        //System.out.println(String.valueOf(isValid[0][length-1]));
        for(int i = 1 ; i < length ; i++){
            dp[i] = dp[i-1] + 1;
            for(int j = 0 ; j < i ; j++){
                if(isValid[j][i]){
                    if(j!=0) dp[i] = Math.min(dp[i],dp[j-1] + 1);
                    else{
                        dp[i] = 0;
                        break;
                    }
                }
            }
        }
        
        return dp[length-1];
        
    }
}