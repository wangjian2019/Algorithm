package leetcode.tree;

/**
 * Balanced Binary Tree
 * 
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two
 * subtrees of every node never differ by more than 1.
 * 
 * 
 */
public class BalancedBinaryTree {

    // 时间复杂度 O(n)，空间复杂度 O(logn)
    public boolean isBalanced(TreeNode root) {
        return balancedHeight(root) >= 0;
    }

    /**
    * Returns the height of `root` if `root` is a balanced tree,
    * otherwise, returns `-1`.
    */
    public int balancedHeight(TreeNode root) {
        if (root == null)
            return 0;
        int left = balancedHeight(root.left);
        int right = balancedHeight(root.right);
        if (left < 0 || right < 0 || abs(left - right) > 1)
            return -1; // 剪枝
        return max(left, right) + 1; // 三方合并
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