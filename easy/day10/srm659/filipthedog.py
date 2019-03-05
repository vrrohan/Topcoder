"""
Problem Statement for FilipTheFrog
Problem Statement
    	Filip the Frog lives on a number line. There are islands at some points on the number line. You are given the positions of these islands in the int[] positions.
		Filip starts on the island located at positions[0]. His maximal jump length is L, which means that he can jump to any island that is within a distance of L (inclusive) from his current location.
		Filip can't jump to a point on the number line that doesn't contain an island. He can make an unlimited number of jumps.
		An island is reachable if Filip can get to it through some sequence of jumps. Please find and return the number of reachable islands.

Definition
Class:	FilipTheFrog
Method:	countReachableIslands
Parameters:	int[], int
Returns:	int
Method signature:	int countReachableIslands(int[] positions, int L)
(be sure your method is public)

Notes
-	If two islands are located at points A and B on the number line, then the distance between them is |A - B|.

Constraints
-	positions will contain between 1 and 50 elements, inclusive.
-	Each element of positions will be between 0 and 1000, inclusive.
-	The elements of positions will be distinct.
-	L will be between 1 and 1000, inclusive.

Examples
0)	{4, 7, 1, 3, 5}
1
Returns: 3
Filip starts at position 4 and his maximal jump length is 1. He can reach the islands at positions 3, 4, and 5.

1)	{100, 101, 103, 105, 107}
2
Returns: 5
Here he can reach all 5 islands.

2)	{17, 10, 22, 14, 6, 1, 2, 3}
4
Returns: 7

3)	{0}
1000
Returns: 1
"""
def countReachableIslands(positions, L) :
    maxIslandsJump = 1
    positions = sorted(positions)
    for i in range(1, len(positions)) :
        if ((positions[i]-positions[i-1]) <= L) :
            maxIslandsJump = maxIslandsJump + 1
    return maxIslandsJump

islands = [4, 7, 1, 3, 5]
print(countReachableIslands(islands, 1))
