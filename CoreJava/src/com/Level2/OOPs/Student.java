package com.Level2.OOPs;

public class Student {
	
	public String name; // global variable name, called with an obj, eg - obj.name --> prints: "kaif khan"
	public int age; // global variable age, stores data globally
	
	public Student(String name) { // constructor, assigns objects with n number of values to properties
		this.name = name; //this keyword points to global variable name, explained better in line 15
		this.age = 500000; // since only name was given, we can set age = 500000 or any other value
	}
	
	public Student(String n, int age) { // another constructor with more parameter
		this.name = n; // The parameter variable does not need to be same with this.name, it can be anything
		this.age = age; // here this.age = age gives some value to global age var
	}
	
	public static void main(String args[]) {
		
		Student student1 = new Student("Kaif Khan"); // just like scanner we can create obj for any class
		// here for student class we create an obj student1 by only giving name
		// new is the keyword that created memory for object in RAM
		// Student is the constructor that initializes values to whatever fields are given
		System.out.println(student1.name+": "+student1.age); 
		
		Student student2 = new Student("Julia Khatun", 16); // here we gave 2 values, so the 2nd constructor was called
		// name was assigned as expected and age was also provided so it assigned accordingly
		// think of line 26 as variable declaration, LHS of = sign is the variable name and type
		// RHS is the value to be given, only difference is the type here is a class
		// thus the values are also to be given accordingly
		// We cannot give "16" instead of 16 as it violates datatype integrity
		System.out.print(student2.name+": "+student2.age);

	}
	
}
