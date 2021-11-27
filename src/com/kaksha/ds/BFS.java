package com.kaksha.ds;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {

	private int[] path;
	private boolean[] visited;

	public BFS(UndirectedGraph g) {
		path = new int[g.V()];
		visited = new boolean[g.V()];
		bfs(g, 0);
	}

	private void bfs(UndirectedGraph g, int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited[s] = true;
		path[s] = s;
		q.add(s);
		while (!q.isEmpty()) {
			int v = q.poll();
			for (int w : g.adj(v)) {
				if (visited[w])
					continue;
				q.add(w);
				visited[w] = true;
				path[w] = v;
			}
		}

	}

	public boolean isPath(int v) {
		return visited[v];
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
