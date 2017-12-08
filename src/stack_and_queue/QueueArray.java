package stack_and_queue;

/**
 * 队列（数组实现）
 * 
 * 队尾进入，队头出去（先入先出）
 * @author Alvin
 *
 */
public class QueueArray {
	private int maxSize;
	private int[] queueArray;
	private int front;
	private int rear;
	private int nItems;
	
	public QueueArray(int maxSize){
		this.maxSize = maxSize;
		this.queueArray = new int[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	public void insert(int j){
		if(rear == maxSize - 1){
			rear = -1;
		}
		queueArray[++rear] = j;
		nItems++;
	}
	
	public int remove(){
		int temp = queueArray[front++];
		if(front == maxSize){
			front = 0;
		}
		nItems--;
		return temp;
	}
	
	public int peekFront(){
		return queueArray[front];
	}
	
	public boolean isEmpty(){
		return nItems == 0;
	}
	
	public boolean isFull(){
		return nItems == maxSize;
	}
	
	public int size(){
		return nItems;
	}
	
}
