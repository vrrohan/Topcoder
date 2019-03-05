"""
Problem Statement for BichromeBoard
Problem Statement
    	We have a rectangular board divided into a grid of unit squares. We are going to color each square either white or black.
		You are given the String[] board. Each character in board represents one unit square. If board[i][j] is 'B', the corresponding square must be black.
		If board[i][j] is 'W', the corresponding square must be white. Finally, if board[i][j] is '?', you get to choose the color for this square: either white or black.
		Two squares are adjacent if they share a common side. We want to color the board in such a way that no two adjacent squares share the same color.
		Return "Possible" (quotes for clarity) if it can be done, or "Impossible" otherwise.

Definition
Class:	BichromeBoard
Method:	ableToDraw
Parameters:	String[]
Returns:	String
Method signature:	String ableToDraw(String[] board)
(be sure your method is public)

Constraints
-	board will contain between 1 and 50 elements, inclusive.
-	Each element in board will contain between 1 and 50 characters, inclusive.
-	Each element in board will contain the same number of characters.
-	Each character in board will be one of 'W', 'B', '?'.

Examples
0)
{"W?W",
 "??B",
 "???"}
Returns: "Possible"
The solution is:
WBW
BWB
WBW

1)	{"W??W"}
Returns: "Impossible"
The four possible colorings of this board are WWWW, WWBW, WBWW, and WBBW.
In each of them there is at least one pair of adjacent squares that share the same color.
Thus, there is no way to get a pattern with the desired property.

2)	{"??"}
Returns: "Possible"
There are 2 ways: WB and BW

3)
{"W???",
 "??B?",
 "W???",
 "???W"}
Returns: "Possible"

4)
{"W???",
 "??B?",
 "W???",
 "?B?W"}
Returns: "Impossible"

5)	{"B"}
Returns: "Possible"
"""

def ableToDraw(board) :
    isBichromeBoardPossible = "Possible"
    if (len(board)>=1) :
        for i in board :
            rowString = str(i)
            firstIndexofWhite = rowString.index('W') if ('W' in rowString) else -1
            firstIndexofBlack = rowString.index('B') if ('B' in rowString) else -1
            #when white color is at even position
            if (firstIndexofWhite>=0 and firstIndexofWhite%2==0) :
                #check if any even contains black
                for ch in range(0, len(rowString), 2) :
                    if rowString[ch]=='B' :
                        isBichromeBoardPossible = "Impossible"
                        break
                #check if any odd contains white
                for ch in range(1, len(rowString), 2) :
                    if rowString[ch]=='W' :
                        isBichromeBoardPossible = "Impossible"
                        break
            #when white color is at odd position
            elif (firstIndexofWhite>=0 and firstIndexofWhite%2==1) :
                #check if any odd contains black
                for ch in range(1, len(rowString), 2) :
                    if rowString[ch]=='B' :
                        isBichromeBoardPossible = "Impossible"
                        break
                #check if any even contains white
                for ch in range(0, len(rowString), 2) :
                    if rowString[ch]=='W' :
                        isBichromeBoardPossible = "Impossible"
                        break
            #when black color is at even position
            if (firstIndexofBlack>=0 and firstIndexofBlack%2==0) :
                 #check if any even contains white
                 for ch in range(0, len(rowString), 2) :
                     if rowString[ch]=='W' :
                         isBichromeBoardPossible = "Impossible"
                         break
                 for ch in range(1, len(rowString), 2) :
                     if rowString[ch]=='B' :
                        isBichromeBoardPossible = "Impossible"
                        break
            #when black color is at odd position
            elif (firstIndexofBlack>=0 and firstIndexofBlack%2==1) :
                #check if any odd contains white
                for ch in range(1, len(rowString), 2) :
                    if rowString[ch]=='W' :
                        isBichromeBoardPossible = "Impossible"
                        break
                for ch in range(0, len(rowString), 2) :
                    if rowString[ch]=='B' :
                        isBichromeBoardPossible = "Impossible"
                        break
    return isBichromeBoardPossible

