/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = new ListNode(-1),current = null,temp = null;
        prev.next = head;
        for(int i = 0 ; i < m - 1 ; i++){
            prev = prev.next;
        }
        ListNode begin = prev;
        prev = prev.next;
        ListNode end = prev;
        current = prev.next;
        for(int i = m ; i < n ; i++){
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        end.next = current;
        begin.next = prev;
        if(m==1) return begin.next;
        else return head;
    }
}