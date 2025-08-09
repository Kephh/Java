package com.Level1.Basics;

import java.util.Arrays;
import java.util.Scanner;

public class SecondLargest {
	public static int findSecondLargest(int[] arr) { // static keyword allows a method to be called/invoked without creating an obj
	    if (arr == null || arr.length < 2) { // method calling with obj is shown in PrimeNums.java
	        throw new IllegalArgumentException("Array must have at least two elements");
	    }
	    Arrays.sort(arr); // inbuilt fn
	    int largest = arr[arr.length - 1];
	    // Start from second last element and go backwards
	    for (int i = arr.length - 2; i >= 0; i--) {
	        if (arr[i] < largest) {
	            return arr[i];
	        }
	    }
	    throw new IllegalArgumentException("No distinct second largest element");
	}

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter size of array: ");
    	int size = sc.nextInt();
    	int[] arr = new int[size];
    	while (size > 0) { // read line 29 and 30, we could use size >= 0 for removing one line
    		System.out.print("Enter elem: "); // reading input and writing in reverse order of arr
    		arr[size - 1] = sc.nextInt(); // could have been written --size
    		size --; // instead of extra line size -- 
    	}
    	System.out.print("Elements are: ");
    	for(int i : arr) // for each loop takes copy of each elem of arr
    		System.out.print(i); // for one line curly braces are not needed
    	System.out.println();
        try { //try catch tries to do something and if cant be done then throws exception saying it cant be done because of some reason
            int result = findSecondLargest(arr);
            System.out.println("Second largest: " + result);
        } catch (IllegalArgumentException e) { // if some exception or run time error is found then it is caught here
            System.out.println("Error: " + e.getMessage()); // In depth explanation is in ArgsParser.java
        }
        sc.close(); // if not closed will occupy memory for an unknown amount of time
    }
}
