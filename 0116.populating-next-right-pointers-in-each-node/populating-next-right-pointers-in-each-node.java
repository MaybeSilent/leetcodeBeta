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
        TreeLinkNode startNode = root;
        while(startNode != null){
            TreeLinkNode curNode = startNode;
            TreeLinkNode prevNode = null;
            startNode = null;
            for( ; curNode != null ; curNode = curNode.next){
                if(curNode.left != null){
                    if(startNode == null) startNode = curNode.left;
                    curNode.left.next = curNode.right;
                    if(prevNode != null) prevNode.next = curNode.left;
                    prevNode = curNode.right;
                } else{
                    return ;                    
                }
            }
        }
    }
}