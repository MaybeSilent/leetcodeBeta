import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (58.71%)
 * Total Accepted:    10K
 * Total Submissions: 17.1K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其自底向上的层次遍历为：
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
 * 
 * 
 */
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new LinkedList<List<Integer>>();

        LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();

        LinkedList<TreeNode> treearray = new LinkedList<>();
        treearray.add(root);
        while(treearray.size() != 0){
            ArrayList<Integer> subans = new ArrayList<>();
            int num = treearray.size();
            for(int i = 0 ; i < num ; i++){
                TreeNode sub = treearray.removeFirst();
                subans.add(sub.val);
                if(sub.left != null) treearray.add(sub.left);
                if(sub.right != null) treearray.add(sub.right);
            }
            ans.addFirst(subans);
        }

        return ans;
    }
}

