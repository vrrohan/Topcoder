package PracticeArena.Easy;

/*
Problem Statement for Cryptography
Problem Statement
    	TopCoder Security Agency (TSA, established today) has just invented a new encryption system! This encryption system takes as its input a list of numbers to encrypt. 
		You work at TSA and your task is to implement a very important part of the encryption process. You are allowed to pick one number in the input list and increment its value by 1. This should be done in such way that the product of all numbers in the list after this change becomes as large as possible. 
		Given the list of numbers as int[] numbers, return the maximum product you can obtain. It is guaranteed that the return value will not exceed 2^62.
 
Definition    	
Class:	Cryptography
Method:	encrypt
Parameters:	int[]
Returns:	long
Method signature:	long encrypt(int[] numbers)
(be sure your method is public)
 
Constraints
-	numbers will contain between 2 and 50 elements, inclusive.
-	Each element of numbers will be between 1 and 1000, inclusive.
-	The return value will not exceed 2^62.
 
Examples
0)	{1,2,3}
Returns: 12
If we increment the first number, we get 2*2*3 = 12. If we increment the second, we get 1*3*3 = 9. If we increment the third, we get 1*2*4 = 8. Hence, the correct return value is 12.

1)	{1,3,2,1,1,3}
Returns: 36
The elements of numbers are not necessarily unique.

2)	{1000,999,998,997,996,995}
Returns: 986074810223904000
The answer may be very big, but will not exceed 2^62.

3)	{1,1,1,1}
Returns: 2
*/

import java.util.stream.IntStream;

public class SRM480Cryptography {

	public static long encrypt(int[] numbers) {
		long maxProduct = 1;
		int minNumber = IntStream.of(numbers).min().getAsInt();
		boolean isIncremented = true;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == minNumber && isIncremented) {
				maxProduct *= numbers[i] + 1;
				isIncremented = false;
			} else {
				maxProduct *= numbers[i];
			}
		}
		return maxProduct;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(encrypt(new int[] { 1, 3, 2, 1, 1, 3 }));
		System.out.println(encrypt(new int[] { 1000, 999, 998, 997, 996, 995 }));
		System.out.println(encrypt(new int[] { 4, 2, 4, 2, 1, 1, 4, 7, 1, 3, 2, 1, 3, 5, 2, 2, 2, 1, 5, 5, 2, 1, 3, 4,
				5, 6, 1, 1, 2, 6, 2, 3, 1, 3, 9, 6, 3, 2, 1, 1, 5, 2, 3, 5, 1, 1, 1, 1, 3, 2 }));
	}

}
