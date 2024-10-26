package eclipse.commandgen.factories;

import java.io.IOException;

import eclipse.commandgen.DynamicInfoParser;

public interface DynamicInfoParserFactory {
	DynamicInfoParser getDynamicInfoParser(String aPath)throws IOException;
}
