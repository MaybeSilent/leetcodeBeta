/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (58.09%)
 * Total Accepted:    39.4K
 * Total Submissions: 67.2K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 反转一个单链表。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    private ListNode ans;

    public ListNode reverseList(ListNode head) {
        // head = recursive(head);
        // if (head != null)
        // head.next = null;
        // return ans;
        ListNode prev, cur, after;
        if (head == null)
            return null;
        else {
            prev = head;
            cur = head.next;
            head.next = null;
        }
        while (cur != null) {
            // System.out.println(cur.val);
            after = cur.next;
            cur.next = prev;
            prev = cur;
            cur = after;
        }
        return prev;

    }

    public ListNode recursive(ListNode head) {
        if (head == null)
            return null;
        ListNode next = recursive(head.next);
        if (next != null)
            next.next = head;
        else {
            ans = head;
        }
        return head;
    }
}
