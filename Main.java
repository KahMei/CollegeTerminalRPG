import java.util.Scanner;


/*
 * Version 1.2
 * 	1.1 -- Code Re-Factored to prevent incremental recursion.
 * 	1.2 -- Created functions for talking, looking and traversing locations.
 * 
 */

public class Main {
	
	public enum GameState {
		Menu, Game, Lose, Win
	}
	
	public enum Location { //Placeholder Locations
		ParkingLot, Campus, Library, Cafeteria
	}
	
	
	static GameState gState = GameState.Menu;
	static Location currLoc;
	
	public static void MainMenu(Scanner scnr) { // First thing user sees
		String userInput;
		
		gState = GameState.Menu;
		System.out.println("This is the Main Menu.");
		System.out.println("Type Start, Help or Quit");
		userInput = scnr.nextLine();
		
		if (userInput.contains("Start") || userInput.contains("start")) { // Starts game
			StartGame(scnr);
		}
		else if (userInput.contains("Help") || userInput.contains("help")) { // Shows help menu with commands
			HelpMenu();
		}
		else if (userInput.contains("Quit") || userInput.contains("quit")) { // Terminates program
			System.out.println("Quitting Game.");
			System.exit(0);
		}
		else {
			System.out.println("Invalid choice, Please try again.");
		}
	}
	
	public static void HelpMenu() {
		System.out.println("Once the game has started, type \"Go, Exit, Talk or Look\" to make a choice");
		System.out.println("Then type the object you would want to interact with such as a person or building.");
		System.out.println("Type Help to show this menu again.");
		System.out.println("Type \"Quit\" to go back to the main menu.\n");
	}
	
	public static void ChangeLocation(Scanner scnr) {
		String userString;
		
		System.out.print("Where would you like to go? ");
		
		switch (currLoc) {
			case Campus:
				System.out.println("You can see the Library and Cafeteria from here.");
				
				while (true) {
					userString = scnr.nextLine();
					
					if (userString.equals("Library")) {
						currLoc = Location.Library;
						break;
					}
					else if (userString.equals("Cafeteria")) {
						currLoc = Location.Cafeteria;
						break;
					}
					else {
						System.out.println("Please enter a valid location.");
					}
				}
				
			case Library:
			case Cafeteria:
				System.out.println("There isn't anywhere further to go from here besides going back to the campus.\n");
				break;
			case ParkingLot:
				System.out.println("You can see the Campus from here.");
				
				while (true) {
					userString = scnr.nextLine();
					
					if (userString.equals("Campus") || userString.equals("campus")) {
						currLoc = Location.Campus;
						break;
					}
					else {
						System.out.println("Please enter a valid location like the Campus.");
					}
				}
				
			default:
				break;
		}
	}
	
	public static void EntryLocation(Scanner scnr) {
		switch (currLoc) {
			case Campus:
				System.out.println("Placeholder Campus entry text. It's hot.\n");
				break;
			case Cafeteria:
				System.out.println("Placeholder Cafeteria entry text. Food everywhere.\n");
				break;
			case Library:
				System.out.println("Placeholder Library entry text. Smells like old books.\n");
				break;
			case ParkingLot:
				System.out.println("Placeholder ParkingLot entry text. Vroom Vroom.\n");
				break;
			default:
				break;
		}
	}
	
	public static void LookLocation(Scanner scnr) {
		switch (currLoc) {
			case Campus:
				System.out.println("Placeholder Campus look text. There's a student and a duck here.\n");
				break;
			case Cafeteria:
				System.out.println("Placeholder Cafeteria look text. Lots of people eating food.\n");
				break;
			case Library:
				System.out.println("Placeholder Library look text. Two stories of musty books.\n");
				break;
			case ParkingLot:
				System.out.println("Placeholder ParkingLot look text. Beep Beep cars.\n");
				break;
			default:
				break;
		}
	}
	
	public static void TalkLocation(Scanner scnr) {
		String userString;
		
		System.out.println("Who would you like to talk to?\n");
		userString = scnr.nextLine();
		
		switch (currLoc) {
			case Campus:
				// Currently only does literals, Can change to a function later to create a conversation system.
				if (userString.equals("Student") || userString.equals("student")) {
					System.out.println("Student placeholder talk text. Hello!\n");
				}
				else if (userString.equals("Duck") || userString.equals("duck")) {
					System.out.println("Quack Quack!");
					System.out.println("The duck flew away...\n");
				}
				else {
					System.out.printf("There doesn't seem to be a %s here.\n\n", userString);
				}
				break;
			case Cafeteria:
				break;
			case Library:
				break;
			case ParkingLot:
				break;
			default:
				break;
		}
	}
	
	public static void UserInput(Scanner scnr) {
		String userString;
		

		
 		if (gState == GameState.Menu) { // Goes to the main menu if userInput is called during the Menu State.
 			MainMenu(scnr);
 		}
		else if (gState == GameState.Game) { // Allows user to choose options for the game.
			
			System.out.println("What would you like to do?");
			System.out.println();
			userString = scnr.nextLine();
			
			if (userString.contains("Go") || userString.contains("go")) {
				ChangeLocation(scnr);
				EntryLocation(scnr);
			}
			else if (userString.contains("Exit") || userString.contains("exit")) {
				System.out.println("You leave your current area and head back to the Campus.");
				currLoc = Location.Campus;
			}
			else if (userString.contains("State") || userString.contains("state")) {
				System.out.println(gState + " " + currLoc);
			}
			else if (userString.contains("Look") || userString.contains("look")) {
				LookLocation(scnr);
			}
			else if (userString.contains("Talk") || userString.contains("talk")) {
				TalkLocation(scnr);
			}
			else if (userString.contains("Help") || userString.contains("help")) {
				HelpMenu();
			}
			else if (userString.contains("Quit") || userString.contains("quit")) { // Changes state and goes back to the main menu
				System.out.println("You decide that's enough of the college life for the day and head home.\n");
				gState = GameState.Menu;
			}
			else {
				System.out.println("Invalid choice, Please try again.");
			}
		}
		else if (gState == GameState.Win) {
			//TODO
		}
		else if (gState == GameState.Lose) {
			//TODO
		}
	}
	
	public static void StartGame(Scanner scnr) {
		gState = GameState.Game;
		currLoc = Location.ParkingLot;
		System.out.println("Game Start Text");
		EntryLocation(scnr);
	}
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		
		while (true) {
			UserInput(scnr);
		}
	}

}
