package eclipse.commandgen.factories;

import java.io.IOException;

import eclipse.commandgen.AVisualStudioLogParser;
import eclipse.commandgen.VisualStudioLogParser;

public class AVisualStudioLogParserFactory implements VisualStudioLogParserFactory{

	@Override
	public VisualStudioLogParser getVisualStudioLogParser(String aPath) throws IOException {
		return new AVisualStudioLogParser(aPath);
	}

}
