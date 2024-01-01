package eclipse.factories;

import eclipse.AVisualStudioLogWriter;
import eclipse.VisualStudioLogWriter;

public class AVisualStudioLogWriterFactory implements VisualStudioLogWriterFactory{

	@Override
	public VisualStudioLogWriter getVisualStudioLogWriter(String aPath) {
		// TODO Auto-generated method stub
		return new AVisualStudioLogWriter(aPath);
	}

}
