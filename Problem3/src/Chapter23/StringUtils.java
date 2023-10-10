package Chapter23;

import java.util.*;

public class StringUtils {
	
	public static Comparator<String> BYLENGTH_ASCENDING = byLengthAscending();
	public static Comparator<String> BYLENGTH_DESCENDING = byLengthDescending();
	private static final List<String> DATA=
			Arrays.asList("bb","ddddd","a","ab","abc","eee");
	public static void main(String [] args) {
//		Comparator<String> comparator = new Comparator<String>() {
//			//if used only in one place
//			@Override
//			public int compare(String o1, String o2) {
//				if(o1.length()==o2.length()) {
//					return o1.compareTo(o2);
//				}
//				return o1.length()-o2.length();
//			}
//		};
//		System.out.println(comparator.compare("aaaaaaa", "bbbb"));
//		System.out.println("a".compareTo("c"));
//		Collections.sort(DATA);
//		System.out.println(DATA);
		Collections.sort(DATA, BYLENGTH_DESCENDING);
		System.out.println(DATA);
	}
	public static Comparator<String> byLengthAscending(){
		return new Comparator<String>() {
			//if used only in one place
			@Override
			public int compare(String o1, String o2) {
				if(o1.length()==o2.length()) {
					return o1.compareTo(o2);
				}
				return o1.length()-o2.length();
			}
		};
	}
	public static Comparator<String> byLengthDescending(){
		return new Comparator<String>() {
			//if used only in one place
			@Override
			public int compare(String o1, String o2) {
				if(o1.length()==o2.length()) {
					return o1.compareTo(o2);
				}
				return o2.length()-o1.length();
			}
		};
	}
}

//class ByLengthComparator implements Comparator<String>{
//	@Override
//	public int compare(String o1, String o2) {
//		if(o1.length()==o2.length()) {
//			return o1.compareTo(o2);
//		}
//		return o1.length()-o2.length();
//	}
//}