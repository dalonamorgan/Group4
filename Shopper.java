package Team;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.math.*;
public class Shopper {
 
	static ListItem[] Items = {};
	
	static int numberofitems = 0;
	public static void main(String[] args) {
		try 
		{
			System.out.println("Welcome to Dalona, Osaede, Renee and Yasin Shopping Project!");
			Customer c1 = new Customer();
			
			c1.name = "Toni";
			System.out.println("Our Customer name is " + c1.name); 
			
			boolean keepShopping = true;
			Scanner input = new Scanner(System.in);
			while (keepShopping == true) {			
				System.out.print("Continue shopping? Y/N: ");
				String answer = input.next();
				keepShopping = ContinueShopping(answer);
				if (keepShopping) {
					System.out.println("What would you like to add to cart? ");
					answer = input.next();
					double price = Math.round(GetPrice())/100;	
					System.out.println("Specify quantity:");	
					int qty = input.nextInt();
					addItem(new ListItem(answer, price, qty));
					numberofitems++;
					System.out.println(qty + " " + answer +" added to cart");
				} 
			}
			DisplayItems();
			System.out.println("Goodbye! Thanks for shopping with us");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void DisplayItems() {
		double total_price = 0.0;
		if (Items.length > 0) {
			System.out.println("\nYou have bought:\n");
			for (int i = 0; i < Items.length; i++) {
				ListItem item = (ListItem)Items[i];
				String item_name = item.getName();
				double item_price = item.getPrice();
				int quantity = item.getQty();
				total_price += item_price * quantity;
				System.out.println(quantity + " of " + item_name + " for " + item_price + " each");
			}
		}
		System.out.println("Your total was " + total_price);
	}
	
	private static boolean ContinueShopping(String answer) {
		boolean yes = true;
		if (answer.equals(String.valueOf("N")) | (answer.equals(String.valueOf("n")))) {
			yes = false;
		}
		return yes;
	}
	
	private static double GetPrice() {
		Random rand = new Random();
		float randomNum = rand.nextFloat();
		float discount = GetDiscount();
		float price = 100 * (randomNum * 10) - discount;
		float discount_percentage = 100* discount / (100 * (randomNum * 10));
		System.out.println("Your discount was " + discount_percentage + "%");
		return price;
	}
	
	private static float GetDiscount() {
		Random rand = new Random();
		float randomNum = rand.nextFloat();
		return 10 * (randomNum * 10);
	}
	
	public static void addItem(ListItem x)
   {
       int i;
       //turn array into ArrayList using asList() method
       List arrList = new ArrayList( Arrays.asList(Items));

       // adding a new element to the array
       arrList.add(x);

       // Transforming the ArrayList into an array
       Items = (ListItem[]) arrList.toArray(Items);
   }
	
	/*
	 * private static void AddItemToCart(ListItem itm) { myCart.add(itm);
	 * 
	 * }
	 */
}