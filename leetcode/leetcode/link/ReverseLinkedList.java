package leetcode.link;

import org.junit.Test;


/**
 * Reverse Linked List I
 * 
 * reverse a single linked list
 * 
 * Reverse Linked List II
 * 
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example: Given 1->2->3->4->5->nullptr, m = 2 and n = 4,
 * return 1->4->3->2->5->nullptr.
 * Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list
 * 
 * 题解：
 * 就是维护3个指针，startpoint，node1和node2。
 * startpoint永远指向需要开始reverse的点的前一个位置。
 * node1指向正序中第一个需要rever的node，node2指向正序中第二个需要reverse的node。 
 * 交换后，node1 在后，node2在前。这样整个链表就逆序好了。
 * 
 * @author Alvin
 *
 */
public class ReverseLinkedList {
	
	@Test
	public void test(){
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		testI1(head);
		testII(head,2,4);
	}
	
	/**
	 * 1->2->3->4->5->null
	 * 
	 * null<-1   2->3->4->5->null
	 * null<-1<-2   3->4->5->null
	 * null<-1<-2<-3  4->5->null
	 * null<-1<-2<-3<-4  5->null
	 * null<-1<-2<-3<-4<-5
	 * 
	 * @param head
	 * @return
	 */
	// 反转一个链表，定义三个指针，先让头结点的next变为null，把链表从头结点开始断开，把中间current的next指向前一个，然后三个指针依次后移动一位，这样就是把后面链表的元素逐个加到前面的链表中，实现了链表反转
	public ListNode testI1(ListNode head){
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
	
	// 反转一个链表，两个节点，分别指的是头结点和后面一个节点。新建一个temp节点，先把头结点的next指到temp节点（把头结点和后面节点的link解除），然后利用这个temp节点实现头结点和后面节点的互换位置，头结点放到temp节点位置，后面节点放到头结点位置。继续向后面迭代
//	public ListNode testI2(ListNode head){
//		ListNode preHead = head;
//		ListNode temp = null;
//		while (head != null) {
//			preHead = head.next;
//			head.next = temp;
//			temp = head;
//			head = preHead;
//		}
//		return temp;
//	}
	
	
	/**
	 * 1->2->3->4->5->6->7->null m=2,n=6
	 * 
	 * 1->3->2->4->5->6->7->null
	 * 1->4->3->2->5->6->7->null
	 * 1->5->4->3->2->6->7->null
	 * 1->6->5->4->3->2->7->null
	 * 
	 * @param node
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode testII(ListNode node, int m, int n){
		    //newhead头结点的前一个
		 	ListNode newhead = new ListNode(-1);
		    newhead.next = node;
		    
		    if(node==null||node.next==null)
		        return newhead.next;
		        
		    ListNode startpoint = newhead;//startpoint指向: 头结点的前一个
		    ListNode node1 = null;//需要reverse到后面去的节点
		    ListNode node2 = null;//需要reverse到前面去的节点
		    
		    for (int i = 0; i < n; i++) {
		        if (i < m-1){
		            startpoint = startpoint.next;//找真正的startpoint：是m指向的节点的前一个节点
		        } else if (i == m-1) {//开始第一轮
		            node1 = startpoint.next;  //第一轮的时候：node1是startpoint的next
		            node2 = node1.next;       //第一轮的时候：node2是node1的next
 		        }else {
 		        	//当第一轮的时候:交换node1和node2的顺序，startpoint,node1永远不动，node2往后移动
 		        	//当非第一轮的时候：把node2后面的元素放到node1的位置，也就是startpoint的下一个，然后node2继续往后移动
		            node1.next = node2.next;//node1交换到node2的后面
		            node2.next = startpoint.next;//node2交换到最开始
		            startpoint.next = node2;//node2作为新的点
		            node2 = node1.next;//node2回归到node1的下一个，继续遍历
		        }
		    }
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
