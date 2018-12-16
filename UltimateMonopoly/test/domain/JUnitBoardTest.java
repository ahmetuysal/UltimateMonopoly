package domain;

import domain.Player;
import domain.square.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
	void testMoveToNextChanceOrCommunityChestSquare() {
		Player player1 = new Player("p1");
		player1.setToken(new Token(new Location(0, 0), "Barrow.png"));
		Board testBoard = new Board();
		Location oldLoc = testBoard.getSquareLocationFromName("Go");
		player1.getToken().setLocation(oldLoc);
		testBoard.moveToNextChanceOrCommunityChestSquare(player1);
		Location newLoc = player1.getToken().getLocation();
		Location checkLoc= new Location(1,2);
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
	
	@Test
	void repOKTestaddTokens() {
		Board b = new Board();	
		b.addToken(new Token(new Location(0, 0), "Barrow.png"));
		assertTrue(b.repOK());
	}

	@Test
	void repOKTestMoveToNextChanceOrCommunityChestSquare() {
		Player player1 = new Player("p1");
		player1.setToken(new Token(new Location(0, 0), "Barrow.png"));
		Board testBoard = new Board();
		Location oldLoc = testBoard.getSquareLocationFromName("Go");
		player1.getToken().setLocation(oldLoc);
		testBoard.moveToNextChanceOrCommunityChestSquare(player1);
		assertTrue(testBoard.repOK());
	}
	
	@Test
	void repOKMoveToNextUnownedProperty() {
		Player player1 = new Player("p1");
		player1.setToken(new Token(new Location(0, 0), "Barrow.png"));
		Board testBoard = new Board();
		Location oldLoc = testBoard.getSquareLocationFromName("Go");
		player1.getToken().setLocation(oldLoc);
		testBoard.moveToNextUnownedProperty(player1);
		assertTrue(testBoard.repOK());
	}
	
}
