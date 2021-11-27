package com.kaksha.ds;

import java.util.Iterator;
import java.util.Stack;

public class TestClass {
	public static void main(String[] args) {
		UndirectedGraph g = new UndirectedGraph(13);
		g.addEdge(5, 3);
		g.addEdge(5, 4);
		g.addEdge(5, 0);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 6);
		g.addEdge(4, 6);
		g.addEdge(3, 4);
		g.addEdge(8, 7);
		g.addEdge(9, 10);
		g.addEdge(9, 11);
		g.addEdge(9, 12);
		g.addEdge(11, 12);


		System.out.println(g.V());
		System.out.println(g.E());
		for (int i = 0; i < g.V(); i++)
			printAdjacencylist(g, i);
		
		System.out.println(g.degree(0));
		System.out.println(g.maxDegree());
		System.out.println(g.hasSelfLoop());
		System.out.println(g.averageDegree());
		
		CC d = new CC(g);
		System.out.println(d.isPath(7));
		System.out.println(d.isPath(4));
		
		System.out.println("1 is connected to 9 "+ d.isConnected(1, 9));
		System.out.println("1 is connected to 6 "+ d.isConnected(1, 6));
		
		for(int i =0;i<13;i++)
			shortestPath(d, i);
	}

	private static void shortestPath(CC d, int i) {
		System.out.println("path to "+i);
		Stack<Integer> s = d.path(i);
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
