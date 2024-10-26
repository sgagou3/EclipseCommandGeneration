package eclipse.commandgen.factories;

import java.io.IOException;

import eclipse.commandgen.AStaticInfoParser;
import eclipse.commandgen.StaticInfoParser;

public class AStaticInfoParserFactory implements StaticInfoParserFactory{
	public StaticInfoParser getStaticInfoParser() throws IOException {
		return new AStaticInfoParser();
	}
}
