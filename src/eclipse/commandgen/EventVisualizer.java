package eclipse.commandgen;

import java.util.List;

public interface EventVisualizer {
	void generateNewLogFile();
	List<EditorEvent> getEditorEventList();
}
