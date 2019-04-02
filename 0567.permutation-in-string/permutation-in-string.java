class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int longLen = s2.length();
        int shortLen = s1.length();
        
        int[] shortCount = new int[26];
        int[] longCount = new int[26];
        
        if(longLen < shortLen) return false;
        
        int start = 0;
        
        for(int i = 0 ; i < shortLen ; i++ ){
            shortCount[s1.charAt(i) - 'a'] ++;
            longCount[s2.charAt(i) - 'a'] ++;
        }
        
        while(start + shortLen <= longLen){
            if(Arrays.equals(shortCount , longCount)) return true;
            
            if(start + shortLen < longLen){
                longCount[s2.charAt(start) - 'a'] --;
                longCount[s2.charAt(start + shortLen) - 'a'] ++;
            }   else return false ;
            
            start ++;
        }
        
        return false;
    }
}