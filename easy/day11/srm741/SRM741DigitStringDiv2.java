package PracticeArena.Easy;

/*
Problem Statement for DigitStringDiv2
Problem Statement
    	
	You are given a digit string S and a positive integer integer X. We want to select a non-empty contiguous substring of S such that:
	The substring does not begin with the digit '0'.
	When you convert it to a number, its value is strictly greater than X.
	Two ways of selecting a substring are different if they begin or end at a different index.
	Compute and return the number of ways in which we can select a substring with the above properties.

Definition    	
Class:	DigitStringDiv2
Method:	count
Parameters:	String, int
Returns:	int
Method signature:	int count(String S, int X)
(be sure your method is public)
    
Constraints
-	S will contain between 1 and 9 characters, inclusive.
-	Each character of S will be a digit ('0'-'9').
-	X will be between 0 and 777,444,111, inclusive.
 
Examples
0)	"0"
1
Returns: 0

1)	"10"
9
Returns: 1

2)	"471"
47
Returns: 2
We can select either the substring "471" or the substring "71".

3)	"2222"
97
Returns: 3
We can select the entire string S ("2222"). We also have two different ways to select the string "222": either we choose the first three or the last three characters of S 
*/

public class SRM741DigitStringDiv2 {

	public static int count(String S, int X) {
		int totalGreaterSubstrings = 0;
		for (int i = 0; i < S.length(); i++) {
			for (int j = i; j < S.length(); j++) {
				if (!S.substring(i, j + 1).startsWith("0")) {
					if (Integer.parseInt(S.substring(i, j + 1)) > X) {
						totalGreaterSubstrings++;
					}
				}
			}
		}
		return totalGreaterSubstrings;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count("0", 1));
	}

}
