"""
Problem Statement for KerimJavati
Problem Statement

	Kerim Javati is one of the most careless coders in his university. He never knows what to type, and he relies on his friends to tell him when he's wrong. Here is how he types a letter of a command into the computer:
	He types the letter 'a' and looks at his friend. If that is the right letter, the friend nods and Kerim moves on to typing the next letter.
	If the friend shook his head, meaning that 'a' was not the correct letter, Kerim presses backspace to erase the 'a' and he types 'b' instead. Then, he looks at his friend again.
	If 'b' wasn't correct either, he will press backspace to erase it and type 'c'. And so on, through the whole alphabet.
	You are given the String text. Determine the number of keystrokes Kerim will perform while typing this text. Both letters and backspaces count as keystrokes.

Definition
Class:	KerimJavati
Method:	howLong
Parameters:	String
Returns:	int
Method signature:	int howLong(String text)
(be sure your method is public)

Constraints
-	Length of text will be between 1 and 50, inclusive.
-	text will consist of lowercase English letters only ('a'-'z').

Examples
0)	"aaa"
Returns: 3
Kerim will simply press the letter 'a' three times and he will be done.

1)	"d"
Returns: 7
Kerim will make the following sequence of keystrokes: 'a', backspace, 'b', backspace, 'c', backspace, 'd'. The total number of keystrokes is 7.

2)	"bad"
Returns: 11

3)	"topcoder"
Returns: 184

4)	"hajikerim"
Returns: 159
"""

def howLong(text) :
    keyStrokes = 0
    for i in text :
        keyStrokes = (keyStrokes + ((ord(i) - 97) * 2) + 1) if ((ord(i) - 97) != 0) else keyStrokes + 1;
    return keyStrokes

print(howLong("topcoder"))
print(howLong("hajikerim"))
