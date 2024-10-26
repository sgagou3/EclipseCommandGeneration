package eclipse.commandgen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ADynamicInfoParser implements DynamicInfoParser {
	private File file;
	private BufferedReader bufferedReader;
	private String[] fileContent = new String[3];

	public ADynamicInfoParser(String aPath) throws IOException {
		file = new File(aPath);
		bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		fileContent[0] = bufferedReader.readLine();
		fileContent[0] = bufferedReader.readLine();
		fileContent[1] = bufferedReader.readLine();
		fileContent[2] = bufferedReader.readLine();
	}

	public String parseCourseID() {
		return fileContent[0];
	}

	public String parseAssignmentID() {
		return fileContent[1];
	}

	public String parseLogSessionID() {
		return fileContent[2];
	}
}
