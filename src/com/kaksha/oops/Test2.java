package com.kaksha.oops;

public class Test2 {

	public void fun(int x) {
		System.out.println("I am small int");
	}

	public void fun(long x) {
		System.out.println("I am long");
	}

	public void fun(int... x) {
		System.out.println("I am var arg");
	}

	public void fun(Integer x) {
		System.out.println("I am Integer Class");
	}

	public static void main(String[] args) {

		// unboxing - widening - boxing - var arg

		Test2 t = new Test2(); // Autobox and autounboxing -- auto widening
		t.fun(10);

		// who gets preference autobox or autowidening
	}

}
