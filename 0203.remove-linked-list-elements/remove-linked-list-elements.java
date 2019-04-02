/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
 *
 * https://leetcode-cn.com/problems/remove-linked-list-elements/description/
 *
 * algorithms
 * Easy (39.25%)
 * Total Accepted:    17.7K
 * Total Submissions: 44.6K
 * Testcase Example:  '[1,2,6,3,4,5,6]\n6'
 *
 * 删除链表中等于给定值 val 的所有节点。
 * 
 * 示例:
 * 
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode curNode = head;
        while (curNode != null) {
            if (curNode.val == val) {
                if (prev != null) {
                    prev.next = curNode.next;
                } else {
                    head = curNode.next;
                }
                curNode = curNode.next;
            } else {
                prev = curNode;
                curNode = curNode.next;
            }

        }

        return head;
    }
}
