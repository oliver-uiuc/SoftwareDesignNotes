package chapter6;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeShow implements Show{
	private final List<Show> aShows;
	

	public CompositeShow(Show... pShows) {
	    aShows = new ArrayList<>(Arrays.asList(pShows));	
		//aShows = Arrays.asList(pShows);
	}
	//public CompositeShow(CompositeShow pShow) {
	//     aShows = new ArrayList<>(pShow.aShows); //shallow copy, not what we want
	//}

	@Override
	public int time() {
		int time=0;
		for(Show show : aShows) {
			time += show.time();
		}
		return time;
	}

	@Override
	public String description() {
		StringBuilder description = new StringBuilder("[");
		for(Show show : aShows) {
			description.append(show.description()).append(";");
		}
		return description.append("]").toString();
	}

	@Override
	public Show copy() {
		CompositeShow toReturn = new CompositeShow();
		for(Show show: aShows) {
			toReturn.aShows.add(show.copy());
		}
		return toReturn;
	}
}
