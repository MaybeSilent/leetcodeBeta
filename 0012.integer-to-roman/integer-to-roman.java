class Solution {
    final int[] index = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    final String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman(int num) {
        /**
        I             1
        IV            4
        V             5
        IX            9
        X             10
        XL            40
        L             50
        XC            90
        C             100
        CD            400
        D             500
        CM            900
        M             1000
        **/
        /**
        HashMap<Integer , String> map = new HashMap<Integer , String>();
        map.put(0,"");map.put(1,"I");map.put(4,"IV");
        map.put(5,"V");map.put(9,"IX");map.put(10,"X");
        map.put(40,"XL");map.put(50,"L");map.put(90,"XC");
        map.put(100,"C");map.put(400,"CD");map.put(500,"D");
        map.put(900,"CM");map.put(1000,"M");
        **/
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < index.length ; i ++){
            int times = num/index[i];
            for(int j = 0 ; j < times ; j++){
                result.append(strs[i]);
            }
            num = num % index[i];
        }
        return result.toString();
        
    }
}