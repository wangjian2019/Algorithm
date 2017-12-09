package leetcode.tree;

import java.util.Stack;

/**
 * 
 * 
 * Given a binary tree, flatten it to a linked list in-place.
 * For example, Given
 *    1
 *   / \
 *  2   5
 * / \   \
 *3   4   6
 * The flattened tree should look like:
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * 
 */
public class FlattenBinaryTreetoLinkedList {
	
    public void flatten1(TreeNode root) {
        if (root == null)
            return; // 终止条件
        flatten1(root.left);
        flatten1(root.right);
        if (null == root.left)
            return;
        // 三方合并，将左子树所形成的链表插入到 root 和 root.right 之间
        TreeNode p = root.left;
        while (p.right != null)
            p = p.right; //寻找左链表最后一个节点
        p.right = root.right;
        root.right = root.left;
        root.left = null;
    }

    //前序遍历，把遍历到的元素逐个放入Linkedlist中
    void flatten2(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.empty()) {
        	TreeNode p = s.pop();
            if (p.right != null)
                s.push(p.right);
            if (p.left != null)
                s.push(p.left);
            p.left = null;
            if (!s.empty())
                p.right = s.pop();
        }
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