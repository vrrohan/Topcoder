package PracticeArena.Easy;

/*
Problem Statement for SquareMaking

Problem Statement
		You have four sticks. Their lengths are a, b, c, and d. There is also a stick altering store. For one coin they can change (i.e., either increase or decrease) the length of any stick by 1. You can use the store as many times as you want. 
		You would like to build a square out of your four sticks. Therefore, you need four sticks that each have the same length. Note that the length must be positive.
		You are given the int's a, b, c, and d. Compute and return the smallest number of coins you need to spend at the store.

Definition    	
Class:	SquareMaking
Method:	getMinimalPrice
Parameters:	int, int, int, int
Returns:	int
Method signature:	int getMinimalPrice(int a, int b, int c, int d)
(be sure your method is public)
    
Constraints
-	a will be between 1 and 1,000,000, inclusive.
-	b will be between 1 and 1,000,000, inclusive.
-	c will be between 1 and 1,000,000, inclusive.
-	d will be between 1 and 1,000,000, inclusive.
 
Examples
0)	5
6
5
5
Returns: 1
Here the optimal solution is to pay 1 coin to decrease b by 1. After the change you will have four equally long sticks.

1)	4
1
5
4
Returns: 4
Here the optimal side length is 4. Hence, you need to pay the store to increase b three times and to decrease c once. The total amount spent at the store will therefore be 4 coins.

2)	
2017
2017
2017
2017
Returns: 0
Here you do not need to change sticks at all.

3)	    	
705451
751563
608515
994713
Returns: 432310
 */

import java.util.stream.IntStream;

public class SRM711SquareMaking {

	public static int getMinimalPrice(int a, int b, int c, int d) {
		int[] minPrice = { Math.abs(a - b) + Math.abs(a - c) + Math.abs(a - d),
				Math.abs(b - a) + Math.abs(b - c) + Math.abs(b - d),
				Math.abs(c - a) + Math.abs(c - b) + Math.abs(c - d),
				Math.abs(d - a) + Math.abs(d - b) + Math.abs(d - c) };
		return IntStream.of(minPrice).min().getAsInt();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMinimalPrice(2017, 2017, 2017, 2017));
		System.out.println(getMinimalPrice(5, 6, 5, 5));
		System.out.println(getMinimalPrice(705451, 751563, 608515, 994713));
	}

}
