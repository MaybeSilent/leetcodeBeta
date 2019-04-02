import java.util.*;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (44.58%)
 * Total Accepted:    246.7K
 * Total Submissions: 553.4K
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 
 * 
 */
class Solution {

    public int[] twoSum(int[] nums, int target){
        int[] arrayCopy = new int[nums.length];
        System.arraycopy(nums , 0 , arrayCopy , 0 , nums.length);

        Arrays.sort(nums);
        int start = 0 ;
        int end = nums.length - 1;

        int compareNum = nums[start] + nums[end];
        while(compareNum != target){
            if(compareNum < target) start++;
            else end--;
            if(start >= end) break;
            compareNum = nums[start] + nums[end];
        }

        if(start >= end) return null; //按照题意不可能发生

        int[] result = new int[2];
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(arrayCopy[i] == nums[start] || arrayCopy[i] == nums[end]){
                result[count++] = i;
                if(count == 2) return result;
            }
        }
        return null;

    }

    public int[] twoSumHash(int[] nums, int target) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            //先不放入自己
            int anotherNum = target - nums[i];
            if(map.containsKey(anotherNum)){
                return new int[]{map.get(anotherNum) , i};
            } else {
                map.put(nums[i],i);
            }
            //map.put();
        }

        return null;
        /**
         * 错误写法，先将所有值存入map之中，这样对于两个相同的数字无法进行相应的判断
         */

        /*
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i ++){
            map.put(nums[i] , i);
        }
        for(int num : map.keySet()){
            int anotherNum = target - num ;
            if(map.containsKey(anotherNum)){
                if(map.get(anotherNum) != map.get(num)){
                    return new int[]{map.get(anotherNum) , map.get(num)};
                } else continue;
            }
        }

        return null;
        */
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = null;
        result = solution.twoSum(new int[]{3,2,4} , 6);
        if(result == null){
            System.out.println("Error Happened !!!");
            return ;
        }
        for(int i : result){
            System.out.println(i); 
        }
    }
}

