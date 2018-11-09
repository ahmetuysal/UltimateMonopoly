import domain.GameController;
import domain.Player;
import domain.card.*;
import ui.MockConsoleUI;

public class Test {

	public static void main(String[] args) {
		GameController controller = new GameController();
		controller.addPlayer(new Player("Ahmet", 0));
		controller.addPlayer(new Player("Merve", 0));
		MockConsoleUI ui = new MockConsoleUI();
		controller.addPropertyListener(ui);
		Card card = ChanceCard.getCard("AdvanceToSaintCharlesPlace", "Hello world");

		while (true) {
			controller.playTurn();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
