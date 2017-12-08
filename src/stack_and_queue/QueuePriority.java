package stack_and_queue;
/**
 * 优先队列（数组实现）
 * 
 * 优先队列中，元素有序，最小的优先级最高，放在队头位置
 * （因此优先队列插入不是从队尾了，但是依然是队头出队。因此没有队头队尾指针了）
 * 
 * @author Alvin
 *
 */
public class QueuePriority {  
	
	private int[] queue;
	private int pointer;
	private int border;
	private int aggregate;
	
	public QueuePriority(int border){
		this.border = border;
		queue = new int[border];
		pointer = -1;
		aggregate = 0;
	}
	
	public void insert(int key){  //由于队列中的元素本来就是有序的，插入的时候需要插到正确的地方，依然保持有序。
		if(!isFull()){
			int i;
			if(pointer == -1){
				pointer++;
				queue[pointer] = key;
				aggregate++;
			}else if(pointer > -1){
				pointer++;
				aggregate++;
				for(i = pointer - 1; i > 0; i--){
					if(key < queue[i]){
						queue[pointer] = queue[pointer-1];
					}else{
						break;
					}			
				}
				queue[i+1] = key;
			}	
		}
	} 
	
	public int delete(){
		if(!isEmpty()){
			int temp = queue[pointer];
			pointer--;
			return temp;
		}else{
			return -1;
		}
	}
	
	public int peek(){
		return queue[pointer];
	}
	
	public boolean isFull(){
		if(border == aggregate){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isEmpty(){
		if(aggregate == 0){
			return true;
		}else{
			return false;
		}
	}
}
