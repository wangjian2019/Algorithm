package tree.heap;
import java.util.Arrays;

/**
 * 堆是一种树(不是内存中JVM的堆)，它实现的优先队列的插入和删除的时间复杂度都是o(logN)。（从根节点到叶子节点，每一条路径都是降序的，但是横着的每一层都是无序的）（每个父节点的值都大于子节点的值）
 * 堆是一种完全二叉树（除了最后一层不需要是满的，其他层都是满的），常用数组实现：每个节点关键字都大于子节点的关键字，兄弟节点无大小关系。
 * 删除：只能删除根节点，（根节点为最大节点，如果用数组实现就是array[0]）,一旦删除根节点，把堆最后一个节点放到根节点位置array[0],然后一直向下筛选，如果不合适就交换，直到符合为止。
 * 
 * 因为堆的弱序性（横着的每一层是无序的），因此堆不支持遍历。
 */
public class Heap {
	Node[] heap;
	int border;
	int pointer;
	
	Heap(int border){
		this.border = border;
		heap = new Node[border]; 
		pointer = 0;
	}
	
	public boolean isEmpty(){
		if(pointer == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean insert(int key){
		if(pointer == border - 1){
			return false;
		}else{
			Node node = new Node(key);
			heap[pointer] = node;  //先把新插入的节点放在数组的最后，即堆的最后一个，然后在向上移动
			trickleUp(pointer);   //向上移动，将新加入的节点放到合适的位置上
			pointer++;
			return true;
		}
	}

	public void trickleUp(int singal) {
		int parent = (singal - 1)/2;   //父节点的数组下标
		Node temp = heap[singal];
		for(;singal > 0 && heap[parent].data < temp.data; parent = (parent - 1)/2 ){
			heap[singal] = heap[parent];
			singal = parent;
		}
		heap[singal] = temp;
	}
	
	public Node move(){
		Node root = heap[0];
		heap[0] = heap[pointer - 1];
		trickleDown(0);
		return root;
	}

	public void trickleDown(int singal) {
		Node top = heap[singal];
		int largeChild;
		while(singal < pointer/2){    //保证此节点下面还有子节点
			int leftChild = 2 * singal + 1;
			int rightChild = leftChild + 1;
			if(rightChild < pointer && heap[leftChild].data < heap[rightChild].data){
				largeChild = rightChild;
			}else{
				largeChild = leftChild;
			}
			if(top.data >= heap[largeChild].data){
				break;
			}
			heap[singal] = heap[largeChild];
			singal = largeChild;
		}
	}
	
	public String toString(){
		return Arrays.toString(heap);
	}
	
	public class Node {
		int data;
		
		Node(int data){
			this.data = data;
		}
		
		public String toString(){
			return String.valueOf(data);
		}
		
	}
}
