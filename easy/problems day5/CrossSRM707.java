package PracticeArena.Easy;

/*
Problem Statement for Cross

Problem Statement
    	There is a rectangular board that is divided into n rows by m columns of cells. Each cell is either black or white. You are given the description of the board in the String[] board. Each character in board represents one cell. 
    	More precisely, the character board[i][j] represents the cell at coordinates (row i, column j). 
    	The character '#' represents a black cell, the character '.' is a white cell. You want to find a cross on this board. A cross is a configuration of 5 black cells placed like this: 

 #
###
 #

		Formally, there is a cross centered at (x, y) if the following five cells are all black: (x, y), (x+1, y), (x-1, y), (x, y-1), and (x, y+1). Note that other cells adjacent to the cross may also be black, it is still a valid cross. 
		Return "Exists" if there is at least one cross on the given board. Otherwise, return "Does not exist". Note that the return value is case-sensitive.
 
Definition
Class:	Cross
Method:	exist
Parameters:	String[]
Returns:	String
Method signature:	String exist(String[] board)
(be sure your method is public)
    
Constraints
-	n, m will be between 3 and 50, inclusive.
-	board will contain exactly n elements.
-	Each element in board will contain exactly m characters.
-	Each character in board will be either '#' or '.'.
 
Examples
0)	
 {".##",
 "###",
 "##."}
Returns: "Exist"
There is a cross centered at (1,1).

1)	
 {".##",
 "###",
 "#.."}
Returns: "Does not exist"
This time there is no cross.

2)	
 {"######",
 "######",
 "######",
 "######",
 "######",
 "######",
 "######"}
Returns: "Exist"

3)	
 {".#.#",
 "#.#.",
 ".#.#",
 "#.#."}
Returns: "Does not exist"

4)	
 {".#.#",
 "###.",
 ".###",
 "#.#."}
Returns: "Exist"
 */

public class CrossSRM707 {

	public static String exist(String[] board) {
		String isCrossExist = "Does not exist";

		for (int row = 1; row < board.length - 1; row++) {
			for (int col = 1; col < board[row].length() - 1; col++) {
				if (board[row].charAt(col) == '#' & board[row].charAt(col + 1) == '#'
						& board[row].charAt(col - 1) == '#' & board[row - 1].charAt(col) == '#'
						& board[row + 1].charAt(col) == '#') {
					isCrossExist = "Exist";
					break;
				}
			}
			if (isCrossExist.equals("Exist")) {
				break;
			}
		}

		return isCrossExist;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] board = { "######", "######", "######", "######", "######", "######", "######" };
		String[] board2 = { ".#.#", "#.#.", ".#.#", "#.#." };
		String[] board3 = { ".#.#", "###.", ".###", "#.#." };
		System.out.println(exist(board3));
	}

}
