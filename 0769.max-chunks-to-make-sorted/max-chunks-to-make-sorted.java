class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] result = new int[arr.length];
        for(int i = 0 ; i < result.length ; i++){
            result[i] = i;
        }
        for(int i = arr.length - 1 ; i >= 0 ; i --){
            if(result[i] > arr[i] && result[i] != result[arr[i]]){
                for(int j = arr[i] ; j < result[i] ; j++){
                    result[j] = result[i];
                }
            }
        }
        int count = 0;
        int index = -1;
        for(int i = 0 ; i < arr.length ; i++){
            if(result[i] != index){
                index = result[i];
                count ++;
            }
        }
        return count;
    }
}