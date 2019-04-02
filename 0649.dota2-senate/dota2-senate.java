class Solution {
    public String predictPartyVictory(String senate) {
        boolean[] isValid = new boolean[senate.length()];
        int countR = 0 ,countD = 0;
        for(int i = 0 ; i < senate.length() ; i++){
            if(senate.charAt(i) == 'R'){
                countR ++;
            }
        }
        countD = senate.length() - countR;
        
        int i = 0 , j = 0 , index = 0;
        int Rflag = 0, Dflag = 0;
        while(i < countR && j < countD){
            if(!isValid[index]){
                if(senate.charAt(index) == 'R'){
                    if(Dflag != 0){
                        Dflag --;
                        isValid[index] = true;
                        i ++;
                    } else {
                        Rflag ++;
                    }
                } else {
                    if(Rflag != 0){
                        Rflag --;
                        isValid[index] = true;
                        j ++;
                    } else {
                        Dflag ++;
                    }
                }
            }
            index = (index+1) % senate.length();
        }
        if(i == countR) return "Dire";
        else return "Radiant";
    }
}