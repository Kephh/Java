package com.Level2.OOPs;

import java.util.Scanner;

abstract class Shape { // abstract classes are used in inheritance, they let u create abstract methods/functions
	
	abstract double area(); // abstract method without any body
	abstract double perimeter(); // this method has to be mandatorily overrided if any class extends(inherits) hape class
	
	public static void main(String args[]) {
		
		Shape shape; // declaring obj of Shape(Parent class), this obj when used with other class constructrs can behave an obj of child class
		
//		Circle circle; 
//		Rectangle rectangle; // 3 different objects can be used as well for ease of understanding
//		Triangle triangle; // if you want to use then give it memory, i.e - Triangle triangle = new Triangle(), same for other obj
		
		Scanner sc = new Scanner(System.in);
		int choice = -1; // see line 21, as the looping condition is choice not being 0, so we can give any value other than 0
		
		while(choice != 0) { // infinitely looping so as to get the below menu as many times
			
			System.out.print("\n=======Area & Perimeter calculator=======\n");
			
			System.out.println("1. Circle");
			System.out.println("2. Rectangle"); // The menu
			System.out.println("3. Triangle");
			System.out.println("Press 0 to exit...");
			
			try { // try block tries to do something
			
				System.out.println("Enter choice: ");
				choice = sc.nextInt(); // choice is inputted
				
				switch(choice) { // switch takes value of choice and checks with other cases if it matched any
				
					case 1: // if choice  = 1, then this executes
						
						System.out.println("Enter radius: ");
						double radius = sc.nextDouble(); // nextDouble takes input for double values, as nextInt takes for integer
						
						//now shape will become obj of Circle class
						shape = new Circle(radius); // if you are using 3 obj then rename this shape to circle
						// here the radius value taken earlier is given to circle class constructor to assign value
						
						System.out.println("Area: "+shape.area()); // calling the method with obj, change shape to circle if using circle obj
						System.out.println("Perimeter: "+ shape.perimeter()); // calling other method with obj
	
						break; // breaking so as to stop executing the below lines
						
					case 2: // if choice = 2 this block executes
						
						System.out.println("Enter length: ");
						double length = sc.nextDouble(); // inputting length
						
						System.out.println("Enter breadth: ");
						double breadth = sc.nextDouble(); // inputting breadth
						
						//now shape will become obj of Rectangle class
						shape = new Rectangle(length, breadth); // as this is rectangle option, we are giving memory to Rectangle obj constructor
						
						System.out.println("Area: "+shape.area()); // calling area method using obj
						System.out.println("Perimeter: "+ shape.perimeter());
	
						break;
						
					case 3: // if choice = 3 then executes this block
						
						System.out.println("Enter side 1: ");
						double s1 = sc.nextDouble();
						
						System.out.println("Enter side 2: ");
						double s2 = sc.nextDouble();
						
						System.out.println("Enter side 3: ");
						double s3 = sc.nextDouble();
						
						//now shape will become obj of Triangle class
						shape = new Triangle(s1, s2, s3); // three sides of triangle so three variables are given to triangle obj constructor
						
						System.out.println("Area: "+shape.area());
						System.out.println("Perimeter: "+ shape.perimeter());
						
						break;
						
					default: // if 1 / 2 / 3 not pressed then default is called
						
						System.out.println("Exiting the menu....");
						choice = 0; // making choice = 0, why? because our exit condition was when choice become 0 and we need to exit loop now
						// thus ending the program
					
				}
			} catch(Exception ex) { // if any exception/run time error is caught then it comes here
				System.out.println("Error: "+ex.getMessage());
				return; // instead of break we are returning the whole main function so that the program stops
			}
			
		}
		sc.close(); // closing scanner sc, why? because if one will leak memory(occupy memory in RAM)
	}
}

// inheritance lets child classes like circle inherit properties(like area, perimeter) of parent class(Shape)

class Circle extends Shape{ // Circle inherits Shape properties
	
	public Double radius = 0.0;
	public final Double pi = 3.14; // making pi final because we dont want to change it

	public Circle(double r) { // the constructor that initializes value for circle obj
		this.radius = r; // this.radius refers to line 104
	}

	@Override // as we had declared a method in Shape  with same name, we are mentioning @Override here
//it signals compiler to call this method instead of the shape class method with same signature(same number & type of parameter and same return type)
	// double area() --> return type is double with no parameter, 0 params, same as line 7
	double area() {
		double ans = this.pi*this.radius*this.radius; // calculating area
		return ans; // return the value to be printed
	}

	@Override // overriding the shape class method perimeter, calling this one instead of the parent class one
	double perimeter() {
		double ans = 2*this.pi*this.radius;
		return ans;
	}
	
}

class Rectangle extends Shape{ // inheriting properties from Shape
	
	public Double length = 0.0;
	public Double breadth = 0.0;

	public Rectangle(double length, double breadth) { // constructor for Rectangle class, called in line 60
		this.length = length;
		this.breadth = breadth;
	}

	@Override // overriding Shape, why because when calling this fn the obj belongs to Rectangle class, see line 59
	double area() {
		double ans = this.length*this.breadth;
		return ans;
	}

	// when we give memory of one class it belong to class only, and inherits properties from parent class if any
	@Override
	double perimeter() {
		double ans = 2*(this.length+this.breadth);
		return ans;
	}
	
}

class Triangle extends Shape{ 
	
	public Double a = 0.0;
	public Double b = 0.0;
	public Double c = 0.0;

	public Triangle(double s1, double s2, double s3) { // constructor for Triangle class, see line 79
		if (s1 + s2 <= s3 || s1 + s3 <= s2 || s2 + s3 <= s1) { // checking for mathematical trianngle properties
            throw new IllegalArgumentException("Invalid triangle sides"); // throws tantrum, saying "Ye cheating hai, mai nahi khel raha"
        }
		this.a = s1; // setting values
		b = s2; // without using this we can also do it but using this is recommended
		this.c = s3; // because we have args with different name like c and s3, but it can also be same, so we differentiate 
	}

	@Override // overriding Shape class method
	double area() {
		double s = (this.a + this.b + this.c)/2; // herons formula
		double ans = s*(s - this.a)*(s - this.b)*(s - this.c); // Herons formula
		return Math.sqrt(ans); // Herons formula, Math.sqrt is inbuilt fn to calculate square root
	}

	@Override
	double perimeter() {
		double ans = a + b + c;
		return ans;
	}
	
}
