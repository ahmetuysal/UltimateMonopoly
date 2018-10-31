package domain.square;

public class Square {
	private String name;
	private String description;
	
	public Square(String name, String description){
		this.name = name;
		this.description = description;
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
	
}
