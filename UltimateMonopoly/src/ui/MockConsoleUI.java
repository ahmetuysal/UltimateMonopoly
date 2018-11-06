package ui;

import util.PropertyEvent;
import util.PropertyListener;

public class MockConsoleUI implements PropertyListener {

	@Override
	public void onPropertyEvent(PropertyEvent e) {
		System.out.println("Current Player: " + e.getNewValue());
	}

}
