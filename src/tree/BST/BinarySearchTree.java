package tree.BST;
import java.util.Stack;
/**
*  为什么会有Tree这个数据结构?
*    有序数组查找快o(1)，插入和删除慢o(n)
*    链表插入和删除快o(1)，查找需要从头结点开始遍历查找慢o(n)
*    因此，引入Tree这个数据结构。而二叉树普遍用于存储与搜索，因此二叉搜索树出现了，插入，删除，查找，都非常快。
*
*/

/**二叉搜索树的搜索，插入，删除，树高=o(log(n))
 * 1.度为2的有序树与二叉树不同，二叉树为有序树，左面是第一棵子树，右面是第二棵子树。
 * 2.深度为5的树，最多有2^5-1个节点，最少有5个节点。
 * 3.深度为5的树，最后一层最多有2^(5-1)
 * 4.任何二叉树，终端节点数n,度为2节点m, n = m + 1
 * 5.n个节点的完全二叉树深度为【log(n)】+1
 * 前序和中序能确定。中序和后序能确定。其他不能不唯一。
 * 二叉遍历树：o(n) 
 * 在二叉搜索数中查找某节点：o(log(n))
 * 线索二叉树：除了有左右孩子的引用之外，还有前驱与后继的引用（根据前序遍历，后序遍历，中序遍历的不同，前驱后继引用也不同）
 * 平衡二叉树：左右子树深度只差绝对值不大于1
 * 
 * 二叉搜索树的左子节点小于此节点，右子结点大于等于此节点。
 * 二叉搜索树的效率取决于是否是平衡二叉搜索树，越平衡效率越高，平衡指的就是搜索二叉树的各个子树高度只差不能大于1，即为平衡。
 * 不平衡的产生原因是插入的顺序造成的，如果关键字是随机插入，那么树大部分时候应该是平衡的，但是如果插入顺序按照升序或者降序或是按照某规律插入，那么树就不会是平衡的了。
 *
 * 常见的树的操作的时间复杂度都是o(log(n))，树的操作都很快，只有遍历最慢o(n)，但是遍历树的操作不常用。
 */
public class BinarySearchTree {
	private Node root;
	public BinarySearchTree(){
		root = null;  //初始状态下为一个空树
	}
	
	/*
	 * 递归的创建二叉搜索树(传入root根节点，和要插入的节点，构建二叉搜索树)
	 */
	public void buildTree(Node root, int data) {
		if (root == null) {// 如果根节点为空，创建根节点
			root = new Node(data);
		} else {
			if (data < root.data) {// 插入到左子树
				if (root.leftChild == null) {// 左节点为空，直接创建值为data的左节点
					root.leftChild = new Node(data);
				} else {// 左节点不为空，调用buildTree函数插到左子树中
					buildTree(root.leftChild, data);
				}
			} else {
				if (root.rightChild == null) {
					root.rightChild = new Node(data);
				} else {
					buildTree(root.rightChild, data);
				}
			}
		}
	}
	
	/**
	 * 剑指offer第6题：重建二叉树，根据前序、中序的遍历结果，生成一个二叉树（前序中序结果中不含有重复值）
	 *
	 * 思路: 前序遍历第一个元素是根节点，中序遍历根节点在中间，左面是左子树，右面是右子树。
	 *       现在前序遍历中找到root，再根据这个root找到中序遍历中的root，然后分别对左子树和右子树递归上面操作
	 */
	public Node rebuildTree(int[] preOrder, int start1, int end1, int[] inOrder, int start2, int end2){
		if(preOrder == null || inOrder == null || preOrder.length <= 0 || inOrder.length == 0){
			return null;
		}
		int rootValue = preOrder[0];
		Node root = new Node(rootValue);
		root.leftChild = null;
		root.rightChild = null;
		
		if(start1 == end1){
			if(start2 == end2 && preOrder[start1] == inOrder[start2]){
				return root;
			}else{
				throw new RuntimeException("invalid input.");
			}
		}
		//在中序遍历inOrder中查找根节点的值
		int rootValueInOrder = start2;
		while(rootValueInOrder <= end2 && inOrder[rootValueInOrder] != rootValue){
			rootValueInOrder++;
		}
		if(rootValueInOrder == end2 && inOrder[rootValueInOrder] != rootValue){
			throw new RuntimeException("invalid input.");
		}
		
		int leftLength = rootValueInOrder - start2;
		int leftPreOrderEnd = start1 + leftLength;
		if(leftLength > 0){
			//构建左子树
			root.leftChild = rebuildTree(preOrder,start1,leftPreOrderEnd,inOrder,start2,rootValueInOrder-1);
		}
		if(leftLength < end1 - start1){
			//构建右子树
			root.rightChild = rebuildTree(preOrder,leftPreOrderEnd,end1,inOrder,rootValueInOrder+1,end2);
		}
		return root;
	}
	
