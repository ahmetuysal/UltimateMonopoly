package ui;

import domain.square.Location;

public class TokenMoveAnimation implements Animation {

	private double ANIMATION_STEP_RATE;

	private UIToken tokenToAnimate;
	private Location startingLocation;
	private Location endingLocation;
	private double completedRate;

	public TokenMoveAnimation(UIToken token, Location startingLocation, Location endingLocation) {
		this(token, startingLocation, endingLocation, 0.15);
	}
	
	public TokenMoveAnimation(UIToken token, Location startingLocation, Location endingLocation, double stepRate) {
		this.startingLocation = startingLocation;
		this.endingLocation = endingLocation;
		this.completedRate = 0;
		tokenToAnimate = token;
		ANIMATION_STEP_RATE = stepRate;
	}

	private void increaseCompletedRate() {
		this.completedRate += ANIMATION_STEP_RATE;
		if (this.completedRate > 1)
			this.completedRate = 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TokenMoveAnimation [Token=" + tokenToAnimate + ", startingLocation=" + startingLocation
				+ ", endingLocation=" + endingLocation + ", completedRate=" + completedRate + "]";
	}

	@Override
	public void animate() {
		increaseCompletedRate();
		tokenToAnimate.changeLocation(startingLocation, endingLocation, completedRate);
	}

	@Override
	public boolean isFinished() {
		return this.completedRate >= 1;
	}

}
