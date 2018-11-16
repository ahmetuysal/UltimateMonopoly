import domain.GameController;
import domain.Player;
import domain.Token;
import domain.card.*;
import domain.square.Location;
import ui.MockConsoleUI;
import ui.MonopolyFrame;
	
public class Test {

	public static void main(String[] args) {
		GameController controller = GameController.getInstance();
		controller.addPlayer(new Player("Ahmet"));
		controller.addPlayer(new Player("Merve"));
		MockConsoleUI ui = new MockConsoleUI();
		controller.addPropertyListener(ui);
		Card card = CardFactory.getCard("Chance Card", "Advance to Saint Charles Place", "Hello world");
		
		MonopolyFrame frame = new MonopolyFrame(controller);
		
		
		
		System.out.println(Token.getAvailableTokens());
		
		/*while (true) {
			controller.playTurn();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
	}

}
