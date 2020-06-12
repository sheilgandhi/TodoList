import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 
 */

/**
 * @author sheil
 *
 */
public class Main {
	private static List<String> list = new ArrayList<>();
	private static String errorEmptyList = "Would you like to add something to your list";
	private static String errorMsg = "Sorry Something went wrong :(";
	
	/**
	 * Displays list and formats it
	 */
	public static void display() {
		if(!list.isEmpty()) {
			for(int i = 0; i<list.size(); i++) {
				System.out.println(i + ". " + list.get(i));
			}
		}
		System.out.println(errorEmptyList);
	}
	
	/**
	 * Adds to list
	 */
	public static void add() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter new TODO: ");
			list.add(sc.nextLine());
		} catch(Exception e) {
			System.out.println(errorMsg + " /2");
			e.printStackTrace();
		}
	}
	
	/**
	 * Removes from list
	 */
	public static void remove() {
		if(list.isEmpty()) {
			System.out.println(errorEmptyList);
			return;
		}
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter position in TODO: ");
			int input = sc.nextInt();
			if(list.size() <= input || input < 0) {
				System.out.println("Please enter valid position in list");
				remove();
			}
			list.remove(input);
		} catch(Exception e) {
			System.out.println(errorMsg + " /3");
			e.printStackTrace();
		}
	}
	

	/**
	 * Runs the main user asking and processing here
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(!list.isEmpty()) {
			display();
		} else {
			System.out.println(errorEmptyList);
		}
		while(true) {
			try {
				//https://stackoverflow.com/questions/24104313/how-do-i-make-a-delay-in-java
				TimeUnit.SECONDS.sleep(2);
				String input;
				Scanner sc = new Scanner(System.in);
				System.out.println("What would you like to do? \n"
						+ "1. Display\n"
						+ "2. Add\n"
						+ "3. Remove\n"
						+ "4. Sort\n"
						+ "5. Exit");
				input = sc.nextLine();
				if(input.equalsIgnoreCase("display") || input.equals("1")) {
					display();
				} else if(input.equalsIgnoreCase("add") || input.equals("2")) {
					add();
				} else if(input.equalsIgnoreCase("remove") || input.equals("3")) {
					remove();
				} else if(input.equalsIgnoreCase("sort") || input.equals("4")) {
					Collections.sort(list);
				} else if(input.equalsIgnoreCase("exit") || input.equals("5")) {
					System.exit(0);
				}
			} catch(Exception e) {
				System.out.println(errorMsg + "\2");
				e.printStackTrace();
			}
		}
	}

}
