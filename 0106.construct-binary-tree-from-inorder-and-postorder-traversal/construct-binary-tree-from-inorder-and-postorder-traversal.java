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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return NumBuildTree(inorder , postorder , 0 , 0 , postorder.length);
    }
    private TreeNode NumBuildTree(int[] inorder , int[] postorder , int befStart , int aftStart , int length){
        if(length == 0) return null;
        TreeNode curNode = new TreeNode(postorder[aftStart + length - 1]);
        if(length == 1) return curNode;
        else{
            int indexNum = postorder[aftStart + length - 1];
            int index = 0;
            for(int i = 0 ; i < length ; i ++){
                if(inorder[befStart + i] == indexNum) index = befStart+i;
            }
            curNode.left =  NumBuildTree(inorder , postorder , befStart , aftStart , index - befStart);
            curNode.right =  NumBuildTree(inorder , postorder , index + 1 , aftStart + index - befStart , length - (index - befStart + 1));
        }
        return curNode;
    } 
}