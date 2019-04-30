package PracticeArena.Easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Problem Statement for CubeAnts
Problem Statement
    	
	NOTE: This problem statement contains images that may not display properly if viewed outside of the applet.
	Fox Ciel is observing the behavior of ants. She has a cube whose vertices are indexed from 0 to 7 as follows.
	You are given a int[] pos containing the initial locations of the ants. The i-th element of pos is the index of the vertex where the i-th ant is located. In an attempt to observe their moves, Ciel puts honey on the 0-th vertex. The ants notice it immediately and start moving toward the honey. In a single turn, each ant will either move to an adjacent vertex along an edge of the cube or stay in its current vertex. 
	All moves in a turn happen simultaneously, and at all times, it is legal for multiple ants to be at the same location of the cube.
	Ciel observes the ants until they all move to the 0-th vertex. In order to determine how clever they were, she wants to know the minimal number of turns that were required for this to happen. Return this minimal number.

 
Definition	
Class:	CubeAnts
Method:	getMinimumSteps
Parameters:	int[]
Returns:	int
Method signature:	int getMinimumSteps(int[] pos)
(be sure your method is public)
 
Constraints
-	pos will contain between 1 and 50 elements, inclusive.
-	Each element of pos will be between 0 and 7, inclusive.
 
Examples
0)	{0,1,1}
Returns: 1

1)	{5,4}
Returns: 2

2)	{0}
Returns: 0
There is only one ant, and it is already on the 0-th vertex, so the minimum number of turns required is 0.

3)	{6,1,6}
Returns: 3

4)	{7,7,3,3,7,7,3,3}
Returns: 2
*/

public class SRM507CubeAnts {

	public static int getMinimumSteps(int[] pos) {
		List<Integer> maxPositionSteps = Arrays.stream(pos).boxed().collect(Collectors.toList());
		return (maxPositionSteps.contains(6)) ? 3
				: (maxPositionSteps.contains(2) || maxPositionSteps.contains(5) || maxPositionSteps.contains(7)) ? 2
						: (maxPositionSteps.contains(1) || maxPositionSteps.contains(3) || maxPositionSteps.contains(4))
								? 1 : 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMinimumSteps(new int[] { 7, 7, 1, 6, 4, 1, 7, 6, 6, 6, 2, 3, 2, 7, 4, 5, 2, 4, 6, 1, 7, 2,
				5, 6, 1, 2, 7, 5, 4, 3, 5, 4, 2, 7, 3, 1, 5, 1, 3, 7 }));
		System.out.println(getMinimumSteps(new int[] { 4, 3, 3, 1, 3, 4, 1, 3, 1, 3, 3, 1, 4, 4, 4, 4, 1, 4, 3, 4 }));
	}

}
