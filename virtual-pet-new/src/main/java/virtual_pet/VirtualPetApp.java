package virtual_pet;

import java.util.Scanner;

public class VirtualPetApp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Congratulations on your new Virtual BudBoi!");
		System.out.println("What would you like to name it?");

		VirtualPet thisPetInstance = new VirtualPet();

		String petGivenName = input.nextLine();
		thisPetInstance.nameYourPet(petGivenName);
		System.out.println(thisPetInstance.name + " loves you already!");
		displayStats(thisPetInstance);

		input.close();
	}

	public static void displayStats(VirtualPet petWithStats) {
		System.out.println("Hunger: " + petWithStats.hunger);
		System.out.println("Sleep: " + petWithStats.sleep);
		System.out.println("Play: " + petWithStats.play);
		System.out.println("Poop: " + petWithStats.poop);

	}

}
