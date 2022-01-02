package com.kaksha.ds;

import java.util.Stack;

public class TopologicalSort {
	private boolean[] visited;
	public Stack<Integer> s = new Stack<>();
	
	public TopologicalSort(DiGraph di) {
		visited = new boolean[di.V()];
		
		for(int i = 0 ; i<di.V();i++) {
			if (!visited[i]) {
				dfs(di, i);
			}
		}
	}
	
	private void dfs(DiGraph di, int v) {
		visited[v] = true;
		for(int w : di.adj(v)) {
			if (!visited[w]) {
				dfs(di,w);
			}
		}
		s.push(v);
	}
	

	public static void main(String[] args) {
		DiGraph di = new DiGraph(7);
		di.addEdge(0, 1);
		di.addEdge(0, 5);
		di.addEdge(0, 2);
		di.addEdge(1, 4);
		di.addEdge(3, 2);
		di.addEdge(3, 5);
		di.addEdge(3, 6);
		di.addEdge(3, 4);
		di.addEdge(5, 2);
		di.addEdge(6, 0);
		di.addEdge(6, 4);
		TopologicalSort ts = new TopologicalSort(di);
		for(int i = 0;i<7;i++) {
			System.out.print(ts.s.pop()+"->");
		}
	}
}
