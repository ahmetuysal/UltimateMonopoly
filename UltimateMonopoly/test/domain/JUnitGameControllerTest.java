package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;

import domain.GameController;
import domain.Token;
import domain.gamestate.GameState;

/**
 * @author mervekarakas
 *
 */
class JUnitGameControllerTest {

	@BeforeEach
	void refreshGameController() {
		Token.initializeAvailableTokens();
		GameController.getInstance().setPlayers(new ArrayList<>());
	}

	// Black-Box Testing
	@ParameterizedTest
	@CsvSource({ "Asma, Battleship.png", "Attila, Boot.png", "Cemil, Dog.png" })
	void testRegisterUserWithValidInputs(String nickName, String tokenName) {
		assertTrue(GameController.getInstance().registerUser(nickName, tokenName));
	}

	@Test
	void testRegisterUserWithRepeatedInputs() {
		assertTrue(GameController.getInstance().registerUser("Ahmet", "Boot.png"));
		assertFalse(GameController.getInstance().registerUser("Merve", "Boot.png"));
		assertFalse(GameController.getInstance().registerUser("Ahmet", "Dog.png"));
		assertFalse(GameController.getInstance().registerUser("Ahmet", "Boot.png"));
	}

	@ParameterizedTest
	@CsvSource({"Attila, Boot", "Ahmet, ahmos.png" })
	void testRegisterUserWithInvalidInputs(String nickName, String tokenName) {
		assertFalse(GameController.getInstance().registerUser(nickName, tokenName));
	}
	// End of Black-Box Testing

	// Glass-Box Testing
	@Test
	void testEmptyUserValidTokenInput() {
		assertFalse(GameController.getInstance().registerUser("", "Boot.png"));
	}
	
	@Test
	void testTokenListChange() {
		int oldSize = Token.getAvailableTokens().size();
		GameController.getInstance().registerUser("Ahmet", "Boot.png");
		int newSize = Token.getAvailableTokens().size();

		assertEquals(oldSize - 1, newSize);
		assertFalse(Token.getAvailableTokens().contains("Boot.png"));
	}

	@Test
	void testPlayersListChange() {
		int oldSize = GameController.getInstance().getPlayerList().size();
		GameController.getInstance().registerUser("Ahmet", "Boot.png");
		int newSize = GameController.getInstance().getPlayerList().size();

		assertEquals(oldSize + 1, newSize);
		assertEquals(GameController.getInstance().getPlayerList().get(newSize - 1).getNickName(), "Ahmet");
	}
	// End of Glass-Box Testing

	@Test
	void testToGameState() {
		GameController.getInstance().registerUser("Meltem", "Top Hat.png");
		GameController.getInstance().registerUser("Umay", "Thimble.png");

		GameState state = GameController.getInstance().toGameState();

		assertTrue(state.repOK());
	}

	@Test
	void testLoadGame() {
		GameController.getInstance().loadGame("JUnitTestInitWithGS");
		assertEquals(GameController.getInstance().getPlayers().size(), 3);
		assertEquals(GameController.getInstance().getPlayers().get(0).getNickName(), "eralp");
		assertEquals(GameController.getInstance().getPlayers().get(1).getNickName(), "umay");
		assertEquals(GameController.getInstance().getPlayers().get(2).getNickName(), "meltem");
		assertEquals(GameController.getInstance().getPlayers().get(0).getToken().getTokenImageName(), "Dog.png");
		assertNotEquals(GameController.getInstance().getPlayers().get(1).getTotalMoney(), 3200);
	}

}
