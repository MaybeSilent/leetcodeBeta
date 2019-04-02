class Solution {
    private int last;
    private List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        last = nums.length;
        boolean[] visited = new boolean[nums.length];
        getPermutation(visited , nums , 0);
        return ans;
    }
    private void getPermutation(boolean[] visited , int[] nums , int index ){
        if(index == last){
            ArrayList<Integer> result = new ArrayList<Integer>();
            for(int i = 0 ; i < index  ; i++){
                if(visited[i]) result.add(nums[i]);
            }
            ans.add(result);
            return ;
        }
        getPermutation(visited , nums , index + 1);
        visited[index] = true;
        getPermutation(visited , nums , index + 1);
        visited[index] = false;
    }
}