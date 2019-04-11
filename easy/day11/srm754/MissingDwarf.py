"""
Problem Statement for MissingDwarf

Problem Statement

One of Snow White's seven dwarves has gone missing! She is sure he will turn up eventually, but she needs to know his height because she is knitting him a sweater.
Here is what she remembers about the heights:

	The missing dwarf is strictly taller than any of the other six dwarves.
	The height of each dwarf is a positive integer.
	The average of all seven heights is also a positive integer.

You are given the int[] otherHeights. The elements of otherHeights are the heights of the other six dwarves. Determine the height of the missing dwarf.
As there are always multiple possibilitities, return the smallest one that matches the information you have. (After all, dwarves are small.)


Definition
Class:	MissingDwarf
Method:	getHeight
Parameters:	int[]
Returns:	int
Method signature:	int getHeight(int[] otherHeights)
(be sure your method is public)


Constraints
-	otherHeights will contain exactly 6 elements.
-	Each element of otherHeights will be between 1 and 1000, inclusive.

Examples
0)	{1,2,3,4,5,6}
Returns: 7
The height of the missing dwarf is 7. (The average height of a dwarf is exactly 4.)

1)	{6,5,4,3,2,1}
Returns: 7
The six heights can be given in any order.

2)	{10,10,20,20,30,30}
Returns: 34
Sometimes some of the six heights given as the input can be equal.

3)	{7,7,7,7,7,7}
Returns: 14
The missing dwarf must be taller than each of the six remaining dwarves.
"""
def getHeight(otherHeights) :
    sumOfAllDwarfHeights = sum(otherHeights)
    missingDwardHeight = max(otherHeights) + 1
    while (sumOfAllDwarfHeights + missingDwardHeight) % 7 != 0 :
        missingDwardHeight = missingDwardHeight + 1
    return missingDwardHeight

dwarfHeights =[1, 2, 3, 4, 5, 6]
dwarfHeights2 = [10, 10, 20, 20, 30, 30]
print(getHeight(dwarfHeights2))
