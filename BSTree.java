package kql.test.practise;

/* In this code I use two ways to insert node into a tree.
 * The first insert method:
 * I use iteration to insert a node into a tree
 * 
 * The second insert method: 
 * I use pointer to find a proper position for the new node
 */

public class BSTree {

	// ----insert 1----------------------
	void insertI(TreeNode parent, TreeNode root, TreeNode n) {
		if (n == null) { // n should not be null
			return;
		}
		if (root == null && parent == null) {
			root = n;
			return;
		}
		if (parent != null && root == null) {
			if (root == parent.left)
				parent.left = n;
			else {
				parent.right = n;
			}
			return;
		}
		parent = root;
		if (n.data < root.data) {
			insertI(parent, parent.left, n);
		} else if (n.data >= root.data) {
			insertI(parent, parent.right, n);
		}
	} // end insert

	// -----insert 2--------------------
	TreeNode r = null;

	void insertII(TreeNode n) {
		if (r == null) {
			r = n;
			return;
		}
		TreeNode parent = null;
		TreeNode current = r;
		while (current != null) {
			if (n.data < current.data) {
				parent = current;
				current = current.left;
			} else {
				parent = current;
				current = current.right;
			}
		}
		if (n.data < parent.data)
			parent.left = n;
		else
			parent.right = n;
	} // end method

	// ------test------in this part I did not test all the cases----------
	public static void main(String[] args) {
		BSTree tr = new BSTree();
		TreeNode parent = null;
		TreeNode r = new TreeNode(4);
		TreeNode n = new TreeNode(2);

		tr.insertI(parent, r, n);
		tr.insertI(parent, r, new TreeNode(6));
	}
} // end class

class TreeNode {
	int data = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int d) {
		data = d;
	}
}