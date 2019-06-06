"""
Problem Statement

	Devu loves to play games. This problem is about a game he recently played. In the game there are n locations, numbered 0 through n-1. Each location has one entrance and one exit. You are given a int[] nextLevel with n elements. For each i, nextLevel[i] describes the exit from location i. If nextLevel[i] is a number between 0 and n-1, inclusive, it means that the exit from location i leads to the entrance of location nextLevel[i].
	Otherwise, nextLevel[i] will be -1 and it means that if the player reaches this exit, they win the game.
	Devu started the game by entering location 0. Return "Win" (quotes for clarity) if he can win the game. Otherwise, return "Lose". Note that the return value is case-sensitive.

Definition
Class:	DevuAndGame
Method:	canWin
Parameters:	int[]
Returns:	String
Method signature:	String canWin(int[] nextLevel)
(be sure your method is public)

Constraints
-	nextLevel will have between 1 and 50 elements, inclusive.
-	Each element in nextLevel will be either -1 or will be between 0 and n - 1, inclusive.

Examples
0)	{1, -1}
Returns: "Win"
Devu will start in location 0. The exit from this location will bring him to location 1, and when he reaches the exit from location 1 he wins the game.

1)	{1, 0, -1}
Returns: "Lose"
Devu will go back and forth between locations 0 and 1. He is unable to reach the exit from location 2.

2)	{0, 1, 2}
Returns: "Lose"
The exit from location 0 leads back to location 0. Devu is unable to reach the other locations.

3)	{29,33,28,16,-1,11,10,14,6,31,7,35,34,8,15,17,26,12,13,22,1,20,2,21,-1,5,19,9,18,4,25,32,3,30,23,10,27}
Returns: "Win"
There can be multiple x such that nextLevel[x] is -1. In order to win the game, Devu has to reach any single location with this property.

4)	{17,43,20,41,42,15,18,35,-1,31,7,33,23,33,-1,-1,0,33,19,12,42,-1,-1,9,9,-1,39,-1,31,46,-1,20,44,41,-1,-1,12,-1,36,-1,-1,6,47,10,2,4,1,29}
Returns: "Win"

5)	{3, 1, 1, 2, -1, 4}
Returns: "Lose"
In this game, Devu will go from location 0 to location 3, from there to location 2, and from there to location 1. There he will get stuck, as the exit from location 1 leads back to location 1.
"""
def canWin(nextLevel) :
    current = 0
    nodesVisited = [0]
    gameResults = "Lose"
    while current!=-1 :
        current = nextLevel[current]
        if current in nodesVisited :
            gameResults = "Lose"
            break
        else :
            gameResults = "Win"
            nodesVisited.append(current)
    return gameResults

print(canWin([15, 10, 18, 36, 32, 38, 2, 4, 21, 33, 12, 13, -1, 30, 44, -1, 28, 19, 25, 14, 42, 22, 27, 7, 3, 41, 5, 46, 17, 26, 40, 20, 37, 34, 23, 43, 11, 45, 6, 16, 9, 31, 35, 39, 1, 29, 24]))
print(canWin([17, 36, 12, -1, 49, -1, -1, -1, 15, 46, 2, -1, -1, 12, 11, -1, 2, 36, -1, 23, -1, -1, 19, -1, 4, -1, -1, 31, -1, 37, 11, 30, -1, -1, -1, 17, 47, 36, 17, 37, 17, -1, -1, 40, 44, 9, 44, 22, -1, 45]))
print(canWin([1, 15, 1, -1, 10, 14, 3, 10, 7, 14, 10, 4, 14, 11, 3, 19, 16, 18, 19, 19, 16, 15]))
