/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
 *
 * https://leetcode-cn.com/problems/sum-of-left-leaves/description/
 *
 * algorithms
 * Easy (48.83%)
 * Total Accepted:    4.9K
 * Total Submissions: 10.1K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 计算给定二叉树的所有左叶子之和。
 * 
 * 示例：
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * 
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private int ans = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return ans;
        recursive(root);
        return ans;
    }

    private void recursive(TreeNode root) {
        if (root.left != null) {
            if(root.left.left == null && root.left.right == null) {
                ans += root.left.val;
            }
            recursive(root.left);
        }
        if (root.right != null) {
            recursive(root.right);
        }
    }
}
