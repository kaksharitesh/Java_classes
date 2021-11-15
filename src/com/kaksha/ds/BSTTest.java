package com.kaksha.ds;

public class BSTTest {

	public static void main(String[] args) {
		BST<Integer, String> b = new BST<>();
		System.out.println(b.search(3));
		b.insert(5, "i m 5");
		b.insert(3, "i m 3");
		b.insert(4, "i m 4");
		b.insert(2, "i m 2");
		b.insert(18, "i m 8");
		b.insert(7, "i m 7");
		b.insert(8, "i m 7");
		b.insert(9, "i m 7");
		System.out.println(b.search(3));
		b.insert(3, "i m new 3"); // update case
		System.out.println(b.search(3));
		System.out.println(b.size());
		
		System.out.println(b.rank(2));
		System.out.println(b.rank(3));
		System.out.println(b.rank(4));
		System.out.println(b.rank(8));
		System.out.println(b.rank(9));
		
		b.topView();
	}
}
