/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode copy = new RandomListNode(-1);
        RandomListNode result = copy;
        while(head != null){
            RandomListNode temp = new RandomListNode(head.label);
            RandomListNode temp_random = head.random == null ? null : new RandomListNode(head.random.label);
            temp.random = temp_random;
            copy.next = temp;
            copy = copy.next;
            head = head.next;
        }
        return result.next;
    }
}