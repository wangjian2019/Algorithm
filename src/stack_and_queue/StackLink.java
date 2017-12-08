package stack_and_queue;

/**
 * 栈（单链表实现）
 * 
 * 表头模拟栈顶，所以出栈入栈都是表头
 * @author Alvin
 *
 */
public class StackLink {  //
	SingleLink stack;

	public StackLink() {
		stack = new SingleLink();
	}
	
	public void push(int data){
		stack.insertFirst(data);
	}
	
	public Node pop(){
		Node temp = stack.deleteFirst();
		return temp;
	}
	
	public boolean isEmpty(){
		boolean justify = stack.isEmpty();
		return justify;
	}
	
	public String toString(){
		return stack.toString();
	}
	
	public class SingleLink {
	
		Node first;  //头结点（表头第一个）
		
		public SingleLink(){
			first = null;   //头结点为空，说明单链表中没有元素
		}
		
		public boolean isEmpty(){
			if(first == null){
				return true;
			}else{
				return false;
			}
		}
		
		public void insertFirst(int data){
			Node node = new Node(data);  //新插入的这个元素编程表头
			if(!isEmpty()){
				node.next = first;     //新插入的元素的下一个是原来的表头元素
				first = node;   //新插入的元素变为表头元素
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
