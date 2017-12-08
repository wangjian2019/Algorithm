package leetcode.link;

import org.junit.Test;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes
 * itself can be changed.
 * 
 * 題解：
 * 
 * 用dummyNode来指向原指针头，防止丢链，用两个指针，ptr1始终指向需要交换的pair的前面一个node，ptr2始终指向需要交换的pair的第一个node。
 * 然后就是进行链表交换。需要用一个临时指针nextstart， 指向下一个需要交换的pair的第一个node，保证下一次交换的正确进行。
 * 然后就进行正常的链表交换，和指针挪动就好。 
 * 
 * 当链表长度为奇数时，ptr2.next可能为null；
 * 当链表长度为偶数时，ptr2可能为null。
 * 所以把这两个情况作为终止条件，在while判断就好，最后返回dummyNode.next。
 * 
 * 
 * 
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //在头节点前，设置一个dummyNode节点s
        ListNode dummyNode = new ListNode(-1);
        fakehead.next = head;
        //ptr1始终指向需要交换的pair的前面一个node，ptr2始终指向需要交换的pair的第一个node。
        ListNode ptr1 = dummyNode;
        ListNode ptr2 = head;

        while (ptr2 != null && ptr2.next != null) {
            ListNode nextstart = ptr2.next.next;
            ptr2.next.next = ptr2;
            ptr1.next = ptr2.next;
            ptr2.next = nextstart;
            ptr1 = ptr2;
            ptr2 = ptr2.next;
        }
        return dummyNode.next;
    }

    private class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }
}