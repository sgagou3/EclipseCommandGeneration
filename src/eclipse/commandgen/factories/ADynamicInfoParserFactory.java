package eclipse.commandgen.factories;

import java.io.IOException;

import eclipse.commandgen.ADynamicInfoParser;
import eclipse.commandgen.DynamicInfoParser;

public class ADynamicInfoParserFactory implements DynamicInfoParserFactory{

	@Override
	public DynamicInfoParser getDynamicInfoParser(String aPath) throws IOException {
		return new ADynamicInfoParser(aPath);
	}
}
