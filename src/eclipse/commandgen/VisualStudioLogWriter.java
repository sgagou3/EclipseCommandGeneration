package eclipse.commandgen;

import java.util.List;

public interface VisualStudioLogWriter {
	void writeEventListToFile(List<EditorEvent> anEditorEventList);
}
