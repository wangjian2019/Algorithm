package leetcode.tree;

import java.util.ArrayList;


/**
 * Convert Sorted List to Binary Search Tree
 * 
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced
 * BST.
 * 
 */
public class ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        list.add(head);
        return helper(list, 0, count - 1);
    }

    private TreeNode helper(ArrayList<ListNode> list, int l, int r) {
        if (l > r)
            return null;
        int m = (l + r) / 2;
        TreeNode left = helper(list, l, m - 1);
        TreeNode root = new TreeNode(list.get(0).value);
        root.left = left;
        list.set(0, list.get(0).next);
        root.right = helper(list, m + 1, r);
        return root;
    }
    
    private class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
    
    private class ListNode {
  		int value;
  		ListNode next;

  		ListNode(int value) {
  			this.value = value;
  		}
  	}
}