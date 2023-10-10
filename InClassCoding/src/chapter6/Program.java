package chapter6;

import java.util.EnumMap;

public class Program {
	// private Show[] aShows = new Show[7];
	private final EnumMap<Day, Show> aShows = new EnumMap<>(Day.class);
	private Show aDefault = Show.NULL;

	public Program() {
		clear();
	}

	public void setDefault(Show pShow) {
		aDefault = pShow;
	}

	public void initialize() {
		initialize(Day.values());
	}

	// Overload
	public void initialize(Day... pDays) {
		for (Day day : pDays) {
			aShows.put(day, aDefault.copy());// ?????why
		}
	}

	public Command createAddCommand(Day pDay, Show pShow) {
		return new Command() {

			@Override
			public void execute() {
				add(pDay, pShow);
			}

			@Override
			public String toString() {
				return String.format("ADD: (%s): %s", pDay, pShow.description());
			}
		};
	}

	public Command createRemoveCommand(Day pDay) {
		return new Command() {

			@Override
			public void execute() {
				remove(pDay);
			}

			@Override
			public String toString() {
				return String.format("REMOVE: (%s)", pDay);
			}
		};
	}

	public Command createClearCommand() {
		return new Command() {

			@Override
			public void execute() {
				clear();
			}

			@Override
			public String toString() {
				return "CLEAR";
			}
		};
	}

	public void add(Day pDay, Show pShow) {
		// aShows[pDay.ordinal()] = pShow;
		assert pDay != null;
		aShows.put(pDay, pShow);
	}

	public void remove(Day pDay) {
		assert pDay != null;
		aShows.remove(pDay);
		aShows.put(pDay, aDefault);// extra argument!
	}

	/**
	 * remove all the shows from the program
	 */
	public void clear() {
		for (Day day : Day.values()) {
			aShows.put(day, Show.NULL);
		}
	}

	public Show get(Day pDay) {
		assert pDay != null;
		return aShows.get(pDay);
	}

	public String toString() {
		StringBuilder description = new StringBuilder();
		for (Day day : Day.values()) {
			description.append(day).append(": ").append(aShows.get(day).description()).append("\n");
		}
		return description.toString();
	}
}
