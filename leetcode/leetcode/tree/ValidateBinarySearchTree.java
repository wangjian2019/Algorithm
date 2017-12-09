package leetcode.tree;


/**
 * 
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:
• The left subtree of a node contains only nodes with keys less than the node’s key.
• The right subtree of a node contains only nodes with keys greater than the node’s key.
Both the left and right subtrees must also be binary search trees
 */
public class ValidateBinarySearchTree {
    boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isValidBST(TreeNode root, int lower, int upper) {
        if (root == null)
            return true;
        return root.value > lower && root.value < upper && isValidBST(root.left, lower, root.value)
                && isValidBST(root.right, root.value, upper);
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