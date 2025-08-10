package com.Level1.Basics;

import java.util.Scanner;

public class StringStats {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String str = sc.nextLine();
		
		String alphabets = "abcdefghijklmopqrstuvwxyz";
		String numbers = "1234567890";
		String vowel = "aeiou";
		
		int spaceCount = 0;
		int vowelCount = 0;
		int consonantCount = 0;
		int digitCount = 0;
		int puncCount = 0;
		
		
		// another optimized method
//		Set<Character> vowelSet = Set.of('a','e','i','o','u'); // Set stores unique values
//		for(char ch : str.toLowerCase().toCharArray()) {
//			// the above 3 variables can be optimized to only 2.
//		}
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.toLowerCase().charAt(i); // toLoweCase method lowercases the whole string
			if (str.charAt(i) == ' ') { // charAt takes individual character from string, "Kaif".charAt(1) is 'a'
				spaceCount ++;
			} else if (alphabets.contains(ch + "")) { // constains checks if a substring is there in a string or not
				if (vowel.contains(ch + "")) { // in "Kaif" it checks if "ai" is there or not
					vowelCount ++;		// here ch was a char so by adding a char to empty str "", 'a' become "a".			
				} else {
					consonantCount ++;
				}
			} else if (numbers.contains(ch + "")) {
				digitCount ++;
			} else {
				puncCount ++;
			}
		}
		
		
		
		System.out.println("Vowels: "+vowelCount);
		System.out.println("Consonants: "+consonantCount);
		System.out.println("Digits: "+digitCount);
		System.out.println("Punctuations: "+puncCount);
		System.out.println("Spaces: "+spaceCount);
		sc.close(); // we have to close this because it reads from System input stream, see SecondLargest.java for more....
	}
}
