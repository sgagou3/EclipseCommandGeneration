package eclipse.commandgen.factories;

import eclipse.commandgen.VisualStudioLogWriter;

public interface VisualStudioLogWriterFactory {
	VisualStudioLogWriter getVisualStudioLogWriter(String aPath);
}
