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
	
	public void setLayer(int layer) {
		this.layer = layer;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public boolean isLocationsEquals(Location loc1, Location loc2) {
		if(loc1.getIndex() == loc2.getIndex() && loc1.getLayer() == loc2.getLayer()) return true;
		return false;
	}

}
