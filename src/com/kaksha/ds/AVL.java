package com.kaksha.ds;

public class AVL<K extends Comparable<K>, V> {

	private Node root;

	public void insert(K key, V data) {
		System.out.println("inserting " + key);
		root = insert(key, data, root);
		System.out.println("Current root is " + root.key);
	}

	public int height() {
		return height(root);
	}

	private int height(Node n) {
		if (n == null)
			return 0;
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
		if (n == null)
			return;
		inOrder(n.left);
		System.out.println(n.key);
		inOrder(n.right);
	}

	private Node insert(K key, V data, Node n) {
		if (n == null)
			return new Node(key, data);
		int cmp = key.compareTo(n.key);
		if (cmp == 0) {
			System.out.println("Duplicate key found " + key + " old data " + n.data + " new data" + data);
			n.data = data; // update case
		} else if (cmp > 0) {
			n.right = insert(key, data, n.right); // insert to right subtree
		} else {
			n.left = insert(key, data, n.left); // insert to left subtree
		}
		int diff = diff(n);
		if (diff == -2) {
			if (diff(n.left) == +1) {
				n.left = leftRotate(n.left);
			}
			n = rightRotate(n);
		}
		if (diff == +2) {
			if (diff(n.right) == -1) {
				n.right = rightRotate(n.right);
			}
			n = leftRotate(n);
		}
		n.h = 1 + Math.max(h(n.left), h(n.right));
		return n;
	}

	private int diff(Node n) {
		return h(n.right) - h(n.left);
	}

	private Node rightRotate(Node n) { // O(1)
		System.out.println("doing right rotate");
		Node x = n.left;
		n.left = x.right;
		x.right = n;
		n.h = 1 + Math.max(h(n.left), h(n.right));
		x.h = 1 + Math.max(h(x.left), h(x.right));
		return x;
	}

	private Node leftRotate(Node n) { // O(1)
		System.out.println("doing left rotate");
		Node x = n.right;
		n.right = x.left;
		x.left = n;
		n.h = 1 + Math.max(h(n.left), h(n.right));
		x.h = 1 + Math.max(h(x.left), h(x.right));
		return x;
	}

	private int h(Node n) {
		return n == null ? 0 : n.h;
	}

	private class Node {
		private K key;
		private V data;
		private Node left;
		private Node right;
		private int h;

		public Node(K key, V data) {
			this.key = key;
			this.data = data;
			this.left = null;
			this.right = null;
			this.h = 1;
		}
	}

}