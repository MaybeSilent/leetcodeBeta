class Solution {
    private List<List<String>> result = new ArrayList<List<String>>();
    private int lineNum;
    public List<List<String>> solveNQueens(int n) {
        boolean[][] valid = new boolean[n][n];
        lineNum = n;
        dfs(valid,0);
        return result;
    }
    private void dfs(boolean[][] visited , int lines){
        if(lines == lineNum){
            ArrayList<String> ans = new ArrayList<String>();
            for(int i = 0 ; i < lineNum ; i++){
                StringBuilder strb = new StringBuilder();
                //System.out.println(position.get(i));
                for(int j = 0 ; j < lineNum ; j++){
                    if(visited[i][j]){
                        strb.append('Q');
                    } else {
                        strb.append('.');
                    }
                }
                ans.add(strb.toString());
            }
            result.add(ans);
        } else {
            for(int i = 0 ; i < lineNum ; i++){
                if(canVisited(visited , lines , i)){
                    visited[lines][i] = true;
                    dfs(visited, lines+1);
                    visited[lines][i] = false;
                }
            }
        }
    }
    
    private boolean canVisited(boolean[][] visited , int x , int y){
        for(int i = 0 ; i < x ; i++){
            if(visited[i][y]) return false;
        }
        for(int i = x , j = y ; i >= 0 && j < lineNum ; i-- , j++){
            if(visited[i][j]) return false;
        }
        for(int i = x , j = y ; i >= 0 && j >= 0 ; i-- , j--){
            if(visited[i][j]) return false;
        }
        return true;
    }
}