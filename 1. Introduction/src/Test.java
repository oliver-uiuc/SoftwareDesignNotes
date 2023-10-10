import java.util.ArrayList;
//import java.util.List;

public class Test {

	private static final String TEXT = "Lorem ipsum dolor sit amet, "
			+ "consectetur adipiscing elit. Nunc quis tempor tellus. Nulla "
			+ "tincidunt pretium justo non finibus. Fusce quis bibendum ante. "
			+ "Vivamus a ex maximus, iaculis nunc eu, posuere augue. Vestibulum "
			+ "ante ipsum primis in faucibus orci luctus et ultrices posuere "
			+ "cubilia Curae; Nullam ut lorem metus. Vivamus consequat eros "
			+ "sed lorem rhoncus finibus. Sed porta euismod consequat. Etiam "
			+ "sodales accumsan nulla, non pretium ex tincidunt eget. Aliquam "
			+ "nibh erat, tristique vel augue sit amet, sodales sollicitudin leo. "
			+ "Mauris in arcu volutpat, efficitur erat imperdiet, finibus dolor. "
			+ "Vestibulum a dolor sed justo tempor elementum. Pellentesque eu "
			+ "tincidunt ex, et posuere orci. Phasellus non nibh non nibh pharetra "
			+ "lobortis. ";
	
	public static void main(String[] args) {
		ArrayList<String> wordList = new ArrayList<String>();
		ArrayList<Integer> numList = new ArrayList<Integer>();
		for (String word: TEXT.split(" ")) {
			//remove , and .
			if(word.charAt(word.length()-1)==','||word.charAt(word.length()-1)=='.') {
				String temp=word;
				word="";
				for(int i=0;i<temp.length()-1;i++) {
					word+=temp.charAt(i);
				}
			}
			//if exists, add one to the value; else append to the list
			boolean find=false;
			for(int i=0;i<wordList.size();i++) {
				if (word.equals(wordList.get(i))) {
					numList.set(i, numList.get(i)+1);
					find=true;
					break;
				}
			}
			if(find==false) {
				wordList.add(word);
				numList.add(1);
			}
		}
		//output the 
		int maxLoc=-1;
		int maxNum=-1;
		for(int i=0;i<wordList.size();i++) {
			if(numList.get(i)>maxNum) {
				maxNum=numList.get(i);
				maxLoc=i;
			}
		}
		System.out.println(maxNum+" "+wordList.get(maxLoc));
	}
}