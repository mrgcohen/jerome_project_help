package Classwork;

import java.util.Scanner;

class BinaryTree {
	BinaryTreeNode root;
	BinaryTree left; // Pointer to left subtree node
	BinaryTree right; // Pointer to right subtree node
	 
	/**
	 * empty tree
	 */
	public BinaryTree(){
		root = null;
		left = null;
		right = null; 
	}
	
	/**
	 * New tree with only root
	 * @param root a binary tree node
	 */
	public BinaryTree(BinaryTreeNode root) {
		this(root, null, null);
	}

	/**
	 * New tree with root, left and right subtrees
	 * @param root
	 * @param nLeft
	 * @param nRight
	 */
	public BinaryTree(BinaryTreeNode root, BinaryTree nLeft, BinaryTree nRight) {
		this.root = root; // this uses local object w/in same class
		this.left = nLeft;
		this.right = nRight;
	}

	/**
	 * Insert a element into tree
	 * @param nodevalue value of node
	 * @return new tree
	 */
	public BinaryTree insertElement(int nodevalue) {
		if (root == null)
			return new BinaryTree(new BinaryTreeNode(nodevalue, true));
		else {
			if (root.isLeaf()) {
				// leaf node, has no children
				root.setLeaf(false);
				if (nodevalue < root.getValue()) {
					return new BinaryTree(root, new BinaryTree(
							new BinaryTreeNode(nodevalue, true)), null);
				} else {
					return new BinaryTree(root, null, new BinaryTree(
							new BinaryTreeNode(nodevalue, true)));
				}
			} else {
				// has children
				if (nodevalue < root.getValue())
					if (left != null)
						return new BinaryTree(root,
								left.insertElement(nodevalue), right);
					else
						return new BinaryTree(root,
								new BinaryTree(new BinaryTreeNode(nodevalue,
										true)), right);
				else if (right != null){
					return new BinaryTree(root, left,
							right.insertElement(nodevalue));
				}else{
					return new BinaryTree(root, left, new BinaryTree(
							new BinaryTreeNode(nodevalue, true), null, null));
				}
			}
		}
	}

	public BinaryTree getLeft() {
		return left;
	}

	public BinaryTree getRight() {
		return right;
	}

	void printInOrder() {
		// left root right
		if (left != null)
			left.printInOrder();
		if (root != null)
			System.out.print(root.getValue() + " ");
		if (right != null)
			right.printInOrder();
		
	}

	void printPreOrder() {
		// root left right
	}

	public void printPostOrder() {
		// left right root
		if (left != null)
			left.printPostOrder();
		if (right != null)
			right.printPostOrder();
		if (root != null)
			System.out.print(root.getValue() + " ");
	}

	public BinaryTree buildBinaryTree(int[] nodevalue) {
		// can't make empty tree
		if (nodevalue.length == 0)
			return null;
		else {
			BinaryTree tree = new BinaryTree(new BinaryTreeNode(nodevalue[0],
					true));
			// now add the rest of the nodes
			for (int i = 1; i < nodevalue.length; i++) {
				tree = tree.insertElement(nodevalue[i]);
			}
			return tree;
		}
	}

	public static void main(String[] args) {
		// Binary Tree object
		BinaryTree tree = new BinaryTree();
		/*
		 * // Binary Tree node objects BinaryTreeNode left = new
		 * BinaryTreeNode(5); BinaryTreeNode right = new BinaryTreeNode(9);
		 * BinaryTreeNode value = new BinaryTreeNode(2);
		 * 
		 * 
		 * //Get user input for nodevalues Scanner in = new Scanner(System.in);
		 * System.out.println("Enter 7 numbers or letters for node values");
		 * 
		 * // declaring arrays int[] nodevalue;
		 * 
		 * // create arrays nodevalue = new int [7];
		 * 
		 * // store input values into array as they are entered for(int
		 * i=0;i<7;i++) { nodevalue[i]=in.nextInt(); }
		 */

		// Use user values to build tree
		int[] nodevalue = new int[] { 5, 7, 2, 1, 4, 6, 8 };
		
		tree = tree.buildBinaryTree(nodevalue);
		/*
		 * tree.traversePreOrder(); System.out.println();
		 * tree.traverseInOrder(); System.out.println();
		 * tree.traversePostOrder(); System.out.println();
		 */
		System.out.println("Print Post Order");
		tree.printPostOrder();
		System.out.println();
		
		System.out.println("Print In Order");
		tree.printInOrder();
		System.out.println();		


	}

}