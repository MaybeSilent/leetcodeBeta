class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack st = new Stack<Integer>();
        int index = 0;
        int result = 0;
        while( index < heights.length){
            if(st.isEmpty() || heights[index] > heights[(int)st.peek()]){
                st.push(index++);
            } else {
                int temp = (int)st.pop();
                result = Math.max(result,heights[temp]*(st.isEmpty() ? index : index - (int)st.peek() - 1));
            }
        }
        while(!st.isEmpty()){
            int temp = (int)st.pop();
            result = Math.max(result,heights[temp]*(st.isEmpty() ? index : index - (int)st.peek() - 1));
        }
        return result;
    }
}