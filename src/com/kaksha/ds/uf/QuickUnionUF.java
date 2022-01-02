package com.kaksha.ds.uf;

public class QuickUnionUF implements UnionFind {

	private int[] id;

	public QuickUnionUF(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++)
			id[i] = i;
	}

	private int root(int v) {
		while (id[v] != v) {
			v = id[v];
		}
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
		QuickUnionUF uf = new QuickUnionUF(8);
		System.out.println(uf.find(0, 1));
		uf.union(0, 1);
		uf.union(2, 3);
		System.out.println(uf.find(0, 1));
		System.out.println(uf.find(0, 3));
		uf.union(0, 2);
		System.out.println(uf.find(0, 3));

	}

}
