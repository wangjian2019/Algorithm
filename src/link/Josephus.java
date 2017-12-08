package link;

public class Josephus {
	
	public class Node {
		int data;
	    Node next;
		
		public Node(int data){
			this.data = data;
		}
		
		public String toString(){
			return String.valueOf(data);
		}
	}
	
	public class FirstLastLink {  //双端链表
		
		private Node first;  //头结点（表头第一个）
		private Node last;  //尾结点（表尾最后一个）
		
		public FirstLastLink(){
			first = null;   //头结点为空，说明单链表中没有元素
			last = null;   //尾结点为空，说明单链表中没有元素
			first = last.next;
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
	}
	
}
