package eclipse.commandgen.factories;

import java.io.IOException;

import eclipse.commandgen.VisualStudioLogParser;

public interface VisualStudioLogParserFactory {
	VisualStudioLogParser getVisualStudioLogParser(String aPath)throws IOException;
}
