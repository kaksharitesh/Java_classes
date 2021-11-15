package com.kaksha.generics;

import java.util.Comparator;

public class StudentComparator {

	public static class NameComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			return o1.getName().compareTo(o2.getName());
		}

	}

	public static class GPAComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			if (o1.getGpa() == o2.getGpa())
				return 0;
			if (o1.getGpa() > o2.getGpa())
				return +1;
			return -1;
		}

	}

}
