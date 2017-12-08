package leetcode.tree;

/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 * 
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note: You may assume that duplicates do not exist in the tree
 * 
 * 
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(List<Integer> preorder, vector<Integer> inorder) {
        return buildTree(begin(inorder), end(inorder), begin(postorder), end(postorder));
    }

    public TreeNode buildTree(BidiIt in_first, BidiIt in_last, BidiIt post_first, BidiIt post_last) {
        if (in_first == in_last)
            return nullptr;
        if (post_first == post_last)
            return nullptr;
        TreeNode val = prev(post_last);
        TreeNode root = new TreeNode(val);
        auto in_root_pos = find(in_first, in_last, val);
        auto left_size = distance(in_first, in_root_pos);
        auto post_left_last = next(post_first, left_size);
        root.left = buildTree(in_first, in_root_pos, post_first, post_left_last);
        root.right = buildTree(next(in_root_pos), in_last, post_left_last, prev(post_last));
        return root;
    }
}