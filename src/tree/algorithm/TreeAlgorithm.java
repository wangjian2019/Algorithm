package tree.algorithm;

public class TreeAlgorithm {

	private class BinaryTree {
		BinaryTree left;
		BinaryTree right;
		int value;
	}

	/**
	 * 问题：给出二叉搜索数树的两个节点x、y，找到最低公共祖先。
	 * 
	 * 思路：从根节点开始找，如果当前节点比给出的x、y小，查当前节点右子树； 如果当前节点比给出的x,y大，查当前节点左子树；
	 * 把这个二叉搜索数从上到下层次遍历，找到第一个当前节点在x、y之间的节点，该节点就是最低公共祖先
	 */
	public void testSharedAncestor1() {

	}

	/**
	 * 问题：给出普通树（非二叉树）的两个节点x、y，每个节点存这父节点的指针（引用），找到最低公共祖先。
	 * 
	 * 思路：如果树中的每个节点都存有父节点的指针（引用），那么这个问题可以转化为求两个链表的第一个公共节点。
	 * 因为树的每个叶子节点到root根节点都是一个链表，每个链表的最后尾节点都是root根节点。输入两个给定的节点，这两个节点位于两个链表上，求两个链表的第一个公共节点就是它们的公共祖先
	 */
	public void testSharedAncestor2() {

	}

	/**
	 * 问题：给出普通树（非二叉树）的两个节点x、y，找到最低公共祖先。
	 * 
	 * 思路：所谓两个节点公共祖先，指的就是这两个节点都出现在某个节点的子树中。
	 * 从根节点开始遍历整个树，遍历到当前节点，判断x、y是否在当前节点的子树中，如果在，遍历它的所有子节点，这样从上到下找到第一个节点，它自己的子树中同时包含x、y而它的子节点却没有，那么该节点就是x、y的最低公共祖先。
	 */
	public void testSharedAncestor3() {

	}

	/**
	 * 问题：给出普通树（非二叉树）的两个节点x、y，找到最低公共祖先。可以使用辅助内存
	 * 
	 * 思路：用两个链表分别保存从根节点到x、y节点的路径，然后问题转化为求两个链表的最后公共节点。
	 * 1.先求root根节点到x节点的路径（链表），过程是从root根节点开始，前序遍历整个树，每遍历到一个节点就把当前节点加入到链表中，当遍历到某个叶子节点的时候，如果它不是x，那么把这个叶子节点从链表中删除，删除后再判断一下链表中最后一个尾节点是否变成叶子节点了如果是也跟删除，如果不是继续遍历，直到找到x节点。那么当前链表就是root根节点到x节点的链表。
	 * 2.再求root根节点到y节点的路径（链表），原理同上 3.求两个链表相交的最后公共节点
	 * 
	 * 两次遍历都是o(n)，两个链表的长度通常情况下是o(log(n))
	 */
	public void testSharedAncestor4() {

	}

	/**
	 * 问题： 给定一个树的Root，求树的深度
	 * 
	 * 思路：递归思想，如果root==null,深度是0； 如果root没有子树，深度是1；
	 * 如果root只有一个左子树，深度是左子树深度+1;如果只有右子树，同理； 如果root有左右子树，深度是max(左子树，右子树)+1
	 */
	public int testDeep(BinaryTree node) {
		if (node == null) {
			return 0;
		} else {
			int left = testDeep(node.left);
			int right = testDeep(node.right);
			return left > right ? left + 1 : right + 1;
		}
	}

	/**
	 * 问题： 输入根节点，判断是不是平衡二叉树
	 * 
	 * 一般答案：上面testDeep方法调用每个节点的左右子树，相差小于等于1就是平衡二叉树
	 * 完美答案：用后序遍历整个二叉树，先左右子树，最后根节点。在遍历过左右子结点后，可以根据他的左右子节点的深度判断它是不是平衡的，也得到了当前结点的深度。最后遍历到根节点的时候，就能判断整个树是不是平衡二叉树了
	 */
	public boolean testBalancedTree(BinaryTree node) {
		return false;
	}

	/**
	 * 二叉树，每个节点有一个指向父节点的指针。任意给一个节点，求这个节点中序遍历的下一个节点
	 * 
	 * @param node
	 * @return
	 */
	public BinaryTreeWithReference test(BinaryTreeWithReference node) {
		if (node == null) {
			return null;
		}

		if (node.right != null) {
			BinaryTreeWithReference temp = node.right;
			while (temp.left != null) {
				temp = temp.left;
			}
			return temp;
		} else {
			// 没有右子树情况下的
			if (node.parent != null && node == node.parent.left) {
				return node.parent;
			} else {
				// 是一个父节点右面的节点
				while (node.parent != null && node == node.parent.right) {
					node = node.parent;
				}
				if (node.parent != null) {
					return node.parent;
				}
			}
			return null;
		}
	}
}
