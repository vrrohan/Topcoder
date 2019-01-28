"""
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
"""

def solve(board) :
    solvedList = [m*0 for m in board]
    colLength = len(board[0])
    rowLength = len(board)
    for i in range(colLength) :
        colString = ""
        for j in range(rowLength) :
            colString = colString + board[j][i]
        #count number of #
        countHash = colString.count('#')
        gravityString = ""
        for k  in range(len(colString)) :
            gravityString = gravityString + "." if (k<len(colString)-countHash) else gravityString + "#"
        for m in range(len(board)) :
            solvedList[m] = solvedList[m] + gravityString[m]
    return solvedList

boxes = ["..#.#", "#.#..", "...##"]
boxes2 = ["##", ".#", "#."]
boxes3 = ["#", ".", "."]
for box in solve(boxes) :
    print(box)
