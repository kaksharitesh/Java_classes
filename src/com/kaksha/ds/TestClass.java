package com.kaksha.ds;

import java.util.Iterator;
import java.util.Stack;

public class TestClass {
	public static void main(String[] args) {
		UndirectedGraph g = new UndirectedGraph(8);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(0, 3);
		g.addEdge(2, 4);
		g.addEdge(4, 5);
		g.addEdge(6, 7);
		g.addEdge(0, 5);


		System.out.println(g.V());
		System.out.println(g.E());
		for (int i = 0; i < g.V(); i++)
			printAdjacencylist(g, i);
		
		System.out.println(g.degree(0));
		System.out.println(g.maxDegree());
		System.out.println(g.hasSelfLoop());
		System.out.println(g.averageDegree());
		
		DFS d = new DFS(g);
		System.out.println(d.isPath(5));
		System.out.println(d.isPath(6));
		Stack<Integer> s = d.path(5);
		while(!s.isEmpty()) {
			System.out.print(s.pop()+"->");
		}
		System.out.println();
		s = d.path(5);
		while(!s.isEmpty()) {
			System.out.print(s.pop()+"->");
		}
		System.out.println();

	}

	private static void printAdjacencylist(UndirectedGraph g, int V) {
		Iterator<Integer> ite = g.adj(V).iterator();
		System.out.print("Adjacency list of " + V + " is ");
		while (ite.hasNext()) {
			System.out.print(ite.next() + " -> ");
			ite.remove();
		}
		System.out.print("null\n");
	}

}
