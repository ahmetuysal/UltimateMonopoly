package domain.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Observable {
	
	private Map<String, List<PropertyListener>> propertyListenersMap;
	
	public Observable() {
		propertyListenersMap = new HashMap<String, List<PropertyListener>>();
		propertyListenersMap.put("all", new ArrayList<PropertyListener>());
	}
	
	public void addPropertyListener(PropertyListener listener) {
		propertyListenersMap.get("all").add(listener);
	}
	
	public void addPropertyListener(String propertyName, PropertyListener listener) {
		if (propertyListenersMap.containsKey(propertyName)) {
			propertyListenersMap.get(propertyName).add(listener);
		}
		else {
			List<PropertyListener> list = new ArrayList<>();
			list.add(listener);
			propertyListenersMap.put(propertyName, list);
		}
	}
	
	public void publishPropertyEvent(String propertyName, Object oldValue, Object newValue) {
		PropertyEvent pEvent = new PropertyEvent(this, propertyName, oldValue, newValue);
		for (PropertyListener listener : propertyListenersMap.get("all")) {
			listener.onPropertyEvent(pEvent);
		}
		if (propertyListenersMap.containsKey(propertyName)) {
			for (PropertyListener listener : propertyListenersMap.get(propertyName)) {
				listener.onPropertyEvent(pEvent);
			}
		}
	}
	
}
