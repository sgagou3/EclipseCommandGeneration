package eclipse.commandgen;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

public class AVisualStudioLogParser implements VisualStudioLogParser {
	private JsonReader jsonReader;
	private JsonArray jsonArray;
	private Iterator<JsonValue> iterator;

	public AVisualStudioLogParser(String aSourcePath) throws FileNotFoundException {
		jsonReader = Json.createReader(new FileInputStream(aSourcePath));
		jsonArray = jsonReader.readArray();
		iterator = jsonArray.iterator();
	}

	public JsonObject parseNextObject() {
		try {
			JsonObject aJsonObject = (JsonObject) iterator.next();
			return aJsonObject;
		} catch (Exception e) {
			return null;
		}
	}
}
