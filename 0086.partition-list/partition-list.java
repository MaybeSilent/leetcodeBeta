/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode cur = head;
        ListNode leftList = new ListNode(-1) , rightList = new ListNode(-1);
        ListNode left = leftList , right = rightList;
        while(cur != null){
            if(cur.val < x){
                left.next = cur;
                left = left.next;
            } else{
                right.next = cur;
                right = right.next;
            }
            cur = cur.next;
        }
        left.next = rightList.next;
        right.next = null;
        return leftList.next;
    }
}