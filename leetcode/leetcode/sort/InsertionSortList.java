package leetcode.sort;

/**
 * Insertion Sort List
 * 
 * Sort a linked list using insertion sort.
 * 
 * 题解：
 *  Insertion Sort就是把一个一个元素往已排好序的list中插入的过程。
 * 初始时，sorted list是空，把一个元素插入sorted list中。然后，在每一次插入过程中，都是找到最合适位置进行插入。
 * 因为是链表的插入操作，需要维护pre，cur和next3个指针。
 * pre始终指向sorted list的fakehead，cur指向当前需要被插入的元素，next指向下一个需要被插入的元素。
 * 当sortedlist为空以及pre.next所指向的元素比cur指向的元素值要大时，需要把cur元素插入到pre.next所指向元素之前。否则，pre指针后移。最后返回fakehead的next即可。
 * 
 *      3-> 2-> 1
 * -1   3-> 2-> 1
 *  |   |   |
 * pre  cur next
 * 
 * -1 ->3-> null 2-> 1
 *  |            |   |
 * pre          cur next
 *  
 * -1 ->2-> 3->null  1
 *  |       |        |
 * pre     cur      next
 * 
 *  -1 ->2-> 3->null  1       null
 *  |                 |        |
 * pre               cur      next
 * 
 *  -1 ->1-> 2-> 3   null     null
 *  |                 |        |
 * pre               cur      next
 * 
 * 
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode sortedlisthead = new ListNode(-1);
        ListNode cur = head; 
        while (cur != null) {
            //next向后走一个位置
            ListNode next = cur.next;
            //每次循环开始的时候，pre必须退回到头结点上，从头开始走,寻找插入的地方
            ListNode pre = sortedlisthead;
            //pre必须指向要插入节点的前一个节点
            while (pre.next != null && pre.next.value < cur.value){
                pre = pre.next;
            }
            //将待排序元素插入点对应的位置，也就是改变指针的指向    
            cur.next = pre.next;
            pre.next = cur;
            //cur向后走一位置
            cur = next;
        }
        return sortedlisthead.next;
    }

    private class ListNode {
		int value;
		ListNode next;

		ListNode(int value) {
			this.value = value;
		}
	}
}