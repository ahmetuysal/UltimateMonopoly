import domain.GameController;
import ui.MonopolyFrame;

public class Test {

	public static void main(String[] args) {

		GameController controller = GameController.getInstance();
		new MonopolyFrame(controller);
	}

}
