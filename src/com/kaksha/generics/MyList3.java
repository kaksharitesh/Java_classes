package com.kaksha.generics;

import java.util.Comparator;

public class MyList3 {
	private Object[] a;
	private int size;

	public MyList3(int initialSize) {
		this.a = new Object[initialSize];
		this.size = 0;
	}

	public int size() {
		return size;
	}

	public void insert(Object i) {
		a[size++] = i;
	}

//	public void sort() {
//		sort(null);
//	}

	public void sort(Comparator c) {
		sort(0, size - 1, c);
	}

	private void sort(int l, int r, Comparator c) {
		if (r <= l)
			return;
		int p = l;
		for (int i = l + 1; i <= r; i++) {
			int cmp = c.compare(a[i], a[l]);
			
			//objects do not have compare to function
//			if (c != null) {
//				cmp = c.compare(a[i], a[l]);
//			} else {
//				cmp = a[i].compareTo(a[l]);  
//			}
			if (cmp < 0)
				swap(i, ++p);

		}

		swap(p, l);
		sort(l, p - 1, c);
		sort(p + 1, r, c);
	}

	private void swap(int i, int j) {
		Object t = a[i];
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
		MyList3 list1 = new MyList3(10);
		
		assert list1.size() == 0;
		list1.insert(new Student("a", 3, 1.3f));
		list1.insert(new Student("c", 5, 1.6f));
		list1.insert(new Student("b", 7, 2.3f));
		list1.insert(new Student("e", 1, 0.3f));
		list1.insert(new Student("d", 6, 1.1f));
		assert list1.size() == 5;
		
		System.out.println(list1);
		list1.sort(new StudentComparator.GPAComparator());
		System.out.println(list1);
		//list1.sort(); -- will not work with default compare to function as Object class does not have compareTo
		System.out.println(list1);
		list1.sort(new StudentComparator.NameComparator());
		System.out.println(list1);
		
		MyList3 list2 = new MyList3(10);
		list2.insert("5");
		list2.insert("6");
		list2.insert("7");
		list2.insert("3");
		list2.insert("2");
		//issue : there is no default compare to function with Object class
		list2.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		}); 
		System.out.println(list2);
		
		//Issue: list2.insert(5) is valid statement but fail at sorting
		// while comparing string to integer
	}
}
