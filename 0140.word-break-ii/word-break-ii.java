class Solution {
    private ArrayList<String>[] pretreatMent; 
    private HashSet<String> wordSets = new HashSet<String>();
    
    private List<String> result = new ArrayList<String>();
    private String s;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        
        for(String word : wordDict){
            wordSets.add(word);
        }
        
        pretreatMent = new ArrayList[s.length()];
        boolean[] reacheable = new boolean[s.length()+1];
        reacheable[0] = true;
        for(int i = 0 ; i < s.length() ; i++){
            pretreatMent[i] = new ArrayList<String>();
            for(String word : wordDict){
                int length = i+word.length();
                if(length > s.length()) continue;
                String newWord = s.substring(i,length);
                if(newWord.equals(word)){
                    if(reacheable[i] == true) reacheable[length] = true;
                    pretreatMent[i].add(newWord);
                }
            }
        }
        
        //System.out.println(reacheable[s.length()]);
        if(!reacheable[s.length()]) return result;
        dfs(0,new ArrayList<String>());
        return result;
    }
    private void dfs(int start, ArrayList<String> array){
        for(String word : pretreatMent[start]){
            int next = start + word.length();
            String newstr = s.substring(start , next);
            if(wordSets.contains(newstr)){
                array.add(newstr);
                if(next != s.length()) dfs(next,array);
                else {
                    StringBuilder strb = new StringBuilder();
                    for(int count = 0 ; count < array.size() ; count++){
                        if(count != 0) strb.append(" ");
                        strb.append(array.get(count));
                    }
                    result.add(strb.toString());
                }
                array.remove(array.size()-1);
            }
        }
    }
}