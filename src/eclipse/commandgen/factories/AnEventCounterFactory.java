package eclipse.commandgen.factories;

import eclipse.commandgen.EventCounter;

public class AnEventCounterFactory implements EventCounterFactory {
	public EventCounter getEventCounter() {
		return new EventCounter();
	}
}
