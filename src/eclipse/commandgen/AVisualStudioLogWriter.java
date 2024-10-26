package eclipse.commandgen;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class AVisualStudioLogWriter implements VisualStudioLogWriter {
	private String destinationPath;

	public AVisualStudioLogWriter(String aDestinationPath) {
		destinationPath = aDestinationPath;
	}

	private JsonArray convertEventListToJsonArray(List<EditorEvent> anEditorEventList) {
		JsonArrayBuilder anArrayBuilder = Json.createArrayBuilder();
		for (EditorEvent anEditorEvent : anEditorEventList) {
			JsonObject nextWrittenObject = Json.createObjectBuilder().add("Event_Id", anEditorEvent.getEventID())
					.add("Event_Id", anEditorEvent.getEventID()).add("Course_Id", anEditorEvent.getCourseID())
					.add("Machine_Id", anEditorEvent.getMachineID()).add("Session_Id", anEditorEvent.getSessionID())
					.add("Student_Id", anEditorEvent.getStudentID()).add("Student_Name", anEditorEvent.getStudentName())
					.add("Milestone", anEditorEvent.getIsMilestone())
					.add("Milestone_Description", anEditorEvent.getMilestoneDescription())
					.add("Event", anEditorEvent.getEventName()).add("Event_Type", anEditorEvent.getEventType())
					.add("Event_Timestamp", anEditorEvent.getEventTimeStamp())
					.add("Start_Timestamp", anEditorEvent.getStartTimeStamp())
					.add("End_Timestamp", anEditorEvent.getEndTimeStamp())
					.add("Event_Result", anEditorEvent.getEventResult())
					.add("Error_Message", anEditorEvent.getErrorMessage())
					.add("Error_Type", anEditorEvent.getErrorType()).add("Log_Source", anEditorEvent.getLogSource())
					.add("Execution_Count", anEditorEvent.getExecutionCount())
					.add("Error_Count", anEditorEvent.getErrorCount())
					.add("Duration_Minutes", anEditorEvent.getDuration()).build();
			anArrayBuilder.add(nextWrittenObject);
		}
		return anArrayBuilder.build();
	}

	public void writeEventListToFile(List<EditorEvent> anEditorEventList) {
		JsonArray aJsonArray = convertEventListToJsonArray(anEditorEventList);
		JsonWriter aJsonWriter = null;
		try {
			aJsonWriter = Json.createWriter(new PrintWriter(destinationPath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		aJsonWriter.writeArray(aJsonArray);
	}
}
