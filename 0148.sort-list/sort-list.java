class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }


        fast = slow.next;
        slow.next = null;

        ListNode l1 = sortList(fast);
        ListNode l2 = sortList(head);
        return mergeSort(l1,l2);
    }
    private ListNode mergeSort(ListNode l1 , ListNode l2){
        
        if(l1 == null){
            return l2;
        } else if(l2 == null){
            return l1;
        } else if(l1.val < l2.val){
            l1.next = mergeSort(l1.next , l2);
            return l1;
        } else {
            l2.next = mergeSort(l2.next , l1);
            return l2;
        }
    }
}
