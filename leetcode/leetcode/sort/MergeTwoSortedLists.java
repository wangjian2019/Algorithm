package leetcode.sort;

/**
 * Merge Two Sorted Lists
 * 
 * 
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together
 * the nodes of the first two lists.
 * 
 * 
 */
public class MergeTwoSortedLists {

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

    //这个算法有问题，dummy.next = l3;后面的l3 = l1;或l3 = l2;后，sumy.next的l3还是以前的那个，不会变化，因为指的是对象，一定要注意这个错误
    public static ListNode wrong(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		// 对于新表选取第一个node，选择两个表表头最小的那个作为新表表头，指针后挪。
		ListNode l3 = new ListNode(0);
		// 这里必须有个指针指向头结点，因为以后遍历l3会遍历到链表末尾，那么就无法找到链表的头结点了
		ListNode dummy = new ListNode(-1);
		dummy.next = l3;

		while (l1 != null && l2 != null) {
			if (l1.value < l2.value) {
				l3 = l1;
				l3 = l3.next;
				l1 = l1.next;
			} else {
				l3 = l2;
				l3 = l3.next;
				l2 = l2.next;
			}
		}

		// 这里不需要再往后循环遍历了，直接把剩下的那个链表接到l3后面就行了
		if (l1 != null)
			l3 = l1;
		if (l2 != null)
			l3 = l2;
		return dummy.next;
	}
}