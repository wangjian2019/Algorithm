package leetcode.link;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * 
 * 题解：逆序表示的数字，第一位是个位，第二位是十位，。。。。
 * 给的加数是倒着给的，你返回的结果也是倒着写的，所以进位也反着进就好。
 */
public class AddTwoNumbers {

	@org.junit.Test
	public void test() {

	}

	public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
		if (node1 == null)
			return node2;
		if (node2 == null)
			return node1;

		int carry = 0;
		ListNode newhead = new ListNode(-1);
		ListNode l3 = newhead;

		//从个位开始
		while (node1 != null || node2 != null) {
			if (node1 != null) {
				carry = carry + node1.value;
				node1 = node1.next;
			}
			if (node2 != null) {
				carry = carry + node2.value;
				node2 = node2.next;
			}

			l3.next = new ListNode(carry % 10);
			//是否需要进位
			carry = carry / 10;
			l3 = l3.next;
		}

		//如果最高位相加完好需要进位，需要再最后加一个node，进位1
		if (carry == 1)
			l3.next = new ListNode(1);
		return newhead.next;
	}

	private class ListNode {
		int value;
		ListNode next;

		ListNode(int value) {
			this.value = value;
		}
	}

}