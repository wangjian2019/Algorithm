package stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指offer的第7题：两个队列模拟栈
 * 
 * 思路： 必须一直保持一个队列是空的，一个队列是有元素的。第一次入栈的时候，选择queue1入队。
 * 第二个以及以后的元素都是找到一个有元素的队列入队，当出栈的时候，就是把那个有元素的队列的n-1个元素全都出队并入队另外一个空的队列中，剩余的那个元素出队。那么这个时候又是出现了一个队列有元素，一个队列空的情况
 * 
 * 1. 入栈的时候，元素进入queue1。再有元素入栈，依然入queue1
 * 2. 出栈的时候，先把queue1中元素逐个出队，入队queue2，直到queue1剩下最后一个元素，然后把这个元素出队
 * 3. 继续出栈的时候，把queue2的元素逐个出队，入队queue1,知道queue2剩下最后一个元素，然后把这个元素出队。
 * 4. 元素入栈，元素进入queue1中（入栈需要找到那个有元素的队列入队）
 * 
 *
 */
public class TwoQueueImitateStack<E> {
	Queue<E> queue1 = new LinkedList<E>();  
	Queue<E> queue2 = new LinkedList<E>();  
}
