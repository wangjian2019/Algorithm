package leetcode.tree;

public class PopulatingNextRightPointersnEachNode {
	
    public void connect1(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode next = null; // the first node of next level
            TreeLinkNode prev = null; // previous node on the same level
            for (; root != null; root = root.next) {
                if (next != null)
                    next = root.left != null ? root.left : root.right;
                if (root.left != null) {
                    if (prev != null)
                        prev.next = root.left;
                    prev = root.left;
                }
                if (root.right!= null) {
                    if (prev!= null)
                        prev.next = root.right;
                    prev = root.right;
                }
            }
            root = next; // turn to next level
        }
    }

    public void connect2(TreeLinkNode root) {
        if (root == null)
            return;
        TreeLinkNode dummy = new TreeLinkNode(-1);
        for (TreeLinkNode curr = root, prev = dummy; curr != null; curr = curr.next) {
            if (curr.left != null) {
                prev.next = curr.left;
                prev = prev.next;
            }
            if (curr.right != null) {
                prev.next = curr.right;
                prev = prev.next;
            }
        }
        connect2(dummy.next);
    }

      private class TreeLinkNode {
        public int value;
        public TreeLinkNode left;
        public TreeLinkNode right;
        public TreeLinkNode next;
        

        public TreeLinkNode(int value) {
            this.value = value;
        }
    }
}