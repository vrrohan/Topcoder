"""
Problem Statement for PairProduct
Problem Statement
    	Paola has an array of integers. The array is called A and its length is n. The elements of A have indices between 0 and n-1, inclusive.
		Paola's favorite number is the long p. Can Paola multiply two elements of her array to get the product p?
		If there are two (not necessarily distinct) indices i, j into Paola's array such that A[i] * A[j] = p, return the int[] {i, j}. (I.e., a int[] with two elements, the first of which is i and the second of which is j.)
		If there are multiple solutions, you may return any one of them. If there is no solution, return an empty int[] instead.
		In order to keep the input size small, you are not given Paola's array explicitly. Instead, you have to generate it using some very simple pseudocode. You are given the ints n, a0, and step. Generate Paola's array as follows:
A[0] = a0
for i = 1 .. n-1:
    A[i] = A[i-1] + step

Definition
Class:	PairProduct
Method:	findPair
Parameters:	int, int, int, long
Returns:	int[]
Method signature:	int[] findPair(int n, int a0, int step, long p)
(be sure your method is public)

Notes
-	This problem does have general solutions that work for any array A of the given size. Using the special form of the values in the array is not necessary.

Constraints
-	n will be between 1 and 100,000, inclusive.
-	a0 will be between -10^9 and 10^9, inclusive.
-	step will be between -10^9 and 10^9, inclusive.
-	a0 and step will be such that all elements of A will be between -10^9 and 10^9, inclusive.
-	p will be between -10^18 and 10^18, inclusive.

Examples
0)	6
2
5
14
Returns: {0, 1 }
Paola's array is A = {2, 7, 12, 17, 22, 27}. The number 14 is the product of A[0] and A[1]. Note that {1, 0} is also a valid return value.

1)	6
2
5
144
Returns: {2, 2 }
The indices into A don't have to be distinct.

2)	6
2
5
47
Returns: { }
No two elements of this array have the product 47.

3)	6
-200000
-500000
2040000000000
Returns: {2, 3 }
This time Paola's array is {-200000, -700000, -1200000, -1700000, -2200000, -2700000}. The value 2040000000000 is A[2] * A[3]. Watch out for integer overflow.

4)	20
-5
1
-6
Returns: {2, 7 }
The desired product p may be negative. In this case, A = {-5,-4,-3,...,14} and the returned value corresponds to the fact that A[2] * A[7] = (-3) * 2 = (-6). There are other correct answers as well.
"""
def findPair(n, a0, step, p) :
    paolaArray = [a0]
    paolaProductArray = []
    for num in range(1, n) :
        paolaArray.append(paolaArray[num-1] + step)
    for i in range(n) :
        if p%paolaArray[i] == 0 and p/paolaArray[i] in paolaArray :
            paolaProductArray.append(i)
            paolaProductArray.append(paolaArray.index(p/paolaArray[i]))
            break
    return tuple(paolaProductArray)

print(findPair(6, 2, 5, 14))
print(findPair(6, -200000, -500000, 2040000000000))
print(findPair(6, 2, 5, 47))
print(findPair(20, -5, 1, -6))
print(findPair(17, -997868077, 123456789, 729288258927802564))
print(findPair(100000, 452640682, -50, 203444372275878724))
print(findPair(17, -997868077, 123456789, 368534203445232400))
print(findPair(100000, 816367118, -4, 665937782031012100))
print(findPair(100000, -73065678, 50, 4922791315174144))
