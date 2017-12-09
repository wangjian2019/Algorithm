package leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Zigzag Level Order Traversal
 * 
 * 
 * Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right,
 * then right to left for the next level and alternate between).
 * For example: Given binary tree 3,9,20,#,#,15,7,
 *   3
 *  / \
 *  9 20
 * / \
 *15  7
 *return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * 
 * 
 * 
 * Solution ： 广度优先遍历（），用一个 boolean 记录是从左到右还是从右到左，每一层结束就翻转一下
 */
public class BinaryTreeZigzagLevelOrderTraversal {

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
	     ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	     
	     if(root==null)
	         return res;
	     
	     LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	     queue.add(root);
	     
	     int num = 0;
	     boolean reverse = false;//a flag
	     
	     while(!queue.isEmpty()){
	         num = queue.size();
	         ArrayList<Integer> levelres = new ArrayList<Integer>();
	         
	         for(int i = 0; i<num; i++){
	             TreeNode node = queue.poll();
	             levelres.add(node.value);
	             
	             if(node.left!=null)
	                 queue.add(node.left);
	             if(node.right!=null)
	                 queue.add(node.right);
	         }
	         
	         if(reverse){
	             Collections.reverse(levelres);
	             reverse = false;
	         }else{
	             reverse = true;
	         }
	         res.add(levelres);
	     }
	     
	     return res;
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