	public void insert(int data){
		Node node = new Node(data);
		if(root == null){      //如果根节点为空，那么是空树，新插入的节点就是根节点
			root = node;
		}else{
			Node current = root;       
			Node previous;
			for(;current!=null;){
				previous = current;
				if(data < node.data){
					current = current.leftChild;
					if(current == null){
						previous.leftChild = node;
						return;
					}
				}else if(data > node.data){
					current = current.rightChild;
					if(current == null){
						previous.rightChild = node;
						return;
					}
				}
			}
		}
	}
	
	//求二叉树高度
	public int height(Node node) {    
        if (node == null)    //如果空树，高度为0
            return 0;  
        else {  
            int leftTreeHeight = height(node.leftChild);  
            int rightTreeHeight = height(node.rightChild);  
            return leftTreeHeight > rightTreeHeight ? leftTreeHeight + 1  
                    : rightTreeHeight + 1;  
        }  
    } 
	
	//求二叉树节点总数
	public int nodesNumber(Node node) {  
        if (node == null){//如果空树，高度为0   
        	return 0; 
        }else {  
            int left = nodesNumber(node.leftChild);  
            int right = nodesNumber(node.rightChild);  
            return left + right + 1;  
        }  
    }  
	
	// 求二叉树父节点个数  
	public static int fatherNodes(Node node) {    
        if (node == null || (node.leftChild == null && node.rightChild == null))  
            return 0;  
        else {  
            int left = fatherNodes(node.leftChild);  
            int right = fatherNodes(node.rightChild);  
            return left + right + 1;  
        }  
    } 
	
	//求二叉树叶子节点个数
	public int leafNumber(Node node) {    
	   if (node == null)  
	       return 0;  
	   else {  
	       int left = leafNumber(node.leftChild);  
           int right = leafNumber(node.rightChild);  
           if (node.leftChild == null && node.rightChild == null){
           	    return left + right + 1;  
           }else{
           	    return left + right;  
           }    
       }  
   }  
	
	// 计算有两个节点的父节点的个数  
    public static int doubleChildFather(Node node) {   
        int left, right;  
        if (node == null)  
            return 0;  
        else {  
            left = doubleChildFather(node.leftChild);  
            right = doubleChildFather(node.rightChild);  
            if (node.leftChild != null && node.rightChild != null)  
                return (left + right + 1);/* 加1是因为要算上根节点 */  
            else  
                return (left + right);  
        }  
    }  
	
    // 求只有一个孩子结点的父节点个数  
	public static int oneChildFather(Node node) {   
        int left, right;  
        if (node == null || (node.rightChild == null && node.leftChild == null))  
            return 0;  
        else {  
            left = oneChildFather(node.leftChild);  
            right = oneChildFather(node.rightChild);  
            if ((node.leftChild != null && node.rightChild == null)  
                    || (node.leftChild == null && node.rightChild != null))  
                return left + right + 1;  /* 加1是因为要算上根节点 */  
            else  
                return left + right;
        }  
    }  
	
	// 求二叉树只拥有左孩子的父节点总数  
    public static int leftChildFather(Node node) {   
        if (node == null)  
            return 0;  
        else {  
            int left = leftChildFather(node.leftChild);  
            int right = leftChildFather(node.rightChild);  
            if ((node.leftChild != null && node.rightChild == null))  
                return left + right + 1;  
            else  
                return left + right;  
        }  
    }  
   
