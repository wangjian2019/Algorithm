package leetcode.link;


/**
 * Reorder List
 * 
 * Given a singly linked list L : L0 ! L1 ! · · · ! Ln−1 ! Ln, reorder it to: L0 ! Ln ! L1 !
 * Ln−1 ! L2 ! Ln−2 ! · · ·
 * You must do this in-place without altering the nodes’ values.
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}
 * 
 * 题解：
 *  题目规定要 in-place，也就是说只能使用 O(1) 的空间。可以找到中间节点，断开，把后半截单链表 reverse 一下，再合并两个单链表。
 * 
 *  1->2->3->4
 *  1->2->null  3->4
 *  1->2->null  4->3
 *  |           |
 * pre          last
 * 1->2->null  4->3
 *    |           |
 *   pre         last
 * 
 * 1->4->2->3
 * 
 */
public class Reorderist{

    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        } 
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        //找到中间节点
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // cut at middle, 中间节点的前一个节点的next变为null
        prev.next = null; 
        // 将中间节点后面的节点做链表倒置
        slow = reverse(slow);
        // merge two lists
        ListNode curr = head;
        while (curr.next != null) {
            ListNode tmp = curr.next;
            curr.next = slow;
            slow = slow.next;
            curr.next.next = tmp;
            curr = tmp;
        }
        curr.next = slow;
    }

	public ListNode reverse(ListNode head){
		if(head == null){
			return null;
		}
		if(head.next == null){
			return head;
		}
		if(head.next.next == null){
			ListNode listNode = head.next;
			listNode.next = head;
			head.next = null;
			return listNode;
		}
		ListNode previous = head;
		ListNode current = head.next;
		ListNode temp = head.next.next;
		//当前的头结点将会变成反转之后链表的尾节点，所以尾节点的next是null
		//把头节点和后面节点断开
		head.next = null;
		while (current.next != null) {
			//第一次循环进来的时候，previous节点指的是头结点，此时头结点的next是null
			//把当前current节点的next原本是指向后一个的节点，现在改为指向前一个的节点，此时有两个链表的存在
			current.next = previous;
			//previous,current,temp三个指针同时往后移动一步
			previous = current;
			current = temp;
			temp = temp.next;
		}
		//遍历到最后节点，前面循环跳出，把最后节点的next指向前一个即可
		current.next = previous;
		return current;
	}

    private class ListNode {
		int value;
		ListNode next;

		ListNode(int value) {
			this.value = value;
		}
	}
}