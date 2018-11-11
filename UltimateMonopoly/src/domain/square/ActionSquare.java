package domain.square;
import domain.Player;

public abstract class ActionSquare extends Square{

	public ActionSquare(String name, String description) {
		super(name, description);
	}

	public abstract void landOn(Player player);

	
}
 	