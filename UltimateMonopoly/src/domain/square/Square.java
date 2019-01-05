package domain.square;

import java.util.HashSet;

import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import domain.GameController;
import domain.Player;
import domain.util.GsonUtils;

public class Square {

	protected String name;
	protected String description;
	protected String type = getClass().getName(); 


	private static final RuntimeTypeAdapterFactory<Square> adapter = RuntimeTypeAdapterFactory
			.of(Square.class);

	private static final HashSet<Class<?>> registeredClasses = new HashSet<Class<?>>();

	static {
		GsonUtils.registerType(adapter);
	}

	private synchronized void registerClass() {
		if (!registeredClasses.contains(this.getClass())) {
			registeredClasses.add(this.getClass());
			adapter.registerSubtype(this.getClass());
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Square(String name, String description) {
		registerClass();
		this.name = name;
		this.description = description;
	}

	/**
	 * 
	 * @param player
	 *            Player who lands on this square.
	 */
	public void landOn(Player player) {
		GameController.getInstance().setCurrentLocationBuyable(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Square [name=" + name + ", description=" + description + "]";
	}

}
