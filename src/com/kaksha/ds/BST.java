package com.kaksha.ds;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BST<K extends Comparable<K>, V> {

	private Node root;

	public K min() {
		return min(root).key;
	}

	public K floor(K key) {
		// largest key in tree less than or equal to me
		return null;
	}

	public K ceil(K key) {
		// smallest key in tree greater than or equal to me
		return null;
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
		System.out.println("Printing inorder of BST");
		inOrder(root);
	}

	private void inOrder(Node n) {
		if (n == null)
			return;
		inOrder(n.left);
		System.out.println(n.key);
		inOrder(n.right);
	}
	
	public void preOrder() {
		System.out.println("Printing preorder of BST");
		preOrder(root);
	}

	private void preOrder(Node n) {
		if (n == null)
			return;
		System.out.println(n.key);
		inOrder(n.left);
		inOrder(n.right);
	}
	
	public void postOrder() {
		System.out.println("Printing preorder of BST");
		postOrder(root);
	}

	private void postOrder(Node n) {
		if (n == null)
			return;
		postOrder(n.left);
		postOrder(n.right);
		System.out.println(n.key);
	}

	// tree traversals
	// in order
	// pre order
	// post order
	// level order
	// zigzag order
	// top view
	// common ancestor
	// bst to circular doubly linked list

	private Node min(Node n) {
		if (n.left == null)
			return n;
		return min(n.left);
	}

	public K max() {
		return max(root).key;
	}

	private Node max(Node n) {
		if (n.right == null)
			return n;
		return max(n.right);
	}

	public void delMin() {
		root = delMin(root);
	}

	private Node delMin(Node n) {
		if (n.left == null) {
			return n.right;
		}
		n.left = delMin(n.left);
		n.size = 1 + sizeOf(n.left) + sizeOf(n.right);
		return n;
	}

	public void delMax() {
		root = delMax(root);
	}

	private Node delMax(Node n) {
		if (n.right == null) {
			return n.left;
		}
		n.right = delMax(n.right);
		n.size = 1 + sizeOf(n.left) + sizeOf(n.right);
		return n;
	}

	public void del(K key) {
		root = del(key, root);
	}

	private Node del(K key, Node n) {
		// size of node adjustment has to be implemented
		if (n == null) {
			return null;
		}
		int cmp = key.compareTo(n.key);
		if (cmp > 0)
			return del(key, n.right);
		if (cmp < 0)
			return del(key, n.left);
		if (n.right == null)
			return n.left;
		if (n.left == null)
			return n.right;
		Node x = min(n.right);
		x.right = delMin(n.right);
		x.left = n.left;
		return x;
	}

	public int rank(K key) {
		// return how many keys are lesser than input key
		// if key is not found in tree return -1
		if (search(key, root) == null)
			return -1;
		return rank(key, root);
	}

	private int rank(K key, Node n) {
		int cmp = key.compareTo(n.key);
		if (cmp == 0)
			return sizeOf(n.left);
		if (cmp < 0)
			return rank(key, n.left);
		return 1 + sizeOf(n.left) + rank(key, n.right);
	}

	public V search(K key) {
		Node result = search(key, root);
		if (result == null)
			return null; // not found case
		return result.data; // found case
	}

	public void insert(K key, V data) {
		root = insert(key, data, root);
	}

	private Node insert(K key, V data, Node n) {
		if (n == null)
			return new Node(key, data);
		int cmp = key.compareTo(n.key);
		if (cmp == 0) {
			n.data = data; // update case
		} else if (cmp > 0) {
			n.right = insert(key, data, n.right); // insert to right subtree
		} else {
			n.left = insert(key, data, n.left); // insert to left subtree
		}
		n.size = 1 + sizeOf(n.left) + sizeOf(n.right);
		return n;
	}

	private int sizeOf(Node n) {
		return n == null ? 0 : n.size;
	}

	public int size() {
		return sizeOf(root);
	}

	private Node search(K key, Node n) {
		if (n == null)
			return null;
		int cmp = key.compareTo(n.key);
		if (cmp == 0)
			return n;
		if (cmp > 0)
			return search(key, n.right);
		return search(key, n.left);
	}

	public void topView() {
		System.out.println("printing top view");
		Queue<NodeWithCoordiate> q = new LinkedList<>();
		q.add(new NodeWithCoordiate(root, 0));
		Set<Integer> s = new HashSet<>();
		while (!q.isEmpty()) {
			NodeWithCoordiate x = q.poll();
			if (!s.contains(x.coordiate)) { // o(1)
				System.out.println(x.node.key);
				s.add(x.coordiate);
			}
			if (x.node.left != null)
				q.add(new NodeWithCoordiate(x.node.left, x.coordiate - 1));
			if (x.node.right != null)
				q.add(new NodeWithCoordiate(x.node.right, x.coordiate + 1));

		}
	}

	public void convertToDlink() {
		List<Node> ends = new ArrayList<>();
		ends = convertToDlink(root);
		if (ends.size() > 1) {
			// making it circular
			ends.get(0).left = ends.get(1);
			ends.get(1).right = ends.get(0);
		}
		// done
	}

	private List<Node> convertToDlink(Node n) {
		// to be added - exit condition
		List<Node> leftEnds = new ArrayList<>();
		List<Node> rightEnds = new ArrayList<>();
		Node left = n;
		Node right = n;
		if (n.left != null) {
			leftEnds = convertToDlink(n.left); // 2,4 2->3->4
			if (leftEnds.size() == 1) {
				n.left = leftEnds.get(0);
				leftEnds.get(0).right = n;
			} else {
				n.left = leftEnds.get(1);
				leftEnds.get(1).right = n;
			}
			left = leftEnds.get(0);
		}

		if (n.right != null) {
			rightEnds = convertToDlink(n.right); // 7,8 7->8
			n.right = rightEnds.get(0);
			rightEnds.get(0).left = n;

			if (rightEnds.size() == 2) {
				right = rightEnds.get(1);
			} else {
				right = rightEnds.get(0);
			}
		}

		List<Node> response = new ArrayList<>();
		response.add(left);
		if (right.key != left.key)
			response.add(right);

		return response;

	}

	private class NodeWithCoordiate {
		private Node node;
		private int coordiate;

		public NodeWithCoordiate(Node n, int coordiate) {
			this.node = n;
			this.coordiate = coordiate;
		}
	}

	private class Node {
		private K key;
		private V data;
		private Node left;
		private Node right;
		private int size;

		public Node(K key, V data) {
			this.key = key;
			this.data = data;
			this.size = 1;
			this.left = null;
			this.right = null;
		}
	}

}