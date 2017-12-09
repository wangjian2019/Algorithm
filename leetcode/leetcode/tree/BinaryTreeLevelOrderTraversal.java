package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
 * 用传统的BFS,广度优先便利BFS, 使用两个队列，把当前节点入队1，左右孩子入队2，遍历队列1；队列1和队列2互换位置，把队列1变成队列2，队列2变成队列1,再次。。。。直到遍历完所有层
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

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {  
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();  
	    if(root == null) 
	        return res;  
	    
	    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();  
	    queue.add(root);  
	    int curLevCnt = 1;  
	    int nextLevCnt = 0;  
	    ArrayList<Integer> levelres = new ArrayList<Integer>();  
	    
	    while(!queue.isEmpty()){  
	        TreeNode cur = queue.poll();  
	        curLevCnt--;  
	        levelres.add(cur.value);  
	        
	        if(cur.left != null){  
	            queue.add(cur.left);  
	            nextLevCnt++;  
	        }  
	        if(cur.right != null){  
	            queue.add(cur.right);  
	            nextLevCnt++;  
	        }  
	          
	        if(curLevCnt == 0){  
	            curLevCnt = nextLevCnt;  
	            nextLevCnt = 0;  
	            res.add(levelres);  
	            levelres = new ArrayList<Integer>();  
	        }  
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