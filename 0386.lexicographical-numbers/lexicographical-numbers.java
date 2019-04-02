class Solution {
    private List<Integer> result = new ArrayList<Integer>();
    private int N;
    public List<Integer> lexicalOrder(int n) {
        N = n;
        for(int i = 1; i <= 9 ; i++){
            dfs(i);
        }
        return result;
    }
    public void dfs(int curresult){
        if(curresult <= N) result.add(curresult);
        else return ;
        for(int i = 0 ; i <= 9 ; i++){
            dfs(curresult*10+i);
        }
        return ;
    }
}