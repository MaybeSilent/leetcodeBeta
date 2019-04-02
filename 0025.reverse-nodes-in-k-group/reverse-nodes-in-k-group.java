/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode prev = result,count = prev.next;
        while(count!=null){
            count = prev.next;
            for(int i = 1 ; i < k && count != null ; i++){
                count = count.next;
            }
            if(count == null) break;
            
            prev = reverse(prev,prev.next,count);
        }
        return result.next;
    }
    private ListNode reverse(ListNode prev,ListNode begin, ListNode end){
        ListNode cur = begin.next;
        ListNode last = end.next;
        while(cur != last){
            begin.next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur = begin.next;
        }
        return begin;
    }
}