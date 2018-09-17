package virtual_pet;

import java.util.Scanner;

public class VirtualPetApp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Congratulations on your new Heckin Smol Boi!");
		System.out.println("What would you like to name it?");

		VirtualPet thisPetInstance = new VirtualPet();

		String petGivenName = input.nextLine();
		thisPetInstance.nameYourPet(petGivenName);
		System.out.println(thisPetInstance.name + " loves you already!");
		do {
			displayStats(thisPetInstance);
			mainMenu();
			int playerChoice = input.nextInt();
			playerChoose(thisPetInstance, playerChoice);
			if (thisPetInstance.tickVariable == 40) {
				System.out.println("Wow! You've been with" + thisPetInstance.name + "for so long!");
			}
		} while (thisPetInstance.isAlive);
		input.close();
	}

	public static void displayStats(VirtualPet petWithStats) {
		System.out.println("Hunger: " + petWithStats.hunger);
		System.out.println("Play: " + petWithStats.play);
		System.out.println("Poop: " + petWithStats.poop);
		System.out.println("Sleep: " + petWithStats.sleep);
	}

	public static void mainMenu() {
		System.out.println("\n*****************************");
		System.out.println("What would you like to do?");
		String menuItems[] = { "Feed", "Play", "Potty", "Go to Bed" };
		for (int i = 0; i < menuItems.length; i++) {
			System.out.println((i + 1) + ". " + menuItems[i]);
		}
		System.out.println("*****************************");
	}

	public static void playerChoose(VirtualPet pet, int choice) {
		switch (choice) {
		case 1:
			System.out.println("You feed " + pet.name + "\nHunger +30\n");
			pet.feedYourPet();
			break;
		case 2:
			System.out.println("You play with " + pet.name + "\nPlay +25\n");
			pet.playWithPet();
			break;
		case 3:
			System.out.println(pet.name + " feels relieved\n");
			pet.takePetOut();
			break;
		case 4:
			System.out.println(pet.name + " feels well rested\n");
			pet.restYourPet();
			break;
		default:
			System.out.println("You do nothing\n");
			pet.tick();
		}
	}
}
