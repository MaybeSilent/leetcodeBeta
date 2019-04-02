/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return getBST(head);
    }
    private TreeNode getBST(ListNode headNode){
        ListNode startNode = headNode;
        if(startNode == null) return null;
        if(startNode.next == null) return new TreeNode(startNode.val);
        else if(startNode.next.next == null){
            TreeNode result = new TreeNode(startNode.val);
            result.right = new TreeNode(startNode.next.val);
            return result;
        }
        else {
            ListNode slowNode = startNode;
            ListNode prevNode = startNode;
            while(startNode.next != null && startNode.next.next != null){
                startNode = startNode.next.next;
                prevNode = slowNode;
                slowNode = slowNode.next;
            }
            if(startNode.next != null) startNode = startNode.next;
            TreeNode result = new TreeNode(slowNode.val);
            result.right = getBST(slowNode.next);
            prevNode.next = null;
            result.left = getBST(headNode);
            return result;
        }
    }
}