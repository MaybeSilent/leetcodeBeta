class Solution {
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int F = 0;
        for(int i = 0 ; i < A.length ; i++){
            sum += A[i];
            F += i*A[i];
        }
        int result = F;
        for(int i = A.length - 1 ; i > 0 ; i--){
            F = F + sum - (A.length * A[i]) ;
            if(F > result) result = F;
        }
        return result;
    }
}