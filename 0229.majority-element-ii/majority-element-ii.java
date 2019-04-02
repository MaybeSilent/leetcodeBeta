class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> array = new ArrayList<Integer>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0 ; i < nums.length ; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            } else {
                map.put(nums[i],1);
            }
        }
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<Integer,Integer> entry = (Map.Entry)iter.next();
            //System.out.println(entry.getValue());
            int value = entry.getValue();
            if(value > nums.length/3){
                array.add(entry.getKey());
            }
        }
        return array;
    }
}