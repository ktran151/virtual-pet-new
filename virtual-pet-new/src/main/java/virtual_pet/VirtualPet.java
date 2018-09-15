package virtual_pet;

public class VirtualPet {

	String name = "fido";
	int tickVariable = 0;
	int hunger = 40;
	int sleep = 0;
	int play = 60;
	int poop = 0;

	public void nameYourPet(String acceptName) {
		name = acceptName;
	}

	public void tick() {
		tickVariable++;
		hunger += 10;
		sleep += 10;
		play += 10;
		poop += 10;
	}

	public void feedYourPet() {
		hunger -= 30;
		tick();
	}

	public void restYourPet() {
		sleep -= 90;
		tick();
		tick();
		tick();
	}

}
