class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int fast = 0 , slow = 0;
        while(slow != name.length() && fast < typed.length()){
            if(name.charAt(slow) == typed.charAt(fast)){
                slow ++ ; fast ++;
            } else {
                if(slow != 0 && typed.charAt(fast) == name.charAt(slow - 1)) fast ++;
                else break;
            }
        }
        if(slow != name.length()) return false;
        else return true;
    }
}