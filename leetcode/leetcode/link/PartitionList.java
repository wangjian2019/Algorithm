package leetcode.link;

import org.junit.Test;

/**
 * Partition List
 * 
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x. You should preserve the
 * original relative order of the nodes in each of the two partitions. 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
 * 题解：
 * new两个新链表，一个用来创建所有大于等于x的链表，一个用来创建所有小于x的链表。
 * 遍历整个链表时，当当前node的val小于x时，接在小链表上，反之，接在大链表上。这样就保证了相对顺序没有改变，而仅仅对链表做了与x的比较判断。
 * 最后，把小链表接在大链表上，别忘了把大链表的结尾赋成null。
 * 
 * 原始链表：
 * 1->4->3->2->5->2
 * 创建的两个链表：
 * 1->2->2
 * 4->3->5
 * 合并连接这两个链表
 * 1->2->2->4->3->5
 * 
 * 
 * 
 * 
 * 
 * 
 * @author Alvin
 *
 */
public class PartitionList {
	
	@Test
	public void test() {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(2);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		partition(head, 3);
	}

	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;
		
		//new两个新链表，一个用来创建所有大于等于x的链表，一个用来创建所有小于x的链表。
		ListNode small = new ListNode(-1);
		ListNode newsmallhead = small;
		ListNode big = new ListNode(-1);
		ListNode newbighead = big;

		while (head != null) {
			if (head.value < x) {
				small.next = head;
				small = small.next;
			} else {
				big.next = head;
				big = big.next;
			}
			head = head.next;
		}
		big.next = null;
		small.next = newbighead.next;
		return newsmallhead.next;
	}
	
	private class ListNode {
		int value;
		ListNode next;

		ListNode(int value) {
			this.value = value;
		}
	}
}
