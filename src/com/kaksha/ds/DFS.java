package com.kaksha.ds;

import java.util.Stack;

public class DFS {

	private boolean[] marked;
	private int[] path;

	public DFS(UndirectedGraph g) {
		marked = new boolean[g.V()];
		path = new int[g.V()];
		dfs(g, 0);

	}

	private void dfs(UndirectedGraph g, int v) {
		marked[v] = true;
		for (int w : g.adj(v)) {
			if (!marked[w]) {
				path[w] = v;
				dfs(g, w);
			}
		}
	}

	public boolean isPath(int v) {
		return marked[v];
	}

	public Stack<Integer> path(int v) {
		Stack<Integer> s = new Stack<>();
		if (isPath(v) == false) {
			return s;
		}
		s.push(v);
		while (v != 0) {
			v = path[v];
			s.push(v);
		}
		return s;
	}

}
