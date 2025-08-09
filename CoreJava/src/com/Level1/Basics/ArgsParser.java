package com.Level1.Basics;

public class ArgsParser { // it doesnt havve to be args always, as you can see its just a name we give, try naming it to you name
	public static void main(String kaif_Args[]) { // here you will get to know why this args is used
		if(kaif_Args.length < 2) { // we all though it was just for show, but it has some purpose
			System.out.println("At least two args should be given while running!");
			return;
		}
		try {
			int sum = 0;
			
			for(int i = 0; i < kaif_Args.length; i++) { // why loop? because more than 2 elem can be sent to args, there is no limit, each separated by a space
				
				int num = Integer.parseInt(kaif_Args[i]); // args sends values as String
				sum += num; // with Integer.parseInt it checks if that particular elem can be converted to number or not
			} // if yes then convert "12" to 12 else throw exception
			
			System.out.print("Sum of args: "+sum);
			
		} catch(NumberFormatException ex) { // various types of exceptions are there, this is because the given elem was not integer value but some other
            System.out.println("Invalid integer: " + ex.getMessage() ); // here the exact message gets printed, stating tthe issue at hand
		}
	}
}
