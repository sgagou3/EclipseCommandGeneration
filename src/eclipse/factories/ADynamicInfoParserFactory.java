package eclipse.factories;

import java.io.IOException;

import eclipse.ADynamicInfoParser;
import eclipse.DynamicInfoParser;

public class ADynamicInfoParserFactory implements DynamicInfoParserFactory{

	@Override
	public DynamicInfoParser getDynamicInfoParser(String aPath) throws IOException {
		return new ADynamicInfoParser(aPath);
	}
}
