package com.kaksha.ds.uf;

public class WeightedUF implements UnionFind{

	private int[] id;
	private int[] size;

	public WeightedUF(int n) {
		id = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}
	
	private int root(int v) {
		while(id[v] != v) {
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
		
		if(size[v] > size[w]) {
			id[rootW] = rootV;
			size[rootV] += size[rootW];
		}else {
			id[rootV] = rootW;
			size[rootW] += size[rootV];
		}
	}
	
	public static void main(String[] args) {
		WeightedUF uf = new WeightedUF(8);
		System.out.println(uf.find(0, 1));
		uf.union(0, 1);
		uf.union(2, 3);
		System.out.println(uf.find(0, 1));
		System.out.println(uf.find(0, 3));
		uf.union(0, 2);
		System.out.println(uf.find(0, 3));
	}
}
