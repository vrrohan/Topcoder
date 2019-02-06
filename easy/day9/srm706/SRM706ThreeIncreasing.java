package PracticeArena.Easy;
/*
Problem Statement for ThreeIncreasing
Problem Statement
    	
	Bear Limak has three boxes arranged in a row. The first box currently contains a candies, the second one contains b candies, and the third one contains c candies.
	Limak thinks that the three boxes would look nice if they had the following two properties:
	Each box should contain at least one candy.
	The numbers of candies should form a strictly increasing sequence. In other words, the first box should contain fewer candies than the second box, and the second box should contain fewer candies than the third one.
	Limak can only modify the current content of the boxes in one way: he can eat some of the candies.
	You are given the ints a, b, and c. Compute and return the smallest possible number of candies Limak should eat in order to make his three boxes look nice. If he has no way to make his boxes look nice, return -1 instead.

Definition    	
Class:	ThreeIncreasing
Method:	minEaten
Parameters:	int, int, int
Returns:	int
Method signature:	int minEaten(int a, int b, int c)
(be sure your method is public)
    
Constraints
-	a, b and c will each be between 1 and 3000, inclusive.
 
Examples
0)	15
40
22
Returns: 19
Limak can eat 19 candies from the second box. Numbers of candies will form a strictly increasing sequence {15, 21, 22}. Limak can't achieve a strictly increasing sequence after eating fewer than 19 candies, so the answer is 19.

1)	5
6
6
Returns: 2
Note that in a strictly increasing sequence every number should be strictly lower than the next number (ties are not allowed). Here, Limak can eat 1 candy from the first box and 1 candy from the second box, which results in a sequence {4, 5, 6}. The answer is 2 because Limak eats 2 candies.

2)	6
1
3000
Returns: -1
Here, the second box contains only 1 candy. The first box should contain a smaller number of candies so Limak would have to eat all candies there. A box can't become empty though, so the answer is -1.

3)	6
4
2
Returns: -1
As in the previous example, Limak cannot produce a strictly increasing sequence of candy counts without emptying one of the boxes.

4)	4
2
6
Returns: 3
Limak can eat 3 candies from the first box.

5)	1
1234
3000
Returns: 0
Limak doesn't have to eat any candies. Boxes aren't empty and the sequence {1, 1234, 3000} is strictly increasing.

6)	2789
2400
1693
Returns: 1806 
*/

public class SRM706ThreeIncreasing {

	public static int minEaten(int a, int b, int c) {
		int minCandiesEaten = 0;

		if (b >= c) {
			minCandiesEaten += b - c + 1;
			b = c - 1;
		}
		if (a >= b) {
			minCandiesEaten += a - b + 1;
			a = b - 1;
		}
		if (a <= 0 | b <= 0 | c <= 0) {
			minCandiesEaten = -1;
		}

		return minCandiesEaten;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minEaten(6, 4, 2));
	}

}
