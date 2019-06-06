package PracticeArena.Easy;

/*
Problem Statement for Ropestring
Problem Statement

    	Hero has a collection of ropes. You are given the String s that contains an ASCII art depicting this collection of ropes. Each character of s is either '-' (dash, ASCII 45) or '.' (period, ASCII 46). Each dash is a rope segment, each period is an empty space. Each contiguous segment of dashes represents one rope; the number of dashes is the length of the rope. For example, s = "..-..----." means that Hero has two ropes: one of length 1 and one of length 4. Hero has decided to rearrange his collection of ropes, using the following rules:
		Each rope that has an even length must be placed to the left of all ropes that have odd lengths.
		There must be at least one empty space between any two ropes.
		
		If there are multiple arrangements that satisfy the previous two rules, Hero will choose the one that corresponds to the lexicographically smallest string. (This is explained below.)
		Once Hero rearranges his ropes, we can encode their new placement into a new string that looks similar to s. (The string will have the same length as s and it will contain the same collection of ropes, but possibly in different places.) Given two strings of the same length, the lexicographically smaller one is the one that has a character with a smaller ASCII value on the first position on which they differ. For example, the string X = "---.-" is lexicographically smaller than the string Y = "-.---" because X[0] = Y[0] and X[1] < Y[1]. (Note that a dash has a smaller ASCII value than a period.) Construct the arrangement of ropes chosen by Hero and return the String that encodes it.
 
Definition
Class:	Ropestring
Method:	makerope
Parameters:	String
Returns:	String
Method signature:	String makerope(String s)
(be sure your method is public)
    
Constraints
-	s will contain between 1 and 50 characters, inclusive.
-	Each character in s will be either '-' or '.'.
 
Examples
0)	"..-..-"
Returns: "-.-..."

1)	"-.-"
Returns: "-.-"

2)	"--..-.---..--"
Returns: "--.--.---.-.."

3)	"--..-.---..--..-----.--."
Returns: "--.--.--.-----.---.-...."

4)	"..."
Returns: "..."
*/

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
			encodedString += dashLength.get(i);
			if (encodedString.length() < s.length()) {
				encodedString += ".";
				totalDashUsed++;
			}
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
			encodedString += dashLength.get(i);
			if (encodedString.length() < s.length()) {
				encodedString += ".";
				totalDashUsed++;
			}

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
		System.out.println(makeRope("-.-"));
	}

}
