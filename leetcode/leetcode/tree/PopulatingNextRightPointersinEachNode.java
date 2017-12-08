package leetcode.tree;

public class PopulatingNextRightPointersnEachNode {
    void connect(TreeLinkNode root) {
        while (root) {
            TreeLinkNode next = null; // the first node of next level
            TreeLinkNode prev = null; // previous node on the same level
            for (; root; root = root.next) {
                if (!next)
                    next = root.left ? root.left : root.right;
                if (root.left) {
                    if (prev)
                        prev.next = root.left;
                    prev = root.left;
                }
                if (root.right) {
                    if (prev)
                        prev.next = root.right;
                    prev = root.right;
                }
            }
            root = next; // turn to next level
        }
    }

    void connect(TreeLinkNode root) {
        if (root == null)
            return;
        TreeLinkNode dummy = new TreeLinkNode(-1);
        for (TreeLinkNode curr = root, prev = dummy; curr; curr = curr.next) {
            if (curr.left != null) {
                prev.next = curr.left;
                prev = prev.next;
            }
            if (curr.right != null) {
                prev.next = curr.right;
                prev = prev.next;
            }
        }
        connect(dummy.next);
    }

      private class TreeLinkNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode next;
        

        public TreeNode(int value) {
            this.value = value;
        }
    }
}