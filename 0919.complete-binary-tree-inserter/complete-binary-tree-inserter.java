/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class CBTInserter {
    private TreeNode root;
    private TreeNode nextInsert;
    private ArrayList<TreeNode> array = new ArrayList<TreeNode>();
    public CBTInserter(TreeNode root) {
        this.root = root;
        LinkedList<TreeNode> tree = new LinkedList<TreeNode>();
        tree.add(root);
        while(tree.size() != 0){
            TreeNode temp = tree.removeFirst();
            array.add(temp);
            if(temp.left != null && temp.right != null){
                tree.add(temp.left);
                tree.add(temp.right);
            }else{
                if(temp.left != null) tree.add(temp.left);
                nextInsert = temp;
                while(tree.size() != 0){
                    TreeNode last = tree.removeFirst();
                    array.add(last);
                }
            }
        }
    }
    
    public int insert(int v) {
        int value = nextInsert.val;
        TreeNode insert = new TreeNode(v);
        array.add(insert);
        if(nextInsert.left == null){
            nextInsert.left = insert;
        } else {
            nextInsert.right = insert;
            nextInsert = array.get(array.indexOf(nextInsert) + 1);
        }
        return value;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */