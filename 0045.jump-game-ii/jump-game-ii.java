class Solution {
    public int jump(int[] nums) {
        if(nums.length == 0||nums.length == 1) return 0;
        int[] minjump = new int[nums.length];
        int max = 0;
        minjump[0] = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] + i <= max) continue;
            else max = nums[i] + i;
            for(int j = i+1 ; j <= nums[i]+i ; j++){
                if(minjump[j] == 0) minjump[j] = minjump[i] + 1;
                if(j == (nums.length - 1)) return minjump[j];
            }
        }
        return 0; // can't reach here
    }
}