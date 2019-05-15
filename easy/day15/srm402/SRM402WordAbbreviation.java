package PracticeArena.Easy;

/*
Problem Statement for WordAbbreviation
Problem Statement
    	You are given a String[] words, each element of which is a single word. Return a String[] where the i-th element is the abbrevation for the i-th word. 
    	The abbreviation for a word is its shortest non-empty prefix that is not a prefix of any other given word. 
    	The constraints will guarantee that it is possible to find an abbreviation for all the given words.
 
Definition
Class:	WordAbbreviation
Method:	getAbbreviations
Parameters:	String[]
Returns:	String[]
Method signature:	String[] getAbbreviations(String[] words)
(be sure your method is public)
 
Notes
-	A string s1 is called a prefix of string s2 if and only if s1 can be obtained by removing zero or more characters from the end of s2.
 
Constraints
-	words will contain between 1 and 50 elements, inclusive.
-	Each element of words will contain between 1 and 50 characters, inclusive.
-	Each element of words will only contain lowercase letters ('a'-'z').
-	No element of words will be a prefix of another element of words.
 
Examples
0)	{"abc","def","ghi"}
Returns: {"a", "d", "g" }
A single character is enough.

1)	{"aaab","aaac","aaad"}
Returns: {"aaab", "aaac", "aaad" }
It's possible that the abbreviation is the same as the original word.

2)	{"top","coder","contest"}
Returns: {"t", "cod", "con" }

3)	
{
 "bababaaaaa",
 "baaabaababa",
 "bbabaaabbaaabbabaabaabbbbbaabb",
 "aaababababbbbababbbaabaaaaaaaabbabbbaaab",
 "baaaaabaababbbaabbbabbababbbabbbbbbbbab"
}
Returns: {"bab", "baaab", "bb", "a", "baaaa" }

4)	{"oneword"}
Returns: {"o" }
*/

public class SRM402WordAbbreviation {

	public static String[] getAbbreviations(String[] words) {
		String[] abbreviationWords = new String[words.length];

		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				String abbr = words[i].substring(0, j + 1);
				boolean isOtherStringAbbrAvailable = false;
				// check for other words abbreviation
				for (int k = 0; k < words.length; k++) {
					if (words[k].startsWith(abbr) && k != i) {
						isOtherStringAbbrAvailable = true;
						break;
					}
				}

				if (!isOtherStringAbbrAvailable) {
					abbreviationWords[i] = abbr;
					break;
				}
			}
		}

		return abbreviationWords;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] abbreviatedWords = getAbbreviations(new String[] { "top", "coder", "contest" });
		for (String abbr : abbreviatedWords) {
			System.out.print(abbr + " ");
		}
	}

}
