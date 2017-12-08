package leetcode.tree;

/**
 * 
 * 
 * 
 * Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right,
 * then right to left for the next level and alternate between).
 * For example: Given binary tree 3,9,20,#,#,15,7,
 *   3
 *  / \
 *  9 20
 * / \
 *15 7
 *return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * 
 * 
 * 
 * Solution ： 广度优先遍历（），用一个 bool 记录是从左到右还是从右到左，每一层结束就翻转一下
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new List<List<Integer>>();
        traverse(root, 1, result, true);
        return result;
    }

    public void traverse(TreeNode root, int level, List<List<Integer>> result, boolean left_to_right) {
        if (!root)
            return;
        if (level > result.size()) {
            result.add(new ArrayList<Integer>());
        }
        if (left_to_right) {
            result.get(level - 1).add(root.val);
        } else {
            result.get(level - 1).insert(result.get(level - 1).begin(), root.val);
        }
        //每次都是取反!left_to_right
        traverse(root.left, level + 1, result, !left_to_right);
        traverse(root.right, level + 1, result, !left_to_right);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new List<List<Integer>>();
        if (null == root) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        boolean left_to_right = true; //left to right
        List<Integer> level = new List<Integer>(); // one level's elements
        q.offer(root);
        q.offer(null); // level separator
        while (!q.empty()) {
            TreeNode cur = q.poll();
            if (cur) {
                level.add(cur.val);
                if (cur.left) {
                    q.push(cur.left);
                }
                if (cur.right) {
                    q.add(cur.right);
                }
            } else {
                if (left_to_right) {
                    result.push_back(level);
                } else {
                    reverse(level.begin(), level.end());
                    result.add(level);
                }
                level.clear();
                left_to_right = !left_to_right;
                if (q.size() > 0) {
                    q.push(null);
                }
            }
        }
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