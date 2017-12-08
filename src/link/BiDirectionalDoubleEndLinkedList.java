package link;

public class BiDirectionalDoubleEndLinkedList { // 双向双端链表
	DoubleNode first;
	DoubleNode last;

	public BiDirectionalDoubleEndLinkedList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		if (first == null) {
			return true;
		} else {
			return false;
		}
	}

	public void insertFirst(int data) {
		DoubleNode doublenode = new DoubleNode(data);
		if (!isEmpty()) {
			doublenode.next = first;
			first.previous = doublenode;
			first = doublenode;
		} else {
			first = doublenode;
			last = doublenode;
		}
	}

	public void insertLast(int data) {
		DoubleNode doublenode = new DoubleNode(data);
		if (!isEmpty()) {
			last.next = doublenode;
			doublenode.previous = last;
			last = doublenode;
		} else {
			first = doublenode;
			last = doublenode;
		}
	}

	public void insertAfter(int key, int data) { // 在key元素之后，插入data
		DoubleNode doublenode = new DoubleNode(data);
		DoubleNode current = first;
		if (isEmpty()) {
			System.out.print("链表为空");
		}
		while (current != null) {
			if (current.data == key) {
				if (current == last) {
					insertLast(data);
					return;
				}
				current.next.previous = doublenode;
				doublenode.next = current.next;
				current.next = doublenode;
				doublenode.previous = current;
			} else {
				current = current.next;
			}
		}
	}

	public DoubleNode deleteLast() { // 删除的时候要考虑只有一个元素的时候
		DoubleNode temp = last;
		if (!isEmpty()) {
			if (first.next == null) {
				last = null;
				first = null;
			} else {
				last.previous.next = null;
				last = last.previous;
			}
			return temp;
		} else {
			return null;
		}
	}

	public DoubleNode deleteFirst() {
		DoubleNode temp = first;
		if (!isEmpty()) {
			if (first.next == null) {
				last = null;
				first = null;
			} else {
				first = first.next;
				first.next.previous = null;
			}
			return temp;
		} else {
			return null;
		}
	}

	public DoubleNode delete(int key) {
		DoubleNode current = first;
		DoubleNode previous = first;
		DoubleNode temp;
		if (!isEmpty()) {
			while (current != null) {
				if (current.data == key) {
					if (current == last) {
						deleteLast();
						return current;
					}
					temp = current;
					previous.next = current.next;
					current.next.previous = previous;
					return temp;
				} else {
					previous = current;
					current = current.next;
				}
			}
			return null;
		} else {
			System.out.print("链表为空");
			return null;
		}
	}

	private class DoubleNode {
		int data;
		DoubleNode next;
		DoubleNode previous;

		public DoubleNode(int data) {
			this.data = data;
		}

		public String toString() {
			return String.valueOf(data);
		}
	}

}
