class Solution {
    public int minFlipsMonoIncr(String S) {
        char[] arrayStr = S.toCharArray();
        int countZero=0;
        for(int i = 0 ; i < arrayStr.length ; i++){
            if(arrayStr[i] == '0') countZero ++; 
        }
        int result = Integer.MAX_VALUE;
        int countOne = 0;
        for(int i = 0 ; i < arrayStr.length ; i++){
            //System.out.println(countZero + " " + countOne);
            if(arrayStr[i] == '0'){
                countZero -- ;
                int tempOne = 0;
                for(int j = i-1 ; j >= 0 ; j--){
                    if(arrayStr[j] == '0') break;
                    tempOne ++;
                }
                int temp = countZero + countOne + 1 - tempOne;
                if(temp < result) result = temp;
            } else {
                if(countZero != 0) countOne++;
            }
        }
        if(countOne < result) result = countOne;
        return result;
    }
}