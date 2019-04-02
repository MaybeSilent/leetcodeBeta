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
    public List<Integer> preorderTraversal(TreeNode root) {
        List result = new ArrayList<Integer>();
        Stack st = new Stack<TreeNode>(); 
        if(root == null) return result;
        st.push(root);
        while(!st.isEmpty()){
            TreeNode nowNode = (TreeNode)st.pop();
            result.add(nowNode.val);
            
            if(nowNode.right != null) st.push(nowNode.right);
            if(nowNode.left != null) st.push(nowNode.left);
        }
        return result;
    }
}