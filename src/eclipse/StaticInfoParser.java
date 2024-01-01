package eclipse;

public interface StaticInfoParser {
	static final String localPath = "//VSCODE-config//staticInfo.txt";

	String getMachineID();

	void setMachineID(String aNewMachineID);

	String getUserName();

	void setUserName(String aNewUserName);
}
