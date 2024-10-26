package eclipse.commandgen;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.json.JsonObject;

public class AnEventVisualizer implements EventVisualizer {
	private VisualStudioLogParser logParser;
	private VisualStudioLogWriter logWriter;
	private DynamicInfoParser dynamicInfoParser;
	private StaticInfoParser staticInfoParser;
	private EventCounter eventCounter = new EventCounter(0);
	private List<EditorEvent> editorEventList;

	public AnEventVisualizer(String aSourcePath, String aDestinationPath) throws IOException {
		logParser = new AVisualStudioLogParser(aSourcePath + "/log/editLog.json");
		logWriter = new AVisualStudioLogWriter(aDestinationPath + "/result-log.json");
		dynamicInfoParser = new ADynamicInfoParser(aSourcePath + "/VSCode-config/dynamicInfo.txt");
		staticInfoParser = new AStaticInfoParser();
	}

	private double getElapsedTime(String aStartTime, String anEndTime) {
		SimpleDateFormat aDateFormat = new SimpleDateFormat("mm/dd/yyyy, hh:mm:ss a");
		try {
			Date aStartDate = aDateFormat.parse(aStartTime);
			Date aEndDate = aDateFormat.parse(anEndTime);

			double aStartMinuteCount = (double) aStartDate.getTime() / (1000 * 60);
			double anEndMinuteCount = (double) aEndDate.getTime() / (1000 * 60);

			return anEndMinuteCount - aStartMinuteCount;
		} catch (ParseException e) {
			System.err.println("could not parse elapsed time");
			return -1;
		}
	}

	private List<EditorEvent> collectOldLogFile() {
		JsonObject aNextJsonObject = null;
		List<EditorEvent> editorEventList = new ArrayList<EditorEvent>();
		while ((aNextJsonObject = logParser.parseNextObject()) != null) {
			eventCounter.increment();
			int aLastIndex = editorEventList.size() - 1;

			EditorEvent aPreviousEditorEvent = null;
			String aPreviousEventType = null;

			EditorEvent aNextEditorEvent = new EditorEvent(aNextJsonObject, dynamicInfoParser, staticInfoParser,
					logParser, eventCounter);
			String aCurrentEventType = aNextEditorEvent.getEventType();

			// Make sure we have previous events to draw from.
			if (aLastIndex > -1) {
				aPreviousEditorEvent = editorEventList.get(aLastIndex);
				aPreviousEventType = aPreviousEditorEvent.getEventType();
				// Make sure the previous event is of the same type.

				if (aPreviousEventType.equals(aCurrentEventType)) {
					// Set execution count and duration.
					int aCurrentExecutionCount = aPreviousEditorEvent.getExecutionCount() + 1;
					aNextEditorEvent.setExecutionCount(aCurrentExecutionCount);

					String aPreviousEventTimeStamp = aPreviousEditorEvent.getStartTimeStamp();
					String aCurrentEventTimeStamp = aPreviousEditorEvent.getEndTimeStamp();

					aNextEditorEvent.setStartTimeStamp(aPreviousEventTimeStamp);

					double anElapsedMinuteCount = getElapsedTime(aPreviousEventTimeStamp, aCurrentEventTimeStamp);
					aNextEditorEvent.setDuration(anElapsedMinuteCount);
				}
			}
			editorEventList.add(aNextEditorEvent);
		}
		return editorEventList;
	}

	public void generateNewLogFile() {
		editorEventList = collectOldLogFile();
		logWriter.writeEventListToFile(editorEventList);
	}

	public List<EditorEvent> getEditorEventList() {
		return editorEventList;
	}
}
