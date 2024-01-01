package eclipse.factories;

import eclipse.EventCounter;

public class AnEventCounterFactory implements EventCounterFactory {
	public EventCounter getEventCounter() {
		return new EventCounter();
	}
}
