class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;
        int index = 0;
        while(index < nums.length){
            if(nums[index] > 0 && nums[index] <= nums.length && nums[index] != index+1){
                int temp = nums[nums[index]-1];
                nums[nums[index]-1] = nums[index];
                if(nums[index] == temp) nums[index] = -1;
                else nums[index] = temp;
            } else {
                index++;
            }
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }
}