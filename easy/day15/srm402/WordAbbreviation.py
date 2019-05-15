"""
Problem Statement for WordAbbreviation
Problem Statement
    	You are given a String[] words, each element of which is a single word. Return a String[] where the i-th element is the abbrevation for the i-th word.
    	The abbreviation for a word is its shortest non-empty prefix that is not a prefix of any other given word.
    	The constraints will guarantee that it is possible to find an abbreviation for all the given words.

Definition
Class:	WordAbbreviation
Method:	getAbbreviations
Parameters:	String[]
Returns:	String[]
Method signature:	String[] getAbbreviations(String[] words)
(be sure your method is public)

Notes
-	A string s1 is called a prefix of string s2 if and only if s1 can be obtained by removing zero or more characters from the end of s2.

Constraints
-	words will contain between 1 and 50 elements, inclusive.
-	Each element of words will contain between 1 and 50 characters, inclusive.
-	Each element of words will only contain lowercase letters ('a'-'z').
-	No element of words will be a prefix of another element of words.

Examples
0)	{"abc","def","ghi"}
Returns: {"a", "d", "g" }
A single character is enough.

1)	{"aaab","aaac","aaad"}
Returns: {"aaab", "aaac", "aaad" }
It's possible that the abbreviation is the same as the original word.

2)	{"top","coder","contest"}
Returns: {"t", "cod", "con" }

3)
{
 "bababaaaaa",
 "baaabaababa",
 "bbabaaabbaaabbabaabaabbbbbaabb",
 "aaababababbbbababbbaabaaaaaaaabbabbbaaab",
 "baaaaabaababbbaabbbabbababbbabbbbbbbbab"
}
Returns: {"bab", "baaab", "bb", "a", "baaaa" }

4)	{"oneword"}
Returns: {"o" }
"""
def getAbbreviations(words) :
    abbreviatedWords = []
    for i in range(0, len(words)) :
        for j in range(0, len(words[i])) :
            slicedWord = words[i][:j+1]
            isWordAbbrAvailable = False
            #check if other words starts with current slicedWord
            for k in range(0, len(words)) :
                if words[k].startswith(slicedWord) and k!=i :
                    isWordAbbrAvailable = True
                    break
            if isWordAbbrAvailable==False :
                abbreviatedWords.append(slicedWord)
                break
    return abbreviatedWords

print(getAbbreviations(["top", "coder", "contest"]))
print(getAbbreviations(["bababaaaaa", "baaabaababa", "bbabaaabbaaabbabaabaabbbbbaabb", "aaababababbbbababbbaabaaaaaaaabbabbbaaab", "baaaaabaababbbaabbbabbababbbabbbbbbbbab"]))
