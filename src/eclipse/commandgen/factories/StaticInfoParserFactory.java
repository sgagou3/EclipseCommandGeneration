package eclipse.commandgen.factories;

import java.io.IOException;

import eclipse.commandgen.StaticInfoParser;

public interface StaticInfoParserFactory {
	StaticInfoParser getStaticInfoParser()throws IOException;
}
