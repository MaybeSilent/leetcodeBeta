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
    public boolean isValidBST(TreeNode root) {
        return checkBST(root , Double.MAX_VALUE*-1 , Double.MAX_VALUE);
    }
    private boolean checkBST(TreeNode root , double min , double max){
        if(root == null) return true;
        return root.val > min && root.val < max 
            && checkBST(root.left , min , root.val)&& checkBST(root.right , root.val , max);
    }
}