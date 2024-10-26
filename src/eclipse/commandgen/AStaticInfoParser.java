package eclipse.commandgen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class AStaticInfoParser implements StaticInfoParser {
	private File file;
	private BufferedReader bufferedReader;
	private String[] fileContent = new String[2];

	public AStaticInfoParser() throws IOException {
		file = new File(System.getProperty("user.home") + localPath);
		bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		fileContent[0] = bufferedReader.readLine();
		fileContent[0] = bufferedReader.readLine();
		fileContent[1] = bufferedReader.readLine();
	}

	public String getMachineID() {
		return fileContent[0];
	}

	public void setMachineID(String aNewMachineID) {
		fileContent[0] = aNewMachineID;
	}

	public String getUserName() {
		return fileContent[1];
	}

	public void setUserName(String aNewUserName) {
		fileContent[1] = aNewUserName;
	}
}
