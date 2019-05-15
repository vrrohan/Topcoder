package PracticeArena.Easy;

/*
Problem Statement for VerifyCreditCard
Problem Statement
    	You are developing an application for online transactions and you want to accept several credit cards. Card numbers, however, are usually long, so it's easy to make mistakes when typing them in. 
    	You want to create a method that will verify the numbers entered by users. 
		You know that the Luhn formula applies for all the acceptable card numbers. The Luhn formula works as follows. 
		
		First, separate the individual digits of the credit card number. For example: 21378 becomes 2 1 3 7 8 

		If there is an even number of digits, multiply each digit in an odd position by 2. Otherwise, multiply each digit in an even position by 2. Positions are 1-indexed, so the first digit is at position 1. 
		The example number above contains an odd number of digits, so we multiply each digit in an even position by 2: 2 1 3 7 8 becomes 2 2 3 14 8 

		Note that the even positions refer to the original number so they don't change even when a 2-digit number appears. 

		Finally, take the sum of all the digits (for 2-digit numbers insert both the digits separately into the sum): 2+2+3+1+4+8 = 20 
		If the sum is a multiple of 10, the number is valid. Otherwise, it is invalid. 
		Given a String cardNumber containing the credit card number, return "VALID" if the card number is valid, or "INVALID" if it is invalid (all quotes for clarity).
 
Definition
Class:	VerifyCreditCard
Method:	checkDigits
Parameters:	String
Returns:	String
Method signature:	String checkDigits(String cardNumber)
(be sure your method is public)
    
Constraints
-	cardNumber will contain between 1 and 50 characters, inclusive.
-	Each character in cardNumber will be a digit ('0'-'9').
 
Examples
0)	"21378"
Returns: "VALID"
This number has 5 digits, which is an odd number, so we multiply the digits in even positions by 2 to get: 2 2 3 14 8 
The sum of the digits is 20, which is a multiple of 10, meaning it's a valid number.

1)	"31378"
Returns: "INVALID"
When we apply the Luhn formula here, the sum of the digits is 21, so the number is invalid.

2)	"11111101"
Returns: "VALID"
We multiply the digits in odd positions by 2 to get: 
2 1 2 1 2 1 0 1 
The sum of the digits is 10, so it's a valid card.

3)	"50005"
Returns: "VALID"
All the digits in even positions are 0 so multiplying by 2 doesn't change the number. The sum of the digits is 10, so it's a valid card.

4)	"542987223412"
Returns: "INVALID" 
*/

public class SRM396VerifyCreditCard {

	public static String checkDigits(String cardNumber) {
		int cardNumberSum = 0;
		// if card number length is even
		if (cardNumber.length() % 2 == 0) {
			for (int i = 0; i < cardNumber.length(); i++) {
				if (i % 2 == 0) {
					// first get all numbers at odd position
					int numberAtOddPosition = Integer.parseInt(String.valueOf(cardNumber.charAt(i)));

					// multiply those number with 2
					String numberAfterMultiplication = String.valueOf(numberAtOddPosition * 2);

					// extract each digit of that number to add it to actual sum
					// i.e. cardNumberSum
					for (int dig = 0; dig < numberAfterMultiplication.length(); dig++) {
						cardNumberSum += Integer.parseInt(String.valueOf(numberAfterMultiplication.charAt(dig)));
					}
				} else {
					cardNumberSum += Integer.parseInt(String.valueOf(cardNumber.charAt(i)));
				}
			}

		} else {
			for (int i = 0; i < cardNumber.length(); i++) {
				if (i % 2 != 0) {
					// first get all numbers at odd position
					int numberAtOddPosition = Integer.parseInt(String.valueOf(cardNumber.charAt(i)));

					// multiply those number with 2
					String numberAfterMultiplication = String.valueOf(numberAtOddPosition * 2);

					// extract each digit of that number to add it to actual sum
					// i.e. cardNumberSum
					for (int dig = 0; dig < numberAfterMultiplication.length(); dig++) {
						cardNumberSum += Integer.parseInt(String.valueOf(numberAfterMultiplication.charAt(dig)));
					}
				} else {
					cardNumberSum += Integer.parseInt(String.valueOf(cardNumber.charAt(i)));
				}
			}

		}

		if (cardNumberSum % 10 == 0) {
			return "VALID";
		} else {
			return "INVALID";
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkDigits("21378"));
		System.out.println(checkDigits("11111101"));
		System.out.println(checkDigits("542987223412"));
	}

}
