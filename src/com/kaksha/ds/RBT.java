package com.kaksha.ds;

public class RBT<K extends Comparable<K>, V> {

	private Node root;
	private final boolean BLACK = true;
	private final boolean RED = false;

	private boolean colorOf(Node n) {
		if (n == null)
			return BLACK;
		return n.color;
	}

	public int size() {
		return sizeOf(root);
	}

	private int sizeOf(Node n) {
		return n == null ? 0 : n.size;
	}

	public void insert(K key, V data) {
		System.out.println("inserting "+ key);
		root = insert(key, data, root);
		root.color = BLACK;
		System.out.println("Current root is "+ root.key);
	}
	
	public int height() {
		return height(root);
	}
	
	private int height(Node n) {
		if(n==null) return 0;
		return 1 + Math.max(height(n.left), height(n.right));
	}
	
	public void inOrder() {
		System.out.println("Printing inorder of RBT");
		inOrder(root);
	}
	
	public void preOrder() {
		System.out.println("Printing preorder of RBT");
		preOrder(root);
	}

	private void preOrder(Node n) {
		if (n == null)
			return;
		System.out.println(n.key);
		inOrder(n.left);
		inOrder(n.right);
	}
	
	private void inOrder(Node n) {
		if(n==null) return;
		inOrder(n.left);
		System.out.println(n.key);
		inOrder(n.right);
	}

	private Node insert(K key, V data, Node n) {
		if (n == null)
			return new Node(key, data);
		int cmp = key.compareTo(n.key);
		if (cmp == 0) {
			System.out.println("Duplicate key found "+ key + " old data "+n.data+ " new data"+data);
			n.data = data; // update case
		} else if (cmp > 0) {
			n.right = insert(key, data, n.right); // insert to right subtree
		} else {
			n.left = insert(key, data, n.left); // insert to left subtree
		}

		if (colorOf(n.left) == BLACK && colorOf(n.right) == RED) {
			n = leftRotate(n);
		}
		if (colorOf(n.left) == RED && colorOf(n.left.left) == RED) {
			n = rightRotate(n);
		}
		if (colorOf(n.left) == RED && colorOf(n.right) == RED) {
			n = flipColor(n);
		}
		n.size = 1 + sizeOf(n.left) + sizeOf(n.right);
		return n;
	}

	private Node flipColor(Node n) { // O(1)
		System.out.println("Voilation of rule no 3 : flip color");
		n.left.color = n.color;
		n.right.color = n.color;
		n.color = RED;
		return n;
	}

	private Node rightRotate(Node n) { // O(1)
		System.out.println("Voilation of rule no 2 : doing right rotate");
		Node x = n.left;
		n.left = x.right;
		x.right = n;
		x.color = n.color;
		n.color = RED;
		x.size = n.size;
		n.size = 1 + sizeOf(n.left) + sizeOf(n.right);
		return x;
	}

	private Node leftRotate(Node n) { // O(1)
		System.out.println("Voilation of rule no 1 : doing left rotate");
		Node x = n.right;
		n.right = x.left;
		x.left = n;
		x.color = n.color;
		n.color = RED;
		x.size = n.size;
		n.size = 1 + sizeOf(n.left) + sizeOf(n.right);
		return x;
	}

	private class Node {
		private K key;
		private V data;
		private Node left;
		private Node right;
		private boolean color;
		private int size;

		public Node(K key, V data) {
			this.key = key;
			this.data = data;
			this.left = null;
			this.right = null;
			this.color = RED;
			this.size = 1;
		}
	}

}