package eclipse.commandgen;

import static fluorite.commands.generation.CommandGenerationUtil.createDelete;
import static fluorite.commands.generation.CommandGenerationUtil.createInsert;
import static fluorite.commands.generation.CommandGenerationUtil.writeCommands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fluorite.commands.EHICommand;

// Modeled using EHReaderWriter.java from Comp524All.jar
public class EclipseCommandGeneration {
	static long startTimeStamp = System.currentTimeMillis();
	static long nextTimeStamp = startTimeStamp;

	static int tenSecondPause = 1000 * 10;
	static int hundredMillisecondPause = 100;
	static List<EHICommand> ehiCommandList = new ArrayList<EHICommand>();
	static int maxPauseTime = 1000 * 5;

	static long getNextPauseTime() {
		return Math.round(maxPauseTime * Math.random());
	}

	static void setTimeStampOfCommands(List<EHICommand> aCommands) {
		long aPauseTime = getNextPauseTime();
		long aNewTimeStamp = nextTimeStamp + aPauseTime;

		for (EHICommand aCommand : aCommands) {
			aCommand.setStartTimestamp(startTimeStamp);
			aCommand.setTimestamp(aNewTimeStamp - nextTimeStamp);
		}

		nextTimeStamp = aNewTimeStamp;
	}

	static void convertEventListToCommandList(List<EditorEvent> anEditorEventList) {
		loop: for (EditorEvent anEvent : anEditorEventList) {
			String anEventType = anEvent.getEventType();
			int anOffset = Integer.parseInt(anEvent.getPosition().substring(anEvent.getPosition().indexOf(",") + 1));
			switch (anEventType) {
			// Insertion type
			case "backspace":
			case "undo":
			case "delete":
				ehiCommandList.add(createDelete(anOffset, anEvent.getEventResult()));
				continue loop;
			// Deletion type
			case "input":
			case "paste":
			case "redo":
				ehiCommandList.add(createInsert(anOffset, anEvent.getEventResult()));
				continue loop;
			}
		}
	}

	static void generateEclipseLog(List<EditorEvent> anEditorEventList) {
		convertEventListToCommandList(anEditorEventList);
		setTimeStampOfCommands(ehiCommandList);
		writeCommands(startTimeStamp, ehiCommandList);
	}

	public static void main(String[] args) throws IOException {
		String localDirectory = System.getProperty("user.dir");
		EventVisualizer anEventVisualizer = new AnEventVisualizer(localDirectory, localDirectory);
		anEventVisualizer.generateNewLogFile();
		generateEclipseLog(anEventVisualizer.getEditorEventList());
	}
}
