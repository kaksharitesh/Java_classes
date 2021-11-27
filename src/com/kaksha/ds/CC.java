package com.kaksha.ds;

import java.util.Stack;

public class CC {

	private boolean[] visited;
	private int[] codes;
	private int[] path;
	private int code = 0;

	public CC(UndirectedGraph g) {
		codes = new int[g.V()];
		visited = new boolean[g.V()];
		path = new int[g.V()];
		for (int i = 0; i < g.V(); i++) {
			if (!visited[i]) {
				dfs(g, i);
				code++;
			}
		}
		System.out.print("\ncodes = [");
		for(int i = 0 ;i<g.V();i++)
			System.out.print(codes[i]+",");
		System.out.println("]");
	}

	private void dfs(UndirectedGraph g, int i) {
		visited[i] = true;
		codes[i] = code;
		for (int v : g.adj(i)) {
			if (!visited[v]) {
				path[v] = i;
				dfs(g, v);
			}
		}
	}
	
	public boolean isConnected(int v, int w) {
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


}
