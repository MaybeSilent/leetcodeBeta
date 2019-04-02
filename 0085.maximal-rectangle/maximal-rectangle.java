class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if(n == 0) return 0;
        int m = matrix[0].length;
        if(m == 0) return 0;
        int[][] copy = new int[n][m];
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j++){
                if(i != 0 && matrix[i-1][j] != '0' && matrix[i][j] == '1')
                    copy[i][j] = copy[i-1][j] + 1;
                else copy[i][j] = matrix[i][j] - '0';
            }
        }
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            int result = getMaxinLine(copy[i]);
            if(result > ans) ans = result;
        }
        return ans;
    }
    private int getMaxinLine(int[] height){
        int ans = 0;
        for(int i = 0 ; i < height.length ; i++){
            if(i+1 < height.length && height[i] < height[i+1]){
                continue;
            }
            int minHeight = height[i];
            for(int j = i ; j >= 0 ; j --){
                minHeight = Math.min(minHeight , height[j]);
                int area = minHeight*(i-j+1);
                if(area > ans) ans = area;
            }
        }
        return ans;
    }
}