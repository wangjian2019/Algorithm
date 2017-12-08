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
    bool isValidBST(TreeNode root) {
        return isValidBST(root, INT_MIN, INT_MAX);
    }

    bool isValidBST(TreeNode root, int lower, int upper) {
        if (root == null)
            return true;
        return root.val > lower && root.val < upper && isValidBST(root.left, lower, root.val)
                && isValidBST(root.right, root.val, upper);
    }
}