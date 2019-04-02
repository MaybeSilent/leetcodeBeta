/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.size() == 0){
            intervals.add(newInterval);
            return intervals;
        }
        int length = intervals.size() - 1;
        int startPos = binarySearch(0,length,intervals,newInterval,0);
        //System.out.println(startPos);
        //System.out.println(startPos);
        if(startPos == intervals.size() && newInterval.start > intervals.get(intervals.size()-1).end){
            intervals.add(newInterval);
            return intervals;
        }
        if(startPos - 1 >= 0 && newInterval.start <= intervals.get(startPos-1).end) startPos = startPos - 1;
        
        int endPos = binarySearch(0,length,intervals,newInterval,1);
        if(endPos == intervals.size()) endPos --;
        if(endPos == 0 && newInterval.end < intervals.get(0).start){
            intervals.add(0,newInterval);
            return intervals;
        }
        if(endPos - 1 >= 0 && newInterval.end < intervals.get(endPos).start) endPos = endPos - 1;
        
        //System.out.println(startPos + " " + endPos);
        
        int startVal = Math.min(newInterval.start,intervals.get(startPos).start) ;
        int endVal = Math.max(newInterval.end,intervals.get(endPos).end);
        
        Interval insert = new Interval(startVal,endVal);
        
        for(int i = startPos ; i <= endPos ; i++){
            intervals.remove(i); i--;endPos--;
        }
        intervals.add(startPos,insert);
        
        return intervals;
    }
    private int binarySearch(int start , int end , List<Interval> intervals , Interval newInterval , int kind){
        while(start <= end){
            int mid = (start+end)/2;
            int comValue = 0 , midValue = 0;
            if(kind == 0){
                midValue = intervals.get(mid).start;
                comValue = newInterval.start;
            } else {
                midValue = intervals.get(mid).end;
                comValue = newInterval.end;
            }
            if(comValue < midValue){
                end = mid - 1;
            } else if(comValue > midValue){
                start = mid + 1;
            } else return mid;
        }
        return start;
    }
}