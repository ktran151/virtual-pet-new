package virtual_pet;

public class VirtualPet {
	String name = "fido";
	boolean isAlive = true;

	static final int poopVariable = 60;
	static final int playVariable = 35;
	static final int restVariable = 100;
	static final int eatVariable = 40;

	int tickVariable = 0;
	int hunger = 20;
	int play = -50;
	int poop = 60;
	int sleep = 60;

	public void nameYourPet(String acceptName) {
		name = acceptName;
	}

	public void tick() {
		timePass();
		deadFromHunger(name, hunger);
		hungryWarning(name, hunger);
		boredWarning(name, play);

	}

	public void timePass() {
		tickVariable++;
		hunger -= 10;
		sleep -= 10;
		play -= 10;
		poop -= 10;
	}

	public void feedYourPet() {
		hunger += eatVariable;
		tick();
	}

	public void restYourPet() {
		sleep += restVariable;
		tick();
		tick();
		tick();
	}

	public void playWithPet() {
		play += playVariable;
		tick();
	}

	public void takePetOut() {
		poop += poopVariable;
		tick();
	}

	public void deadFromHunger(String name, int hunger) {
		if (hunger <= -40) {
			System.out.println(name + " has died");
			isAlive = false;
		}
	}

	public void hungryWarning(String name, int hunger) {
		if (hunger <= 0) {
			System.out.println("!! " + name + " is hungry");
		}

	}

	public void boredWarning(String name, int boredom) {
		if (boredom <= 0) {
			System.out.println("!! " + name + " is bored");
		}
	}

}
