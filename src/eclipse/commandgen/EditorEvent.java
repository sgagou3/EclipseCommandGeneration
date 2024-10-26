package eclipse.commandgen;

import javax.json.JsonObject;

public class EditorEvent {
	private String eventID;
	private String courseID;
	private String machineID;
	private String sessionID;
	private String studentID;
	private String studentName;

	private boolean isMilestone;
	private String milestoneDescription;

	private String eventName;
	private String eventType;

	private String eventTimeStamp;
	private String startTimeStamp;
	private String endTimeStamp;

	private String eventResult;

	private String errorMessage;
	private String errorType;

	private String logSource;

	private int executionCount;
	private int errorCount;

	private double duration;

	private String positionString;

	public EditorEvent(JsonObject aJsonObject, DynamicInfoParser aDynamicInfoParser, StaticInfoParser aStaticInfoParser,
			VisualStudioLogParser aLogParser, EventCounter anEventCounter) {
		eventID = String.valueOf(anEventCounter.getCount());
		courseID = aDynamicInfoParser.parseCourseID();
		machineID = aStaticInfoParser.getMachineID();
		sessionID = aDynamicInfoParser.parseLogSessionID();
		studentID = aStaticInfoParser.getUserName();
		// Not final
		studentName = System.getProperty("user.name");

		isMilestone = false;
		milestoneDescription = "no milestone";

		eventName = aJsonObject.getString("command");

		eventType = aJsonObject.getString("command");

		eventTimeStamp = aJsonObject.getString("time");
		startTimeStamp = aJsonObject.getString("time");
		endTimeStamp = aJsonObject.getString("time");

		if (aJsonObject.isNull("arguments")) {
			eventResult = "no event result available";
		} else {
			eventResult = aJsonObject.getString("arguments");
		}

		errorMessage = "no error";
		errorType = "no error";

		logSource = aJsonObject.getString("path");

		executionCount = 1;
		errorCount = 0;

		duration = 0.0f;

		positionString = aJsonObject.getString("position");
	}

	public String getEventID() {
		return eventID;
	}

	public void setEventID(String aNewEventID) {
		eventID = aNewEventID;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String aNewCourseID) {
		courseID = aNewCourseID;
	}

	public String getMachineID() {
		return machineID;
	}

	public void setMachineID(String aNewMachineID) {
		machineID = aNewMachineID;
	}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String aNewSessionID) {
		sessionID = aNewSessionID;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String aNewStudentID) {
		studentID = aNewStudentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String aNewStudentName) {
		studentName = aNewStudentName;
	}

	public boolean getIsMilestone() {
		return isMilestone;
	}

	public void setIsMilestone(boolean aNewMilestone) {
		isMilestone = aNewMilestone;
	}

	public String getMilestoneDescription() {
		return milestoneDescription;
	}

	public void setMilestoneDescription(String aNewMilestoneDescription) {
		milestoneDescription = aNewMilestoneDescription;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String aNewEventName) {
		eventName = aNewEventName;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String aNewEventType) {
		eventType = aNewEventType;
	}

	public String getEventTimeStamp() {
		return eventTimeStamp;
	}

	public void setEventTimeStamp(String aNewEventTimeStamp) {
		eventTimeStamp = aNewEventTimeStamp;
	}

	public String getStartTimeStamp() {
		return startTimeStamp;
	}

	public void setStartTimeStamp(String aNewStartTimeStamp) {
		startTimeStamp = aNewStartTimeStamp;
	}

	public String getEndTimeStamp() {
		return endTimeStamp;
	}

	public void setEndTimeStamp(String aNewEndTimeStamp) {
		endTimeStamp = aNewEndTimeStamp;
	}

	public String getEventResult() {
		return eventResult;
	}

	public void setEventResult(String aNewEventResult) {
		eventResult = aNewEventResult;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String aNewErrorMessage) {
		errorMessage = aNewErrorMessage;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String aNewErrorType) {
		errorType = aNewErrorType;
	}

	public String getLogSource() {
		return logSource;
	}

	public void setLogSource(String aNewLogSource) {
		logSource = aNewLogSource;
	}

	public int getExecutionCount() {
		return executionCount;
	}

	public void setExecutionCount(int aNewExecutionCount) {
		executionCount = aNewExecutionCount;
	}

	public int getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(int aNewErrorCount) {
		errorCount = aNewErrorCount;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double aNewDuration) {
		duration = aNewDuration;
	}

	public String getPosition() {
		return positionString;
	}

	public void setPosition(String aNewPositionString) {
		positionString = aNewPositionString;
	}
}
