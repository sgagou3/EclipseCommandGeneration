package eclipse.factories;

import java.io.IOException;

import eclipse.AVisualStudioLogParser;
import eclipse.VisualStudioLogParser;

public class AVisualStudioLogParserFactory implements VisualStudioLogParserFactory{

	@Override
	public VisualStudioLogParser getVisualStudioLogParser(String aPath) throws IOException {
		return new AVisualStudioLogParser(aPath);
	}

}
