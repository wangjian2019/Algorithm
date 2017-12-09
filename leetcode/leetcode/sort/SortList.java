package leetcode.sort;


/**
 * Sort List
 * 
 * Sort a linked list in O(nlogn) time using constant space complexity
 * 
 * 
 * 题解：单向链表排序用归并排序，双向链表排序用快排
 * 
 * 
 * 
 */
public class SortList{

    public ListNode sortList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        
        // 快慢指针找到中间节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 断开
        fast = slow;
        slow = slow.next;
        fast.next = null;
        ListNode l1 = sortList(head); // 前半段排序
        ListNode l2 = sortList(slow); // 后半段排序
        return mergeTwoLists(l1, l2);
    }


      public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        //对于新表选取第一个node，选择两个表表头最小的那个作为新表表头，指针后挪。
        ListNode l3  = new ListNode(-1);
        if (l1.value < l2.value) {
            l3 = l1;
            l1 = l1.next;
        } else {
            l3 = l2;
            l2 = l2.next;
        }

        ListNode fakehead = new ListNode(-1);
        fakehead.next = l3;
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                l3.next = l1;
                l3 = l3.next;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l3 = l3.next;
                l2 = l2.next;
            }
        }

        if (l1 != null)
            l3.next = l1;
        if (l2 != null)
            l3.next = l2;
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