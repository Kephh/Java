package com.Level2.OOPs;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class WordFrequency {

	public static void main(String args[]) {
		
		try { // try performing logic
			
			Path filePath = Path.of("./resources/text.txt"); // reading path of file 
			String text = Files.readString(filePath); // reading content of file as string
			
			text = text.toLowerCase().replaceAll("[^a-z0-9\\s]", " "); // normalizing --> removing punctuations and lowercasing
			
			String[] words = text.split("\\s+"); // splitting on the basis of one or more whitespaces --> if one then, only s but for more s+, it is called regex -> regular expression
			
			Map<String, Integer> freqMap = new HashMap<>(); // making a map with key and value
			
			for(String word : words) { // using foreach loop to iterate
				if(!word.isEmpty()) // if word is not empty
					freqMap.put(word, freqMap.getOrDefault(word, 0) + 1); // putting the word in map while checking its previous count in consideration
				// put is for storing, word is the key, the last part gets either the value for that key or 0, lastly whatever we get we increment it by 1
				// if a word is there then its value is fetched, else 0 is fetched and 1 is incremented
			}
			
			freqMap.entrySet() // this gets a link between all elements of map 
				.stream() // creates the iterable link 
				.sorted((a, b) -> { // sorts by taking 2 values at a moment
					int cmp = b.getValue().compareTo(a.getValue()); // compares values by frequency
					return cmp != 0 ? cmp : a.getKey().compareTo(b.getKey()); // compares values lexicographically
				})
				.limit(10) // gives top 10 elem
				.forEach(e -> System.out.println(e.getKey()+": "+e.getValue())); // iterates over and does the needful
			
		} catch(Exception ex) { // catches any exception
			System.out.println("Error: "+ex.getLocalizedMessage()); // prints the exception msg
		}
	}
	
}
