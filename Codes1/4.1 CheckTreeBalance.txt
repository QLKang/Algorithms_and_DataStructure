package kql.test.practise;
/*
 * Implement a function to check if a binary tree is balanced. For the purposes of this question, 
 * a balanced tree is defined to be a tree such that the heights of the two subtrees of any node 
 * never differ by more than one.
 */

// 7:36 PM 1/21/2014----7:54 PM 1/21/2014
/*----------the first way to implement the function-----------------------------------------------------------------------------*/
class TreeNode {
	int data = 0;
	TreeNode left = null;
	TreeNode right = null;
	
	public TreeNode(int d) {
		data = d;
	}
} // end class

/*----------------------------------------------------------------*/
public class IsBalancedTree {

	/*-------------------------------*/
	boolean isBalanced(TreeNode rt) {
		// more code .......................
		if (rt == null) {
			return true;
		}
		int l = getDepth(rt.left);
		int r = getDepth(rt.right);
		if (abs(l, r) > 1) {
			return false;
		} else {
			return isBalanced(rt.left) && isBalanced(rt.right);
		}
		// return true;
	}

	int getDepth(TreeNode n) {
		if (n == null) {
			return 0;
		}
		return max(getDepth(n.left), getDepth(n.right)) + 1;
	}

	int max(int a, int b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}

	int abs(int a, int b) {
		if (a >= b)
			return a - b;
		return b - a;
	} // end class

	// for test
	public static void main(String[] args) {
		// create a new tree
		TreeNode r = new TreeNode(4);
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(1);
		TreeNode g = new TreeNode(2);
		TreeNode c = new TreeNode(5);
		TreeNode d = new TreeNode(0);
		TreeNode e = new TreeNode(8);
		TreeNode f = new TreeNode(4);
		TreeNode h = new TreeNode(39);
		
		r.left = a;
		r.right = b;
		a.right = g;
		b.left = c;
		b.right = d;
		d.left = e;
		d.right = f;
		f.right = h;
		IsBalancedTree ibt = new IsBalancedTree();
		boolean result = ibt.isBalanced(r);
		System.out.println(result);
	}

}


/*----------the sencond way to implement the function------------------------------------------------------------------*/

package kql.test.practise;

class TreeNode{
	int data = 0;
	TreeNode left = null;
	TreeNode right = null;
	public TreeNode(int d){
		data = d;
	}
} // end class

/*--------------------------------------------------------------------------*/
public class IsBalanced {

	boolean isBalanced(TreeNode rt) {
		// more code .......................
		if (rt == null) {
			return true;
		}
		if (getDepth(rt) == -1)
			return false;
		return true;
	}
/*-------------------------------*/
	int getDepth(TreeNode n) {
		if (n == null) {
			return 0;
		}

		int leftDepth = getDepth(n.left);
		if (leftDepth == -1) {
			return -1;
		}
		int rightDepth = getDepth(n.right);
		if (rightDepth == -1) {
			return -1;
		}

		int d = 0;

		if (abs(getDepth(n.left), getDepth(n.right)) > 1) {
			d = -1;
		} else {
			d = max(getDepth(n.left), getDepth(n.right)) + 1;
		}
		return d;
	}

	int max(int a, int b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}

	int abs(int a, int b) {
		if (a >= b) {
			return a - b;
		} else {
			return b - a;
		}
	}
//----- for test------
	public static void main(String[] args) {
		// create a new tree
		TreeNode r = new TreeNode(4);
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(1);
		TreeNode g = new TreeNode(2);
		TreeNode c = new TreeNode(5);
		TreeNode d = new TreeNode(0);
		TreeNode e = new TreeNode(8);
		TreeNode f = new TreeNode(4);
//		TreeNode h = new TreeNode(39);
		
		r.left = a;
		r.right = b;
		a.right = g;
		b.left = c;
		b.right = d;
		d.left = e;
		d.right = f;
//		f.right = h;
		IsBalancedTree ibt = new IsBalancedTree();
		boolean result = ibt.isBalanced(r);
		System.out.println(result);
	}
} // end class
