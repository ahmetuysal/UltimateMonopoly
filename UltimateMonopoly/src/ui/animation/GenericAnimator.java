package ui.animation;

import java.awt.Container;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import domain.GameController;

public class GenericAnimator implements Runnable {

	private List<Animatable> elementsToAnimate;
	private long sleepTime = 50;
	private boolean animatorStopped = false;
	private Container animationPanel;

	private static GenericAnimator instance;

	public static synchronized GenericAnimator getInstance(Container animationPanel) {
		if (instance == null) {
			instance = new GenericAnimator(animationPanel);
		}
		return instance;
	}

	private GenericAnimator(Container animationPanel) {
		this.animationPanel = animationPanel;
		elementsToAnimate = new ArrayList<>();
	}

	@Override
	public void run() {
		while (true) {
			try {
				synchronized (this) {
					if (animatorStopped == true) {
						wait();
					}
				}
				if (animatorStopped != true)
					Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				System.out.println("Program Interrupted");
				System.exit(0);
			}
			for (Animatable animatable : elementsToAnimate) {
				LinkedList<Animation> waitingAnimations = animatable.getWaitingAnimations();
				if (!waitingAnimations.isEmpty()) {
					Animation currentAnim = waitingAnimations.getFirst();
					currentAnim.animate();
					if (currentAnim.isFinished()) {
						waitingAnimations.removeFirst();
					}
				}
			}
			animationPanel.repaint();
		}
	}

	public void addAnimatable(Animatable animatable) {
		elementsToAnimate.add(animatable);
	}

	public boolean removeAnimatable(Animatable animatable) {
		return elementsToAnimate.remove(animatable);
	}

}
