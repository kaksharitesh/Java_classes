package com.kaksha.oops;

import java.io.Serializable;

public class Test implements Serializable{   
	//Marker interface  : Serializable and Cloneable
	int i;
	
public static void main(String[] args) {
	
	Car c = new Car();
	System.out.println(c.average);
	System.out.println(c.getAverage());
	System.out.println("-----------------------------");
	Maruti m = new Maruti();
	System.out.println(m.average);
	System.out.println(m.getAverage());
	
	System.out.println("-----------------------------");
	Car m2 = new Maruti();
	System.out.println(m2.average);
	System.out.println(m2.getAverage());
	
	System.out.println(c.getClass());
	System.out.println(m.getClass());
	System.out.println(m2.getClass());

}
	
	

}
