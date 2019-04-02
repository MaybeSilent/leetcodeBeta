class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if(words.length == 0 || words[0].length()*words.length > s.length()) return new ArrayList<Integer>();
        
        List<Integer> result = new ArrayList<Integer>();
        
        int wordsLength = words[0].length();
        
        HashSet<Character> firstSet = new HashSet<Character>();
        for(String str : words){
            firstSet.add(str.charAt(0));
        }
        
        for(int i = 0 ; i < s.length() ; i++){
            if(firstSet.contains(s.charAt(i))){
                boolean[] visited = new boolean[words.length];
                int count = 0;
                for(int j = 0 ; j < words.length && i+(j+1)*wordsLength <= s.length(); j++){
                    String curStr = s.substring(i+j*wordsLength,i+(j+1)*wordsLength);
                    //System.out.println(curStr);
                    int k = 0;
                    for(k = 0 ; k < words.length ; k++){
                        if(!visited[k] && words[k].equals(curStr)){
                            visited[k] = true;
                            count ++;
                            break;
                        }
                    }
                    if(k == words.length) break;
                }
                //System.out.println(count);
                if(count == words.length){
                    result.add(i);
                }
            }
        }
        
        return result;
        
    }
}