package leetcode.link;

import org.junit.Test;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example, Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *  • Given n will always be valid.
 *  • Try to do this in one pass.
 * 
 * 
 * 题解：设两个指针 p; q，让 q 先走 n 步，然后 p 和 q 一起走，直到 q 走到尾节点，删除 p->next 即可。
 * 
 */
public class RemoveNthNodeFromEndOfList{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;
        // q 先走 n 步
        for (int i = 0; i < n; i++){
            q = q->next;
        } 
        // q,p一起走
        while(q->next) { 
            p = p->next;
            q = q->next;
        }
        ListNode tmp = p.next;
        p.next = p.next.next;
        delete tmp;
        return dummy.next;
    }

    private class ListNode {
		int value;
		ListNode next;

		ListNode(int value) {
			this.value = value;
		}
	}


}