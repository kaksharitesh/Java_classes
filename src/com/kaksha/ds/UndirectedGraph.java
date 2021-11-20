package com.kaksha.ds;

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
		if (w != v)
			adj[w].add(v);
		E++;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public int degree(int v) {
		int degree = 0;
		for (int w : adj[v]) {
			degree++;
		}
		return degree;
	}

	public int maxDegree() {
		int maxDegree = 0;
		for (int i = 0; i < V; i++) {
			int degree = degree(i);
			if (degree > maxDegree)
				maxDegree = degree;
		}
		return maxDegree;
	}

	public boolean hasSelfLoop() {
		for (int v = 0; v < V; v++) {
			for (int w : adj[v]) {
				if (w == v)
					return true;
			}
		}
		return false;
	}

	public float averageDegree() {
		return 2 * E / V;
	}
}
