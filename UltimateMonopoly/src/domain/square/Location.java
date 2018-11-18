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
	
	public boolean isLocationsEquals(Location loc1, Location loc2) {
		return loc1.getIndex() == loc2.getIndex() && loc1.getLayer() == loc2.getLayer();
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Location [layer=" + layer + ", index=" + index + "]";
	}
}
