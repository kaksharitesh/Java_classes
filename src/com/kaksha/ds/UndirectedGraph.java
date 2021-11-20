package com.kaksha.ds;

import java.util.Iterator;

public class UndirectedGraph {

	private Bag[] adj;
	private int V;
	private int E;

	public UndirectedGraph(int V) {
		this.V = V;
		adj = new Bag[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new Bag();
		}
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}

	public Iterator<Integer> adj(int v) {
		return adj[v].iterator();
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}
	
	public int degree(int v) {
		return 0;
	}
	
	public int maxDegree() {
		return 0;
	}
	
	public boolean hasSelfLoop() {
		return false;
	}
}
