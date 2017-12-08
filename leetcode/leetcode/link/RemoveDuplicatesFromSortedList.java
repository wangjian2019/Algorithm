package leetcode.link;

/**
 * Remove Duplicates From Sorted List
 * 
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once. 
 * 
 * For example, Given 1->1->2, 
 *              return 1->2. 
 *              
 * Given 1->1->2->3->3, 
 * return 1->2->3
 * 
 * Remove Duplicates From Sorted List II
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers
 * from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3
 * 
 * 
 * @author Alvin
 *
 */
public class RemoveDuplicatesFromSortedList {

	// 维护两个指针，一个指向当前不重复的最后一个元素，一个进行依次扫描，遇到不重复的则更新第一个指针，继续扫描，否则就把前面指针指向当前元素的下一个（即把当前元素从链表中删除）。时间上只需要一次扫描，所以是O(n)，空间上两个额外指针，是O(1)。
	public ListNode deleteDuplicatesI(ListNode head) {
		if (head == null)
			return head;
		ListNode previous = head;
		ListNode current = head.next;
		while (current != null) {
			if (current.value == previous.value) {
				previous.next = current.next;
			} else {
				previous = current;
			}
			current = current.next;
		}
		return head;
	}

	//这道题与I的区别就是要把所有重复的node删除。因此，还是利用I中去重的方法，引用双指针，并且增加一个新的指针，指向当前的前一个node，使用3个指针（prev，current，post）来遍历链表。 
	// 最开始还是需要建立一个fakehead，让fakehead的next指向head。
	public ListNode deleteDuplicatesII(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode fakehead = new ListNode(-1);
		fakehead.next = head;

		ListNode ptr0 = fakehead;
		ListNode ptr1 = fakehead.next;
		ListNode ptr2 = fakehead.next.next;

		boolean flag = false;
		while (ptr2 != null) {
			if (ptr1.val == ptr2.val) {
				flag = true;
				ptr2 = ptr2.next;
				if (ptr2 == null)
					ptr0.next = null;
			} else {
				if (flag) {
					ptr0.next = ptr2;
					flag = false;
				} else {
					ptr0 = ptr1;
				}
				ptr1 = ptr2;
				ptr2 = ptr2.next;
			}
		}
		return fakehead.next;

	}

	private class ListNode {
		int value;
		ListNode next;

		ListNode(int value) {
			this.value = value;
		}
	}
}
