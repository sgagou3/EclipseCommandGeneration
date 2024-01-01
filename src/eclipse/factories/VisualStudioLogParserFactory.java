package eclipse.factories;

import java.io.IOException;

import eclipse.VisualStudioLogParser;

public interface VisualStudioLogParserFactory {
	VisualStudioLogParser getVisualStudioLogParser(String aPath)throws IOException;
}
