import domain.GameController;
import domain.util.GameStateJSONConverter;
import ui.MonopolyFrame;

public class Test {

	public static void main(String[] args) {
		new MonopolyFrame();
		GameStateJSONConverter converter = GameStateJSONConverter.getInstance();
		converter.writeGameStateToJSONFile(GameController.getInstance().toGameState(), "deneme");
	}

}
