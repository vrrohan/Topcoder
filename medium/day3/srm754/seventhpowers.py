"""
Problem Statement for SeventhPowers
Problem Statement

	Alice had some positive integer A with at most 500 digits. Bob looked at A and computed the number B: the sum of seventh powers of digits of A.
	For example, if Alice had the number A = 407, Bob computed the number B = 4^7 + 0^7 + 7^7 = 839927.
	You are given the number B. Find and return a String containing the decimal representation of any valid number A.

Definition
Class:	SeventhPowers
Method:	reconstructA
Parameters:	int
Returns:	String
Method signature:	String reconstructA(int B)
(be sure your method is public)

Notes
-	The answer always exists.
-	Any valid answer will be accepted. (Remember that A must have at most 500 digits.)
-	The String you return cannot have leading zeros.

Constraints
-	B will be between 1 and 10,000,000, inclusive.

Examples
0)	839927
Returns: "407"

1)	130
Returns: "121"

2)	43740
Returns: "33333333333333333333"
20 * 3^7 = 43,740.
"""
def reconstruct(numberB) :
    numberA = ''
    powersOfSeven = [x**7 for x in range(0, 10)]
    while numberB!=0 :
        for i in range(9, 0, -1) :
            if (numberB >= powersOfSeven[i]) :
                numberB = numberB - powersOfSeven[i]
                numberA = numberA + str(i)
                break
    return numberA

print(reconstruct(130))
print(reconstruct(6584637))
