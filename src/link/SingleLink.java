package link;

import java.util.Stack;

public class SingleLink { // 表头插入和删除都是o(1)，很快；查找、删除、插入指定元素o(n)，慢。比数组好的地方是没有数量限制
	Node first; // 头结点（表头第一个）
	int countNumber = 0; // 链表中共有多少个节点

	public SingleLink() {
		first = null; // 头结点为空，说明单链表中没有元素
	}

	/**
	 * 判表是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		if (first == null) {
			return true;
		} else {
			return false;
		}
	}

	public int getLength() { // 求表长
		Node current = first;
		int count = 0;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	// o(1)
	public void insertFirst(int data) {
		Node node = new Node(data); // 新插入的这个元素变成表头
		if (!isEmpty()) {
			node.next = first; // 新插入的元素的下一个是原来的表头元素
			first = node; // 新插入的元素变为表头元素
		} else {
			first = node; // 新插入的元素变为表头元素
		}
		countNumber++;
	}

	// o(n)
	public void insertLast(int data) {
		Node node = new Node(data);
		if (!isEmpty()) {
			Node nodeTemp = first;
			while (nodeTemp.next != null) {
				nodeTemp = nodeTemp.next;
			}
			nodeTemp.next = node;
		} else {
			first = node;
		}
		countNumber++;
	}

	// 删除表头元素
	public Node deleteFirst() {
		if (!isEmpty()) {
			Node temp = first;
			first = first.next;
			return temp;
		} else {
			return null;
		}
	}

	// 删除某个key元素,时间复杂度o(n),需要两个指针，从头结点遍历到要删的节点，也就拿到了要删节点的前一个节点，让要删节点的前一个节点的指针指向要删节点后一个节点上
	public Node delete(int key) {
		if (!isEmpty()) {
			Node previous = first;
			Node current = first;
			while (current != null) {
				if (current.data == key) {
					previous.next = current.next;
					return current;
				} else {
					previous = current;
					current = current.next;
				}
			}
			return null;
		} else {
			return null;
		}
	}

	/*
	 * 剑指offer第13题：在o(1)时间，删除链表中某个节点。给定一个单链表的头节点和将要删除的节点，o(1)时间删除该节点
	 *
	 * 题解：找到将要被删除节点的下一个节点，把下一个节点中的内容赋值到将要被删除的节点中覆盖现有的内容。
	 * 然后将这个将要被删除的节点的next指针指向下一个的下一个。
	 *
	 *	但是，如果要删除的节点是最后一个节点，那么我们只能使用传统的方式：从链表头节点开始顺序遍历得到该节点的前一个节点，让该前一个节点的next指向将要被删除的下一个节点
	 *  但是，如果这个链表只有一个节点，那么直接删除这个节点，头结点变为null
	 *  
	 *  隐患：默认该删除节点一定在该链表中，o(1)无法判断出来
	 */
	public Node deleteQuick(int key) {
		return null;
	}

	// 查找必须从表头第一个元素开始找，一个一个的next，直到最后。o(n)
	public Node find(int key) {
		Node current;
		for (current = first; current != null; current = current.next) {
			if (current.data == key) {
				return current;
			}
		}
		return null;
	}

	// 单链表排序
	// 相当于冒泡排序，o(n^2)
	public void sortLink() {
		if (!isEmpty()) {
			for (int i = 0; i < countNumber; i++) { // 因为链表没有数组下标，此处的i，j仅表示次数，不表示下标的含义。由于链表只能通过next遍历，且单链表不能往回走，因此用i，j控制是否next到的终点。
				Node current = first;
				for (int j = 0; j < countNumber - i; j++, current = current.next) {
					if (current.data > current.next.data) {
						int temp = current.data;
						current.data = current.next.data;
						current.next.data = temp;
					}
				}
			}
		} else {
			return;
		}
	}

	// 单链表逆置
	/**
	 * 1->2->3->4->5->null
	 * 
	 * null<-1  2->3->4->5->null
	 * null<-1<-2  3->4->5->null
	 * null<-1<-2<-3  4->5->null
	 * null<-1<-2<-3<-4  5->null
	 * null<-1<-2<-3<-4<-5
	 * 
	 * @param head
	 * @return
	 */
	// 反转一个链表，定义三个指针，先让头结点的next变为null，把链表从头结点开始断开，把中间current的next指向前一个，然后三个指针依次后移动一位，这样就是把后面链表的元素逐个加到前面的链表中，实现了链表反转
	public Node testI1(){
		if(first == null){
			return null;
		}
		if(first.next == null){
			return first;
		}
		if(first.next.next == null){
			Node listNode = first.next;
			listNode.next = first;
			first.next = null;
			return listNode;
		}
		Node previous = first;
		Node current = first.next;
		Node temp = first.next.next;
		//当前的头结点将会变成反转之后链表的尾节点，所以尾节点的next是null
		//把头节点和后面节点断开
		first.next = null;
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

	// 寻找单链表的中间节点，new两个指向指针，第一个每次移动两个距离，第二个每次移动一个距离，当第一个移动到移动到链表尾部，第二个正好是中点。
	// 快慢指针，寻找链表中点
	public Node searchMiddle() {
		Node whole = first;
		Node half = first;
		while (whole != null) {
			whole = whole.next;
			half = half.next.next;
		}
		return half;
	}

	// 从前往后打印链表
	public String toString() {
		String LinkList = null;
		for (Node current = first; current != null; current = current.next) {
			LinkList = LinkList + current.toString() + "-->";
		}
		return LinkList;
	}

	// 剑指offer第5题：从后往前打印链表(利用栈Stack，先顺序遍历链表push入栈，在依次pop出栈)
	public void printFromEndToBegin1() {
		Stack<Node> stack = new Stack<Node>();
		Node nodeTemp = first;
		for (; nodeTemp != null; nodeTemp = nodeTemp.next) {
			stack.push(nodeTemp);
		}
		for (; stack.isEmpty();) {
			Node node = stack.pop();
			System.out.println(node + "-->");
		}
	}

	private class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

		public String toString() {
			return String.valueOf(data);
		}
	}
}
