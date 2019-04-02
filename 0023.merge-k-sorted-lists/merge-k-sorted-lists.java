/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        LinkedList<ListNode> result = new LinkedList<ListNode>(Arrays.asList(lists));
        while(result.size() != 1){
            for(int i = 0 ; i < result.size() - 1 ; i += 2){
                result.add(mergeTwoLists(result.get(0),result.get(1)));
                result.removeFirst();result.removeFirst();
            }                
        }
        return result.get(0);
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode head = result;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if(l1 == null) head.next = l2;
        if(l2 == null) head.next = l1;
        return result.next;
    }
}