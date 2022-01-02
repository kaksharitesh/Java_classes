package com.kaksha.oops;

public class Car {
	public int val;
	
	public Car(int val) {
		this.val = val;
	}
	
	public int average = 10;
	
	public int getAverage() {
		System.out.println("val in Car "+this.val);
		return average;
	}

}
