import java.util.Scanner;

// ------------------------------------------------------- 
// Assignment 3 
// Written by: Jack Fraser 40266009 
// For COMP 248 Section P – Fall 2024 
// -------------------------------------------------------- 


public class A3_Q2 {

	public static void main(String[] args) {
		//initialize input
		Scanner input=new Scanner(System.in);
		
		
		
		
		
		System.out.println("Welcome to Inventory Management System");
		
		
		// create product arrays for names, prices, and quantity
		String[] names=new String[5];
		
		double[] prices=new double[5];
		
		int[] quantity=new int[5];
		
		System.out.println("Enter details for 5 products (price, quantity, name):");
		
		//get user info about product and put them in arrays
		for(int i=0;i<5;i++) 
		{
			
			System.out.println("Product: "+(i+1)+"\nEnter product details (price, quantity, name): ");
			
			prices[i]=input.nextDouble();
			quantity[i]=input.nextInt();
			names[i]=input.nextLine();
			
			
		}
		
		
		
		
		
		//this variable will be used to exit the loop to terminate the program
		boolean run =true;
		
		while(run) 
		{
			
			
			System.out.println("\nInventory Management Menu: \r\n"
					+ " 1. Display information of all products \r\n"
					+ " 2. Update the quantity of a product \r\n"
					+ " 3. Search for a product by name \r\n"
					+ " 4. Find the product with the lowest quantity \r\n"
					+ " 5. Find the product with the highest price \r\n"
					+ " 6. Exit \r\n"
					+ "Enter your choice:");
			//user input selects operation to be executed from the menu
			int choice=input.nextInt();
			
			switch(choice) 
			{
				//simply displays info on all products
				case 1:
					System.out.println("Product List:");
					for(int i=0;i<5;i++) {
						System.out.println("Product: "+i+1);
						System.out.println("Name:"+names[i]);
						System.out.println("Price: "+prices[i]);
						System.out.println("Quantity: "+quantity[i]);
						System.out.println("-------------------------- ");
						
						
					}
					
					
					break;
					
					//update quantity
				case 2:
					//the program take 2 inputs, one is the index of the item to update the other is what it shoudl be updated to
					System.out.println("Enter the product number (1-5) to update quantity: ");
					int product_index=input.nextInt();
					System.out.println("Enter new quantity for "+names[product_index-1]);
					quantity[product_index-1]=input.nextInt();
					System.out.println("Quantity updated successfully!");
					
					break;
					//name search
				case 3:
					
					System.out.println("Enter the name of the product to search for:");
					
					String product_name;
					/*the reason for the use of input.nextLine() twice is 
					because we previously called input.nextInt() 
					which leaves a \n in the input buffer 
					so we need to call it twice to actually read input the first one bassically uses up
					the /n in the buffer so that the second call works normally.*/
					product_name=input.nextLine()+input.nextLine();
					
					//iterates through each element of the list to find what element of names corresponds to the user inputed search
					for(int i=0; i<5; i++) {
						
						if(product_name.toUpperCase().equals(names[i].toUpperCase())) {
							//displays matching product information
							System.out.println("Product Found:\n\tName: "+names[i]
									+"\n\tPrice: "+prices[i]
									+"\n\tQuantity: "+quantity[i]);
							
							break;
							}
						
							
						
						
						
					}
					
					
					break;
					//find lowest quantity
				case 4:
					//(initialize to 0 to avoid compilation errors)
					int lowest_quantity=quantity[0];
					int lowest_quantity_index=0;
					/* iterate through each element of the quantity array and compare it to the variable lowest_quantity 
					 * if element i in quantity[] is lesser than lowest_quantity it becomes lowest_quantity 
					 * the program does that for every element of quantity to find the lowest quantity*/
					for(int i=0; i<5;i++) 
					{
						if(quantity[i]<lowest_quantity) {
							
							
							lowest_quantity=quantity[i];
							lowest_quantity_index=i;
							
							
							
						}
						
						
						
						
						
					}
					//display item with lowest quantity
					System.out.println("\nProduct with the Lowest Quantity:\n\tName: "+names[lowest_quantity_index]
							+"\n\tPrice: "+prices[lowest_quantity_index]
							+"\n\tQuantity: "+quantity[lowest_quantity_index]);
					
					
					
					break;
				case 5:
					
					
					double lowest_price=prices[0];
					int lowest_price_index=0;
					
					
					/* iterate through each element of the prices array and compare it to the varible lowest_price 
					 * if element i in prices[] is lesser than lowest_price than it becomes lowest_price
					 * the program does that for every element of prices to find the lowest price */
					for(int i=0; i<5;i++) 
					{
						if(prices[i]>lowest_price) {
							
							
							lowest_price=prices[i];
							lowest_price_index=i;
							
							
							
						}
					}
					
					//display item with the lowest price
					System.out.println("\nProduct with the Highest Price :\n\tName: "+names[lowest_price_index]
								+"\n\tPrice: "+prices[lowest_price_index]
								+"\n\tQuantity: "+quantity[lowest_price_index]);
					
					
					
					break;
					//exit
				case 6:
					//the program ends by saying goodbye and switching run=false to break the while loop and terminate the program
					System.out.println("Goodbye?");
					//exit loop to end the program
					run=false;
					
					break;
			
			
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		input.close();
	}

}
