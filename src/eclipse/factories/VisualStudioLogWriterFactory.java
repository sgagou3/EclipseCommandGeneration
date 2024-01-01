package eclipse.factories;

import eclipse.VisualStudioLogWriter;

public interface VisualStudioLogWriterFactory {
	VisualStudioLogWriter getVisualStudioLogWriter(String aPath);
}
