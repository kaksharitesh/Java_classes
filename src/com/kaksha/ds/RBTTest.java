package com.kaksha.ds;

public class RBTTest {

	public static void main(String[] args) {
		BST<Integer, String> bst = new BST<>();
		RBT<Integer, String> rbt = new RBT<>();
		AVL<Integer, String> avl = new AVL<>();
        for(int i = 10;i>=1;i--) {
        	//bst.insert(i, null);
        	rbt.insert(i, null);
        }
        
        for(int i = 10;i>=0;i--) {
        	//bst.insert(i, null);
        	avl.insert(i, null);
        }
		//bst.inOrder();
		//bst.preOrder();
		System.out.println("height of bst = " + bst.height()); // height is N
		
		//rbt.inOrder();
		//rbt.preOrder();
		System.out.println("height of rbt = " + rbt.height()); // height should be log n
		
		avl.inOrder();
		avl.preOrder();
		System.out.println("height of avl = " + avl.height()); // height should be log n
	}
}
