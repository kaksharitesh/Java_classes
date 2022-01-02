package com.kaksha.ds;

import java.util.Stack;

public class SCC {

	private boolean[] visited;
	private int[] codes;
	private int[] path;
	private int code = 0;

	public SCC(DiGraph g) {
		codes = new int[g.V()];
		visited = new boolean[g.V()];
		path = new int[g.V()];
		/*
		 * reverse the graph, topological sort run cc on this order
		 */

		DiGraph reverse = getReverseGraph(g);

		TopologicalSort ts = new TopologicalSort(reverse);

		Stack<Integer> choice = ts.s;

		while (!choice.isEmpty()) {
			int i = choice.pop();
			if (!visited[i]) {
				dfs(g, i);
				code++;
			}
		}
		System.out.print("\ncodes = [");
		for (int i = 0; i < g.V(); i++)
			System.out.print(codes[i] + ",");
		System.out.println("]");
	}

	private DiGraph getReverseGraph(DiGraph g) {
		DiGraph reverse = new DiGraph(g.V());
		for (int i = 0; i < g.V(); i++) {
			for (int v : g.adj(i)) {
				reverse.addEdge(v, i);
			}
		}
		return reverse;
	}

	private void dfs(DiGraph g, int i) {
		visited[i] = true;
		codes[i] = code;
		for (int v : g.adj(i)) {
			if (!visited[v]) {
				path[v] = i;
				dfs(g, v);
			}
		}
	}

	public boolean isStronglyConnected(int v, int w) {
		return codes[v] == codes[w];
	}

	public boolean isPath(int v) {
		return codes[v] == codes[0];
	}

	public Stack<Integer> path(int v) {
		Stack<Integer> s = new Stack<Integer>();
		if (isPath(v)) {
			s.push(v);
			while (v != 0) {
				v = path[v];
				s.push(v);
			}
		}
		return s;
	}

	public static void main(String[] args) {
		DiGraph di = new DiGraph(6);
		di.addEdge(0, 3);
		di.addEdge(0, 1);
		di.addEdge(1, 2);
		di.addEdge(2, 0);
		di.addEdge(3, 4);
		di.addEdge(4, 5);
		di.addEdge(5, 3);
		SCC ts = new SCC(di);

	}

}
