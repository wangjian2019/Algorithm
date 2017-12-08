package stack_and_queue;

import java.util.Stack;

/**
 * 剑指offer第7题：两个栈模拟队列
 * 
 * 思路：从stack1入，从stack2中出。当出的时候，从stack1中把元素一次性batch的元素弹出并push进stack2zhong 
 * 1. 入队的时候，先插入的元素，进入stack1
 * 2. 出队的时候，把stack1的的元素逐个pop出来并push进stack2中。再从stack2中pop元素。
 * @author Alvin
 *
 */
public class TwoStackImitateQueue{
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	
}




