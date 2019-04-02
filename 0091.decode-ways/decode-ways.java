class Solution {
    public int numDecodings(String s) {
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[0] = 1;
        if(s.charAt(0) != '0') dp[1] = 1;
        for(int i = 2 ; i <= length ; i++){
            if(s.charAt(i-1) != '0') dp[i] = dp[i-1];
            if(isValid(s.charAt(i-2),s.charAt(i-1))){
                if(s.charAt(i-2) != '0') dp[i] += dp[i-2];
            } else{
                if(s.charAt(i-1) == '0') return 0;
            }
        }
        return dp[length];
    }
    private boolean isValid(char first, char second){
        int number = (first-'0')*10+(second-'0');
        if(number < 1 || number > 26) return false;
        return true;
    }
}