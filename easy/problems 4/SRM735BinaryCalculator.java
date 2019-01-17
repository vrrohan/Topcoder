package PracticeArena.Easy;

/*
Problem Statement for BinaryCalculator

Problem Statement    	
You have a very simple calculator that has a display and two buttons. The buttons are labelled "-2" and "+3". Whenever you press a button, the corresponding operation is applied to the number shown on the display. 
For example, if the display shows the number 10, pressing the "-2" button changes it to 10-2 = 8, while pressing the "+3" button changes it to 10+3 = 13.
You are given the ints a and b. The display currently shows the integer a. You would like to change the displayed number to b. Calculate and return the smallest total number of buttons you need to press.
 
Definition    	
Class:	BinaryCalculator
Method:	minimumSteps
Parameters:	int, int
Returns:	int
Method signature:	int minimumSteps(int a, int b)
(be sure your method is public)
    
Constraints
-	a will be between 1 and 100, inclusive.
-	b will be between 1 and 100, inclusive.
 
Examples
0)	10
14
Returns: 3
One solution is to press the button +3 to get 13, then -2 to get 11 and finally +3 to get 14. There are other ways of obtaining the same result, but none of them is shorter than 3 presses.

1)	23
23
Returns: 0
As a = b, you don't need to press any buttons.

2)  18
12
Returns: 3
The only optimal solution is to press "-2" three times in a row.

3)	23
62
Returns: 13
 */

public class SRM735BinaryCalculator {

	public static int minimumSteps(int a, int b) {
		int minSteps = 0;
		if (a == b) {
			minSteps = 0;
		} else if (a < b) {
			// move forward by +3
			int num = b - a;
			if (num % 3 == 0) {
				minSteps = num / 3;
			} else {
				a = a + (num / 3) * 3;
				minSteps = num / 3;
				if (b - a == 1) {
					a = a + 3;
					minSteps++;
				} else if (b - a == 2) {
					a = a + 6;
					minSteps = minSteps + 2;
				} // else if ends...

				minSteps = minSteps + (a - b) / 2;
			} // else ends...

		} // else if a<b ends...
		else if (a > b) {
			int num = a - b;
			if (num % 2 == 0) {
				minSteps = num / 2;
			} else {
				a = a - (num / 2) * 2;
				minSteps = num / 2;
				if (a - b == 1) {
					a = a - 4;
					minSteps = minSteps + 2;
				}

				minSteps = minSteps + (b - a) / 3;
			} // else ends...
		} // else if a>b ends...
		return minSteps;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("minimum steps a=10, b=14 is : " + minimumSteps(10, 14));
		System.out.println("minimum steps a=23, b=23 is : " + minimumSteps(23, 23));
		System.out.println("minimum steps a=18, b=12 is : " + minimumSteps(18, 12));
		System.out.println("minimum steps a=23, b=62 is : " + minimumSteps(23, 62));
	}

}
