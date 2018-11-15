/**
 * 
 */
package domain.util;

public class PropertyEvent {
	
	private Object source;
	private String propertyName;
	private Object oldValue;
	private Object newValue;
	
			
	public PropertyEvent(Object source, String propertyName, Object oldValue, Object newValue) {
		this.source = source;
		this.propertyName = propertyName;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}
	
	public Object getSource() {
		return source;
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
