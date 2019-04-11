"""
Problem Statement for DigitStringDiv2
Problem Statement

	You are given a digit string S and a positive integer integer X. We want to select a non-empty contiguous substring of S such that:
	The substring does not begin with the digit '0'.
	When you convert it to a number, its value is strictly greater than X.
	Two ways of selecting a substring are different if they begin or end at a different index.
	Compute and return the number of ways in which we can select a substring with the above properties.

Definition
Class:	DigitStringDiv2
Method:	count
Parameters:	String, int
Returns:	int
Method signature:	int count(String S, int X)
(be sure your method is public)

Constraints
-	S will contain between 1 and 9 characters, inclusive.
-	Each character of S will be a digit ('0'-'9').
-	X will be between 0 and 777,444,111, inclusive.

Examples
0)	"0"
1
Returns: 0

1)	"10"
9
Returns: 1

2)	"471"
47
Returns: 2
We can select either the substring "471" or the substring "71".

3)	"2222"
97
Returns: 3
We can select the entire string S ("2222"). We also have two different ways to select the string "222": either we choose the first three or the last three characters of S
"""
def count(S, X) :
    totalGreaterSubstrings = 0
    for i in range(len(S)) :
        for j in range(i, len(S)) :
            if S[i:j+1][0]!='0' :
                if int(S[i:j+1]) > X :
                    totalGreaterSubstrings = totalGreaterSubstrings + 1
    return totalGreaterSubstrings

print(count('20463', 0))
print(count('000000000', 777444111))
print(count('289775158', 40240))
