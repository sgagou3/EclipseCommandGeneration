package eclipse.commandgen;

public class EventCounter {
	private int count;

	public EventCounter() {
		count = 0;
	}

	public EventCounter(int aStartingCount) {
		count = aStartingCount;
	}

	public void increment() {
		count++;
	}

	public void increment(int anIncrementation) {
		count += anIncrementation;
	}

	public int getCount() {
		return count;
	}

	public void reset() {
		count = 0;
	}
}
