package ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MockConsoleUI implements PropertyChangeListener {

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		System.out.println("Current Player: " + e.getNewValue());
	}

}
