package stack_and_queue;

/**
 * 队列（双端链表实现）
 * 
 * 队尾进入，队头出去（先入先出）
 * 
 * @author Alvin
 *
 */
public class QueueLink {
	FirstLastLink queue;
	
	public QueueLink(){
		queue = new FirstLastLink();
	}
	
	public boolean isEmpty(){
		boolean justify = queue.isEmpty();
		return justify;
	}
	
	public void insert(int data){
		queue.insertLast(data);
	}
	
	public Node delete(){
		Node node = queue.deleteFirst();
		return node;
	}
	
	public String toString(){
		return queue.toString();
	}
	
	private class FirstLastLink {
		private Node first;  //头结点（表头第一个）
		private Node last;  //尾结点（表尾最后一个）
		
		public FirstLastLink(){
			first = null;   //头结点为空，说明单链表中没有元素
			last = null;   //尾结点为空，说明单链表中没有元素
		}
		
		public boolean isEmpty(){
			if(first == null){
				return true;
			}else{
				return false;
			}
		}
		
		public void insertFirst(int data){
			Node node = new Node(data);  //新插入的这个元素变成表头
			if(!isEmpty()){
				node.next = first;     //新插入的元素的下一个是原来的表头元素
				first = node;   //新插入的元素变为表头元素
			}else{
				first = node;    //新插入的元素变为表头元素
				last = node;           //新插入的元素变为表尾元素
			}
		}
		
		public void insertLast(int data){
			Node node = new Node(data);  //新插入的这个元素变成表头
			if(!isEmpty()){
				node = last.next;     //新插入的元素的下一个是原来的表头元素
				last = node;   //新插入的元素变为表头元素
			}else{
				first = node;    //新插入的元素变为表头元素
				last = node;           //新插入的元素变为表尾元素
			}
		}
		
		public Node deleteFirst(){
			Node temp = first;
			if(first.next == null){  //如果双端链表中只有一个元素，则删掉之后，first和last都是null
				last = null;
			}
			first = first.next;
			return temp;
		}
		
		public Node delete(int key){
			if(!isEmpty()){
				Node previous = first;
				Node current = first;
				while(current != null){
					if(current.data == key){
						previous.next = current.next;
						return current;
					}else{
						previous = current;
						current = current.next;
					}
				}
				return null;
			}else{
				return null;
			}
		}
		
		public Node find(int key){   //查找必须从表头第一个元素开始找，一个一个的next，直到最后
			Node current;
			for(current = first; current != null; current = current.next){
				if(current.data == key){
					return current;
				}
			}
			return null;
		}
		
		public String toString(){
			String LinkList = null;
			for(Node current = first; current != null; current = current.next){
				LinkList = LinkList + current.toString() + "-->" ;
			}
			return LinkList;
		}
	}
	
	private class Node {
		int data;
	    Node next;
		
		public Node(int data){
			this.data = data;
		}
		
		public String toString(){
			return String.valueOf(data);
		}
	}

}
