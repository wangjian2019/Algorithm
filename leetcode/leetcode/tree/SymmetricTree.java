package leetcode.tree;

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
    bool isSymmetric(TreeNode root) {
        return root ? isSymmetric(root.left, root.right) : true;
    }

    bool isSymmetric(TreeNode left, TreeNode right) {
        if (!left && !right)
            return true; // 终止条件
        if (!left || !right)
            return false; // 终止条件
        return left.val == right.val // 三方合并
                && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    bool isSymmetric(TreeNode root) {
        if (!root)
            return true;
        stack<TreeNode> s;
        s.push(root.left);
        s.push(root.right);
        while (!s.empty()) {
            auto p = s.top();
            s.pop();
            auto q = s.top();
            s.pop();
            if (!p && !q)
                continue;
            if (!p || !q)
                return false;
            if (p.val != q.val)
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