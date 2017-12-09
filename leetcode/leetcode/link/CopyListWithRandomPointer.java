package leetcode.link;

import java.util.HashMap;
import java.util.Map;

/**
 * Copy List with Random Pointer
 * 
 * 
 * A linked list is given such that each node contains an additional random pointer which could point to
 * any node in the list or null.
 * Return a deep copy of the list.
 * 
 * 题解：
 * 如果要copy一个带有random pointer的list，主要的问题就是有可能这个random指向的位置还没有被copy到，所以解决方法都是多次扫描list。
 *  
 * 就是使用HashMap，HashMap的key存原始pointer，value存新的pointer。
 * 第一遍，先不copy random的值，只copy数值建立好新的链表。并把新旧pointer存在HashMap中。
 * 第二遍，遍历旧表，复制random的值，因为第一遍已经把链表复制好了并且也存在HashMap里了，所以只需从HashMap中，把当前旧的node.random作为key值，得到新的value的值，并把其赋给新node.random就好
 * 
 */
public class CopyListWithRandomPointer {

    //遍历2次list，所以时间复杂度是O(2n)=O(n)，然后使用了HashMap，所以空间复杂度是O(n)。
    public ListNode copyRandomList(ListNode head) {
        if (head == null){
            return null;
        }
        Map<ListNode, ListNode> map = new HashMap<ListNode, ListNode>();
        //新链表头节点，但是没有赋值next指针
        ListNode newhead = new ListNode(head.value);
        //key: 老链表头结点， value:新链表头结点
        map.put(head, newhead);
        ListNode oldp = head.next;
        ListNode newp = newhead;
        //第一次遍历，复制链表和节点的next指针，新老链表对应关系放入hashmap中
        while (oldp != null) {
            //新建新链表节点，但是没有赋值next指针
            ListNode newnode = new ListNode(oldp.value);
            //key: 老链表结点， value:新链表结点
            map.put(oldp, newnode);
            //赋值该新链表的节点的next指针
            newp.next = newnode;
            //向后遍历
            oldp = oldp.next;
            newp = newp.next;
        }
        //两个指针重新指向新老链表的头结点
        oldp = head;
        newp = newhead;
        //第二次遍历：新链表赋值random指针
        while (oldp != null) {
            newp.random = map.get(oldp.random);
            oldp = oldp.next;
            newp = newp.next;
        }

        return newhead;
    }

    private class ListNode {
		int value;
		ListNode next;
        ListNode random;

		ListNode(int value) {
			this.value = value;
		}
	}

}