package stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 队尾进入，队头出去（先入先出）
 * @author Alvin
 *
 * @param <E>
 */
public class QueueJDKLinkedList<E>{
    Queue<E> queue = new LinkedList<E>();  //此处不能用List的upcasting，因为LinkedList在List的基础上增加了方法，用upcasting无法使用。还需要downward cast。
    
    public QueueJDKLinkedList(){
        queue = new LinkedList();
    }
    
    public E remove(){
        //return queue.removeFirst();
        return queue.poll();
    }
    
    public void insert(E o){
        //queue.addLast(o);
        queue.add(o);
    }
    
    public E getQueueHead(){
        //return queue.getFirst();
        return queue.peek();
    }
    
    public boolean isEmpty(){
        return queue.size()==0;
    }
    
    public int size(){
        return queue.size();
    }

}
