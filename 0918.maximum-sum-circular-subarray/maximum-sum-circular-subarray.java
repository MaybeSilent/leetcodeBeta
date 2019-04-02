class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int[] B = change(A);
        if(B.length == 0) return 0;
        int max = B[0];
        for(int i = 0 ; i < B.length ; i++){
            int temp = caculate(B,i);
            if(temp > max) max = temp;
        }
        return max;
    }
    private int[] change(int[] A){
        ArrayList<Integer> array = new ArrayList<Integer>();
        int addResult = 0;
        for(int i = 0 ; i < A.length ; i++){
            if(A[i] < 0){
                if(addResult != 0) array.add(addResult);
                addResult = 0;
                array.add(A[i]);
            } else{
                addResult += A[i];
            }
        }
        if(addResult > 0) array.add(addResult);
        int[] result = new int[array.size()];
        for(int i = 0 ; i < array.size() ; i++){
            result[i] = array.get(i);
        }
        return result;
    }
    private int caculate(int[] A, int index){
        if(A[index] < 0) return A[index];
        int result = A[index];
        int compare = A[index];
        for(int i = (index + 1)%A.length ; i%A.length != index ; i=(i+1)%A.length){
            compare += A[i];
            if(compare < 0) break;
            if(compare > result){
                result = compare;
            }
        }
        return result;
    }
}