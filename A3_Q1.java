

import java.util.Scanner;

// ------------------------------------------------------- 
// Assignment 3 
// Written by: Jack Fraser 40266009 
// For COMP 248 Section P – Fall 2024 
// -------------------------------------------------------- 

public class A3_Q1 {
	
	
	
	public static void main(String args[]) {
		
		//initialize input object instance
		Scanner input = new Scanner(System.in);
		
		//welcome message
		System.out.println("Welcome to the Best Bank ATM!");
		//System.out.println("this was a test change to learn git");
		System.out.println("this is a change made in master branch to see what happens");
		//intialize ballance, run, option variables
		float ballance=0;
		
		int option;
		
		boolean run=true;
		
		while(run) {
			
			System.out.println("----------------------------------------------------\nPlease choose an option\n\t1. Check Balance\n\t2. Deposit\n\t3. Withdraw\n\t4. Exit\nEnter your choice: ");
			
			
			//take input to determine desired operation
			option = input.nextInt();
			
			switch(option) {
			
			case 1:
				
				System.out.println("Your balance is: $"+ballance);
				
				break;
			case 2:
				
				System.out.print("Enter amount to deposit:");
				float depo_sum=input.nextFloat();
				if (depo_sum<0) {
					System.out.println("invalid deposit amount! Input must be non-negative.");
				}
				else {
					
					ballance+=depo_sum;
					System.out.println("Deposit successful!");
				}
				
				
				break;
			case 3:
				
				System.out.println("Enter amount to withdraw (multiples of 5, 10, 50, or 100):");
				//get withdraw amount
				int withdraw_sum=input.nextInt();
				//this is an array of the values that the deposit will be divided into
				int[] bills= {5,10,50,100};
				// this is an array where each index corresponds to a bill (5:index 0, 10:index 1, 50:index 2, 100:index 3) and the values of the index is the quantitiy of each bill that will be returned
				int[] bills_quantity=new int[4];
				
				//check if input is valid by seing if it is a multiple of 5, non-negative, 
				if(!((withdraw_sum%5==0) && (withdraw_sum>=5)&&(withdraw_sum<10000)&&((withdraw_sum<=ballance))))
				{
					
					System.out.println("Invalid withdrawal amount! You can only withdraw amounts that are multiples of 5, 10, 50 or 100.");
					
					
				}
				else {
					
					//subtract withdraw from ballance
					ballance-=withdraw_sum;
		
					
					//this loop divides the withdraw_sum into bills and prioritizes larger bills meaning it will split 150 int 100+50 and not 10X10+5X5
					int i=3;
					while( i>-1) 
					{
						
						
						//checks if bill i in bills is smaller than the withdraw sum
						if(withdraw_sum>=bills[i]) 
							{
							//removes the quantity of bill i from the withdraw_sum
							withdraw_sum-=bills[i];
							//adds one count to the quantity of bill i in the bill_quantity index corresponding to bill i 
							bills_quantity[i]++;
						
							}
						else {
							//if the current bill i is too large then move on to next largest bill in bills
							i--;
							
							
						}
						
						
					}
					//output the corresponding bill quantities for withdraw
					System.out.println("You will receive:\n\t"
					+bills_quantity[3]+" bill(s) of $100\n\t"
					+bills_quantity[2]+" bill(s) of $50\n\t"
					+bills_quantity[1]+" bill(s) of $10\n\t"
					+bills_quantity[0]+" bill(s) of $5\n\t"
					+"Withdraw successful!");
					
					
					
					
					
					
				}
				
				
				break;
			case 4:
				//if user inputs 4 the program terminates by breaking the while loop by changing the variable run from true to false
				run=false;
				System.out.println("Goodbye!");
				break;
			default:
				//if none of the listed choices are selected by the user a message is displayed and then the user is re-prompted for input
				System.out.println("Invalid choice! Please try again.");
				break;
			
			
			}
			
			
			
		}
		
		input.close();
	}
	
}
