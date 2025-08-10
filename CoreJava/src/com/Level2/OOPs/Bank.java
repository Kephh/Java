package com.Level2.OOPs;

import java.util.Scanner;

public class Bank {
	
	public String name; // global variable name
	public Double balance; // double is a datatype, Double is a wrapper class
	//Wrapper classes provide more features, than regular datatypes
	
	public Bank(String name) { // constructor, assigning value to obj
		this.name = name; //this keyword points to global variable name
		this.balance = 0.0; // since only name was given, we should set balance = 0, if not set will be null
	}
	
	public Bank(String n, double balance) { // another constructor with more parameter
		this.name = n; // The parameter variable does not need to be same with this.name, it can be anything
		this.balance = balance; // here this.balance = balance gives some value to global balance var
	}
	
	public static void main(String args[]) {

		System.out.println("Create your own account!!!!\n");
		Scanner sc = new Scanner(System.in); // taking input from user using scanner
		
		System.out.print("Enter your name: "); // prompt user to give input
		String name = sc.nextLine(); // next() takes only one word, nextLine() takes the whole line
		//thus now instead of kaif you will be able to see your full name
//		String name = sc.next(); // comment this line and uncomment the previous line
		
		Bank acc = new Bank(name); // obj acc created with name taken from user
		
		System.out.println("New account created!");
		System.out.println(acc.name+": "+acc.balance);
		try { // using try catch to try something and if not possible throw an exception
			while(true) { // while true keeps the loop going infinitely
				// so as to keep doing transactions until any error or exit condition reached
				System.out.print("\n\n========Banking options========\n\n");
				System.out.println("1. Deposit money");
				System.out.println("2. Withdraw money");
				System.out.println("3. Check balance");
				System.out.println("Press any other key to exit...");
				System.out.println("Enter your choice: ");
				String choice = sc.next(); // taking choice of transaction in string
				// users can type anything other than integer so it is a precaution
				
				double amount = 0; // double because the amount can be decimal point number like 50.5
				
				switch (Integer.parseInt(choice)) { // switch has a variable given and case matches its value
				// parseInt because choice was taken in string so converting it into integer for matching
				
					case 1:	// if choice=1 then this will execute
							System.out.print("Enter amount to deposit: "); 
							amount = sc.nextInt();
							acc.deposit(amount); // sending amount to be deposited to the balance of obj acc
							break; // breaking because we dont want any other cases to run
					// try commenting the above break and see case 2 also getting executed when pressed 1
							
					case 2: // if choice=2 then this will execute
							System.out.print("Enter amount to withdraw: ");
							amount = sc.nextInt(); // taking amount from user
							acc.withdraw(amount); // withdrawing amount from balance of obj acc
							break;
							
					case 3: // if choice=3 then this will execute
							acc.getBalance(); // getting balance details
							break;
							
					default: // if no other cases executed then this will execute
						// think of switch cases like a river
						// if not stopped (break) then will flow down (execute) everything below it until end of block
						System.out.println("Exiting banking system....");
						break; // not necessary as below it is the end of block, but still given
				}
			}
		} catch(Exception ex) { // catches any exception caught during flow of program
			System.out.println("Error: "+ex.getMessage()); // the error message
		}
		sc.close();
		
	}

	private void getBalance() {
		System.out.println("Your account balance is: "+this.balance); // prints the balance
	}

	private void withdraw(double amount) throws InsufficientBalanceException { 
		// throws keyword throws exception
		// dont bother with the last word, will get to know about it later
												
		if(amount > this.balance) // if amount greater than balance, say the following
			throw new InsufficientBalanceException("The withdraw amount exceeds balance: "+ this.balance);
		else // do the needful
			this.balance -= amount;
	}

	private void deposit(double amount) throws InvalidAmountException{
		if(amount < 1) // again dont mind it for now
			throw new InvalidAmountException("The depositing amount is invalid: "+ amount);
		else 
			this.balance += amount; // if amount greater than 0 then only deposit otherwise throw exception
	}
}

@SuppressWarnings("serial") // suppresses something, will talk later
class InvalidAmountException extends Exception{ // will explain later
	public InvalidAmountException(String msg) {// will explain later
		super(msg);// will explain later
	}
}

@SuppressWarnings("serial")// will explain later
class InsufficientBalanceException extends Exception{// will explain later
	public InsufficientBalanceException(String msg) {// will explain later
		super(msg);// will explain later
	}
}