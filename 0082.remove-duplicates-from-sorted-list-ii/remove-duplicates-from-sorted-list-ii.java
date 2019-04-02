/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode prev = head,cur = head.next;
        ListNode temp = new ListNode(-1);
        ListNode result = temp;
        while(cur != null){
            if(prev.val != cur.val){
                result.next = prev;
                result = result.next;
                prev = cur;
            } else{
                while(cur != null && prev.val == cur.val)
                    cur = cur.next;
                prev = cur;
            }        
            if(cur != null) cur = cur.next;
        }
        if(prev != null){
            result.next = prev;
            result = result.next;
        }
        result.next = null;
        return temp.next;
    }
}