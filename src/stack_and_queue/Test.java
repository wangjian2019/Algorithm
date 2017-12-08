package stack_and_queue;

public class Test {

	public static void main(String[] args) {
		Test test = new Test();
		//test.testStackArray();
		test.testQueueArray();
	}
	
	public void testStackArray(){
		StackArray stackArray = new StackArray(5);
		stackArray.push(99);
		stackArray.push(56);
		stackArray.push(23);
		stackArray.push(996);
		stackArray.push(1);
		System.out.println(stackArray.peek());
		stackArray.pop();
		System.out.println(stackArray.peek());
	}
	
	public void testQueueArray(){
		QueueArray stackArray = new QueueArray(5);
		System.out.println(stackArray.isEmpty());
		stackArray.insert(99);
		stackArray.insert(56);
		stackArray.insert(23);
		stackArray.insert(996);
		stackArray.insert(1);
		System.out.println(stackArray.isFull());
		stackArray.remove();
		stackArray.insert(909);
		System.out.println(stackArray.isFull());
		/*stackArray.delete();
		stackArray.delete();
		stackArray.delete();
		stackArray.delete();
		stackArray.delete();
		System.out.println(stackArray.isEmpty());
		System.out.println(stackArray.peek());*/
	}
}
