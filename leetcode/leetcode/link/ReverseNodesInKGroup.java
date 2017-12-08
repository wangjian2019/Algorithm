package leetcode.link;

import org.junit.Test;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example, Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * 题解：
 * 
 * 以每k个为一组来翻转链表，实际上是把原链表分成若干小段，然后分别对每个小段链表进行翻转，最后一个小段如果长度小于k，那么就不翻转保持原样
 * 
 * 
 * 总共需要两个函数，一个是用来分段的，一个是用来翻转的，我们就以题目中给的例子来看，对于给定链表1->2->3->4->5，一般在处理链表问题时，我们大多时候都会在开头再加一个dummy node，因为翻转链表时头结点可能会变化，为了记录当前最新的头结点的位置而引入的dummy node，那么我们加入dummy node后的链表变为-1->1->2->3->4->5，如果k为3的  * 话，我们的目标是将1,2,3翻转一下，
 * 利用reverse链表的方法，reverse的方法就是维护三个指针
 * 
 */
public class ReverseNodesInKGroup {

    /**
    * Reverse a link list between pre and next exclusively
    * An example:
    * a linked list:
    *  
    *  当k=3,将双指针分别指向要reverse的链表的第一个节点的前一个节点、最后一个节点的后一个节点
    * -1->1->2->3->4->5->6
    *  |           |   
    * pre         next

    * after call pre = reverse(pre, next)
    * 
    * 0->3->2->1->4->5->6
    *          |  |
    *          pre next
    *
    * @param pre 
    * @param next
    * @return the reversed list's last node, which is the precedence of parameter next
    */
    private static ListNode reverse(ListNode pre, ListNode next) {
        ListNode last = pre.next;//where first will be doomed "last"
        ListNode cur = last.next;
        while (cur != next) {
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int count = 0;
        //定义双指针
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            count++;
            ListNode next = cur.next;
            if (count == k) {
                //将双指针分别指向要reverse的链表的第一个节点的前一个节点、最后一个节点的后一个节点
                pre = reverse(pre, next);
                count = 0;
            }
            cur = next;
        }
        return dummy.next;
    }

    private class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }
}
