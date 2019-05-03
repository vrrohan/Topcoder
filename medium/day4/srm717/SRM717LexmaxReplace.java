package PracticeArena.Medium;

/*
Problem Statement for LexmaxReplace
Problem Statement
    	
	Alice has a string s of lowercase letters. The string is written on a wall.
	Alice also has a set of cards. Each card contains a single letter. Alice can take any card and glue it on top of one of the letters of s. She may use any subset of cards in this way, possibly none or all of them. She is not allowed to glue new letters in front of s or after s, she can only replace the existing letters.
	Alice wants to produce the lexicographically largest possible string.
	You are given the String s. You are also given a String t. Each character of t is a letter written on one of the cards. Compute and return the lexicographically largest string Alice can produce on the wall while following the rules described above.

Definition    	
Class:	LexmaxReplace
Method:	get
Parameters:	String, String
Returns:	String
Method signature:	String get(String s, String t)
(be sure your method is public)
    
Notes
-	Given two distinct strings X and Y of the same length, the lexicographically larger one is the one that has a larger character on the first position on which they differ.
 
Constraints
-	s will contain between 1 and 50 characters, inclusive.
-	t will contain between 1 and 50 characters, inclusive.
-	s will contain only lowercase English letters ('a' - 'z').
-	t will contain only lowercase English letters ('a' - 'z').
 
Examples
0)	"abb"
"c"
Returns: "cbb"
Alice has a single card. This card contains the letter 'c'. The optimal solution is to glue it on top of s[0], producing the string "cbb".

1)	"z"
"f"
Returns: "z"
Here the optimal solution is to do nothing. The card with the letter 'f' will remain unused.

2)	"fedcba"
"ee"
Returns: "feeeba"

3)	"top"
"coder"
Returns: "trp"

4)	"xldyzmsrrwzwaofkcxwehgvtrsximxgdqrhjthkgfucrjdvwlr"
"xfpidmmilhdfzypbguentqcojivertdhshstkcysydgcwuwhlk"
Returns: "zyyyzyxwwwzwvuuttxwtssvtssxrqxppqrontmmllukrkjvwlr"
*/

import java.util.ArrayList;
import java.util.Collections;

public class SRM717LexmaxReplace {

	public static char getMaximumCharacter(String s) {
		ArrayList<Character> lis = new ArrayList<Character>();
		for (int i = 0; i < s.length(); i++) {
			lis.add(s.charAt(i));
		}
		return Collections.max(lis).charValue();
	}

	public static String get(String s, String t) {
		StringBuffer stringS = new StringBuffer(s);
		StringBuffer stringT = new StringBuffer(t);
		int counter = stringT.length();
		while (counter-- > 0) {
			// find maximum character in String t & save it as maxChar
			char maxChar = getMaximumCharacter(stringT.toString());

			// From the start find 1st small character in s, which is smaller
			// than maxChar
			for (int i = 0; i < stringS.length(); i++) {
				if (maxChar > stringS.charAt(i)) {
					// Replace that character with maxChar. Need to continue
					// this till length of String t
					stringS.replace(i, i + 1, String.valueOf(maxChar));
					int deleteCharIndex = stringT.indexOf(String.valueOf(maxChar));
					stringT.deleteCharAt(deleteCharIndex);
					break;
				}
			}
		}

		return stringS.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(get("kgan", "rtm"));
	}

}
