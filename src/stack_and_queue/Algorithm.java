package stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Algorithm {

	/**
	 * 问题： 实现一个栈，带有查找最小元素的方法
	 * 
	 * 方案：
	 * 1.设原有的栈叫做栈A，此时创建一个额外的栈B，用于辅助原栈A。
	 * 2.当第一个元素进入栈A的时候，让新元素的下标进入栈B。这个唯一的元素是栈A的当前最小值。（考虑到栈中元素可能不是类对象，
	 * 所以B栈存储的是A栈元素的下标） 
	 * 3.每当新元素进入栈A时，比较新元素和栈A当前最小值的大小，如果小于栈A当前最小值，则让新元素的下标进入栈B，
	 * 此时栈B的栈顶元素就是栈A当前最小值的下标。
	 * 4.每当栈A有元素出栈时，如果出栈元素是栈A当前最小值，则让栈B的栈顶元素也出栈。此时栈B余下的栈顶元素所指向的，是栈A当中原本第二小的元素，
	 * 代替刚才的出栈元素成为了栈A的当前最小值。（备胎转正） 
	 * 5.当调用getMin方法的时候，直接返回栈B的栈顶所指向的栈A对应元素即可。
	 * 
	 * 
	 */
	public void test() {

	}
	
	/**
	* 两个Stack模拟一个Queue: A Stack只负责insert入栈， 然后定期将一个Batch的数据出栈pop到另外一个B Stack里面，然后B Stack只负责出栈。
	*
	* 以下的peek操作和pop操作都是符合操作，必须保持原子性。虽然Stack继承于Vector是线程安全，但是我们的方法中是多次操作不同的Stack，无法保证整个方法的线程安全，所以方法上都加锁，相当于串行。
	* 
	*/
	private class TwoStackImitateQueue {
		Stack<Integer> a = new Stack<Integer>();
		Stack<Integer> b = new Stack<Integer>();
		
		public synchronized void insert(int key){
			a.push(key);
		}
		
		public synchronized int peek(){
			if(b.isEmpty()){
				if(!a.isEmpty()){
					int temp = a.peek();
					b.push(temp);
					a.pop();
					return b.peek();
				}else{
					return -1;
				}
			}else{
				return b.peek();
			}
		}
		
		public synchronized boolean delete(){
			if(!b.isEmpty()){
				b.pop();
				return true;
			}else{
				if(a.isEmpty()){
					return false;
				}else{
					int temp = a.peek();
					b.push(temp);
					a.pop();
					b.pop();
					return false;
				}
			}
		}
	}
	
	/**
	* 两个Queue模拟一个Stack: A Queue只负责队尾入队，当有移除pop的操作的时候，将A queue中前n-1个元素都从队头出队，入队到b queue中，那么这个时候a queue中只有一个元素，出队这个元素即可。
	* 
	* 思路：当再有数据进入的时候，判断那个queue中元素不为空，就从哪个队的队尾入队。当有移除pop的操作的时候，把这个queue中元素不为空的queue中前n-1个元素移动到另外一个queue中，移除最后一个元素。
	*
	* 以下的insert操作和remove操作都是符合操作，必须保持原子性。所以方法上都加锁，相当于串行。
	* 
	*/
	private class TwoQueueImitateStack {
		Queue<Integer> a = new LinkedList<Integer>();
		Queue<Integer> b = new LinkedList<Integer>();
		
		public synchronized void insert(int key){
			a.add(key);
		}
		
		public synchronized int peek(){
			//...
			return 0;
		}
		
		public synchronized boolean delete(){
			//...
			return false;
		}
	}
}
