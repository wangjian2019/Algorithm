package leetcode.tree;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 * 
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note: You may assume that duplicates do not exist in the tree
 * 
 * 
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(List<Integer> preorder, vector<Integer> inorder) {
        return buildTree(begin(preorder), end(preorder), begin(inorder), end(inorder));
    }

    public TreeNode buildTree(Integer pre_first, Integer pre_last, Integer in_first,
            Integer in_last) {
        if (pre_first == pre_last)
            return null;
        if (in_first == in_last)
            return null;
        TreeNode root = new TreeNode(pre_first);
        TreeNode inRootPos = find(in_first, in_last, pre_first);
        TreeNode leftSize = distance(in_first, inRootPos);
        root.left = buildTree(next(pre_first), next(pre_first, leftSize + 1), in_first, next(in_first, leftSize));
        root.right = buildTree(next(pre_first, leftSize + 1), pre_last, next(inRootPos), in_last);
        return root;
    }
}