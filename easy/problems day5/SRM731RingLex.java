package PracticeArena.Easy;

/*
Problem Statement for RingLex

Problem Statement
    	Hero has an infinite periodic string t. You are given the String s that is the period of Hero's string. For example, if s = "abc", Hero's actual string is t = "abcabcabcabc..." 
    	Let n be the length of string s. 
    	Hero is now going to use the infinite string t to generate a new n-character string by doing the following steps:
		He will choose an offset: a non-negative integer x.
		He will choose the length of a step: a prime number p that is less than n.
		The new string will consists of the first n characters we can read in the string t if we start at the index x and after each character we move p positions to the right.
		Formally, Hero's new string will consist of the following characters, in order: t[x], t[x + p], t[x + 2*p], ..., t[x + (n-1)*p]. Find and return the lexicographically smallest string Hero can produce.
 
Definition
Class:	RingLex
Method:	getmin
Parameters:	String
Returns:	String
Method signature:	String getmin(String s)
(be sure your method is public)
    
 
Notes
-	Given two distinct strings of the same length, the lexicographically smaller one is the one that has a smaller character at the first position where they differ.
-	A positive integer p is a prime if it has exactly two distinct divisors: 1 and p. Note that the number 1 is not a prime.
 
Constraints
-	s will contain between 3 and 50 characters, inclusive.
-	Each character in s will be between 'a' and 'z', inclusive.
 
Examples
0)	"cba"
Returns: "abc"
Hero should choose the offset x=2 and the step p=2. The resulting string is t[2]+t[4]+t[6] = 'a'+'b'+'c' = "abc".

1)	"acb"
Returns: "abc"
Here, Hero should choose x=0 and p=2.

2)	"abacaba"
Returns: "aaaabcb"

3)	"aaabb"
Returns: "aabab"

4)	"azzzabbb"
Returns: "abazabaz"
Note that Hero cannot choose x=0 and p=4, because 4 is not a prime number.

5)	"abbaac"
Returns: "aaaaaa"

6)	"fsdifyhsoe"
Returns: "dehifsfsoy"
 */

import java.util.ArrayList;
import java.util.Collections;

public class SRM731RingLex {

	public static String getMin(String s) {
		String smallestString = "";
		char[] ch = s.toCharArray();
		ArrayList<Character> liChars = new ArrayList<Character>();
		for (char c : ch) {
			liChars.add(c);
		}
		char minAlphabet = Collections.min(liChars);
		int freqMinAlpha = Collections.frequency(liChars, new Character(minAlphabet));

		ArrayList<Integer> minIndexesList = new ArrayList<Integer>();
		if (freqMinAlpha > 1) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == minAlphabet) {
					minIndexesList.add(i);
				}
			} // for loop ends...
		} // if condition ends...
		else {
			minIndexesList.add(s.indexOf(String.valueOf(minAlphabet)));
		}

		// choosing prime numbers
		// creating primes less than string length
		ArrayList<Integer> listOfPrimes = new ArrayList<Integer>();
		for (int i = 2; i < s.length(); i++) {
			boolean b = true;
			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					b = false;
					break;
				}
			} // inner for loop ends...
			if (b) {
				listOfPrimes.add(i);
			}
		} // outer for loop ends...

		// Create Demo String to compare with
		for (int i = 0; i < s.length(); i++) {
			int x = minIndexesList.get(0);
			int p = listOfPrimes.get(0);
			smallestString += s.charAt((x + i * p) % s.length());
		}

		// for loop for min character list - loop1
		for (int x = 0; x < minIndexesList.size(); x++) {
			// for loop for step i.e. p - loop2
			for (int y = 0; y < listOfPrimes.size(); y++) {
				String demoString = "";
				// for loop that creates smallest string - loop3
				for (int z = 0; z < s.length(); z++) {
					int xx = minIndexesList.get(x);
					int pp = listOfPrimes.get(y);
					demoString += s.charAt((xx + z * pp) % s.length());
				} // loop3 ends...
				if (demoString.compareTo(smallestString) <= 0) {
					smallestString = demoString;
				}
			} // loop2 ends...
		} // loop1 ends...

		return smallestString;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMin("fsdifyhsoe"));
		System.out.println(getMin("abbaac"));
		System.out.println(getMin("acb"));
		System.out.println(getMin("abacaba"));
		System.out.println(getMin("lkmfqrmyjfjnhhssqctydteamdcjbprhtnegyiwxgcjwlg"));
	}
}
