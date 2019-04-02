/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 *
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (33.24%)
 * Total Accepted:    99.8K
 * Total Submissions: 299.3K
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
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
    private int inNum = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode iter = head;

        while (l1 != null && l2 != null) {
            iter = AdditerNext(iter, l1.val, l2.val);
            l1 = l1.next; 
            l2 = l2.next;
        }
        while (l1 != null) {
            iter = AdditerNext(iter, l1.val, 0);
            l1 = l1.next;
        }
        while (l2 != null) {
            iter = AdditerNext(iter, 0, l2.val);
            l2 = l2.next;
        }
        if (inNum != 0) {
            iter.next = new ListNode(inNum);
            iter = iter.next;
        }
        iter.next = null;
        return head.next;

    }

    private ListNode AdditerNext (ListNode iter, int value1, int value2) {
        int result = value1 + value2 + inNum;
        if (result >= 10) {
            result -= 10;
            inNum = 1;
        } else {
            inNum = 0;
        }

        iter.next = new ListNode(result);
        return iter.next;

    }


}

