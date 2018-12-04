package ui;



import javax.swing.JButton;

import domain.util.PropertyEvent;
import domain.util.PropertyListener;

public class ObserverButton extends JButton implements PropertyListener {

	private boolean activeOnTurn;
	public ObserverButton(String text, boolean activeOnTurn) {
		super(text);
		this.activeOnTurn = activeOnTurn;
	}

	@Override
	public void onPropertyEvent(PropertyEvent e) {
		if (e.getPropertyName().equals("isTurnFinished")) {
			if (activeOnTurn) {
				this.setEnabled(!(boolean) e.getNewValue());
			} else {
				this.setEnabled((boolean) e.getNewValue());
			}
		}
		else if (e.getPropertyName().equals("currentLocationBuyable")) {
			this.setEnabled((boolean) e.getNewValue());
		}
		else if (e.getPropertyName().equals("isPaused")) {
			this.setEnabled(!(boolean) e.getNewValue());
		}
		else if(e.getPropertyName().equals("isResumed")) {
			this.setEnabled(!(boolean) e.getNewValue());
		}
	}

}
