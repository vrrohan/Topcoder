package PracticeArena.Easy;

/*
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
*/

import java.util.ArrayList;

public class SRM666DevuAndGame {

	public static String canWin(int[] nextLevel) {
		int current = 0;
		ArrayList<Integer> nodesVisited = new ArrayList<Integer>();
		nodesVisited.add(0);

		String gameResults = "Lose";
		while (current != -1) {
			current = nextLevel[current];

			if (nodesVisited.contains(current)) {
				gameResults = "Lose";
				break;
			} else {
				gameResults = "Win";
				nodesVisited.add(current);
			}
		}

		return gameResults;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(canWin(new int[] { 29, 33, 28, 16, -1, 11, 10, 14,
		// 6, 31, 7, 35, 34, 8, 15, 17, 26, 12, 13,
		// 22, 1, 20, 2, 21, -1, 5, 19, 9, 18, 4, 25, 32, 3, 30, 23, 10, 27 }));
		System.out.println(canWin(new int[] { 42, 5, 26, 18, 13, 21, 25, 12, 31, 19, 24, 27, 17, 45, 46, 23, 15, 35, 39,
				22, 47, 36, 47, 30, 37, 11, 16, 2, 9, 43, 7, 14, 29, 1, 48, 8, 10, 32, 3, 34, 6, 4, 33, 44, 40, 28, 20,
				38, 41 }));
	}

}
