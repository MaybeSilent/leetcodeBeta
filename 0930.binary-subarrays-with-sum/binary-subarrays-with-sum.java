class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        if(A.length == 0) return 0;
        int count = 0;
        int afterPos = 0;
        int sum = A[0];
        int resultSum = 0;
        int[] sums = new int[A.length];
        for(int i = 0 ; i < A.length ; i++){
            boolean after = false;
            if(afterPos < i){
                afterPos = i;
                sum = 0;
                if(A[i] == 1) sum ++;
            }
            //System.out.println(i + " " + afterPos);
            for(int j = afterPos ; j < A.length ; j++){
                if(A[j] == 1 && j != afterPos) sum ++;
                //System.out.println(i + " " + j + " " + afterPos + " " + sum);
                if(sum == S){
                    if(!after){
                        afterPos = j;
                    }
                    after = true;
                    count ++;
                }
                if(sum > S){
                    break;
                }
            }
            if(sum < S) break;
            if(A[i] == 1) sum = S-1;
            else sum = S;
        }
        return count;
    }
}