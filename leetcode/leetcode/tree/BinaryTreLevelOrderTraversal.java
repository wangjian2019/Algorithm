package leetcode.tree;

/**
 * Binary Tree Level Order Traversal
 * 
 * 
 * Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by
 * level).
 * For example: Given binary tree {3,9,20,#,#,15,7},
 *    3
 *   / \
 *  9  20
 * / \
 *15  7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * 
 * 
 * 题解：
 * 广度优先便利BFS, 使用两个队列，把当前节点入队1，左右孩子入队2，遍历队列1；队列1和队列2互换位置，把队列1变成队列2，队列2变成队列1,再次。。。。直到遍历完所有层
 * 
 * 
 * 
 * 
 * Binary Tree Level Order Traversal II
 * Given a binary tree, return the bottom-up level order traversal of its nodes’ values. (ie, from left to right,
 * level by level from leaf to root).
 * For example: Given binary tree {3,9,20,#,#,15,7},
 *    3
 *   / \
 *  9  20
 * / \
 *15  7
 * return its bottom-up level order traversal as:
 * [
 * [15,7]
 * [9,20],
 *[3],
 * ]
 * 
 * 
 * 
 * 题解：同样广度优先便利BFS, 在上一题的基础上， reverse() 一下即可
 * 
 */
public class BinaryTreeLevelOrderTraversal {

    //
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new List<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> current;
        Queue<TreeNode> next;
        List<Integer> level; // elments in level level
        current.offer(root);
        while (!current.empty()) {
            while (!current.empty()) {
                TreeNode node = current.poll();
                level.add(node.value);
                if (node.left != null) {
                    next.push(node.left);
                }
                if (node.right != null) {
                    next.push(node.right);
                }
            }
            result.add(level);
            level.clear();
            swap(next, current);
        }
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new List<List<Integer>>();
        traverse(root, 1, result);
        return result;
    }

    public void traverse(TreeNode root, int level, List<List<Integer>> result) {
        if (!root)
            return;
        if (level > result.size()) {
            result.add(new ArrayList<Integer>());
        }
        result.get(level - 1).add(root.value);
        traverse(root.left, level + 1, result);
        traverse(root.right, level + 1, result);
    }

    public List<List<Integer>> levelOrderII1(TreeNode root) {
        List<List<Integer>> result = new List<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> current;
        Queue<TreeNode> next;
        List<Integer> level; // elments in level level
        current.offer(root);
        while (!current.empty()) {
            while (!current.empty()) {
                TreeNode node = current.poll();
                level.add(node.value);
                if (node.left != null) {
                    next.push(node.left);
                }
                if (node.right != null) {
                    next.push(node.right);
                }
            }
            result.add(level);
            level.clear();
            swap(next, current);
        }
        reverse(result.begin(), result.end());
        return result;
    }

    public List<List<Integer>> levelOrderII2(TreeNode root) {
        List<List<Integer>> result = new List<List<Integer>>();
        traverse(root, 1, result);
        reverse(result.begin(), result.end());
        return result;
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