board = ["W???", "??B?", "W???", "?B?W"]
board2 = ["W???", "??B?", "W???", "???W"]
board3 = ["W??W"]
board4 = ["B?B???BW?WBW", "??WBWB?BWB??", "BW?W?WB??W?W", "WBWBWB??WB?B", "BWB???B?????", "???B?B?B?B?B", "?W?W?WB?B???", "??WBW?W?WBW?", "?W?WBWB?B???", "?B??WB?BWB??", "BW????B?B?BW", "WBW???W?W???",
            "??BWB?BWBW?W", "?BW?WB??W?W?", "?????W??BW??", "WB?BW?W?W???", "??B??WB???B?", "?B??WBW?????", "?W?????W???W", "???B?B?BW?W?", "B?BW???W?W?W", "?????BW?WB??", "?W?W?W??B???", "?B?BWBW?W???",
            "?WB???BWBW??", "WBW?W??B??WB", "??BWB?BW?W?W", "WBWB?B?BW?WB", "?WB???????BW", "??WB?B?BWB??", "BW?W?W???WB?", "WBW????BWBWB"]
board5 = ["W?????WBW??????", "?????WB?????BW?", "?B???????B???BW", "???W???????????", "?????B??W????B?", "B??????W???WB??", "????W??B??W????", "??????B???B????", "????WBW???W??B?", "?W?????W?W?????", "????WB?????B???"]
board6 = ["BW?WBWBWBWBWBWBWBWBWBWBWBWBWBWBWBW", "??WB?BW??BWBWBWBWBWBWBWBWBWBB?WWWB", "BWBWBWBWBWBWBWBWBWBWBWB?BBBWBWBWBW", "WBWB?B?BWBWBWBW?WBWBWBWBWBWBWBWBWB", "BWBW?WBWBWBWBWBWBWBWBWBWBWBWBWBWBW",
            "WBWBWW?BWBWB?BWB?BWB?BWBWBWBWBBBW?", "BBBWBWBWWWBWBWBWBWBWBWBWBWBWBWBWBW", "WBWBWBWWWBWBWBWBWBW?WBWBWBBBWBWBWB", "BWBWB?BW?WBWBWBWBWBWBWBWBWBWBWBWB?", "WBWBWB?BWBWB?BWBWB?B?BWBWBWBWBWBWB",
            "BWBWBWBWBWBWBWB?BWBWBWBWBWBWBWBWBW", "WBWWWBWBWBWB?BWBBBWBWBWBWBWBWBWBWB", "BWBWBWBWBWBWBW?WBW?WBWBW?WBWWWB??W", "WB?B?WWBWBWBWBWBWBWBWBWBWBWBWBWBWB", "BWBWBWBWBWBWB?BWBWBWBWBW?WBWBWBWBW",
            "WBWBBBWB?BWBWBWBBBWBWBBBWWW?WBWBWB", "BWBWBWWWWWBWBWBWBWBWBWBWBWBWBWBWBW", "WBWB?WWBWBWB?BWWWBWBWBWBWBWBBBWBWB", "BWBWB?BWBWBWBWBWBWBWBW?WBB??BWBWBW", "WBWBWB?BW?WBWBWBW?WBWBWBWBWBW?BBW?",
            "BWBW?WBBBWB?BWBWBWBWBWBWBWBW?W??BW", "WBWBWBWBWBW?WBWBWBWBWBWBWB?BWBWBWB", "BWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBWBW", "WBWBWBWBWBWBWBWBBB?BW?WBWBWBWBBBWB", "BWBW?W?WBWBWBWBWBWBBBWBWBWBWBWBWBW",
            "WBWBWBWBWBW?WBW?WBWBWBBBW?WBW?WBWB", "B?BWBW?WBBBWBWBWBWBWBWBW?WBWWWBWBW", "WBWBWBWBW?WB?BWBWBWBWBBBWBWB??WBWB", "BWBW??BWBWBWBWBWB?WWBWBWBWBWBWBWBW", "WBWBBBWBWBWBWBWB?BWBWBWBWB?BWBWBWB",
            "BWBWBWBWBWBWBWB?BWBWBWBWBWBWBWBWBB"]
print(ableToDraw(board6))
