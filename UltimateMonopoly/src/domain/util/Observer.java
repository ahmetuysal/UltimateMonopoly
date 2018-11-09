package domain.util;

public interface Observer {
	public void update(String key, String event, Object object);
}
