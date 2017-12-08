package leetcode.tree;



/**
 * Binary Tree Preorder Traversal
 * 
 * Given a binary tree, return the preorder traversal of its nodes’ values.
 * For example: Given binary tree {1,#,2,3},return [1,2,3].
 * 1
 *  \
 *   2
 *  /
 * 3
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * 
 * 树的前序遍历方式：root->left->right
 * 1. 迭代： 广度优先搜索（BFS），使用辅助stack， 时间复杂度o(n), 空间复杂度o(n)
 * 2, 递归： 深度优先搜索（DFS），时间复杂度o(n)
 * 3. Morris 遍历: 时间复杂度o(n), 空间复杂度o(1)
 * 
 */
public class BinaryTreePreorderTraversal{

    // 方法一：使用stack辅助来迭代
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        TreeNode p;
        Stack<TreeNode> s = new Stack<TreeNode>();
        p = root;
        if (p != null){
            s.push(p);
        } 
        while (!s.empty()) {
            p = s.peek();
            s.pop();
            result.add(p.value);
            //stack是先入后出，所以右面的子树先入栈
            if (p.right != null){
                s.push(p.right);
            } 
             //stack是先入后出，所以左面的子树后入栈
            if (p.left != null){
                s.push(p.left);
            } 
        }
        return result;
    }

    // 方法二：递归
    public void preorderTraversal2(TreeNode root){  
        TreeNode p;
        p = root;
        List<Integer> result = new ArrayList<Integer>(); 
		if(root != null){
		    result.add(p.value);
		    preOrderRecursion(p.left);
		    preOrderRecursion(p.right);	
		}
	}






    private class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}