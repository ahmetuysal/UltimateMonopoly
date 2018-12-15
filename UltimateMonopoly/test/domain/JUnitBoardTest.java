package domain;

import domain.Player;
import domain.square.*;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class JUnitBoardTest {
	/**
	 * @author umaybozkurt
	 *
	 */
	
	@BeforeEach
	void refreshAvailableTokens() {
		Token.initializeAvailableTokens();
	}
	/////////////////////////black-box testing//////////////////////////////
	
	@Test
	void testMoveToNextUnownedProperty() {
		Player player1 = new Player("p1");
		player1.setToken(new Token(new Location(0, 0), "Barrow.png"));
		Board testBoard = new Board();
		Location oldLoc = testBoard.getSquareLocationFromName("Go");
		player1.getToken().setLocation(oldLoc);
		testBoard.moveToNextUnownedProperty(player1);
		Location newLoc = player1.getToken().getLocation();
		assertEquals(newLoc, testBoard.getSquareLocationFromName("Meditteranian Avenue"));
	}
	@Test
	void testMoveToNextOwnedProperty() {
		Player player1 = new Player("p1");
		player1.setToken(new Token(new Location(0, 0), "Barrow.png"));
		Board testBoard = new Board();
		Location oldLoc = testBoard.getSquareLocationFromName("Go");
		player1.getToken().setLocation(oldLoc);
		Player owner = new Player("Umay");
		TitleDeedSquare boardWalk = new TitleDeedSquare("Boardwalk", "dsc", 400, 50, 200, 600, 1400, 1700, 2000, 3000,
				TitleDeedSquareColor.DARK_BLUE);
		
		boardWalk.buyProperty(owner);
		testBoard.moveToNextOwnedProperty(player1);
		Location newLoc = player1.getToken().getLocation();
		assertEquals(newLoc, testBoard.getSquareLocationFromName("Boardwalk"));
		
	}
	@Test
	void testMoveToNextChanceOrCommunityChestSquare() {
		Player player1 = new Player("p1");
		player1.setToken(new Token(new Location(0, 0), "Barrow.png"));
		Board testBoard = new Board();
		Location oldLoc = testBoard.getSquareLocationFromName("Go");
		player1.getToken().setLocation(oldLoc);
		testBoard.moveToNextUnownedProperty(player1);
		Location newLoc = player1.getToken().getLocation();
		Location checkLoc= new Location(1,1);
		assertEquals(newLoc,checkLoc);
	}
	
	@Test
	void testgetSquareLocationFromValidName() {
	 Board b = new Board();	
	 Location goLoc= new Location(1,0);
	 assertEquals(goLoc, b.getSquareLocationFromName("Go"));
	}
	
	@Test
	void testgetSquareLocationFromInvalidName() {
	 Board b = new Board();	
	assertEquals(null, b.getSquareLocationFromName("Umay square"));
	}
	
	//////////////////end of Black-box///////////////////////////////////////
}
