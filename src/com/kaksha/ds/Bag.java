package com.kaksha.ds;

import java.util.Iterator;

public class Bag implements Iterable<Integer> {

	private Node first;

	public void add(int data) {
		first = add(first, data);
	}

	private Node add(Node n, int data) {
		if (n == null)
			return new Node(data);
		n.next = add(n.next, data);
		return n;
	}

	private class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		return new CustomIterator();
	}

	private class CustomIterator implements Iterator<Integer> {

		private Node n = first;

		@Override
		public boolean hasNext() {
			return n != null;
		}

		@Override
		public Integer next() {
			Node temp = n;
			n = n.next;
			return temp.data;
		}

		@Override
		public void remove() {
			// so that no body can remove a node once created. A graph is snapshop of a
			// problem
			// at any point of time.
		}

	}

}
