import domain.GameController;
import domain.communication.network.CommunicationFacade;
import domain.util.GameStateJSONConverter;
import ui.MonopolyFrame;
	
public class Test {

	public static void main(String[] args) {
		
		GameController controller = GameController.getInstance();
		//CommunicationFacade facade = new CommunicationFacade();
		MonopolyFrame frame = new MonopolyFrame(controller);

		
		GameStateJSONConverter jsonConverter = GameStateJSONConverter.getInstance();
		jsonConverter.writeGameStateToJsonFile(controller.toGameState(), "deneme");
		
		System.out.println(jsonConverter.readGameStateFromJson("deneme"));
		System.out.println("Hello");
	}

}
