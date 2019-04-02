import java.util.*;
class Solution {
    public int lastRemaining(int n) {
        boolean isleft = true;
        int start = 1; int end = n;
        int distance = 1;
        if(start == end) return 1;
        while(end - start >= 0){
            int nums = (end - start)/distance + 1;
            if(nums == 2){
                if(isleft) return end;
                else return start;
            }
            if(start == end) return start;
            if(isleft){
                start = start + distance;
                isleft = false;
                if(nums%2 != 0) end = end - distance;
            } else{
                end = end - distance;
                isleft = true;
                if(nums%2 != 0) start = start + distance;
            }
            distance *= 2;
        }
        return 0;
    }
}