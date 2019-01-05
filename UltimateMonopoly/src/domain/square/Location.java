package domain.square;

import java.io.Serializable;

public class Location implements Serializable{
	
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




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (index != other.index)
			return false;
		if (layer != other.layer)
			return false;
		return true;
	}
	
}