    // 求二叉树只拥有右孩子的结点总数  
    public static int rightChildFather(Node node) {   
        if (node == null || node.rightChild == null)  
            return 0;  
        else {  
            int left = rightChildFather(node.leftChild);  
            int right = rightChildFather(node.rightChild);  
            if (node.leftChild == null && node.rightChild != null)  
                return left + right + 1;  
            else  
                return left + right;  
        }  
    } 

	// 取得搜索二叉树最小值（最左下角的节点）
	public Node getMinNumber(){
		Node current, last = null;
		current = root;
		while(current != null){
			last = current;
			current = current.leftChild;
		}
		return last;
	}
	
    // 取得搜索二叉树最大值（最右下角的节点）
	public Node getMaxNumber(){
		Node current, last = null;
		current = root;
		while(current != null){
			last = current;
			current = current.rightChild;
		}
		return last;
	}
	
	//把根节点传进来，前序遍历
	public void preOrderRecursion(Node node){   
		if(node != null){
		System.out.print(node.data);
		preOrderRecursion(node.leftChild);
		preOrderRecursion(node.rightChild);
			
		}
	}
	
	public void preOrder(Node node) {  
        Stack<Node> stack = new Stack<Node>();  //栈本身在java.util.Stack类库中一定义好了
        if (node != null) {     //判断是否为空树
            stack.push(node);     //先把根节点入栈
            while (!stack.isEmpty()) {    
                node = stack.pop();      
                System.out.print(node.data);  
                if (node.rightChild != null)  
                    stack.push(node.rightChild);    //先放右子树，再放左子树，出栈的时候就是先出左子树，再出右子树
                if (node.leftChild != null)  
                    stack.push(node.leftChild);  
            }  
        }  
    }  
	
	//把根节点传进来，中序遍历
	public void inOrderRecursion(Node node){     
		if(node != null){
		preOrderRecursion(node.leftChild);
		System.out.print(node.data);
		preOrderRecursion(node.rightChild);
			
		}
	}
	
	public void inOrder(Node node) {  
        Stack<Node> stack = new Stack<Node>();  //栈本身在java.util.Stack类库中一定义好了
        while (node != null) {  //判断是否为空树
            while (node != null) {  
                if (node.rightChild != null)  
                    stack.push(node.rightChild);// 当前节点右子入栈  
                stack.push(node);// 当前节点入栈  
                node = node.leftChild;  
            }  
            node = stack.pop();  
            while (!stack.empty() && node.rightChild == null) {  
                System.out.print(node.data);  
                node = stack.pop();  
            }  
            System.out.print(node.data);  
            if (!stack.empty())  
                node = stack.pop();  
            else  
                node = null;  
        }  
    }  
	
	//把根节点传进来，后序遍历
	public void postOrderRecursion(Node node){    
		if(node != null){
		preOrderRecursion(node.leftChild);
		preOrderRecursion(node.rightChild);
		System.out.print(node.data);	
		}
	}
	
	 public void postOrder(Node node) {  
	    Node temp = node;  
	    Stack<Node> stack = new Stack<Node>();  
	    while (node != null) {  // 左子树入栈  
	        for (; node.leftChild != null; node = node.leftChild)  
	            stack.push(node);   // 当前节点无右子或右子已经输出  
	        while (node != null  && (node.rightChild == null || node.rightChild == temp)) {  
	            System.out.print(node.data);  
	            temp = node;// 记录上一个已输出节点  
	            if (stack.empty()){
	                return;
	            } 
	            node = stack.pop();  
	            }  
	            // 处理右子  
	            stack.push(node);  
	            node = node.rightChild;  
	        }  
	 }  
	 
