package domain.square;

public abstract class Square {
	private String name;
	private String description;
	private String type;
	
	public Square(String name, String description, String type){
		this.name = name;
		this.description = description;
		this.type = type;
	}

	/**
	 * @return the name of the Square
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return the description about what squares do
	 */
	public String getDescription() {
		return description;
	}

	public String getType() {
		return type;
	}
	
	
}
