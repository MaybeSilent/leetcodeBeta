class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length <= 1) return false;
        int[] count = new int[10005];
        int kind = 0;
        int[] indexs = new int[2];
        int countkind = 0;
        for(int i = 0 ; i < deck.length ; i++){
            if(count[deck[i]] == 0){
                if(countkind < 2) indexs[countkind++] = deck[i];
                kind++;
            }
            count[deck[i]] ++;
        }
        
        if(kind == 1) return true;
        
        int first = count[indexs[0]];
        int second = count[indexs[1]];
        
        int min = gcd(first,second);
        //System.out.println(first + " " + second + " " + min);
        if(min == 1) return false;
        //System.out.println(min);
        for(int i = 0 ; i < deck.length ; i++){
            if(count[deck[i]] != 0 && count[deck[i]]%min != 0){
                int last = gcd(count[deck[i]],min);
                if(last!=1){
                    min = last;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
    private int gcd(int a, int b){
        if(b == 0) return a;
        for(int r = a%b ; r != 0 ; r = a%b){
            a = b;
            b = r;
        }
        return b;
    }
}