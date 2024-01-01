package eclipse;

import javax.json.JsonObject;

public interface VisualStudioLogParser {
    JsonObject parseNextObject();
}
