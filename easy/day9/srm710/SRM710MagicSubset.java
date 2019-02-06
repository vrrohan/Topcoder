package PracticeArena.Easy;

/*
Problem Statement for MagicSubset
Problem Statement
    	You are given n stones labeled from 0 to n-1. Each stone has an integer value: the value of stone i is value[i]. Note that some of those values may be negative or zero.
		You would like to choose a subset of stones such that the sum of their values is maximized. (You are allowed to choose the empty subset. In that case, the sum of the values of the chosen stones is zero.)
		This would be an easy problem, but there is a catch: the stone labeled 0 has magical properties. If you include this stone into your chosen subset, its entire sum is multiplied by -1. (The value of stone 0 still contributes to the sum. See Example 1.)
		You are given the int[] value containing n elements: the values of your stones. Find and return the maximum sum of a subset of stones, given that the sum of any subset that contains stone 0 is negated.

Definition    	
Class:	MagicSubset
Method:	findBest
Parameters:	int[]
Returns:	int
Method signature:	int findBest(int[] values)
(be sure your method is public)
    
Notes
-	The value of n is not given explicitly. Instead, you can determine it as the number of elements in value."
 
Constraints
-	value will contain between 1 and 50 elements, inclusive.
-	Each element of value will be between -100 and 100, inclusive.
 
Examples
0)	{1,10,4,-6,3}
Returns: 17
There are five stones. The magic stone 0 has value 1. In this case, it is optimal to ignore the magic stone and to choose only the stones labeled 1, 2, and 4. The sum of their values is 10 + 4 + 3 = 17.

1)	{3,-5,1,-6}
Returns: 8
In this case the optimal choice is to take the stones labeled 0, 1, and 3. The sum of their values is 3 + (-5) + (-6) = -8. However, since we included the magic stone 0, we have to multiply this sum by -1, getting the final value (-8) * (-1) = 8.

2)	{0,0,0,0,0,0,0,0,0}
Returns: 0
Stones can also have value 0.

3)	{-100}
Returns: 100

4)  {100}
Returns: 0
In this case, we don't take any stones.

5)	{-3,1,-4,1,5,-9,2,6,-5,3,5}
Returns: 23
*/

public class SRM710MagicSubset {

	public static int findBest(int[] values) {
		int posSum = 0;
		int negSum = values[0];
		for (int i = 1; i < values.length; i++) {
			if (values[i] >= 0) {
				posSum += values[i];
			} else {
				negSum += values[i];
			}
		}

		negSum *= -1;
		return Math.max(posSum, negSum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findBest(new int[] { -3, 1, -4, 1, 5, -9, 2, 6, -5, 3, 5 }));
		System.out.println(findBest(new int[] { 12, 6, 46, 20, 22, -40, 41, 29, 27, -22, -33, -6, -30, -11, -50, 35,
				-39, 14, 38, 32, -29, 21, -3, -36, 5, -33, 50, 18, -47, 16, 44, 2, -15, -19, -1, 25, -40, -17, -17, 14,
				-34, -22, -43, 31, 28, -35, -36, 22 }));
		System.out.println(findBest(new int[] { -38, 76, 4, 79, -26, -23, 6, -73, 92, -44, 13, -38, -39, -100, 6, 86,
				-66, -71, 82, -100, -29, 84, 65, -40, -48, 97, -22, 10, -67, 86, -76, -32, -9, 83, -30, 70, 61, -76,
				-40, -32, -26, -61, -88, 89, -31, 57, -91, 80, 66, 95 }));
	}

}
