package stack_and_queue;

import java.util.LinkedList;

public class StackJDKLinkedList<E>{
    LinkedList<E> stack;  //此处不能用List的upcasting，因为LinkedList在List的基础上增加了方法，用upcasting无法使用。还需要downward cast。
    
    public StackJDKLinkedList(){
        stack = new LinkedList();
    }
    
    public E pop(){
        return stack.removeLast();
    }
    
    public void push(E o){
        stack.add(o);
    }
    
    public E getTop(){
        return stack.getLast();
    }
    
    public boolean isEmpty(){
        return stack.size()==0;
    }
    
    public int size(){
        return stack.size();
    }

}
