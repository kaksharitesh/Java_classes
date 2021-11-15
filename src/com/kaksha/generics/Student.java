package com.kaksha.generics;

public class Student implements Comparable<Object>{
    private int id;
    private String name;
    private float gpa;
    
    public String getName() {
    	return this.name;
    }
    
    public float getGpa() {
    	return this.gpa;
    }
    
    public Student(String name, int id, float gpa) {
    	this.id = id;
    	this.name = name;
    	this.gpa = gpa;
    }
    
//	@Override
//	public int compareTo(Student o) {
//		return this.id - o.id;
//	}
	
	@Override
	public String toString() {
		return "{name="+name+",id="+id+",gpa="+gpa+"}";
	}

	@Override
	public int compareTo(Object o) {
		Student s1 = (Student) o;
		return this.id - s1.id; 
	}

}
