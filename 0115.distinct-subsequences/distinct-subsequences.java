class Solution {
    public int numDistinct(String s, String t) {
        int x = t.length();
        int y = s.length();
        
        int[][] dp = new int[x+1][y+1];
        for(int i = 0 ; i <= x ; i++){
            for(int j = 0 ; j <= y ; j++){
                if(j == 0 && i != 0) dp[i][j] = 0;
                else if(i == 0) dp[i][j] = 1;
                else{
                    if(t.charAt(i-1) == s.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                    else dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[x][y];
    }
}