
/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
 *
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/description/
 *
 * algorithms
 * Hard (33.34%)
 * Total Accepted:    4K
 * Total Submissions: 12K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个非空二叉树，返回其最大路径和。
 * 
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   3
 * 
 * 输出: 6
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-10,9,20,null,null,15,7]
 * 
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * 
 * 输出: 42
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private int maxnum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        recursive(root);
        return maxnum;
    }

    public int recursive(TreeNode root){
        int left_max = 0, right_max = 0;
        if (root.left != null) {
            left_max = recursive(root.left);
        }
        if (root.right != null) {
            right_max = recursive(root.right);
        }

        int nowValue = root.val;
        if (left_max > 0)
            nowValue += left_max;
        if (right_max > 0)
            nowValue += right_max;
        maxnum = Math.max(maxnum, nowValue);
        
        int retVal = root.val;
        int max_value = left_max > right_max ? left_max : right_max ;
        if(max_value > 0)
            retVal += max_value;
        return retVal;
    }
}
/**
 *                    5
 *                 4     8
 *              11     13 4
 *             7  2         1 
 */
