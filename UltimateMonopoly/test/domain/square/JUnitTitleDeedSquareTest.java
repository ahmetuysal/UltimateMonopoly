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
		
	}
	
	@Test
	void testLandOn() {
		
	}
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////

	
	
	
	
	////////////////////////////////////// Glass-Box Tests //////////////////////////////////////

	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////

}
