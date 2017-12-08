package leetcode.tree;



/**
 * Binary Tree Postorder Traversal
 * 
 * 
 * Given a binary tree, return the postorder traversal of its nodes’ values.
 * For example: Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 * 
 * return [3,2,1].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * 
 * 树的中序遍历方式：left->right->root
 * 1. 迭代： 使用辅助stack， 时间复杂度o(n), 空间复杂度o(n)
 * 2, 递归： 时间复杂度o(n)
 * 3. Morris 遍历: 时间复杂度o(n), 空间复杂度o(1)
 * 
 * 
 */
public class BinaryTreePostorderTraversal{

    // 方法一：使用stack辅助来迭代
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        TreeNode p;
        TreeNode q;
        Stack<TreeNode> s = new Stack<TreeNode>();
        p = root;

        do {
            /* 把当前节点往左下走 */
            while (p != null) { 
                s.push(p);
                p = p.left;
            }
            q = null;
            while (!s.empty()) {
                p = s.peek();
                s.pop();
                /* 右孩子不存在或已被访问，访问之 */
                if (p.right == q) {
                    result.add(p.value);
                    /* 保存刚访问过的结点 */
                    q = p; 
                } else {
                    /* 当前结点不能访问，需第二次进栈 */
                    s.push(p);
                    /* 先处理右子树 */
                    p = p.right;
                    break;
                }
            }
        } while (!s.empty());
        return result;
    }

    // 方法二：递归
    public void preorderTraversal2(TreeNode root){  
        TreeNode p;
        p = root;
        List<Integer> result = new ArrayList<Integer>(); 
		if(root != null){
		    preOrderRecursion(p.left);
		    preOrderRecursion(p.right);
            result.add(p.value);	
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