package ui.animation;

import ui.UIDie;

public class DieRotateAnimation implements Animation {

	private double ANIMATION_STEP_RATE = 0.04;

	private UIDie dieToAnimate;
	private double completedRate;
	
	public DieRotateAnimation(UIDie die) {
		dieToAnimate = die;
	}

	private void increaseCompletedRate() {
		this.completedRate += ANIMATION_STEP_RATE;
		if (this.completedRate > 1)
			this.completedRate = 1;
	}

	@Override
	public void animate() {
		increaseCompletedRate();
		dieToAnimate.setAngle(completedRate * 360);
	}

	@Override
	public boolean isFinished() {
		return this.completedRate >= 1;
	}

}
