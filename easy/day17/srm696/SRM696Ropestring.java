package PracticeArena.Easy;

import java.util.ArrayList;
import java.util.Comparator;

public class SRM696Ropestring {

	public static String makeRope(String s) {
		String encodedString = "";
		String[] dashRopes = s.split("[.]+");
		ArrayList<String> dashLength = new ArrayList<String>();
		int totalDashUsed = 0;
		// store all even length dash(-) strings
		for (String d : dashRopes) {
			if (d.length() > 0 && d.length() % 2 == 0) {
				dashLength.add(d);
			}
		}

		// reverse sort dash(-) string by length i.e. highest even length string
		// comes first
		dashLength.sort(new Comparator<String>() {
			@Override
			public int compare(String dashStringOne, String dashStringTwo) {
				// TODO Auto-generated method stub
				return Integer.compare(dashStringOne.length(), dashStringTwo.length());
			}
		}.reversed());

		// add those sorted dash strings one by one with dot(.)
		for (int i = 0; i < dashLength.size(); i++) {
			encodedString += dashLength.get(i) + ".";
			totalDashUsed++;
		}

		// clear dashLength al to store odd length dash strings
		dashLength.clear();

		// now add odd length strings
		for (String d : dashRopes) {
			if (d.length() > 0 && d.length() % 2 != 0) {
				dashLength.add(d);
			}
		}

		// now reverse sort those odd length dash string
		dashLength.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.length(), o2.length());
			}
		}.reversed());

		// add those sorted dash strings one by one with dot(.)
		for (int i = 0; i < dashLength.size(); i++) {
			encodedString += dashLength.get(i) + ".";
			totalDashUsed++;
		}

		int totalDots = 0;
		for (int k = 0; k < s.length(); k++) {
			if (s.charAt(k) == '.') {
				totalDots++;
			}
		}

		// build final dots
		for (int i = 0; i < totalDots - totalDashUsed; i++) {
			encodedString += ".";
		}

		return encodedString;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(makeRope("..----.-.-.-.--..-.-----.-..------...-.---.-----.."));
		System.out.println(makeRope("--..-.---..--..-----.--."));
	}

}
