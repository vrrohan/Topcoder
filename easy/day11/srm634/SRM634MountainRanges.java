package PracticeArena.Easy;

/*
Problem Statement for MountainRanges
Problem Statement
    	
	Tom is in charge of a tourist agency. He has a lovely picture of the local mountain range. He would like to sell it to the tourists but first he needs to know how many peaks are visible in the picture.
	The mountain range in the picture can be seen as a sequence of heights. You are given these heights as a int[] height. An element of height is called a peak if its value is strictly greater than each of the values of adjacent elements. 
	Compute and return the number of peaks in the given mountain range.

Definition    	
Class:	MountainRanges
Method:	countPeaks
Parameters:	int[]
Returns:	int
Method signature:	int countPeaks(int[] heights)
(be sure your method is public)
    
Constraints
-	heights will contain between 1 and 50 elements, inclusive.
-	Each element of heights will be between 1 and 100, inclusive.
 
Examples
0)	{5, 6, 2, 4}
Returns: 2
Element 1 (0-based index) is a peak. Its height is 6, which is strictly greater than each of its neighbors' heights (5 and 2). Element 3 is also a peak since its height is 4 and that is strictly greater than its neighbor's height (which is 2).

1)	{1, 1, 1, 1, 1, 1, 1}
Returns: 0
This is a very flat mountain with no peaks.

2)	{2, 1}
Returns: 1
Element 0 is a peak.

3)	{2,5,3,7,2,8,1,3,1}
Returns: 4
The peaks here are the elements with 0-based indices 1, 3, 5, and 7. Their heights are 5, 7, 8, and 3, respectively.

4)	{1}
Returns: 1
Element 0 is a peak. Even though it has no neighbors, the condition from the problem statement is still satisfied.

5)	{1,2,3,4,4,3,2,1}
Returns: 0
According to our definition there is no peak in this mountain range.
*/

public class SRM634MountainRanges {

	public static int countPeaks(int[] heights) {
		int totalPeaks = 0;
		if (heights.length == 1) {
			return 1;
		}
		for (int i = 0; i < heights.length; i++) {
			totalPeaks = (i == 0 && heights[i] > heights[i + 1]) ? totalPeaks + 1
					: (i == heights.length - 1 && heights[i] > heights[i - 1]) ? totalPeaks + 1
							: (i > 0 && i <= heights.length - 2 && heights[i] > heights[i - 1]
									&& heights[i] > heights[i + 1]) ? totalPeaks + 1 : totalPeaks;
		}

		return totalPeaks;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = { 55, 27, 91, 86, 50, 21, 95, 98, 7, 93, 46, 95, 63, 89, 93, 71, 41, 25, 75, 64, 36, 72, 56, 47,
				3, 7, 97, 34, 83, 75, 83, 25, 56, 41, 13, 26, 92, 34, 55, 99, 12, 71, 24, 94, 91, 83, 51 };
		System.out.println(countPeaks(heights));
	}

}
