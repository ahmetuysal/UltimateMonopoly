package domain.square;

public class Location {
	
	private int layer;
	private int index;
	
	public Location(int layer, int index) {
		this.layer = layer;
		this.index = index;
	}
	
	
	/**
	 * @return the layer
	 */
	public int getLayer() {
		return layer;
	}
	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}
	

}
