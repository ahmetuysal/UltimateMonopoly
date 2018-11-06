/**
 * 
 */
package util;

import java.awt.AWTEvent;


public class PropertyEvent extends AWTEvent {
	
	private String propertyName;
	private Object oldValue;
	private Object newValue;
	
	
	private static final int PROPERTY_EVENT_ID = 1234323432;
		
	public PropertyEvent(Object source, String propertyName, Object oldValue, Object newValue) {
		super(source, PROPERTY_EVENT_ID);
		this.propertyName = propertyName;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}
	
	public String getPropertyName() {
		return propertyName;
	}
	
	public Object getOldValue() {
		return oldValue;
	}
	
	public Object getNewValue() {
		return newValue;
	}
	
}
