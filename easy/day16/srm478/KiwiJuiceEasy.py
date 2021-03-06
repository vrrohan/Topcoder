"""
Problem Statement for KiwiJuiceEasy
Problem Statement
    	Taro has prepared delicious kiwi fruit juice. He poured it into N bottles numbered from 0 to N-1. The capacity of the i-th bottle is capacities[i] liters, and he poured bottles[i] liters of kiwi juice into this bottle.
		Now he wants to redistribute juice in the bottles. In order to do this, he will perform M operations numbered from 0 to M-1 in the order in which he will perform them. For the i-th operation, he will pour kiwi juice from bottle fromId[i] to bottle toId[i].
		He will stop pouring when bottle fromId[i] becomes empty or bottle toId[i] becomes full, whichever happens earlier.
		Return an int[] that contains exactly N elements and whose i-th element is the amount of kiwi juice in the i-th bottle after all pouring operations are finished.

Definition
Class:	KiwiJuiceEasy
Method:	thePouring
Parameters:	int[], int[], int[], int[]
Returns:	int[]
Method signature:	int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId)
(be sure your method is public)

Constraints
-	capacities will contain between 2 and 50 elements, inclusive.
-	Each element of capacities will be between 1 and 1,000,000, inclusive.
-	capacities and bottles will contain the same number of elements.
-	For each i, bottles[i] will be between 0 and capacities[i], inclusive.
-	fromId will contain between 1 and 50 elements, inclusive.
-	fromId and toId will contain the same number of elements.
-	Each element of fromId and toId will be between 0 and N-1, inclusive, where N is the number of elements in capacities.
-	For each i, fromId[i] and toId[i] will be distinct.

Examples
0)	{20, 20}
{5, 8}
{0}
{1}
Returns: {0, 13 }
He pours kiwi juice from bottle 0 to bottle 1. After pouring, bottle 0 will become empty and bottle 1 will contain 13 liters of kiwi juice.

1)	{10, 10}
{5, 8}
{0}
{1}
Returns: {3, 10 }
He will stop pouring when bottle 1 becomes full.

2)	{30, 20, 10}
{10, 5, 5}
{0, 1, 2}
{1, 2, 0}
Returns: {10, 10, 0 }

3)	{14, 35, 86, 58, 25, 62}
{6, 34, 27, 38, 9, 60}
{1, 2, 4, 5, 3, 3, 1, 0}
{0, 1, 2, 4, 2, 5, 3, 1}
Returns: {0, 14, 65, 35, 25, 35 }

4)	{700000, 800000, 900000, 1000000}
{478478, 478478, 478478, 478478}
{2, 3, 2, 0, 1}
{0, 1, 1, 3, 2}
Returns: {0, 156956, 900000, 856956 }
"""
def thePouring(capacities, bottles, fromId, toId) :
    for i in range(len(fromId)) :
        if bottles[fromId[i]] + bottles[toId[i]] < capacities[toId[i]] :
            bottles[toId[i]] = bottles[toId[i]] + bottles[fromId[i]]
            bottles[fromId[i]] = 0
        else :
            bottles[fromId[i]] = bottles[fromId[i]] - (capacities[toId[i]] - bottles[toId[i]])
            bottles[toId[i]] = bottles[toId[i]] + (capacities[toId[i]] - bottles[toId[i]])
    return bottles

print(thePouring([14, 35, 86, 58, 25, 62], [6, 34, 27, 38, 9, 60], [1, 2, 4, 5, 3, 3, 1, 0], [0, 1, 2, 4, 2, 5, 3, 1]))
print(thePouring([995925, 772141], [51609, 382001], [1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0],
    [0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1]))
