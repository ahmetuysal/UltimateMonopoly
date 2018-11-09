package domain.square;
import domain.Player;

public abstract class ActionSquare extends Square {

	public ActionSquare(String name, String description, String type) {
		super(name, description, type);
	}

	public abstract void performAction(Player player);
}
 	