package eclipse.factories;

import java.io.IOException;

import eclipse.AStaticInfoParser;
import eclipse.StaticInfoParser;

public class AStaticInfoParserFactory implements StaticInfoParserFactory{
	public StaticInfoParser getStaticInfoParser() throws IOException {
		return new AStaticInfoParser();
	}
}
