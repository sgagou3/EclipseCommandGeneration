package eclipse.commandgen.factories;

import eclipse.commandgen.AVisualStudioLogWriter;
import eclipse.commandgen.VisualStudioLogWriter;

public class AVisualStudioLogWriterFactory implements VisualStudioLogWriterFactory{

	@Override
	public VisualStudioLogWriter getVisualStudioLogWriter(String aPath) {
		// TODO Auto-generated method stub
		return new AVisualStudioLogWriter(aPath);
	}

}
