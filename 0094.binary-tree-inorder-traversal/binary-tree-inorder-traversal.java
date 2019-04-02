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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack st = new Stack<TreeNode>();
        List result = new ArrayList<Integer>();
        if(root == null) return result;
        st.push(root);
        
        TreeNode nowNode = root.left;
        
        while(!st.isEmpty() || nowNode != null){
            if(nowNode != null){
                st.push(nowNode);
                nowNode = nowNode.left;
            } else{
                nowNode = (TreeNode)st.pop();
                result.add(nowNode.val);
                nowNode = nowNode.right;
            }
        }
        return result;
    }
}