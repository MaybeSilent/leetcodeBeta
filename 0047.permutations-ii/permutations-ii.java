class Solution {
    private List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        ArrayList<Integer> result = new ArrayList<Integer>();
        Arrays.sort(nums);
        getPermutation(nums , visited , 0 , result);
        return ans;
    }
    private void getPermutation(int[] nums , boolean[] visited , int index , ArrayList<Integer> result){
        if(index == nums.length){
            ans.add(new ArrayList<Integer>(result));
        }
        for(int i = 0 ; i < nums.length ; i ++){
            if( i > 0 && nums[i] == nums[i-1] && visited[i-1] == true ) continue;
            if(!visited[i]){
                visited[i] = true;
                result.add(nums[i]);
                getPermutation(nums , visited , index + 1 , result);
                result.remove(result.size() - 1);
                visited[i] = false;
            }
        }
    }
}