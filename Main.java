package ttrpg;

import java.util.Scanner;


/*
 * Version 1.2
 * 	1.1 -- Code Re-Factored to prevent incremental recursion.
 * 	1.2 -- Created functions for talking, looking and traversing locations.
 * 	1.3 -- Adding a time function, a functioning talk loop and more Locations.
 *	
 */

public class Menu {
	
	public enum GameState {
		Menu, Game, Lose, Win
	}
	
	public enum Location { //Placeholder Locations
		ParkingLot, Campus, Admissions, Cafeteria, Classroom, Library
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
			scnr.close();
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
				System.out.println("You can see the Library, Cafeteria, a Classroom and the Admissions building from here.");
				
				while (true) {
					userString = scnr.nextLine();
					
					if (userString.equals("Library")) {
						currLoc = Location.Library;
						break;
					}
					else if (userString.equals("Cafeteria") || userString.equals("Cafeteria")) {
						currLoc = Location.Cafeteria;
						break;
					}
					else if (userString.equals("Classroom") || userString.equals("classroom")) {
						currLoc = Location.Classroom;
						break;
					}
					else if (userString.equals("Admissions") || userString.equals("admissions")) {
						currLoc = Location.Admissions;
						break;
					}
					else {
						System.out.println("Please enter a valid location.");
					}
				}
				break;
			case ParkingLot:
				System.out.println("You can see the Admissions building from here.");
				
				while (true) {
					userString = scnr.nextLine();
					
					if (userString.equals("Admissions") || userString.equals("admissions")) {
						currLoc = Location.Admissions;
						break;
					}
					else {
						System.out.println("Please enter a valid location like the Campus.");
					}
				}
				break;
			case Admissions:
			case Library:
			case Classroom:
			case Cafeteria:
				System.out.println("There isn't anywhere further to go from here besides going back to the campus.\n");
				break;
			default:
				break;
		}
	}
	
	public static void EntryLocation() {
		switch (currLoc) {
			case Campus:
				System.out.println("Placeholder Campus entry text. It's hot.\n");
				break;
			case Admissions:
				System.out.println("You enter the Admissions Building.");
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
			case Classroom:
				System.out.println("Placeholder Classroom entry text. Seems to be empty at the moment.\n");
				break;
			default:
				break;
		}
	}
	
	public static void LookLocation() {
		switch (currLoc) {
			case Campus:
				System.out.println("Placeholder Campus look text. There's a student and a duck here.\n");
				break;
			case Admissions:
				System.out.println("Placeholder Admissions. You see a clerk nearby.");
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
			case Classroom:
				System.out.println("There's nobody in here at the moment.\n");
				break;
			default:
				break;
		}
	}
	
	public static void TalkLocation(Scanner scnr, ActivityLog questLog) {
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
			case Admissions:
				if (userString.equals("Clerk") || userString.equals("clerk")) {
					
					System.out.println("Clerk: Welcome to the College!");
					
					while (true) {
						userString = scnr.nextLine();
						
						if (userString.equals("Hello") || userString.equals("hello")) {
							System.out.println("Clerk: Hello!");
							questLog.setAdmission();
						}
						else if (userString.equals("Bye") || userString.equals("bye")) {
							System.out.println("Clerk: Have a good rest of your day!");
							break;
						}
						else {
							System.out.println("Clerk: I didn't quite catch what you said...");
						}
					}
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
			case Classroom:
				break;
			default:
				System.out.println("Fix Me!");
				System.out.println("No talk Text!");
				break;
		}
	}
	
	public static void UserInput(Scanner scnr, ActivityLog questLog) {
		String userString;
		
 		if (gState == GameState.Menu) { // Goes to the main menu if userInput is called during the Menu State.
 			MainMenu(scnr);
 		}
		else if (gState == GameState.Game) { // Allows user to choose options for the game.
			
			System.out.println("What would you like to do?");
			System.out.println();
			userString = scnr.nextLine();
			
			if (userString.contains("Go") || userString.contains("go")) {
				//questLog.addPlayTime(.2);
				ChangeLocation(scnr);
				EntryLocation();
			}
			else if (userString.contains("Exit") || userString.contains("exit")) {
				//questLog.addPlayTime(0.1);
				System.out.println("You leave your current area and head back to the Campus.");
				currLoc = Location.Campus;
			}
			else if (userString.contains("Look") || userString.contains("look")) {
				//questLog.addPlayTime(0.05);
				LookLocation();
			}
			else if (userString.contains("Talk") || userString.contains("talk")) {
				//questLog.addPlayTime(0.1);
				TalkLocation(scnr, questLog);
			}
			else if (userString.contains("Time") || userString.contains("time")) {
				System.out.printf("The current time is around %.0f:00\n", questLog.getPlayTime());
			}
			else if (userString.contains("Wait") || userString.contains("wait")) {
				questLog.addPlayTime(1.0);
				
				System.out.println("You wait for an hour.");
				System.out.printf("It is currently around %.0f:00\n", questLog.getPlayTime());
			}
			else if (userString.contains("Help") || userString.contains("help")) {
				HelpMenu();
			}
			else if (userString.contains("Quit") || userString.contains("quit")) { // Changes state and goes back to the main menu
				gState = GameState.Lose;
			}
			else {
				System.out.println("Invalid choice, Please try again.");
			}
			
			if (questLog.isTimeDone()) { //Is needed in case the game is going to be replayed.
				questLog.Reset();
				gState = GameState.Lose;
			}
		}
		else if (gState == GameState.Win) {
			//TODO
		}
		else if (gState == GameState.Lose) { //Happens when you run out of time or is otherwise called
			System.out.println("You decide that's enough of the college life for today and head home.\n");
			gState = GameState.Menu;
		}
	}
	
	public static void StartGame(Scanner scnr) {
		gState = GameState.Game;
		currLoc = Location.ParkingLot;
		System.out.println("Game Start Text");
		EntryLocation();
	}
	
	public static void main(String[] args) {
		ActivityLog questLog = new ActivityLog();
		Scanner scnr = new Scanner(System.in);
		
		
		while (true) {
			UserInput(scnr, questLog);
		}
	}

}
