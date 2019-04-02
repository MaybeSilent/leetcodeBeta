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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList();
        return helper(1,n);
    }
    private ArrayList<TreeNode> helper(int start , int end){
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(start > end){
            result.add(null);
            return result;
        }
        if(start == end){
            result.add(new TreeNode(start));
            return result;
        }
        for(int k = start ; k <= end ; k++){
            ArrayList<TreeNode> left = helper(start , k - 1);
            ArrayList<TreeNode> right = helper(k + 1 , end);
            for(int i = 0 ; i < left.size() ; i ++){
                for(int j = 0 ; j < right.size() ; j ++){
                    TreeNode curNode = new TreeNode(k);
                    curNode.left = left.get(i);
                    curNode.right = right.get(j);
                    result.add(curNode);
                }
            }
        }
        return result;
    }
}