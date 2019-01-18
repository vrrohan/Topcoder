package PracticeArena.Easy;

/*
Problem Statement for SwapAndArithmetic

Problem Statement
    	A sequence S is called an arithmetic sequence if there is a number d (called the difference) such that for each i, S[i+1] = S[i] + d. 
    	Note that d may be zero or negative. Examples of arithmetic sequences: {1,2,3}, {3,2,1}, {10,10,10,10}, {47}. 

		You are given a int[] x. You want to change x into an arithmetic sequence. In order to do that, you are allowed to swap any two elements of x. 
		You may perform arbitrarily many such swaps, one after another. For example, you can change {2,1,5,4,3} to {2,1,3,4,5} and then change that sequence to {1,2,3,4,5}. 
Return "Possible" if x can be changed into an arithmetic sequence. Otherwise, return "Impossible". Note that the return value is case-sensitive.
 
Definition
Class:	SwapAndArithmetic
Method:	able
Parameters:	int[]
Returns:	String
Method signature:	String able(int[] x)
(be sure your method is public)
    
Constraints
-	x will contain between 2 and 50 elements, inclusive.
-	Each element in x will be between 0 and 1,000, inclusive.
 
Examples
0)	{3,1,2}
Returns: "Possible"
We can swap the last two elements to change the given x to {3, 2, 1}, which is an arithmetic sequence.

1)	{1,2,4}
Returns: "Impossible"
We can change x to one of the following 6 sequences:
{1,2,4}
{1,4,2}
{2,1,4}
{2,4,1}
{4,1,2}
{4,2,1}
There is no arithmetic sequence among these six sequences.

2)	{1,1,1,1,1,1}
Returns: "Possible"

3)	{1000,704,1}
Returns: "Impossible"

4)	{7,3,11,5,1,9}
Returns: "Possible"
*/

import java.util.stream.IntStream;

public class SwapAndArithmetic {

	public static String able(int[] x) {
		String isSequencePossible = "Possible";
		int[] sortedListOfSequence = IntStream.of(x).sorted().toArray();

		int d = sortedListOfSequence[1] - sortedListOfSequence[0];

		for (int i = 0; i < sortedListOfSequence.length - 1; i++) {
			if (sortedListOfSequence[i] + d != sortedListOfSequence[i + 1]) {
				isSequencePossible = "Impossible";
				break;
			}
		}
		return isSequencePossible;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 7, 3, 11, 5, 1, 9 };
		System.out.println(able(arr));
	}

}
