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
    public void recoverTree(TreeNode root) {
        
        ArrayList<TreeNode> vals = new ArrayList<TreeNode>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode nowNode = root;
        
        while(!st.isEmpty() || nowNode!=null){
            while(nowNode != null){
                st.push(nowNode);
                nowNode = nowNode.left;
            }
            nowNode = (TreeNode)st.pop();
            vals.add(nowNode);
            nowNode = nowNode.right;
        }
        int before = 0 , after = 0;
        for(int i = 0 ; i < vals.size() - 1 ; i++){
            if(vals.get(i).val > vals.get(i+1).val){
                before = i;break;
            }
        }
        for(int i = vals.size() - 1 ; i > 0 ; i--){
            if(vals.get(i).val < vals.get(i-1).val){
                after = i;break;
            }
        }
        
        
        int temp = vals.get(before).val;
        vals.get(before).val = vals.get(after).val;
        vals.get(after).val = temp;
    }
}