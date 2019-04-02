/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        int number = 1;
        ListNode loop = head;
        while(loop.next != null){
            number ++;
            loop = loop.next;
        }
        loop.next = head;
        
        int position = number - k%number;
        ListNode fast = head;
        for(int i = 0 ; i < position - 1 ; i++){
            fast = fast.next;
        }
        ListNode result = fast.next;
        fast.next = null;
        return result;
    }
}