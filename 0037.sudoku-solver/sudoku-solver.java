class Solution {
    private boolean[][] rowVisited = new boolean[9][10];
    private boolean[][] cloVisited = new boolean[9][10];
    private boolean[][][] subVisited = new boolean[3][3][10];
    public void solveSudoku(char[][] board) {
        
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                if(board[i][j] != '.'){
                    rowVisited[i][board[i][j]-'0'] = true;
                    cloVisited[j][board[i][j]-'0'] = true;
                    subVisited[i/3][j/3][board[i][j]-'0'] = true;
                }
            }
        }
        
        dfs(board);
    }
    private boolean dfs(char[][] board){
        boolean flag = true;
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 1 ; j <= 9 ; j++){
                if(rowVisited[i][j] == false) flag = false;
            }
        }
        //System.out.println(flag);
        if(flag) return true;
        else {
            for(int i = 0 ; i < 9 ; i++){
                for(int j = 0 ; j < 9 ; j++){
                    if(board[i][j] == '.'){
                        for(int k = 1 ; k <= 9 ; k++){
                            if(!rowVisited[i][k] && !cloVisited[j][k] && !subVisited[i/3][j/3][k]){
                                board[i][j] = (char)(k+'0');
                                //System.out.println(board[i][j]);
                                rowVisited[i][k] = true;
                                cloVisited[j][k] = true;
                                subVisited[i/3][j/3][k] = true;
                                if(dfs(board)) return true;
                                board[i][j] = '.';
                                rowVisited[i][k] = false;
                                cloVisited[j][k] = false;
                                subVisited[i/3][j/3][k] = false;
                            }
                        }
                        return false;
                    }
                }
            }
        }
        return true;
    }
}