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

	
	@Test
	void testBuyHouse() {
		Player owner = new Player("Merve");
		
		TitleDeedSquare boardWalk = new TitleDeedSquare("Boardwalk", "dsc", 400, 50, 200, 600, 1400, 1700, 2000, 3000,
				TitleDeedSquareColor.DARK_BLUE);
		boardWalk.buyProperty(owner);
		assertTrue(boardWalk.repOK());
		TitleDeedSquare unowned = new TitleDeedSquare("Unowned", "dsc", 300, 60, 300, 600, 3000, 3300, 3600, 7000, TitleDeedSquareColor.DARK_BLUE);
		//tries to build house on a square that is not owned
		assertFalse(unowned.buyHouse());
		assertTrue(boardWalk.repOK());
		// owner does not have majority ownership (has 1 out of 3)
		assertFalse(boardWalk.buyHouse());
		assertTrue(boardWalk.repOK());
		(new TitleDeedSquare("MadeUpSquare", "dsc", 400, 0, 0, 0, 0, 0, 0, 0, TitleDeedSquareColor.DARK_BLUE)).buyProperty(owner);
		
		//owner tries to buy house when she does not have enough money
		int oldMoney = owner.getTotalMoney();
		owner.setTotalMoney(30);
		assertFalse(boardWalk.buyHouse());
		assertTrue(boardWalk.repOK());

		owner.setTotalMoney(oldMoney);		
		
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
		assertTrue(boardWalk.repOK());
	}
	
	
	@Test
	void testBuyHotel() {
		Player owner = new Player("Merve");
		TitleDeedSquare pacificAvenue = new TitleDeedSquare("Pacific Avenue", "dsc", 300, 26, 130, 390, 900, 1100, 1275, 2275,
				TitleDeedSquareColor.GREEN);
		pacificAvenue.buyProperty(owner);
		assertTrue(pacificAvenue.repOK());

		TitleDeedSquare unowned = new TitleDeedSquare("Unowned", "dsc", 300, 60, 300, 600, 3000, 3300, 3600, 7000, TitleDeedSquareColor.GREEN);
		
		//tries to build hotel on unowned property
		assertFalse(unowned.buyHotel());
				
		// owner does not have majority ownership (has 1 out of 3)
		pacificAvenue.setNumHouses(4);
		assertFalse(pacificAvenue.buyHotel());
		assertTrue(pacificAvenue.repOK());
		
		(new TitleDeedSquare("MadeUpSquare", "dsc", 400, 0, 0, 0, 0, 0, 0, 0, TitleDeedSquareColor.GREEN)).buyProperty(owner);
		// owner has majority ownership (has 2 out of 3)
		// property has 0 houses
		
		pacificAvenue.setNumHouses(0);
		assertFalse(pacificAvenue.buyHotel());
		assertTrue(pacificAvenue.repOK());

		
		pacificAvenue.setNumHouses(4);
		assertTrue(pacificAvenue.repOK());

		int playerMoneyBefore = owner.getTotalMoney();
		
		//owner does not have enough money to buy hotel
		owner.setTotalMoney(20);
		assertFalse(pacificAvenue.buyHotel());
		assertTrue(pacificAvenue.repOK());

		owner.setTotalMoney(playerMoneyBefore);
		
		assertTrue(pacificAvenue.buyHotel());
		assertFalse(pacificAvenue.buyHotel());
		assertTrue(pacificAvenue.repOK());
		
		int playerMoneyAfter = owner.getTotalMoney();
		assertEquals(playerMoneyBefore, playerMoneyAfter +  pacificAvenue.getColor().hotelPriceProperty());
		assertEquals(pacificAvenue.getNumHotels(), 1);
		assertTrue(pacificAvenue.repOK());
	}
	
	@Test
	void testLandOn() {
		Player owner = new Player("Rich Merve");
		Player rentPayer = new Player("Poor Guy");
		
		TitleDeedSquare pacificAvenue = new TitleDeedSquare("Pacific Avenue", "dsc", 300, 26, 130, 390, 900, 1100, 1275, 2275,
				TitleDeedSquareColor.GREEN);
		pacificAvenue.buyProperty(owner);
		assertTrue(pacificAvenue.repOK());

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
		assertTrue(pacificAvenue.repOK());
		
		pacificAvenue.setNumSkyscrapers(1);
		assertTrue(pacificAvenue.repOK());

		// update players' money
		rentPayerInitialMoney = rentPayer.getTotalMoney();
		ownerInitialMoney = owner.getTotalMoney();
		
		pacificAvenue.landOn(rentPayer);
		assertEquals(2275, owner.getTotalMoney() - ownerInitialMoney);
		assertEquals(-2275, rentPayer.getTotalMoney() - rentPayerInitialMoney);
		assertTrue(pacificAvenue.repOK());

	}

}
