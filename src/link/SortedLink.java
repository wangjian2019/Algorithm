package link;

/**
 * 有序的单链表
 */
public class SortedLink {
	//头结点（表头第一个）
	private Node first;  
	
	public SortedLink(){
		first = null;   //头结点为空，说明单链表中没有元素
	}
	
	public boolean isEmpty(){
		if(first == null){
			return true;
		}else{
			return false;
		}
	}
	
	public void insert(int data){
		Node node = new Node(data);  //新插入的这个元素变成表头
		if(!isEmpty()){
			Node previous = first;
			Node current = first;
			while(current != null){
				if(data > current.data){
					previous = current;
					current = current.next;
				}else if(data < current.data){
					previous.next = node;
					node.next = current;
				}
			}
		}else{
			first = node;    //新插入的元素变为表头元素
		}
		
	}
	
	public Node deleteFirst(){
		Node temp = first;
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
