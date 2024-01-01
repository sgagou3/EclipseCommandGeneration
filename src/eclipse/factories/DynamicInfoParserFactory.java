package eclipse.factories;

import java.io.IOException;

import eclipse.DynamicInfoParser;

public interface DynamicInfoParserFactory {
	DynamicInfoParser getDynamicInfoParser(String aPath)throws IOException;
}
