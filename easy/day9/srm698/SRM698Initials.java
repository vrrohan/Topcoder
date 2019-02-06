package PracticeArena.Easy;

/*
Problem Statement for Initials
Problem Statement
    	When dealing with long names and phrases, we sometimes use the initial letters of words to form its acronym. For example, we use "JFK" instead of "John Fitzgerald Kennedy", "lgtm" instead of "looks good to me", and so on. 
		You are given a String name. This String contains a phrase: one or more words separated by single spaces. Please compute and return the acronym of this phrase. (As above, the acronym should consist of the first letter of each word, in order.)
 
Definition
Class:	Initials
Method:	getInitials
Parameters:	String
Returns:	String
Method signature:	String getInitials(String name)
(be sure your method is public)
    
Constraints
-	name will contain between 1 and 50 characters, inclusive.
-	Each character in s will be a space or a lowercase English letter ('a' - 'z').
-	The first and last character in s will not be a space.
-	No two continuous spaces can appear in s.
 
Examples
0)	"john fitzgerald kennedy"
Returns: "jfk"
There are three words: "john", "fitzgerald" and "kennedy". Their first letters are 'j', 'f' and 'k'. The correct return value is their concatenation: the string "jfk". Note that all letters in our problem are in lowercase.

1)	"single"
Returns: "s"
There is only one word: "single". Its acronym has a single letter.

2)	"looks good to me"
Returns: "lgtm"

3)	"single round match"
Returns: "srm"

4)	"a aa aaa aa a bbb bb b bb bbb"
Returns: "aaaaabbbbb"
*/

public class SRM698Initials {

	public static String getInitials(String name) {
		String nameInitials = "";
		for (String s : name.split("\\s+")) {
			nameInitials += s.charAt(0);
		}
		return nameInitials;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getInitials("john fitzgerald kennedy"));
		System.out.println(getInitials("looks good to me"));
		System.out.println(getInitials("a aa aaa aa a bbb bb b bb bbb"));
	}

}
