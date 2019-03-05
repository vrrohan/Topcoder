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
