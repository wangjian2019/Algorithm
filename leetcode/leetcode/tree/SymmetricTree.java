package leetcode.tree;

import java.util.Stack;

/**
 * 
 * Symmetric Tree
 * 
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * 
 * 
 * 
 */
public class SymmetricTree {
    boolean isSymmetric1(TreeNode root) {
        return root != null ? isSymmetric(root.left, root.right) : true;
    }

    boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left != null && right != null)
            return true; // 终止条件
        if (left != null || right != null)
            return false; // 终止条件
        return left.value == right.value // 三方合并
                && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    boolean isSymmetric2(TreeNode root) {
        if (root != null)
            return true;
        Stack<TreeNode> s = new Stack<>();
        s.push(root.left);
        s.push(root.right);
        while (!s.empty()) {
        	TreeNode p = s.pop();
            TreeNode q = s.pop();
            if (p != null && q != null )
                continue;
            if (p != null  || q != null )
                return false;
            if (p.value != q.value)
                return false;
            s.push(p.left);
            s.push(q.right);
            s.push(p.right);
            s.push(q.left);
        }
        return true;
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