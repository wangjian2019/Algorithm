package leetcode.link;

import org.junit.Test;

/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative. For example: Given 1->2->3->4->5->nullptr and k = 2, return
 * 4->5->1->2->3->nullp
 * 
 * 题解： 这道题主要先理解题意，就是倒着数k个node，从那开始到结尾和之前那部分对调，那个例子就是，4->5拿前面来，1->2->3拿后面去。 几个特殊：
 * (1)k是可以大于整个list的长度的，所以这时要对k对len取模 (2)如果取模之后得0，相当于不用rotate，直接返回
 * 
 * 先遍历一遍，得出链表长度 len，注意 k 可能大于 len，因此令 k% = len。将尾节点 next 指针，指向首节点，形成一个环，接着往后跑
 * len − k 步，从这里断开，就是要求的结果了。
 * 
 * 
 */
public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0) {
			return head;
		}
		int len = 1;
		ListNode p = head;
		// 求链表长度
		while (p.next != null) {
			len++;
			p = p.next;
		}
		// k是可以大于整个list的长度的，所以这时要对k对len取模
		k = len - k % len;
		// 尾的nest是头，链表变成一个环
		p.next = head;
		for (int step = 0; step < k; step++) {
			p = p.next;
		}
		// 新的头节点
		head = p.next;
		// 断开环
		p.next = null;
		return head;
	}
}

class ListNode {
	int value;
	ListNode next;

	ListNode(int value) {
		this.value = value;
	}

}