package PracticeArena.Medium;

/*
Problem Statement for CycleLength
Problem Statement
    	Hermi has read somewhere that one of the measures of quality for a pseudorandom generator is the length of its period. Help him test some simple generators for this property.
		Formally, the period length of an infinite sequence { A[0], A[1], A[2], ... } is the smallest positive integer p such that starting from some n=n0 we have A[n+p] = A[n] for all n. 
		Of course, some infinite sequences don't have any period, but those in this problem will all have some finite periods.
		Note that the period doesn't have to start right at the beginning of the sequence. For example, suppose we have the sequence { 4, 7, 1024, 15, 1, 2, 3, 1, 2, 3, 1, 2, 3, ... } that goes on by repeating 1, 2, 3 forever. 
		The length of the period of this sequence is 3.
		
		Hermi's generators are linear congruential generators. You are given the parameters of one generator: the ints seed, a, b, and m. The generator itself is shown below. Compute and return the length of its period.

		state = seed
		while True:
    		print(state)
    		state = (state * a + b) modulo m
 
Definition
Class:	CycleLength
Method:	solve
Parameters:	int, int, int, int
Returns:	int
Method signature:	int solve(int seed, int a, int b, int m)
(be sure your method is public)
    
Notes
-	It can be shown that the output of the generator always has a finite period.
 
Constraints
-	m will be between 1 and 10^6, inclusive.
-	seed, a and b will each be between 0 and m-1, inclusive.
 
Examples
0)	7
3
4
10
Returns: 4
The generated sequence is {7, 5, 9, 1, 7, 5, 9, 1, 7, 5, 9, 1, ...} and its period length is 4.

1)	1
2
0
997
Returns: 332
The sequence begins {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 27, ...}. Eventually it starts repeating itself.

2)	47
0
23
100
Returns: 1
The sequence {47, 23, 23, 23, 23, 23, 23, 23, 23, ...} has period length 1.

3)	548687
538918
376524
931161
Returns: 690
Watch out for integer overflow when generating the sequence! The correct first few elements of this sequence are { 548687, 52352, 564521, 120560, 571829, 653435, 861713, 684494, 565739, 54179, 930530, 193031, ... }
*/

import java.util.LinkedList;

public class SRM747CycleLength {

	public static int solve(int seed, int a, int b, int m) {
		LinkedList<Long> seedSequence = new LinkedList<Long>();
		long state = seed;
		int seedSequenceLength = 1;
		seedSequence.add(state);
		while (true) {
			// calculate state
			state = (state * a + b) % m;

			// check if state if present in list or not
			if (seedSequence.contains(state)) {
				seedSequenceLength = seedSequence.size() - seedSequence.indexOf(new Long(state));
				break;
			} else {
				seedSequence.add(state);
			}

		}

		return seedSequenceLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(47, 0, 23, 100));
		System.out.println(solve(548687, 538918, 376524, 931161));
	}

}
