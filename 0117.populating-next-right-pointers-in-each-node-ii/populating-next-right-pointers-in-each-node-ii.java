/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        while(root != null){
            TreeLinkNode startNode = null;
            TreeLinkNode prevNode = null;
            for( ; root != null ; root = root.next ){
                if(startNode == null) startNode = (root.left != null) ? root.left : root.right;
                if(root.left != null){
                    if(prevNode != null) prevNode.next = root.left;
                    prevNode = root.left;
                }
                if(root.right != null){
                    if(prevNode != null) prevNode.next = root.right;
                    prevNode = root.right;
                }
            }
            root = startNode;
        }
    }
}