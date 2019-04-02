class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        ArrayList<StringBuilder> result = new ArrayList<StringBuilder>();
        result.add(new StringBuilder());
        for(int i = 0 ; i < numRows ; i++){
            result.add(new StringBuilder());
        }


        for(int i = 1; i <= s.length(); i++){
            //System.out.println(getLine(i, numRows) + " " + s.charAt(i-1));
            result.get(getLine(i, numRows)).append(s.charAt(i-1));
        }
        StringBuilder lastString = new StringBuilder();
        for(int i = 1 ; i <= numRows ; i++){
            lastString.append(result.get(i));
        }
        return lastString.toString();
    }
    private int getLine(int index , int numRows){
        int num = index % ((numRows-1)*2); // ? %优先级跟*一样大
        if(num == 0) num = ((numRows-1)*2);
        return num > numRows ? 2*numRows - num : num;
    }
}