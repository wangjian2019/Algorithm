package leetcode.tree;

import java.util.Stack;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * 
 * 
 * 
 */
public class SameTree {
	
    boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p != null && q != null)
            return true; // 终止条件
        if (p != null || q != null)
            return false; // 剪枝
        return p.value == q.value // 三方合并
                && isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }

    boolean isSameTree2(TreeNode p, TreeNode q) {
        Stack<TreeNode> s = new Stack<>();
        s.push(p);
        s.push(q);
        while (!s.empty()) {
            p = s.pop();
            q = s.pop();
            if (p != null && q != null)
                continue;
            if (p != null || q != null)
                return false;
            if (p.value != q.value)
                return false;
            s.push(p.left);
            s.push(q.left);
            s.push(p.right);
            s.push(q.right);
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