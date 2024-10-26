package eclipse.commandgen;

import javax.json.JsonObject;

public interface VisualStudioLogParser {
    JsonObject parseNextObject();
}
