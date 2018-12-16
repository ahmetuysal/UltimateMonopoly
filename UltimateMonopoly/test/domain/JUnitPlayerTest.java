package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Token;
import domain.card.OwnableCard;
import domain.card.RollThreeCard;

/**
 * @author halileralpkocas
 *
 */

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
		player.goToJail();
		assertEquals(player.isInJail(), true);
	}
	
	
	//////////////////////////////////////////////////////////////////////////
	
	/////////////////////////Glass-Box Test///////////////////////////////////
	
	@Test
	void testIncreaseMoney() {
		int money = 100;
		Player player = new Player("Eralp");
		int startMoney = player.getTotalMoney();
		player.increaseMoney(money);
		assertEquals(startMoney + money, player.getTotalMoney());
		assertTrue(player.repOK());
	}
	
	@Test
	void testDecreaseMoney() {
		int money = 100;
		Player player = new Player("Eralp");
		int startMoney = player.getTotalMoney();

		boolean isDecreased = player.decreaseMoney(startMoney+1);
		assertEquals(isDecreased, false);
		
		player.decreaseMoney(money);
		assertEquals(startMoney - money, player.getTotalMoney());
		
		assertTrue(player.repOK());
	}
	
	@Test
	void testGoToJailGlassBox() {
		GameController.getInstance().registerUser("Eralp", "Boot.png");
		Player player = GameController.getInstance().getPlayerList().get(0);
		player.goToJail();
		assertEquals(player.isInJail(), true);
		assertEquals(player.getToken().getLocation(), GameController.getInstance().getBoard().getSquareLocationFromName("Jail"));
		assertEquals(player.getJailTime(), 3);
		
	}
	
	@Test
	void testAddCard() {
		Player player = new Player("Eralp");
		OwnableCard card = new RollThreeCard("","", 1, 2, 3);
		int oldNum = player.getCards().size();
		player.addCard(card);
		
		assertEquals(oldNum + 1, player.getCards().size());
		assertEquals(player.getCards().contains(card), true);
		
	}
	
	//////////////////////////////////////////////////////////////////////////
	
}
