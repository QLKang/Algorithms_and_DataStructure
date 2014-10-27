package kql.test.practise;

import java.util.ArrayList;

public class InOrderWalk {

	ArrayList<Integer> arr = new ArrayList<Integer>();
	ArrayList<Integer> inOrderWalk(Node r){
		if(r == null) { return null ;}
		inOrderWalk(r.left);
		arr.add(r.data);
		inOrderWalk(r.right);
		
		return arr;
		
	}
	
	public static void main(String[] args) {
		Node r = new Node(30);
		r.left = new Node(15);
		r.right = new Node(44);
		r.left.left = new Node(7);
		r.left.right = new Node(23);
		r.right.left = new Node(37);
		r.right.right = new Node(30);
		r.left.left.left = new Node(2);
		r.left.left.right = new Node(9);
		r.left.right.left = new Node(19);
		r.left.right.right = new Node(27);
		r.right.left.left = new Node(33);
		r.right.left.right = new Node(40);
		r.right.right.left = new Node(47);
		r.right.right.right = new Node(61);

		InOrderWalk iow = new InOrderWalk();
		ArrayList<Integer> arr = iow.inOrderWalk(r);
		for(Integer i: arr){
			System.out.print(i+". ");
		}
	
	}

}
