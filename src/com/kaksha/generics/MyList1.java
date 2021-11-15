package com.kaksha.generics;

import java.util.Comparator;

public class MyList1<T extends Comparable<? super T>> {
    //Generics : E, K V T, S U  ? 
	private T[] a;
	private int size;

	@SuppressWarnings("unchecked")
	public MyList1(int initialSize) {
		this.a = (T[]) new Comparable[initialSize];
		this.size = 0;
	}

	public int size() {
		return size;
	}

	public void insert(T i) {
		a[size++] = i;
	}

	public void sort() {
		sort(null);
	}

	public void sort(Comparator<T> c) {
		sort(0, size - 1, c);
	}

	private void sort(int l, int r, Comparator<T> c) {
		if (r <= l)
			return;
		int p = l;
		for (int i = l + 1; i <= r; i++) {
			int cmp = 0;
			if (c != null) {
				cmp = c.compare(a[i], a[l]);
			} else {
				cmp = a[i].compareTo(a[l]);
			}
			if (cmp < 0)
				swap(i, ++p);

		}

		swap(p, l);
		sort(l, p - 1, c);
		sort(p + 1, r, c);
	}

	private void swap(int i, int j) {
		T t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	@Override
	public String toString() {
		String s = "[";
		for (int i = 0; i < size; i++)
			s = s + a[i].toString() + ",";
		s = s + "]";
		return s;
	}
	public static void main(String[] args) {
		MyList1<Student> l = new MyList1<Student>(10);
		
		assert l.size() == 0;
		l.insert(new Student("a", 3, 1.3f));
		l.insert(new Student("c", 5, 1.6f));
		l.insert(new Student("b", 7, 2.3f));
		l.insert(new Student("e", 1, 0.3f));
		l.insert(new Student("d", 6, 1.1f));
		assert l.size() == 5;
		
		System.out.println(l);
		l.sort(new StudentComparator.GPAComparator());
		System.out.println(l);
		l.sort();
		System.out.println(l);
		l.sort(new StudentComparator.NameComparator());
		System.out.println(l);
		
		MyList1<String> l2 = new MyList1<String>(10);
		l2.insert("5");
		l2.insert("6");
		l2.insert("7");
		l2.insert("3");
		l2.insert("2");
		l2.sort();
		System.out.println(l2);
		
		MyList1<Integer> l3 = new MyList1<Integer>(10);
	}
}
