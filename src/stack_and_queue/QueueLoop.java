package stack_and_queue;

/**
 * 循环队列（数组实现）
 * 
 * 数组实现队列，会导致容量固定有限，即便队列里面的已经数据都已经出队了，队列已经空了，但是一旦rear指针到了数组的length，那么队列也会显示满了。
 * 这种数组实现队列会有资源浪费问题，因此引入了循环队列
 * 
 * 队尾入队，队头出队(此代码为循环队列，当队头指针与队尾指针遇到队最大容量时，退回到初始位置)
 * @author Alvin
 *
 */
public class QueueLoop {  
	
	private int[] queue;
	private int front;
	private int rear;
	private int border;
	private int aggregate;  //队列中元素数量
	
	public QueueLoop(int border) {
		this.border = border;
		queue = new int[border];
		aggregate = 0;
		rear = -1;
		front = 0;	
	}
	
	public void insert(int key){  //队尾指针先++，再入队
		if(!isFull()){
			circulate();
		    rear++;
			queue[rear] = key;
			aggregate++;
		}else{
			System.out.println("已经满了，不能再insert了");
		}
	}
	
	public int delete(){             //先出队，再队头指针++
		if(!isEmpty()){
			circulate();
			int temp = queue[front];
			front++;
			aggregate--;
			return temp;
		}else{
			System.out.println("已经空了，不能再delete了");
			return -1;
		}
	}
	
	public int peek(){
		return queue[front];
	}
	
	public boolean isEmpty(){
		if(aggregate == 0){
			return true;
		}else{
			return false;
		}
	}
	
	/*public boolean isEmpty(){
		if(rear + 1 == front || front + border == rear){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isFull(){
		if(rear == front || front + border -1 == rear){
			return true;
		}else{
			return false;
		}
	}
	*/
	public boolean isFull(){
		if(aggregate == border){
			return true;
		}else{
			return false;
		}
	}
	
	public void circulate(){
		if(rear == border - 1){
			rear = -1;
		}
		if(front == border){
			front = 0;
		}
	}
}
