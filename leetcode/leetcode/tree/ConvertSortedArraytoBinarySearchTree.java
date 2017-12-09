package leetcode.tree;


/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST
 * 
 * 
 * 二叉查找树（Binary Search Tree），也称有序二叉树（ordered binary tree）,排序二叉树（sorted binary tree），是指一棵空树或者具有下列性质的二叉树：

若任意节点的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
任意节点的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
任意节点的左、右子树也分别为二叉查找树。
 

 

再复习下什么是平衡二叉树（引自GeekforGeek）：

An empty tree is height-balanced. A non-empty binary tree T is balanced if:
   1) Left subtree of T is balanced
   2) Right subtree of T is balanced
   3) The difference between heights of left subtree and right subtree is not more than 1.  

 

解决方法是选中点构造根节点，然后递归的构造左子树和右子树。
 */
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode buildTree(int[] num, int low, int high) {
        if (low > high)
            return null;

            //找到数组中点，作为root
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = buildTree(num, low, mid - 1);
        node.right = buildTree(num, mid + 1, high);
        return node;
    }

    public TreeNode sortedArrayToBST(int[] num) {
        return buildTree(num, 0, num.length - 1);
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