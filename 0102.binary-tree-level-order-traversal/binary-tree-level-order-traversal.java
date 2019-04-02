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
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        Queue que = new LinkedList<TreeNode>();
        if(root == null) return result;
        que.add(root);
        
        while(que.size() != 0){
            int num = que.size();
            ArrayList vals = new ArrayList<Integer>();
            for(int i = 0 ; i < num ; i++){
                TreeNode nowNode = (TreeNode)que.poll();
                if(nowNode.left != null) que.add(nowNode.left);
                if(nowNode.right != null) que.add(nowNode.right);
                vals.add(nowNode.val);
            }
            result.add(vals);
        }
        return result;
    }
}