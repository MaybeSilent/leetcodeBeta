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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        ArrayList pre = new ArrayList<Integer>();
        for(int i = 0 ; i < preorder.length ; i ++) pre.add(preorder[i]);
        ArrayList after = new ArrayList<Integer>();
        for(int i = 0 ; i < inorder.length ; i ++) after.add(inorder[i]);
        return ArrayBuildTree( pre , after );
    }
    private TreeNode ArrayBuildTree(ArrayList<Integer> preorder , ArrayList<Integer> inorder){
        if(preorder.size() == 0) return null;
        TreeNode curNode = new TreeNode(preorder.get(0));
        if(preorder.size() == 1) return curNode;
        else{
            int splitIndex = inorder.indexOf(preorder.get(0));
            curNode.left = ArrayBuildTree(new ArrayList<Integer>(preorder.subList(1,splitIndex+1)) , 
                                          new ArrayList<Integer>(inorder.subList(0,splitIndex)));
            curNode.right = ArrayBuildTree(new ArrayList<Integer>(preorder.subList(splitIndex+1,preorder.size())) , 
                                          new ArrayList<Integer>(inorder.subList(splitIndex+1,inorder.size())));
        }
        return curNode;
    }
}