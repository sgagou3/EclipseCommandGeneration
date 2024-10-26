package eclipse.commandgen;

public class VisualStudioCommandGeneration {
	static String sourceDir = System.getProperty("user.dir");
	static String destDir = System.getProperty("user.dir");

	static AnEventVisualizer eventVisualizer;

	public static void main(String[] args) throws Exception {
		eventVisualizer = new AnEventVisualizer(sourceDir, destDir);
		eventVisualizer.generateNewLogFile();
	}
}
