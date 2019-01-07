import domain.GameController;
import ui.MonopolyFrame;

public class Test {

	public static void main(String[] args) {
		GameController.getInstance();
		new MonopolyFrame();
	}

}
