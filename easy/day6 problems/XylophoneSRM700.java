package PracticeArena.Easy;
/*
Problem Statement for Xylophone

Problem Statement
    	
	A xylophone is a musical instrument that consists of a sequence of wooden bars. In order to make a sound, you have to strike one of the bars by a mallet.
	For the purpose of this problem we will assume that our xylophone has exactly 50 bars. The bars are numbered from 1 to 50 in the order from the left to the right.
	There are 7 notes: A, B, C, D, E, F, G. Each bar of our xylophone plays one of these notes. The notes repeat periodically. When you play the bars from the left to the right, you will hear the following sequence of notes: A,B,C,D,E,F,G,A,B,C,D,E,F,G,A,B,C,...
	In other words: bar 1 produces the note A, bar 2 plays B, bar 3 plays C, ..., bar 7 plays G, and then the sequence of notes starts repeating: bar 8 plays the note A again, bar 9 is B, and so on.
	You have hit a sequence of bars. You are given their numbers in the int[] keys. Return the number of distinct notes you've hit.

Definition    	
Class:	Xylophone
Method:	countKeys
Parameters:	int[]
Returns:	int
Method signature:	int countKeys(int[] keys)
(be sure your method is public)
    
Constraints
-	keys will contain between 1 and 50 elements, inclusive.
-	Each element of keys will be between 1 and 50, inclusive.
 
Examples
0)	{1,8,3}
Returns: 2
If you hit the keys 1,8,3, you have played the notes A,A,C. This means you have hit two distinct notes: A and C.

1)	{7,3,2,4,1,5,6}
Returns: 7
In this case you have played 7 distinct notes, each of them exactly once.

2)	{1,8,15}
Returns: 1
Although these are all distinct keys, these keys all have the same note, so they are counted as one.

3)	{25,1,17,9,8}
Returns: 4

4)	{11,11,11,11,11,11,11,11,11,11,11}
Returns: 1

5)	{50,10,20,30,11,30,24,38,5,2,9}
Returns: 6
*/

import java.util.HashSet;

public class XylophoneSRM700 {

	public static int countKeys(int[] keys) {
		HashSet<Character> hs = new HashSet<Character>();

		char[] notes = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		for (int i = 0; i < keys.length; i++) {
			hs.add(notes[keys[i] % 7]);
		}
		return hs.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] keys = { 7, 3, 2, 4, 1, 5, 6 };
		int[] keys2 = { 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11 };
		int[] keys3 = { 50, 10, 20, 30, 11, 30, 24, 38, 5, 2, 9 };
		int[] keys4 = { 25, 1, 17, 9, 8 };
		System.out.println(countKeys(keys3));
	}

}
