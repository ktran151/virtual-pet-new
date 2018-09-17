package virtual_pet;

import org.junit.Assert;
import org.junit.Test;

public class VirtualPetTest {

	@Test
	public void giveFidoAsName() {
		VirtualPet underTest = new VirtualPet();
		String expectedFido = "fido";
		Assert.assertEquals(expectedFido, underTest.name);
	}

	@Test
	public void acceptsNewName() {
		VirtualPet underTest = new VirtualPet();
		underTest.nameYourPet("James Baxter");
		Assert.assertEquals("James Baxter", underTest.name);
	}

	@Test
	public void checkTickFromZero() {
		VirtualPet underTest = new VirtualPet();
		underTest.tick();
		Assert.assertEquals(1, underTest.tickVariable);
	}

	@Test
	public void shouldFeedYourPet() {
		VirtualPet underTest = new VirtualPet();
		int startingHunger = 40;
		underTest.hunger = startingHunger;
		int pointsFromTicks = 10;
		underTest.feedYourPet();
		Assert.assertEquals(startingHunger + VirtualPet.eatVariable - pointsFromTicks, underTest.hunger);
	}

	@Test
	public void shouldRest() {
		VirtualPet underTest = new VirtualPet(); // arrange
		int startingSleep = 10;
		underTest.sleep = startingSleep;
		underTest.restYourPet(); // act
		int pointsFromTicks = 30;
		int sleepAfterRest = startingSleep - pointsFromTicks + VirtualPet.restVariable;
		Assert.assertEquals(sleepAfterRest, underTest.sleep); // assert
	}

	@Test
	public void checkTickAfterRest() {
		VirtualPet underTest = new VirtualPet(); // arrange
		underTest.restYourPet();
		Assert.assertEquals(3, underTest.tickVariable);

	}

	@Test
	public void shouldPlay() {
		VirtualPet underTest = new VirtualPet(); // arrange
		int startingPlay = 0;
		underTest.play = startingPlay;
		int pointsFromTicks = 10;
		underTest.playWithPet();
		Assert.assertEquals(startingPlay + VirtualPet.playVariable - pointsFromTicks, underTest.play);
	}

	@Test
	public void shouldPoop() {
		VirtualPet underTest = new VirtualPet();
		int startingPoop = 10;
		underTest.poop = startingPoop;
		int pointsFromTicks = 10;
		underTest.takePetOut();
		Assert.assertEquals(startingPoop + VirtualPet.poopVariable - pointsFromTicks, underTest.poop);
	}

	@Test
	public void shouldChooseHunger() {
		VirtualPet underTest = new VirtualPet();
		underTest.hunger = 0;
		VirtualPetApp.playerChoose(underTest, 1);
		Assert.assertEquals(30, underTest.hunger);
	}

	@Test
	public void deadAtNegFourty() {
		VirtualPet underTest = new VirtualPet();
		underTest.hunger = -40;
		underTest.deadFromHunger(underTest.name, underTest.hunger);
		Assert.assertEquals(false, underTest.isAlive);
	}

//	@Test
//	public void shouldWarnIfHungry() {
//		VirtualPet underTest = new VirtualPet();
//		underTest.hunger = 10;
//		underTest.hungryWarning(underTest.name, underTest.hunger);
//		Assert.assertEquals(underTest.name + " is hungry", );
//	}
}
