class Solution {
    private int result = Integer.MAX_VALUE;
    public int minFallingPathSum(int[][] A) {
        /*
        for(int i = 0 ; i < A.length ; i++){
            for(int j = 0 ; j < A.length ; j++){
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
        */
        
        /*
        for(int i = 0 ; i < A.length ; i++){
            dfs(A, 0, i, A[0][i]);
        }
        return result;
        */
        
        int[][] sums = new int[A.length][A.length];
        
        for(int i = 0 ; i < A.length ; i++){
            for(int j = 0 ; j < A.length ; j++){
                if(i == 0) sums[i][j] = A[i][j];
                else {
                    for(int k = -1 ; k <= 1 ; k++){
                        int addY = j+k;
                        if(addY < 0 || addY >= A.length) continue;
                        int Y = A[i][j] + sums[i-1][addY];
                        if(sums[i][j] == 0 || sums[i][j] > Y){
                            sums[i][j] = Y;
                        }
                    }
                }
            }
        }
        for(int i = 0 ; i < A.length ; i++){
            if(sums[A.length-1][i] < result) result = sums[A.length-1][i];
        }
        return result;
        
    }
    private void dfs(int[][] A , int i , int j , int sum){

        if(i + 1 >= A.length){
            if(sum < result) result = sum;
            return ;
        }
        int addX = i + 1;
        for(int k = -1 ; k <= 1 ; k++){
            int addY = j + k;
            //System.out.println(">>>>>" + addY + " " + addX);
            if(addY < 0 || addY >= A.length) continue;
            //System.out.println(sum + " " + A[addX][addY]);
            dfs(A, addX, addY, sum+A[addX][addY]);
        }
    }
}