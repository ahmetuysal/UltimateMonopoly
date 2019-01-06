package domain.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

public class GsonUtils {

	private static final GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();

	public static void registerType(RuntimeTypeAdapterFactory<?> adapter) {
		gsonBuilder.registerTypeAdapterFactory(adapter);
	}

	public static Gson getGson() {
		return gsonBuilder.create();
	}

}
