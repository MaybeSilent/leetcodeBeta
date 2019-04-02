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
    private int allSum;
    private int target;
    private ArrayList<Integer> tempPath = new ArrayList<Integer>();
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        target = sum;
        SumPath(root);
        return result;
    }
    private void SumPath(TreeNode root){
        if(root == null) return ; 
        allSum += root.val;
        tempPath.add(root.val);
        if(root.left == null && root.right == null){
            if(allSum == target){
                result.add(new ArrayList<Integer>(tempPath));
            } 
        }
        if(root.right != null) SumPath(root.right);
        SumPath(root.left);
        
        allSum -= root.val;
        tempPath.remove(tempPath.size() - 1);
    }
}