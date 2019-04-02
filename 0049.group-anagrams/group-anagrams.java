class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , List<String>> resultMap = new HashMap<String , List<String>>();
        for(int i = 0 ; i < strs.length ; i++){
            char[] strChar = strs[i].toCharArray();
            Arrays.sort(strChar);
            String key = String.valueOf(strChar);
            if(resultMap.containsKey(key)){
                resultMap.get(key).add(strs[i]);
            } else {
                List<String> newStr = new ArrayList<String>();
                newStr.add(strs[i]);
                resultMap.put(key,newStr);
            }
        }
        return new ArrayList(resultMap.values());
    }
}