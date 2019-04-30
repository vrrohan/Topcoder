package PracticeArena.Easy;

/*
Problem Statement for FoxAndIntegers
Problem Statement
    	
	Fox Jiro and Eel Saburo are good friends. One day Jiro received a letter from Saburo. The letter contains four integers representing an encrypted message. Please help Jiro to decrypt the message.
	You are given four ints: AminusB, BminusC, AplusB, and BplusC. Your task is to find three integers A, B, and C such that:

	AminusB = A - B
	BminusC = B - C
	AplusB = A + B
	BplusC = B + C
	
	There is always at most one triplet of integers A, B, C that satisfies all four equalities. If it exists, return a int[] with exactly three elements: { A, B, C }. If there are no such integers, return an empty int[] instead.

Definition	
Class:	FoxAndIntegers
Method:	get
Parameters:	int, int, int, int
Returns:	int[]
Method signature:	int[] get(int AminusB, int BminusC, int AplusB, int BplusC)
(be sure your method is public)
    
Constraints
-	AminusB will be between -30 and 30, inclusive.
-	BminusC will be between -30 and 30, inclusive.
-	AplusB will be between -30 and 30, inclusive.
-	BplusC will be between -30 and 30. inclusive.
 
Examples
0)	
1
-2
3
4
Returns: {2, 1, 3 }
A - B = 2 - 1 = 1
B - C = 1 - 3 = -2
A + B = 2 + 1 = 3
B + C = 1 + 3 = 4

1)	    	
0
0
5
5
Returns: { }
A = B = C = 2.5 satisfy all four equalities, but A, B, and C must all be integers.

2)	    	
10
-23
-10
3
Returns: {0, -10, 13 }
A, B, and C may be negative or zero.

3)	    	
-27
14
13
22
Returns: { }

4)	    	
30
30
30
-30
Returns: {30, 0, -30 }
*/

public class SRM535FoxAndIntegers {

	public static int[] get(int AminusB, int BminusC, int AplusB, int BplusC) {
		if ((AminusB + AplusB) % 2 == 0 && (BminusC + BplusC) % 2 == 0) {
			int A = (AminusB + AplusB) / 2;
			int B = (BminusC + BplusC) / 2;
			int C = BplusC - B;

			if (((A - B) == AminusB) && ((B - C) == BminusC) && ((A + B) == AplusB) && ((B + C) == BplusC)) {
				return new int[] { A, B, C };
			} else {
				return new int[] {};
			}
		} else {
			return new int[] {};
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] threeInts = get(-14, 27, 11, -24);
		for (int i : threeInts) {
			System.out.print(i + " ");
		}

	}

}
