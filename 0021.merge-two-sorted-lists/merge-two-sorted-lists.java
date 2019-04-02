/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (52.37%)
 * Total Accepted:    44.7K
 * Total Submissions: 85.1K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * */

class Solution {
    /**
     * 两种写法，递归或者遍历
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        else if (l2 == null) return l1;

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    public ListNode mergeTwoListsloop(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode tempNode = result;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tempNode.next = l1;
                l1 = l1.next;
            } else {
                tempNode.next = l2;
                l2 = l2.next;
            }
            tempNode = tempNode.next;
        }
        /*
        while(l1 != null){
            tempNode.next = l1;
            tempNode = tempNode.next;
            l1 = l1.next;
        }

        while(l2 != null){
            tempNode.next = l2;
            tempNode = tempNode.next;
            l2 = l2.next;
        }
        */
        if(l1 == null){
            tempNode.next = l2;
        } else {
            tempNode.next = l1;
        }

        return result.next;
    }
}


