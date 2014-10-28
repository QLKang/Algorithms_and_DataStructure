//sidiansan
/*
 * Given a sorted (increasing order) array, write an algorithm to create a binary search tree. 
 */
//9:34 PM 1/21/2014--9:52 PM 1/21/2014

package kql.test.practise;
class TreeNode {
	int data = 0;
	TreeNode left = null;
	TreeNode right = null;
	public TreeNode(int d) {
		data = d;
	}
} // end class

public class CreateBSTree {

	TreeNode createBSTree(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("array is illegal. ");
		}
		int len = arr.length;
		return createBSTree(arr, 0, len - 1);
	} // end method 1

	
	TreeNode createBSTree(int[] arr, int top, int end) {
		TreeNode rt = null;
		if (top <= end) {
			int mid = (top + end) / 2;
			rt = new TreeNode(arr[mid]);
			rt.left = createBSTree(arr, top, mid - 1);
			rt.right = createBSTree(arr, mid + 1, end);
		} // end if
		return rt;
	}// end method 2

	
	void inOrderWalk(TreeNode rt){
		if(rt!=null){
			inOrderWalk(rt.left);
			System.out.print(rt.data+" ");
			inOrderWalk(rt.right);
		}
	}
	
	// for test---------
	public static void main(String[] args) {
		int[] arr = {3, 9, 10, 17, 19, 27, 29, 40, 41, 60};
		CreateBSTree cbt = new CreateBSTree();
		TreeNode r = cbt.createBSTree(arr);
		cbt.inOrderWalk(r);
	} // end test
} // end class