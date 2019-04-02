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
    public void flatten(TreeNode root) {
        while(root != null){
            if(root.left != null){
                TreeNode temp = root.right;
                root.right = root.left;
                TreeNode lastRight = root.left;
                root.left = null;
                while(lastRight.right != null) lastRight = lastRight.right;
                lastRight.right = temp;
            }
            root = root.right;
        }
    }
}