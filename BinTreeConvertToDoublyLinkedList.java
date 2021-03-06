package org.leetcode;

/*
 * Convert Binary Search Tree (BST) to Sorted Doubly-Linked List
 * http://leetcode.com/2010/11/convert-binary-search-tree-bst-to.html
 * Convert a BST to a sorted circular doubly-linked list in-place. 
 * Think of the left and right pointers as synonymous to the previous 
 * and next pointers in a doubly-linked list.
 *  
 */
import java.util.ArrayList;
import java.util.LinkedList;

public class BinTreeConvertToDoublyLinkedList {
	/*!not a circle doubly linked list!*/
	Pairs convert(Node root) {
		Pairs p = new Pairs(); // used to keep the head and tail of the linkedlist
		if (root == null)
			return null;
		Pairs pL = convert(root.left);
		Pairs pR = convert(root.right);
		if (pL == null) {
			p.head = root;
		} else if (pL != null) {
			concat(pL.tail, root);
			p.head = pL.head;
		}
		if (pR == null) {
			p.tail = root;
		} else {
			concat(root, pR.head);
			p.tail = pR.tail;
		}
		return p;
	}
	// concat b to a : a <--> b
	void concat(Node a, Node b) {
		a.right = b;
		b.left = a;
	}

	/*
	 * not the part of the bin convert to doubly linked list. this is for print
	 * a tree, bfs
	 */
	ArrayList<LinkedList<Node>> printBFS(Node root) {
		if (root == null)
			throw new IllegalArgumentException("Tree is null, Error.");
		ArrayList<LinkedList<Node>> lvlArr = new ArrayList<LinkedList<Node>>();
		LinkedList<Node> lvl = new LinkedList<Node>();
		lvl.add(root);
		lvlArr.add(lvl);
		while (!lvl.isEmpty()) {
			LinkedList<Node> newLvl = new LinkedList<Node>();
			for (Node parent : lvl) {
				if (parent.left != null)
					newLvl.add(parent.left);
				if (parent.right != null)
					newLvl.add(parent.right);
			}
			lvl = newLvl;
			if (!lvl.isEmpty())
				lvlArr.add(lvl);
		}
		// print them out
		for (LinkedList<Node> level : lvlArr) {
			for (Node n : level) {
				System.out.print(n.data + " ");
			}
			System.out.println();
		}

		return lvlArr;
	} // end print tree method
}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int d) {
		data = d;
	}

}

class Pairs {
	Node head;
	Node tail;
}

/*-----for test-------*/
class Test {
	public static void main(String[] args) {
		BinTreeConvertToDoublyLinkedList bd = new BinTreeConvertToDoublyLinkedList();
		Node root = new Node(4);
		Node a = new Node(2);
		Node b = new Node(5);
		Node c = new Node(1);
		Node d = new Node(3);
		Node e = new Node(6);
		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		b.right = e;
		bd.printBFS(root);// print the tree

		Pairs ps = bd.convert(root);

		Node current = ps.head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.right;
		}

	}
}
