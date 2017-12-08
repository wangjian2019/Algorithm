package leetcode.tree;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * 
 * 
 * 
 */
public class SameTree {
    bool isSameTree(TreeNode p, TreeNode q) {
        if (!p && !q)
            return true; // 终止条件
        if (!p || !q)
            return false; // 剪枝
        return p.val == q.val // 三方合并
                && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    bool isSameTree(TreeNode p, TreeNode q) {
        stack<TreeNode> s;
        s.push(p);
        s.push(q);
        while (!s.empty()) {
            p = s.top();
            s.pop();
            q = s.top();
            s.pop();
            if (!p && !q)
                continue;
            if (!p || !q)
                return false;
            if (p.val != q.val)
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