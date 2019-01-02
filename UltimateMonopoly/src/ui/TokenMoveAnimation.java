package ui;

import domain.square.Location;

public class TokenMoveAnimation {

	private static final double ANIMATION_STEP_RATE = 0.1;
	
	private Location startingLocation;
	private Location endingLocation;
	private double completedRate;
	
	public TokenMoveAnimation(Location startingLocation, Location endingLocation) {
		this.startingLocation = startingLocation;
		this.endingLocation = endingLocation;
		this.completedRate = 0;
	}

	public double increaseCompletedRate() {
		this.completedRate += ANIMATION_STEP_RATE;
		if (this.completedRate > 1)
			this.completedRate = 1;
		return this.completedRate;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TokenMoveAnimation [startingLocation=" + startingLocation + ", endingLocation=" + endingLocation + "]";
	}



	/**
	 * @return the startingLocation
	 */
	public Location getStartingLocation() {
		return startingLocation;
	}

	/**
	 * @param startingLocation the startingLocation to set
	 */
	public void setStartingLocation(Location startingLocation) {
		this.startingLocation = startingLocation;
	}

	/**
	 * @return the endingLocation
	 */
	public Location getEndingLocation() {
		return endingLocation;
	}

	/**
	 * @param endingLocation the endingLocation to set
	 */
	public void setEndingLocation(Location endingLocation) {
		this.endingLocation = endingLocation;
	}
 
	

}
