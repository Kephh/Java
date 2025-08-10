package com.Level2.OOPs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee implements Comparable<Employee>{
	public int id;
	String name;
	int salary;
	
	Employee(int id, String name, int salary){
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }

	@Override
	public int compareTo(Employee emp) {
		return Integer.compare(this.id, emp.id);
	}
	
	@Override
	public String toString() {
	    return "Employee{id=" + id + 
	           ", name='" + name + '\'' + 
	           ", salary=" + salary + '}';
	}
}

public class EmployeeCompare {
	
	public static void main(String args[]) {
		List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(3, "Alice", 70000));
        employees.add(new Employee(1, "Bob", 90000));
        employees.add(new Employee(4, "Charlie", 70000));
        employees.add(new Employee(2, "David", 90000));
        employees.add(new Employee(5, "Eve", 50000));

        System.out.println("Original List:");
        employees.forEach(System.out::println);
        
        Collections.sort(employees);
        employees.forEach(System.out::println);
        
        Comparator<Employee> bySalaryThenName = 
        		Comparator.comparingDouble(Employee::getSalary)
        		.thenComparing(Employee::getName);
        
        employees.sort(bySalaryThenName);
        employees.forEach(System.out::println);
	}
	

}
