package PracticeArena.Medium;

/*
Problem Statement for WolfDelaymaster
Problem Statement
    	
    	Wolf Sothe is playing the game Delaymaster. In this game, he can create new words according to the following rules:
		For each positive integer n, the string which consists of n copies of 'w', then n copies of 'o', then n copies of 'l', and finally n copies of 'f' is a valid word.
		The concatenation of two valid words is a valid word. Only the words that can be obtained by rules 1 and 2 are valid. There are no other valid words. Thus, for example:
		
		By rule 1, "wolf", "wwoollff", and "wwwooolllfff" are valid words.
		Then, by rule 2, "wolfwwoollff" is a valid word.
		By applying rule 2 twice, "wolfwwoollffwolf" is a valid word.
		The string "wfol" is not a valid word (order matters).
		The string "wwolfolf" is not a valid word (we can only concatenate, not insert one word into another).
		The string "wwwoolllfff" is not a valid word (only two 'o's instead of three).
		You are given a String str. Return "VALID" if str is a valid word and "INVALID" otherwise. Note that the return value is case-sensitive: you must return the strings "VALID" and "INVALID" in all-uppercase.
 
Definition
Class:	WolfDelaymaster
Method:	check
Parameters:	String
Returns:	String
Method signature:	String check(String str)
(be sure your method is public)
    
Constraints
-	str will contain between 1 and 50 characters, inclusive.
-	Each character in str will be 'w', 'o', 'l' or 'f'.
 
Examples
0)	"wolf"
Returns: "VALID"
The first valid word from the examples in the problem statement.

1)	"wwolfolf"
Returns: "INVALID"
The second invalid word from the examples in the problem statement.

2)	"wolfwwoollffwwwooolllfffwwwwoooollllffff"
Returns: "VALID"

3)	"flowolf"
Returns: "INVALID"
*/

public class SRM593WolfDelayMaster {

	public static String check(String str) {
		String isValidWord = "VALID";
		if (!str.startsWith("w") || str.length() % 4 != 0 || !str.endsWith("f") || str.contains("wl")
				|| str.contains("wf") || str.contains("of") || str.contains("ow") || str.contains("lw")
				|| str.contains("lo") || str.contains("fo") || str.contains("fl")) {
			isValidWord = "INVALID";
		} else {
			char[] freqChars = str.toCharArray();
			int index = 0;
			while (index < freqChars.length) {
				int[] countWolf = new int[4];
				while (index < freqChars.length && freqChars[index] == 'w') {
					index++;
					countWolf[0]++;
				}
				while (index < freqChars.length && freqChars[index] == 'o') {
					index++;
					countWolf[1]++;
				}
				while (index < freqChars.length && freqChars[index] == 'l') {
					index++;
					countWolf[2]++;
				}
				while (index < freqChars.length && freqChars[index] == 'f') {
					index++;
					countWolf[3]++;
				}
				if (countWolf[0] != countWolf[1] || countWolf[1] != countWolf[2] || countWolf[2] != countWolf[3]) {
					isValidWord = "INVALID";
					break;
				}

			}
		}

		return isValidWord;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(check("wwwwwwwwwwoooooooooollllllllllffffffffffwwoollff"));
		System.out.println(check("wolfwolfwwoollffwolfwwwooolllff"));
		System.out.println(check("wwolfolf"));
	}

}
