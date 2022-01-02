package com.kaksha.ds.uf;

public class QuickFindUF implements UnionFind{

	private int[] id;

	public QuickFindUF(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++)
			id[i] = i;
	}

	@Override
	public boolean find(int v, int w) {
		return id[v] == id[w];
	}

	@Override
	public void union(int v, int w) {
		int idV = id[v];
		int idW = id[w];
		for (int i = 0; i < id.length; i++)
			if (id[i] == idW)
				id[i] = idV;
	}

	public static void main(String[] args) {
		QuickFindUF uf = new QuickFindUF(8);
		System.out.println(uf.find(0,1));
		uf.union(0, 1);
		uf.union(2, 3);
		System.out.println(uf.find(0,1));
		System.out.println(uf.find(0,3));
		uf.union(0, 2);
		System.out.println(uf.find(0,3));
	}
}
