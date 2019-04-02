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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack st = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        
        st.push(root);
        TreeNode nowNode = root.left;
        
        while(!st.isEmpty()){
            while(nowNode != null){
                st.push(nowNode);
                nowNode = nowNode.left;
            }
            TreeNode before = null;
            while(!st.isEmpty()){
                nowNode = (TreeNode)st.pop();
                if(nowNode.right == before){
                    result.add(nowNode.val);
                    before = nowNode;
                } else {
                    st.push(nowNode);
                    nowNode = nowNode.right;
                    break;
                }
            }
        }
        return result;
    }
}