/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (57.88%)
 * Total Accepted:    16K
 * Total Submissions: 27.6K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 
 * 
 * 示例:
 * 
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode prev = new ListNode(-1);
        ListNode ans = prev;
        prev.next = head;
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != null && fast != null) {
            prev.next = fast;
            slow.next = fast.next;
            fast.next = slow; 

            
            prev = slow;
            if (slow.next == null) break;
            else {
                slow = slow.next;
                fast = slow.next;
            }
        }

        return ans.next;
    }
}

