package com.kaksha.ds;

import java.util.Iterator;

public class TestClass {
	public static void main(String[] args) {
		UndirectedGraph g = new UndirectedGraph(6);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(4, 5);

		System.out.println(g.V());
		System.out.println(g.E());
		for (int i = 0; i < g.V(); i++)
			printAdjacencylist(g, i);

	}

	private static void printAdjacencylist(UndirectedGraph g, int V) {
		Iterator<Integer> ite = g.adj(V);
		System.out.print("Adjacency list of " + V + " is ");
		while (ite.hasNext()) {
			System.out.print(ite.next() + " -> ");
		}
		System.out.print("null\n");
	}

}
