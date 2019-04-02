class Solution {
    public String reverseOnlyLetters(String S) {
        char[] result = new char[S.length()];
        int length = 0;
        for(int i = 0 ; i < S.length() ; i++){
            if((S.charAt(i) >= 'a' && S.charAt(i) <= 'z')||(S.charAt(i) >= 'A' && S.charAt(i) <= 'Z')){
                result[length++] = S.charAt(i);
            }
        }
        int reverse = length/2;
        for(int i = 0 ; i < reverse ; i++){
            char temp = result[i];
            result[i] = result[length-1-i];
            result[length-1-i] = temp;
        }
        length = 0;
        StringBuilder saveResult = new StringBuilder();
        for(int i = 0 ; i < S.length() ; i++){
            if((S.charAt(i) >= 'a' && S.charAt(i) <= 'z')||(S.charAt(i) >= 'A' && S.charAt(i) <= 'Z')){
                saveResult.append(result[length++]);
            } else {
                saveResult.append(S.charAt(i));
            }
        }
        return saveResult.toString();
    }
}