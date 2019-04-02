import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
 *
 * https://leetcode-cn.com/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (57.37%)
 * Total Accepted:    6.6K
 * Total Submissions: 11.4K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 
 * 输入:
 * 
 * ⁠  1
 * ⁠/   \
 * 2     3
 * ⁠\
 * ⁠ 5
 * 
 * 输出: ["1->2->5", "1->3"]
 * 
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private ArrayList<String> ans = new ArrayList<>();
    private StringBuilder builder = new StringBuilder();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return ans;
        getTrees(root);
        return ans;
    }

    private void getTrees(TreeNode root) {

        int length = builder.length();
        if (builder.length() != 0)
            builder.append("->" + root.val);
        else
            builder.append(root.val);

        if (root.left == null && root.right == null) {
            ans.add(builder.toString());
        }
        if (root.left != null) {
            getTrees(root.left);
        }
        if (root.right != null) {
            getTrees(root.right);
        }
        
        builder.setLength(length);

    }
}
