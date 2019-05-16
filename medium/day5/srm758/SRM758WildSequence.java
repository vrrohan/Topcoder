package PracticeArena.Medium;

/*
Problem Statement for WildSequence
Problem Statement
    	A sequence of distinct integers is called wild if it has the following properties:

		It never increases twice in a row.
		It never decreases twice in a row.
		
		For example, {4, 7, 3, 9, 1, 5, 2} is a wild sequence but {4, 7, 3, 6, 9, 1, 5, 2} is not, as it increases twice in a row: from 3 to 6 and then from 6 to 9.
		You are given the int head and the int[] rest. Construct any wild sequence that begins with head and continues with the elements of rest, in an order of your choice. You must use each element of rest exactly once and you cannot use any other numbers in your sequence. 
		Return the answer as a int[]. Any valid wild sequence will be accepted. If there is no valid wild sequence, return an empty int[] instead.

Definition    	
Class:	WildSequence
Method:	construct
Parameters:	int, int[]
Returns:	int[]
Method signature:	int[] construct(int head, int[] rest)
(be sure your method is public)
    
Constraints
-	head will be between 0 and 10^6, inclusive.
-	rest will contain between 0 and 49 elements, inclusive.
-	Each element of rest will be between 0 and 10^6, inclusive.
-	The elements of rest will be distinct.
-	head will be distinct from all elements of rest.
 
Examples
0)	20
{10, 30}
Returns: {20, 10, 30 }
Both {20, 10, 30} and {20, 30, 10} are correct answers. You may return either of them.

1)	20
{10, 30, 40}
Returns: {20, 10, 40, 30 }
This time, there are three correct answers: {20, 10, 40, 30}, {20, 30, 10, 40}, and {20, 40, 10, 30}. You may return any one of these sequences.

2)	4
{1, 2, 3, 6, 7, 5}
Returns: {4, 7, 5, 6, 1, 3, 2 }
*/

import java.util.ArrayList;
import java.util.Collections;

public class SRM758WildSequence {

	public static int[] construct(int head, int[] rest) {
		int[] wildSequence = new int[rest.length + 1];
		int next = 0;
		wildSequence[next++] = head;

		if (rest.length > 0) {
			ArrayList<Integer> restList = new ArrayList<Integer>();
			for (int i = 0; i < rest.length; i++) {
				restList.add(rest[i]);
			}

			int minimumListElement = Collections.min(restList).intValue();
			if (minimumListElement > head) {
				for (int j = 0; j < rest.length; j++) {
					wildSequence[next++] = (j % 2 == 0) ? Collections.max(restList).intValue()
							: Collections.min(restList).intValue();
					restList.remove(new Integer(wildSequence[next - 1]));
				}
			} else {
				for (int j = 0; j < rest.length; j++) {
					wildSequence[next++] = (j % 2 == 0) ? Collections.min(restList).intValue()
							: Collections.max(restList).intValue();
					restList.remove(new Integer(wildSequence[next - 1]));
				}
			}
		}

		return wildSequence;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] wildSequence = construct(540325,
				new int[] { 863537, 222268, 727121, 285693, 609805, 466954, 608087, 439850, 319779, 277780, 139767,
						921159, 405902, 222992, 870002, 252714, 834141, 847673, 965823, 612782, 708668, 126529, 798696,
						634794, 170805, 48344, 802147, 40287, 443720, 287283, 975600, 259554, 34911, 59140, 756276,
						678202, 337218, 125695, 436456, 164468, 309359, 261292, 966880, 518704, 357285 });
		for (int seq : wildSequence) {
			System.out.print(seq + " ");
		}
	}

}
