package com.Level1.Basics;

import java.util.Scanner;

public class PrimeNums {
	
	public boolean isPrime(int num) { // this fn says it will check if an integer num given to it is prime or not, by true or false value
		if(num < 2) // that means wherever this fn is called you have to believe that fn will do whatit says
			return false; // without asking any questions
		for(int i = 2; i < num ; i++) { // as for logic ask chatgpt to explain
			if(num % i == 0)
				return false;
		}
		return true;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		PrimeNums kaif = new PrimeNums(); // creates obj name kaif, change it to your name

		System.out.print("Enter a num to check if prime: ");
		int num = sc.nextInt();
		
		if(kaif.isPrime(num)) // will fail, uncomment line 19 and add the obj name before isprime -- kaif.isPrime(num) 
			System.out.println(num+" is prime");
		else
			System.out.println(num+" is not prime");
		
		System.out.print("Enter a num to find nth prime num: ");
		int limit = sc.nextInt();
		int checker = 2;
		int res = 0;
		
		while (limit != 0 ) {
			if(kaif.isPrime(checker)) {
				res = checker;
				limit --;
			}
			checker ++;
		}
		System.out.print(res+" is the nth prime number");
		sc.close();
	}
}