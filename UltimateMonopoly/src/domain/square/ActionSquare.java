package domain.square;
import domain.Player;

public abstract class ActionSquare extends SquareFactory {

	public ActionSquare(String name, String description) {
		super(name, description);
	}

	public abstract void landOn(Player player);

	
}
 	