package eclipse.factories;

import java.io.IOException;

import eclipse.StaticInfoParser;

public interface StaticInfoParserFactory {
	StaticInfoParser getStaticInfoParser()throws IOException;
}
