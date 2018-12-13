package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import domain.square.Location;
import domain.Token;
import domain.card.OwnableCard;
import domain.card.RollThreeCard;


public class JUnitPlayerTest {
	
	@BeforeEach
	void refreshGameController() {
		Token.initializeAvailableTokens();
		GameController.getInstance().setPlayers(new ArrayList<>());
	}

	///////////////////////////Black-Box Test/////////////////////////////////
	@Test
	void testGoToJail() {
		GameController.getInstance().registerUser("Eralp", "Boot.png");
		Player player = GameController.getInstance().getPlayerList().get(0);
		boolean inJail = player.isInJail();
		player.goToJail();
		assertNotEquals(inJail, player.isInJail());
	}
	
	
	//////////////////////////////////////////////////////////////////////////
	
	/////////////////////////Glass-Box Test///////////////////////////////////
	
	@ParameterizedTest
	@CsvSource({"100", "200", "300"})
	void testIncreaseMoney(int money) {
		Player player = new Player("Eralp");
		int startMoney = player.getTotalMoney();
		player.increaseMoney(money);
		assertEquals(startMoney + money, player.getTotalMoney());
	}
	
	@ParameterizedTest
	@CsvSource({"100", "200", "300"})
	void testDecreaseMoney(int money) {
		Player player = new Player("Eralp");
		int startMoney = player.getTotalMoney();
		player.decreaseMoney(money);
		assertEquals(startMoney - money, player.getTotalMoney());
	}
	
	@Test
	void testGoToJailGlassBox() {
		GameController.getInstance().registerUser("Eralp", "Boot.png");
		Player player = GameController.getInstance().getPlayerList().get(0);
		Location oldLoc = player.getToken().getLocation();
		int jailTime = player.getJailTime();
		boolean inJail = player.isInJail();
		player.goToJail();
		assertNotEquals(inJail, player.isInJail());
		assertNotEquals(oldLoc, player.getToken().getLocation());
		assertNotEquals(jailTime, player.getJailTime());
		
	}
	
	@Test
	void testAddCard() {
		Player player = new Player("Eralp");
		OwnableCard card = new RollThreeCard("","", 1, 2, 3);
		int oldNum = player.getCards().size();
		player.addCard(card);
		assertNotEquals(oldNum, player.getCards().size());
		
	}
	
	//////////////////////////////////////////////////////////////////////////
	
}
