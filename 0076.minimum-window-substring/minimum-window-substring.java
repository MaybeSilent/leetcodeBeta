class Solution {
    public String minWindow(String s, String t) {
        int count = 0;
        int minResult = Integer.MAX_VALUE;
        int start = 0 , end = 0;
        int[] countArray = new int[t.length()];
        HashMap<Character,Integer> map = new HashMap();
        for(int i = 0 ; i < t.length() ; i++){
            if(!map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),count);
                countArray[count++] = 1;
            } else {
                countArray[map.get(t.charAt(i))] ++;
            }
        }
        LinkedList<Integer> record = new LinkedList<Integer>();
        for(int i = 0 ; i < s.length() ; i++){
            if(map.containsKey(s.charAt(i))){
                record.add(i);
                countArray[map.get(s.charAt(i))] -- ;
                while(isValid(countArray,count)){
                    int length = record.get(record.size()-1) - record.get(0);
                    if(minResult > length){
                        minResult = length;
                        start = record.get(0);
                        end = record.get(record.size()-1);
                    }
                    int index = record.removeFirst();
                    countArray[map.get(s.charAt(index))] ++ ;
                }
            }
        }
        if(minResult == Integer.MAX_VALUE) return "";
        else{
            return s.substring(start,end+1);
        }
    }
    private boolean isValid(int[] countArray, int count){
        for(int i = 0 ; i < count ; i++){
            if(countArray[i] > 0) return false;
        }
        return true;
    }
}