package PracticeArena.Easy;

/*
Problem Statement for CopyingHomework
Problem Statement
    	"Dude, can I copy your homework?"
        "Sure, but change it a little, so it doesn't look like we cheated."
        You are given the int[] friendsHomework containing the five values your friend measured for their Physics homework. Construct and return a int[] yourHomework with the following properties:
yourHomework must have exactly 5 elements.
For each i, yourHomework[i] must differ from friendsHomework[i] (so it doesn't look like you cheated).
For each i, the difference between yourHomework[i] and friendsHomework[i] must be at most 10 (so that the values are similar).
The sum of yourHomework must be the same as the sum of friendsHomework (so that you both get the same final result).

Definition
Class:	CopyingHomework
Method:	copy
Parameters:	int[]
Returns:	int[]
Method signature:	int[] copy(int[] friendsHomework)
(be sure your method is public)

Notes
-	Any valid solution will be accepted.

Constraints
-	friendsHomework will contain exactly 5 elements.
-	Each element of friendsHomework will be between 0 and 1000, inclusive.

Examples
0)	{10, 20, 30, 40, 50}
Returns: {9, 19, 29, 39, 54 }

1)	{0, 0, 0, 0, 0}
Returns: {-1, -1, -1, -1, 4 }
Note that the values in yourHomework may lie outside the range [0,1000]. As long as they satisfy the constraints from the problem statement, you have a valid answer.

2)	{400,399,400,399,400}
Returns: {399, 398, 399, 398, 404 }
 */

import java.util.stream.IntStream;

public class SRM748CopyingHomework {

	public static int[] copy(int[] friendsHomework) {
		int[] yourHomework = new int[friendsHomework.length];
		int totalHomeworkSum = IntStream.of(friendsHomework).sum();
		for (int i = 0; i < friendsHomework.length - 1; i++) {
			yourHomework[i] = friendsHomework[i] - 1;
			totalHomeworkSum -= yourHomework[i];
		}
		yourHomework[yourHomework.length - 1] = totalHomeworkSum;
		return yourHomework;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] friendsHomeWork = { 10, 20, 30, 40, 50 };
		int[] friendsHomeWork2 = { 0, 0, 0, 0, 0 };
		int[] friendsHomeWork3 = { 400, 399, 400, 399, 400 };
		int[] getYourHomework = copy(friendsHomeWork);
		for (int scores : getYourHomework) {
			System.out.print(scores + " ");
		}
	}

}
