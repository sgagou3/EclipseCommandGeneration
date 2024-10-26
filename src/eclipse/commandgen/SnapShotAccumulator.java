package eclipse.commandgen;

import java.util.List;

public interface SnapShotAccumulator {
	void processSnapshotFromEvent(EditorEvent anEditorEvent);
	List<EditorEvent> getEditorEventList();
}
