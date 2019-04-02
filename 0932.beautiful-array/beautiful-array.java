class Solution {
    public int[] beautifulArray(int N) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        while(result.size() < N){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for(int i : result) if(i*2-1 <= N) tmp.add(i*2-1);
            for(int i : result) if(i*2 <= N) tmp.add(i*2);
            result = tmp;
        }
        
        return result.stream().mapToInt(i -> i).toArray();
        
    }
}