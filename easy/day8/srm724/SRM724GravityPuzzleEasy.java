package PracticeArena.Easy;

/*
Problem Statement for GravityPuzzleEasy
Problem Statement
    	We have a rectangular board divided into unit square cells. The board is mounted on a wall, with rows going horizontally and columns vertically. Each cell contains at most one box.
        You are given the current state of the board in the String[] board. The elements of board describe the rows of the board from top to bottom.
        (I.e., board[0] describes the topmost row of the board, and so on.) The characters of board[r] describe the cells in row r from left to right, with '.' being an empty cell and '#' a cell with a box.
        Due to gravity, each box will fall down: whenever a cell below a box is empty, the box can fall into that cell. Thus, if you have a column with k boxes, those will eventually occupy the bottommost k cells in that column.

Please return a String[] describing the state of the board after all boxes finish falling down.

Definition
Class:	GravityPuzzleEasy
Method:	solve
Parameters:	String[]
Returns:	String[]
Method signature:	String[] solve(String[] board)
(be sure your method is public)

Constraints
-	board will contain between 1 and 50 elements, inclusive.
-	Each element in board will contain between 1 and 50 characters, inclusive.
-	Each element in board will contain the same number of characters.
-	Each character in board will be '.' or '#'.

Examples
0)
{"#",
 ".",
 "."}
Returns: {".", ".", "#" }
This box will fall to the bottom, so we get:
.
.
#

1)
{"##",
 ".#",
 "#."}
Returns: {"..", "##", "##" }
This time we have 2 boxes in each column.

2)
{"..#.#",
 "#.#..",
 "...##"}
Returns: {".....", "..#.#", "#.###" }

3)
{"#####",
 "#####",
 "#####",
 "#####"}
Returns: {"#####", "#####", "#####", "#####" }

4)
{"."}
Returns: {"." }
 */

public class SRM724GravityPuzzleEasy {

	public static String[] solve(String[] board) {
		String[] gravityBoard = new String[board.length];
		int colLen = board[0].length();
		int rowLen = board.length;

		for (int i = 0; i < colLen; i++) {
			String colString = "";
			//Create string column by column i.e. first column 0 string will be created, then column 1 & so on...
			for (int j = 0; j < rowLen; j++) {
				colString = colString + String.valueOf(board[j].charAt(i));
			}

			//Count number of # in a string created by column number
			int countHash = 0;
			for (int index = 0; index < colString.length(); index++) {
				if (colString.charAt(index) == '#') {
					countHash++;
				}
			}

			//Now place that number of # at the end of the string & number of . at begining of string
			String gravityString = "";
			for (int k = 0; k < colString.length(); k++) {
				gravityString = (k < colString.length() - countHash) ? gravityString + "." : gravityString + "#";
			} // for ends...

			//Create & append string column by column i.e. at 0th index, string string default null is present, hence need to simply create new string, else keep on appending the string column by column
			for (int m = 0; m < gravityBoard.length; m++) {
				gravityBoard[m] = (i == 0) ? String.valueOf(gravityString.charAt(m)) : gravityBoard[m] + String.valueOf(gravityString.charAt(m));
			}

		} // main for loop ends...
		return gravityBoard;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] boxes = { "#", ".", "." };
		String[] boxes2 = { "##", ".#", "#." };
		String[] boxes3 = { "..#.#", "#.#..", "...##" };
		String[] boxes4 = { "#####", "#####", "#####", "#####" };
		String[] res = solve(boxes3);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

}
