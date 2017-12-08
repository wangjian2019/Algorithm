package leetcode.tree;

/**
 * Recove Binary Search Tree
 * 
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * Note: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * 
 * 
 * 
 * 题解：中序遍历找顺序不对的两个点，最后swap一下就好。
 * 
 * 对于一个BST的二叉搜索树，中序遍历，是一个递增的从小到大的过程
 * 
 * Inorder用了递归来解决，所以为了能存储这两个逆序点，这里用了全局变量
 */
public class RecoverBinarySearchTree {
    TreeNode pre;
    TreeNode first;
    TreeNode second;

    public void recoverTree(TreeNode root) {
        pre = null;
        first = null;
        second = null;
        inorder(root);
        //交换两个值
        if (first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        if (pre == null) {
            pre = root; //pre指针初始
        } else {
            if (pre.val > root.val) {
                if (first == null) {
                    first = pre;//第一个逆序点
                }
                second = root; //不断寻找最后一个逆序点
            }
            pre = root; //pre指针每次后移一位
        }
        inorder(root.right);
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