	/**
	 *  删除节点：
	 *  （1）如果被删除节点没有子节点，直接删除 
	 *  （2）如果被删除节点有一个子节点，删除此节点，把子节点连接到被删节点的父节点上 
	 *  （3）如果被删除节点有两个子节点，删除有两个子节点的节点，用它的中序后继代替被删节点 
	 * @param data
	 * @return
	 */
	public boolean delete(int data){
		Node current = root;
		Node previous = root;
		boolean isLeftChild = true;
		while(current != null){
			previous = current;
			if(current.data < data){
				current = current.leftChild;
				isLeftChild = true;
			}else if(current.data > data){
				current = current.rightChild;
				isLeftChild = false;
			}
		}
		if(current.leftChild == null && current.rightChild == null){
			if(current == root){
				root = null;
				return true;
			}
			if(isLeftChild){
				previous.leftChild = null;
				return true;
			}else if(!isLeftChild){
				previous.rightChild = null;
				return true;
			}
		}else if(current.leftChild == null && current.rightChild != null){
			if(current == root){
				root = root.rightChild;
				return true;
			}
			if(isLeftChild){
				previous.leftChild = current.rightChild;
				return true;
			}else if(!isLeftChild){
				previous.rightChild = current.rightChild;
				return true;
			}
		}else if(current.leftChild != null && current.rightChild == null){
			if(current == root){
				root = root.leftChild;
				return true;
			}
			if(isLeftChild){
				previous.leftChild = current.leftChild;
				return true;
			}else if(!isLeftChild){
				previous.rightChild = current.leftChild;
				return true;
			}
		} else if(current.leftChild != null && current.rightChild != null){
			Node successor = getSuccessor(current);
			if(current == root){
				root = successor;
			}else if(isLeftChild){
				previous.leftChild = successor;
			}else if(!isLeftChild){
				previous.rightChild = successor;
			}
			successor.leftChild = current.leftChild;
		}
		return true;
	}

	public Node getSuccessor(Node node) {
		Node successPrevious = node;
		Node successor = node;
		Node current = node.rightChild;
		while(current != null){
			successPrevious = successor;
			successor = current;
			current = current.leftChild;
		}
		if(successor != node.rightChild){
			successPrevious.leftChild = successor.rightChild;
			successor.rightChild = node.rightChild;
		}
		return successor;
	}
	 
	// 将树中的每个节点的孩子对换位置  
    public void exChange(Node node) {  
        if (node == null){
        	return;
        }
        if (node.leftChild != null){
        	exChange(node.leftChild);  
        }  	
        if (node.rightChild != null){
        	exChange(node.rightChild);  
        }  
        Node temp = node.leftChild;  
        node.leftChild = node.rightChild;  
        node.rightChild = temp;  
    } 
    
  //递归求二叉树中所有结点的和  
    public  static int getSumByRecursion(Node node){  
        if(node == null){  
            return 0;  
        }  
        else{  
            int left=getSumByRecursion(node.leftChild);  
            int right=getSumByRecursion(node.rightChild);  
            return node.data +left+right;  
        }  
          
    }  
    
  //非递归求二叉树中所有结点的和  
    public static int getSumByNoRecursion(Node node){   
        Stack<Node> stack = new Stack<Node>();  
        int sum=0;  
        if(node != null){  
            stack.push(node);  
            while(!stack.isEmpty()){  
                node=stack.pop();  
                sum = sum + node.data;  
                if(node.leftChild!=null)  
                    stack.push(node.leftChild);  
                if(node.rightChild!=null)  
                    stack.push(node.rightChild);  
            }  
              
        }  
        return sum;  
          
    }  
    
    //比较两棵二叉树树是否相同
    public boolean compareTwoTrees(Node root1, Node root2){   //判断两个树是否相等
    	if(root1 == null && root2 == null){
    		return true;
    	}else if(root1 != null && root2 == null){
    		return false;
    	}else if(root1 == null && root2 != null){
    		return true;
    	}
    	if(root1.data != root2.data){
    		return false;
    	}else{
    		if(compareTwoTrees(root1.leftChild, root2.leftChild) && compareTwoTrees(root1.rightChild, root2.rightChild)){
    			return true;
    		}
    	}
    	return true;
    }
	
	private class Node {
		int data;
		Node leftChild;
		Node rightChild;
		
		public Node(int data){
			this.data = data;
		}
		
		public String toString(){
			return Integer.toString(data) + "  ";
		}
	}
	
	public static void main(String ars[]) {
		int[] a = { 2, 4, 12, 45, 21, 6, 111 };
		BinarySearchTree binTree = new BinarySearchTree();
		for (int i = 0; i < a.length; i++) {
			binTree.buildTree(binTree.root, a[i]);
		}
		System.out.print("前序遍历");
		binTree.preOrder(binTree.root);
		System.out.println("");
		System.out.print("中序遍历");
		binTree.inOrder(binTree.root);
		System.out.println("");
		System.out.print("后序遍历");
		binTree.postOrder(binTree.root);
	}
}




