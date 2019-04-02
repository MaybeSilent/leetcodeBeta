class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;
        ListNode first = head;
        ListNode tail = head;
        while(tail.next != null){
            ListNode curNode = tail.next;
            tail.next = tail.next.next;
            if(curNode.val >= tail.val) {
                curNode.next = tail.next;
                tail.next = curNode;
                tail = curNode;
            } else if(curNode.val <= first.val){
                curNode.next = first;
                first = curNode;
            } else {
                ListNode compareNode = first;
                while(compareNode != tail){
                    if(curNode.val < compareNode.next.val){
                        curNode.next = compareNode.next;
                        compareNode.next = curNode;
                        break;
                    } else compareNode = compareNode.next;
                }
            }
            
        }
        return first;
    }
}