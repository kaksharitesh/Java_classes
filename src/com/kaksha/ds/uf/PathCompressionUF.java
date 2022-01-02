package com.kaksha.ds.uf;

public class PathCompressionUF implements UnionFind{

	private int[] id;
	

	public PathCompressionUF(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++)
			id[i] = i;
	}

	private int root(int v) {
	   int counter = 0;
	   int w = v;
		while (id[v] != v) {
			id[v] = id[id[v]];
			v = id[v];
			counter++;
		}
		System.out.println("cost of finding root of "+w + " is "+counter);
		return v;
	}

	@Override
	public boolean find(int v, int w) {
		return root(v) == root(w);
	}

	@Override
	public void union(int v, int w) {
		int rootV = root(v);
		int rootW = root(w);
		if (rootW == rootV)
			return;
		id[rootW] = rootV;
	}
	
	public static void main(String[] args) {
		PathCompressionUF uf = new PathCompressionUF(8);
		System.out.println(uf.find(0, 1));
		uf.union(0, 1);
		uf.union(2, 3);
		System.out.println(uf.find(0, 1));
		System.out.println(uf.find(0, 3));
		uf.union(0, 2);
		System.out.println(uf.find(0, 3));

	}

}
