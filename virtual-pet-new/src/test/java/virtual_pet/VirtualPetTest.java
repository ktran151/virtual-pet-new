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
		underTest.nameYourPet("James");
		Assert.assertEquals("James", underTest.name);
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
		underTest.hunger = 60;
		underTest.feedYourPet();
		Assert.assertEquals(40, underTest.hunger);
	}

	@Test
	public void shouldRestYourPet() {
		VirtualPet underTest = new VirtualPet();
		underTest.sleep = 80;
		underTest.restYourPet();
		Assert.assertEquals(20, underTest.sleep);
	}

	public void checkTickAfterRest() {
		VirtualPet underTest = new VirtualPet(); // arrange
		int startingSleep = 80;
		underTest.sleep = startingSleep;
		underTest.restYourPet(); // act
		int numberOfTicksFromRest = 30;
		int sleepAfterRest = startingSleep - numberOfTicksFromRest - 90;
		Assert.assertEquals(sleepAfterRest, underTest.sleep); // assert
	}

}
