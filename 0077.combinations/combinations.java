class Solution {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    private int max;
    private int nums;
    public List<List<Integer>> combine(int n, int k) {
        if(k==0) return result;
        max = k; nums = n;
        recursive(1, new ArrayList<Integer>());
        return result;
    }
    private void recursive(int index, ArrayList<Integer> array){
        if(max - array.size() > nums + 1 - index) return; 
        if(array.size() == max){
            result.add(new ArrayList<Integer>(array)); 
        } else {
            array.add(index);
            recursive(index + 1 , array);
            array.remove((Integer)index);
            recursive(index + 1 , array);
        }
    }
}