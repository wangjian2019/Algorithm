package graph;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 无向图
 * 表示图的方法：邻接矩阵，邻接表。（以下代码为邻接矩阵表示）
 * 最小生成树：边数量   = 顶点数量  - 1
 * @author Administrator
 *
 */

public class NoDirectionGraph {
	final int MAX = 20;
	Node[] node;
	int[][] edge;
	int current;
	Stack<Integer> stack;
	Queue<Integer> queue;
	
	NoDirectionGraph(){
		node = new Node[MAX];
		edge = new int[MAX][MAX];
		current = 0;
		for(int i = 0; i < MAX; i++){
			for(int j = 0; j < MAX; j++){
				edge[i][j] = 0;
			}
		}
		stack = new Stack<Integer>();
		queue = new LinkedList<Integer>();
	}
	
	public void addNode(char label){
		node[current] = new Node(label);
		current++;
	}
	
	public void addEdge(int start, int end){
		edge[start][end] = 1;
		edge[end][start] = 1;
	}
	
	public void displayNode(int v){
		System.out.print(node[v].label + " --> ");
	}
	
	public int getBesideUnvisitedNode(int v){   //找到第v个节点的邻接且没有被访问过的节点
		for(int i = 0; i < current; i++){
			if(edge[v][i] == 1 && node[i].isVisited == false){
				return i;
			}
		}
		return -1;
	}
	
	public void dfs(){   //深度优先搜索
		node[0].isVisited = true;  //初始化，先从第一个节点开始访问，
		this.displayNode(0);
		stack.push(0);  //把第一个节点放进栈中。
		
		while(!stack.isEmpty()){
			int v = this.getBesideUnvisitedNode(stack.peek());
			if(v == -1){   //如果找不到此节点的没有访问过的相邻节点，就从其他节点找，即v == -1，并从栈中弹出一个节点
				stack.pop();
			}else{
				node[v].isVisited = true;
				this.displayNode(0);
				stack.push(v);  
			}
		}
		
		for(int j = 0; j < MAX; j++){  //搜索完毕后，还原数组
			node[j].isVisited = false;
		}
	}
	
	public void bfs(){   //广度优先搜索
		node[0].isVisited = true;  //初始化，先从第一个节点开始访问，
		this.displayNode(0);
		queue.add(0);  //把第一个节点放进栈中。
		
		while(!queue.isEmpty()){
			int v = this.getBesideUnvisitedNode(queue.peek());
			if(v == -1){   //如果找不到此节点的没有访问过的相邻节点，就从其他节点找，即v == -1，并从栈中弹出一个节点
				queue.remove();
			}else{
				node[v].isVisited = true;
				this.displayNode(0);
				queue.add(v);  
			}
		}
		
		for(int j = 0; j < MAX; j++){  //搜索完毕后，还原数组
			node[j].isVisited = false;
		}
	}
	
	public void mfs(){   //形成最小生成树
		node[0].isVisited = true;  //初始化，先从第一个节点开始访问，
		stack.push(0);  //把第一个节点放进栈中。
		
		while(!stack.isEmpty()){
			int vv = stack.peek();
			int v = this.getBesideUnvisitedNode(vv);
			if(v == -1){   //如果找不到此节点的没有访问过的相邻节点，就从其他节点找，即v == -1，并从栈中弹出一个节点
				stack.pop();
			}else{
				node[v].isVisited = true;
				stack.push(v);  
				this.displayNode(v);
				this.displayNode(vv);
			}
		}
		
		for(int j = 0; j < MAX; j++){  //搜索完毕后，还原数组
			node[j].isVisited = false;
		}
	}
}
