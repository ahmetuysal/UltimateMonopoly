/**
 * 
 */
package domain.util;

public class PropertyEvent {
	
	private Object source;
	private String propertyName;
	private Object oldValue;
	private Object newValue;
	
			
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PropertyEvent [propertyName=" + propertyName + ", oldValue=" + oldValue
				+ ", newValue=" + newValue + " source=" + source.getClass().getName() + "]";
	}

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
