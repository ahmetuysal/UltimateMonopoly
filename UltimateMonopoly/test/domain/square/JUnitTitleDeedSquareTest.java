/**
 * 
 */
package domain.square;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.Player;

/**
 * @author ahmetuysal
 *
 */
public class JUnitTitleDeedSquareTest {

	
	////////////////////////////////////// Black-Box Tests //////////////////////////////////////

	@Test
	void testBuyHouse() {
		Player owner = new Player("Merve");
		TitleDeedSquare boardWalk = new TitleDeedSquare("Boardwalk", "dsc", 400, 50, 200, 600, 1400, 1700, 2000, 3000,
				TitleDeedSquareColor.DARK_BLUE);
		boardWalk.buyProperty(owner);
		// owner does not have majority ownership (has 1 out of 3)
		assertFalse(boardWalk.buyHouse());
		(new TitleDeedSquare("MadeUpSquare", "dsc", 400, 0, 0, 0, 0, 0, 0, 0, TitleDeedSquareColor.DARK_BLUE)).buyProperty(owner);
		// owner not has majority ownership (has 2 out of 3)
		int playerMoneyBefore = owner.getTotalMoney();
		assertTrue(boardWalk.buyHouse());
		assertTrue(boardWalk.buyHouse());
		assertTrue(boardWalk.buyHouse());
		assertTrue(boardWalk.buyHouse());
		assertFalse(boardWalk.buyHouse());
		assertFalse(boardWalk.buyHouse());
		assertFalse(boardWalk.buyHouse());
		assertFalse(boardWalk.buyHouse());
		int playerMoneyAfter = owner.getTotalMoney();
		assertEquals(playerMoneyBefore, playerMoneyAfter + 4 *boardWalk.getColor().housePriceProperty());
		assertEquals(boardWalk.getNumHouses(), 4);
	}
	
	
	@Test
	void testBuyHotel() {
		Player owner = new Player("Merve");
		TitleDeedSquare pacificAvenue = new TitleDeedSquare("Pacific Avenue", "dsc", 300, 26, 130, 390, 900, 1100, 1275, 2275,
				TitleDeedSquareColor.GREEN);
		pacificAvenue.buyProperty(owner);
		// owner does not have majority ownership (has 1 out of 3)
		assertFalse(pacificAvenue.buyHotel());
		(new TitleDeedSquare("MadeUpSquare", "dsc", 400, 0, 0, 0, 0, 0, 0, 0, TitleDeedSquareColor.GREEN)).buyProperty(owner);
		// owner not has majority ownership (has 2 out of 3)
		// property has 0 houses
		assertFalse(pacificAvenue.buyHotel());
		
		pacificAvenue.setNumHouses(4);
		int playerMoneyBefore = owner.getTotalMoney();
		assertTrue(pacificAvenue.buyHotel());
		assertFalse(pacificAvenue.buyHotel());
		assertFalse(pacificAvenue.buyHotel());
		assertFalse(pacificAvenue.buyHotel());
		assertFalse(pacificAvenue.buyHotel());
		int playerMoneyAfter = owner.getTotalMoney();
		assertEquals(playerMoneyBefore, playerMoneyAfter +  pacificAvenue.getColor().hotelPriceProperty());
		assertEquals(pacificAvenue.getNumHotels(), 1);
	}
	
	@Test
	void testLandOn() {
		Player owner = new Player("Rich Merve");
		Player rentPayer = new Player("Poor Guy");
		
		TitleDeedSquare pacificAvenue = new TitleDeedSquare("Pacific Avenue", "dsc", 300, 26, 130, 390, 900, 1100, 1275, 2275,
				TitleDeedSquareColor.GREEN);
		pacificAvenue.buyProperty(owner);
		
		int rentPayerInitialMoney = rentPayer.getTotalMoney();
		int ownerInitialMoney = owner.getTotalMoney();
		// owner lands on its own property
		pacificAvenue.landOn(owner);
		assertEquals(ownerInitialMoney, owner.getTotalMoney());

		// property does not have any buildings and only 1 property from color is owned by Rich Merve
		pacificAvenue.landOn(rentPayer);
		assertEquals(26, owner.getTotalMoney() - ownerInitialMoney);
		assertEquals(-26, rentPayer.getTotalMoney() - rentPayerInitialMoney);
		
		// now owner has majority ownership
		(new TitleDeedSquare("MadeUpSquare", "dsc", 300, 0, 0, 0, 0, 0, 0, 0, TitleDeedSquareColor.GREEN)).buyProperty(owner);
		
		// update players' money
		rentPayerInitialMoney = rentPayer.getTotalMoney();
		ownerInitialMoney = owner.getTotalMoney();
		
		pacificAvenue.landOn(rentPayer);
		assertEquals(52, owner.getTotalMoney() - ownerInitialMoney);
		assertEquals(-52, rentPayer.getTotalMoney() - rentPayerInitialMoney);

		// now owner has monopoly
		(new TitleDeedSquare("MadeUpSquare2", "dsc", 300, 0, 0, 0, 0, 0, 0, 0, TitleDeedSquareColor.GREEN)).buyProperty(owner);
		
		// update players' money
		rentPayerInitialMoney = rentPayer.getTotalMoney();
		ownerInitialMoney = owner.getTotalMoney();
		
		pacificAvenue.landOn(rentPayer);
		assertEquals(78, owner.getTotalMoney() - ownerInitialMoney);
		assertEquals(-78, rentPayer.getTotalMoney() - rentPayerInitialMoney);
		
		pacificAvenue.setNumSkyscrapers(1);
		
		// update players' money
		rentPayerInitialMoney = rentPayer.getTotalMoney();
		ownerInitialMoney = owner.getTotalMoney();
		
		pacificAvenue.landOn(rentPayer);
		assertEquals(2275, owner.getTotalMoney() - ownerInitialMoney);
		assertEquals(-2275, rentPayer.getTotalMoney() - rentPayerInitialMoney);
	}
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////

	
	
	
	
	////////////////////////////////////// Glass-Box Tests //////////////////////////////////////

	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////

}
