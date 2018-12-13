package domain;

import domain.Player;
import domain.square.*;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class JUnitBoardTest {
	/**
	 * @author umaybozkurt
	 *
	 */
	
	@BeforeEach
	void refreshAvailableTokens() {
		Token.initializeAvailableTokens();
	}
	
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
	

	// void testgetSquareLocationFromName(String name) {
	// Board b = new Board();
	// Square s1 = new Go();
	//

	// assertEquals(s1, b.getSquareLocationFromName("Go"));

	// }

}
