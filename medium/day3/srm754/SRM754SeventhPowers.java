package PracticeArena.Medium;

/*
Problem Statement for SeventhPowers
Problem Statement
    	
	Alice had some positive integer A with at most 500 digits. Bob looked at A and computed the number B: the sum of seventh powers of digits of A.
	For example, if Alice had the number A = 407, Bob computed the number B = 4^7 + 0^7 + 7^7 = 839927.
	You are given the number B. Find and return a String containing the decimal representation of any valid number A.

Definition    	
Class:	SeventhPowers
Method:	reconstructA
Parameters:	int
Returns:	String
Method signature:	String reconstructA(int B)
(be sure your method is public)
    
Notes
-	The answer always exists.
-	Any valid answer will be accepted. (Remember that A must have at most 500 digits.)
-	The String you return cannot have leading zeros.
 
Constraints
-	B will be between 1 and 10,000,000, inclusive.
 
Examples
0)	839927
Returns: "407"

1)	130
Returns: "121"

2)	43740
Returns: "33333333333333333333"
20 * 3^7 = 43,740.
*/

public class SRM754SeventhPowers {

	public static String reconstructA(int B) {
		String numberA = "";
		int[] powersOfSeven = new int[10];
		for (int i = 0; i < 10; i++) {
			powersOfSeven[i] = (int) Math.pow(i, 7);
		}

		while (B != 0) {
			for (int i = 9; i >= 1; i--) {
				if (B >= powersOfSeven[i]) {
					B -= powersOfSeven[i];
					numberA += String.valueOf(i);
					break;
				}
			}
		}

		return numberA;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reconstructA(6584637));

	}

}
