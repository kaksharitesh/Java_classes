package com.kaksha.oops;

import java.io.Serializable;

public class Test implements Serializable{   
	//Marker interface  : Serializable and Cloneable
	int i;
	
public static void main(String[] args) {
	Test t = new Test();
	System.out.println(t.toString());
}
	
	

}
