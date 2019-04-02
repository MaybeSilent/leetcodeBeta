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
    private int ans;
    private int TempSum;
    public int sumNumbers(TreeNode root) {
        if(root == null) return ans;
        TempSum += root.val;
        if(root.left == null && root.right == null){
            ans += TempSum;
            TempSum -= root.val;
            return ans; // end the process;
        }
        TempSum *= 10;
        sumNumbers(root.left);
        sumNumbers(root.right);
        TempSum /= 10;
        TempSum -= root.val;
        return ans;
    }
}