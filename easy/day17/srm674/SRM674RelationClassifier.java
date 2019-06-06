package PracticeArena.Easy;

/*
Problem Statement for RelationClassifier
Problem Statement
    	
	Weiwei is studying math. Unfortunately, math is very hard for him. Today, the teacher asked Weiwei to determine if a relation is a bijection or not.
	Formally, a relation is a set of ordered pairs of elements. The teacher gave Weiwei one such relation. You are also given a description of this relation: int[]s domain and range. For each valid i, the relation contains the ordered pair (domain[i], range[i]).
	Let X be the set of elements that appear at least once in domain. Similarly, let Y be the set of elements that appear at least once in range. We say that an element x of X is paired to an element y of Y if the relation contains the ordered pair (x, y).
	We will say that our relation is a bijection if each element of X is paired to exactly one element of Y, and each element of Y is paired to exactly one element of X.
	If Weiwei's relation is a bijection, return "Bijection" (quotes for clarity). Otherwise, return "Not". Note that the return value is case-sensitive.

Definition    	
Class:	RelationClassifier
Method:	isBijection
Parameters:	int[], int[]
Returns:	String
Method signature:	String isBijection(int[] domain, int[] range)
(be sure your method is public)
    
Constraints
-	domain will contain between 1 and 10 elements, inclusive.
-	range will contain the same number of elements as domain.
-	Each element of domain and range will be between 1 and 100, inclusive.
-	No two pairs (domain[i], range[i]) will be identical.
 
Examples
0)		
{1, 1}
{2, 3}
Returns: "Not"
Since 1 in X is paired with both 2 and 3 in Y, the given relation is not a bijection.

1)	    	
{4, 5}
{2, 2}
Returns: "Not"
Since both 4 and 5 in X are paired with 2 in Y, the given relation is not a bijection.

2)	    	
{1}
{2}
Returns: "Bijection"
A single ordered pair is always a bijection.

3)	    	
{1, 2, 3, 4, 5}
{1, 2, 3, 4, 5}
Returns: "Bijection"

4)	    	
{14, 12, 10, 13, 20, 18, 9, 17, 14, 9}
{18, 6, 8, 15, 2, 14, 10, 13, 13, 15}
Returns: "Not"
*/

import java.util.stream.IntStream;

public class SRM674RelationClassifier {

	public static String isBijection(int[] domain, int[] range) {
		String isRelationBijection = "Bijection";
		for (int i = 0; i < range.length; i++) {
			final int numRange = range[i];
			final int numDomain = domain[i];
			long rangePair = IntStream.of(range).filter(x -> {
				return x == numRange;
			}).count();
			long domainPair = IntStream.of(domain).filter(x -> {
				return x == numDomain;
			}).count();
			if (rangePair > 1 || domainPair > 1) {
				isRelationBijection = "Not";
				break;
			}
		}
		return isRelationBijection;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isBijection(new int[] { 14, 12, 10, 13, 20, 18, 9, 17, 14, 9 },
				new int[] { 18, 6, 8, 15, 2, 14, 10, 13, 13, 15 }));
		System.out.println(isBijection(new int[] { 50, 51, 52, 53, 54, 55, 56, 57, 58, 59 },
				new int[] { 50, 49, 48, 47, 46, 45, 44, 43, 42, 41 }));
		System.out.println(isBijection(new int[] { 1 }, new int[] { 1 }));
		System.out.println(isBijection(new int[] { 18, 8, 50, 3, 33, 2, 87, 100, 1, 23 },
				new int[] { 29, 58, 83, 31, 75, 95, 29, 34, 58, 62 }));
		System.out.println(isBijection(new int[] { 94, 74, 71, 86, 46, 22, 23, 50, 58, 14 },
				new int[] { 11, 100, 44, 96, 81, 31, 89, 27, 92, 77 }));
	}

}
