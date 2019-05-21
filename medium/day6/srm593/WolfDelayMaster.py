"""
Problem Statement for WolfDelaymaster
Problem Statement

    	Wolf Sothe is playing the game Delaymaster. In this game, he can create new words according to the following rules:
		For each positive integer n, the string which consists of n copies of 'w', then n copies of 'o', then n copies of 'l', and finally n copies of 'f' is a valid word.
		The concatenation of two valid words is a valid word. Only the words that can be obtained by rules 1 and 2 are valid. There are no other valid words. Thus, for example:

		By rule 1, "wolf", "wwoollff", and "wwwooolllfff" are valid words.
		Then, by rule 2, "wolfwwoollff" is a valid word.
		By applying rule 2 twice, "wolfwwoollffwolf" is a valid word.
		The string "wfol" is not a valid word (order matters).
		The string "wwolfolf" is not a valid word (we can only concatenate, not insert one word into another).
		The string "wwwoolllfff" is not a valid word (only two 'o's instead of three).
		You are given a String str. Return "VALID" if str is a valid word and "INVALID" otherwise. Note that the return value is case-sensitive: you must return the strings "VALID" and "INVALID" in all-uppercase.

Definition
Class:	WolfDelaymaster
Method:	check
Parameters:	String
Returns:	String
Method signature:	String check(String str)
(be sure your method is public)

Constraints
-	str will contain between 1 and 50 characters, inclusive.
-	Each character in str will be 'w', 'o', 'l' or 'f'.

Examples
0)	"wolf"
Returns: "VALID"
The first valid word from the examples in the problem statement.

1)	"wwolfolf"
Returns: "INVALID"
The second invalid word from the examples in the problem statement.

2)	"wolfwwoollffwwwooolllfffwwwwoooollllffff"
Returns: "VALID"

3)	"flowolf"
Returns: "INVALID"
"""
def check(strings) :
    isValidWord = "VALID"
    word = str(strings)
    if (not word.startswith('w') or not word.endswith('f') or len(word)%4!=0 or
        'wl' in word or 'wf' in word or 'of' in word or 'ow' in word or 'lw' in word or
        'lo' in word or 'fo' in word or 'fl' in word) :
        isValidWord = "INVALID"
    else :
        freqChars = list(word)
        index = 0
        while index < len(freqChars) :
            countWolf = [0, 0, 0, 0]
            while (index<len(freqChars) and freqChars[index]=='w') :
                index = index + 1
                countWolf[0] = countWolf[0] + 1
            while (index<len(freqChars) and freqChars[index]=='o') :
                index = index + 1
                countWolf[1] = countWolf[1] + 1
            while (index<len(freqChars) and freqChars[index]=='l') :
                index = index + 1
                countWolf[2] = countWolf[2] + 1
            while (index<len(freqChars) and freqChars[index]=='f') :
                index = index + 1
                countWolf[3] = countWolf[3] + 1
            if countWolf[0]!=countWolf[1] or countWolf[1]!=countWolf[2] or countWolf[2]!=countWolf[3] :
                isValidWord = "INVALID"
                break
    return isValidWord

print(check("wolf"))
print(check("ofolowlwwoowfowlfwowwwowoofoolwlff"))
print(check("wwwooolllfffwwwwwwoooooollllllffffffwwoollff"))
