import domain.GameController;
import domain.communication.network.CommunicationFacade;
import ui.MonopolyFrame;
	
public class Test {

	public static void main(String[] args) {
		
		GameController controller = GameController.getInstance();
		//CommunicationFacade facade = new CommunicationFacade();
		MonopolyFrame frame = new MonopolyFrame(controller);

	}

}
