class Solution {
    private int[] Circles;
	public int findCircleNum(int[][] M){
		int stuNum = M.length;
		Circles = new int[stuNum];
		for(int i = 0 ; i < stuNum ; i++) Circles[i] = i;
		for(int i = 0 ; i < stuNum ; i++){
			for(int j = i+1 ; j < stuNum ; j++){
				if(M[i][j] == 1){
					merge(i,j);
				}
			}
		}
		int count = 0;
		for(int i = 0 ; i < stuNum ; i++){
			if(Circles[i] == i){
				count ++;
			}
		}
		return count;
	}
	private int find(int num){
		if(num != Circles[num]){
			return find(Circles[num]);
		} else {
			return num;
		}
	}

	private void merge(int num1 , int num2){
		int fatterNum1 = find(num1);
		int fatherNum2 = find(num2);
		Circles[fatherNum2] = fatterNum1;
	}
}