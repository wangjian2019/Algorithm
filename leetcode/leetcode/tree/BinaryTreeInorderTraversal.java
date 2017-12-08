package leetcode.tree;


/**
 * Binary Tree Inorder Traversal
 * 
 * Given a binary tree, return the inorder traversal of its nodes’ values.
 * For example: Given binary tree {1,#,2,3},
 * 1
 * \
 *  2
 * /
 * 3
 * return [1,3,2].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * 
 * 树的中序遍历方式：left->root->right
 * 1. 迭代： 使用辅助stack， 时间复杂度o(n), 空间复杂度o(n)
 * 2, 递归： 时间复杂度o(n)
 * 3. Morris 遍历: 时间复杂度o(n), 空间复杂度o(1)
 * 
 * 
 * 
 */
public class BinaryTreeInorderTraversal{

      // 方法一：使用stack辅助来迭代
    public List<Integer> preorderTraversal1(TreeNode root) {
         List<Integer> result = new ArrayList<Integer>();
        TreeNode p;
        Stack<TreeNode> s = new Stack<TreeNode>();
        p = root;

        while (!s.empty() || p != null) {
            //把当前节点入栈，往左孩子移动，直到找到整个树的最左下角的叶子节点
            if (p != null) {
                s.push(p);
                p = p.left;
            } else {
                p = s.peek();
                s.pop();
                result.add(p.value);
                p = p.right;
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
		    preOrderRecursion(p.left);
            result.add(p.value);
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