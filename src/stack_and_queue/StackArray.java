package stack_and_queue;
import java.util.Arrays;
/**
 * 栈（数组实现）
 * @author Alvin
 *
 */
public class StackArray {  //入栈（插入）、出栈（删除）都是O(1)
	
	private int[] stack;
	private int pointer;
	private int border;
	
	
	public StackArray(int border){
		this.border = border;
		stack = new int[border];
		pointer = -1;  //栈在初始状态时，指针指在-1处，栈低的下面一个位置。
	}
	
	public void push(int key){   //压栈（先++指针，再入栈）
		if(!isFull()){                //压栈前先判满
			pointer++;
			stack[pointer] = key;
		}else{
			System.exit(0);
		}
	}
	 
	public int pop(){       //弹栈，并返回被弹出的元素（先出栈，再--指针）
		if(!isEmpty()){               //弹栈前先判空
			int temp = stack[pointer];
			pointer--;
			return temp;
		}else{
			return -1;
		}
	}
	
	public int peek(){    //返回栈顶元素
		int temp = stack[pointer];
		return temp;
	}
	
	public boolean isEmpty(){
		if(pointer == -1){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isFull(){
		if(pointer == border - 1){
			return true;
		}else{
			return false;
		}
	}
	
	public String toString(){
		return Arrays.toString(stack);
	}
}