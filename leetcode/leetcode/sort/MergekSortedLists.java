package leetcode.sort;

/**
 * Mergek Sorted Lists
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity
 * 
 * 
 * 题解：
 * 经典的Merge Sort，只不过那个是对数组进行sort。而不同的地方，仅仅是Merge两个list的操作不同。
 * 最优o(n),最坏和平均都是o(nlogn)
 * 
 */
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return mergeSort(lists, 0, lists.length - 1);
    }

    public ListNode mergeSort(ListNode[] lists, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            ListNode leftlist = mergeSort(lists, low, mid);
            ListNode rightlist = mergeSort(lists, mid + 1, high);
            return mergeTwoLists(leftlist, rightlist);
        }
        return lists[low];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode l3;
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