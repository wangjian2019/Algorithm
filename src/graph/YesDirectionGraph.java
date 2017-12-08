package graph;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 拓扑排序：  既可以应用到有向连通图，也可以应用到有向非连通图。但是拓扑排序不能处理有环图。
 *          1.找到一个没有后继的顶点
 *          2.从图中删除这个顶点，在列表的前面插入顶点的标记
 *          （如果一条边：A->B，表示B是A的后继，A是B的前驱。如果一个顶点没有后继，那么它可以成为拓扑排序中的最后一个。一旦删除它，顶点中必然有一个没有后继。所以为下一个拓扑序列最后一个提供基础）
 * @author Administrator
 *
 */

public class YesDirectionGraph {
	final int MAX = 20;
	Node[] node;
	int[][] edge;
	int current;
	char[] sortedArray;
	
	YesDirectionGraph(){
		node = new Node[MAX];
		edge = new int[MAX][MAX];
		current = 0;
		for(int i = 0; i < MAX; i++){
			for(int j = 0; j < MAX; j++){
				edge[i][j] = 0;
			}
		}
		sortedArray = new char[MAX];
	}
	
	public void addNode(char label){
		node[current] = new Node(label);
		current++;
	}
	
	public void addEdge(int start, int end){
		edge[start][end] = 1;
	}
	
	public void displayNode(int v){
		System.out.print(node[v].label + " --> ");
	}
	
	public void topo(){     //拓扑排序
		int originalCurrent = current;
		while(current > 0){
			int v = noSuccessors();  //找到没有后继节点的节点v
			if(v == -1){
				System.out.print("Error!");
				return;
			}
			sortedArray[current - 1] = node[v].label;  //把此节点放在数组最后的位置
			deleteNode(v);  //删除此节点
		}
		for(int i = 0; i < originalCurrent; i++){
			System.out.print(sortedArray[i]);
		}
		current = originalCurrent;
	}

	public void deleteNode(int v) {
		if(v != current - 1){
			for(int k = v; k < current - 1; k++){
				node[k] = node[k+1];
			}
			for(int i = v; i < current - 1; i++){
				moveRowUp(i,current);
			}
			for(int j = v; j < current - 1; j++){
				moveColUp(j,current - 1);
			}
		}
		current--;
	}

	public void moveColUp(int j, int length) {
		for(int i = 0; i < length; i++){
			edge[i][j] = edge[i][j+1];
		}
	}

	public void moveRowUp(int i, int length) {
		for(int j = 0; j < length; j++){
			edge[i][j] = edge[i+1][j];
		}
	}

	public int noSuccessors() {  //查找图中没有后继的节点，返回其数组的下标
		boolean isNoSuccessor;
		for(int i = 0 ; i < current; i++){
			isNoSuccessor = false;
			for(int j = 0; j < current; j++){
				if(edge[i][j] == 1){
					isNoSuccessor = true;
					break;
				}
			}
			if(isNoSuccessor == false){
				return i;
			}
		}
		return -1;
	}
	
	
}
