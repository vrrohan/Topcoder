"""
Problem Statement for SimilarUserDetection
Problem Statement

    	Each competitor on Topcoder must have a handle. Sometimes, different people may choose handles that look too similar to each other. For example, consider the handles "TOPCODER" and "T0PCODER". These two handles are different: the second character in the first handle is the letter 'O' (big oh), while the second character in the second handle is the digit '0' (zero).
		In this problem, all handles are nonempty strings. Each character in a handle must be a letter ('a'-'z', 'A'-'Z') or a digit ('0'-'9'). We will consider two groups of characters that look too similar to each other. The first group are the characters 'O' (big oh) and '0' (zero) mentioned above.
		The second group are the characters '1' (one), 'l' (lowercase ell), and 'I' (uppercase i).
		Strings S and T are called similar if we can change S into T by repeatedly replacing a character by another character from the same group.

		You are given the String[] handles. Return "Similar handles found" if there is at least one pair of similar handles in handles. Otherwise, return "Similar handles not found".
		Note that the quotes are for clarity only and that the return value is case sensitive.

Definition
Class:	SimilarUserDetection
Method:	haveSimilar
Parameters:	String[]
Returns:	String
Method signature:	String haveSimilar(String[] handles)
(be sure your method is public)

Constraints
-	handles will contain between 2 and 50 elements, inclusive.
-	Each element in handles will contain between 1 and 50 characters, inclusive.
-	Each character in handles will be '0'-'9', 'a'-'z' or 'A'-'Z'.

Examples
0)	{"top", "coder", "TOPCODER", "TOPC0DER"}
Returns: "Similar handles found"
"TOPCODER" and "TOPC0DER" are similar.

1)	{"Topcoder", "topcoder", "t0pcoder", "topcOder"}
Returns: "Similar handles not found"
No two of these handles are similar. Note that case matters: the letter 'o' (lowercase oh) is not in the group with 'O' and '0'.

2)	{"same", "same", "same", "different"}
Returns: "Similar handles found"
Any two identical strings are similar.

3)	{"0123", "0I23", "0l23", "O123", "OI23", "Ol23"}
Returns: "Similar handles found"
These six handles are all similar to each other.

4)	{"i23", "123", "456", "789", "000", "o", "O"}
Returns: "Similar handles not found"
"""
def checkHandleContent(handleOne, handleTwo) :
    isHandleContentSimilar = True
    for i in range(len(handleOne)) :
        if ((handleOne[i] == 'O' and handleTwo[i] == '0') or (handleOne[i] == '0' and handleTwo[i] == 'O') or (handleOne[i] == '1' and (handleTwo[i] == 'l' or handleTwo[i] == 'I')) or (handleOne[i] == 'l' and (handleTwo[i] == '1' or handleTwo[i] == 'I')) or (handleOne[i] == 'I' and (handleTwo[i] == '1' or handleTwo[i] == 'l')) or (handleOne[i] == handleTwo[i])) :
            isHandleContentSimilar = True
        else :
            isHandleContentSimilar = False
            break
    return isHandleContentSimilar

def haveSimilar(handles) :
    similarHandles = "Similar handles not found"
    for i in range(len(handles)-1) :
        for j in range(i+1, len(handles)) :
            #If both handles contains same content
            if handles[i]==handles[j] :
                similarHandles = "Similar handles found"
                break
            elif len(handles[i])==len(handles[j]) :
                if(checkHandleContent(handles[i], handles[j])) :
                    similarHandles = "Similar handles found"
                    break
        if similarHandles=="Similar handles found" :
            break
    return similarHandles

print(haveSimilar(["top", "coder", "TOPCODER", "TOPC0DER"]))
print(haveSimilar(["0123", "0I23", "0l23", "O123", "OI23", "Ol23"]))
print(haveSimilar(["10I1OlOIO1IIl0Il0IO000l1IlI1000OI0l1", "OIO00I1IIl0llOlII11110Ol0l", "I1IOI0IIIllllll0lIO0OlOOlO0l0IOl", "O1II01ll0l0lO10lIl01I001OOI00I1lOOl", "I010110O111I01I11111O0IOllIllI10ll0OlIOIO001l", "l1OOO0O0OO101OIIl0", "O0IO1I1I0II01O0O1lOO0OI1101lOIOlI1IllOIOO1lOOlI", "00I", "lO00IIl10IO01OlO110", "I0OIO0IlllI", "110", "1001O", "lIl0100O11l0011OOIO1lOIl1lI0I00I001l", "1IOIIlI0Il", "lIII10OI0lI1I11O01II00l01O00O", "00O1IOl1OO1lI101III11lIOOIOlOlI0l1", "lIlI1000010I0I1I1101IlIOOOl1I0l0l110O1l11Il", "l10ll11lII0OlI0lI1OI0IIIOIll1lIIIOlI0I0lO", "10IOlO1OIO01", "OOll1l100I0IO100OOIIl0OOlIOO01IO0Il10OII", "O1Ill01lllIlIII110I1lI11O0l0llOO0O0II10OOO01l1l01l", "IOIOlIl1IIll0llOl01", "O01OO0IOI00IIIO10lOII0IIIl011O1lIOOIOl1I0Ol", "I0Il01l11OIOO1O0O111lOllO1OI0l0I", "ll11I0OO0O0OOI101OlIIll1lI10O1O0OIlO", "l10lO1O00O100101IOI1OII", "lll11I0IIlI1O001O1l001Ol0l0I00I0IO0I0O01", "00I11I1O0O0IO1O110I00I", "llI1IOOlIlOl0O", "11lO1II0l1OI00O0IIII", "l011O0001OIlI1III0I0Oll01I000OO001OI0I", "OlIIlO1l1O1O0I001O0l11Ol0l1l1", "0IO0I1Il0OOO0I0I0O0IO1l1l0I1O1OIO0ll1IOOI1II", "O", "I0I", "II0lO0OIl1O01OIlIO00l1I1IO1I", "01I", "llO0OOlIIIlOO10l01lO0l0111Il10", "OlO101O1Ol0011IO0OlIll0OIll0I0O0llIlll", "O", "lIO1I1l1110O01lIOO0001IIIO01I11", "lI1100Ol0101lIOII1lIOOIl00lI1I1001O0", "0OO00I1IlllIO0111111111lIO", "OIl11110OO1OOl1II1OO110OIl0", "1II0IlOOI1O0lIOlI0", "1l0II0I1O10Il1lIII1Il0111IO01Ol", "O10110O1l000OII010l1110", "101OIlIl0I10IO0I00II000", "1ll00l1", "O1I0OOOIlIlI"]))
print(haveSimilar(["OOOl100OOl0l01IlOlO1I0IOIl11lO0OI11IllIl11I", "O0l", "I11IIl0OI10lO1ll", "O0lIO00O11O1l0O00l000111lIII1", "00I10lO0OO11lI0", "Ill001lOIOOOlI0I100IIOIO0I0IlO11Il1l", "lOII10llOIOOO0l1I1lOO0l0OlI1lI0Il", "0Olll1l0O01l0OlO10lIOIl1I0OI", "O0IIO00l111l10l0OOl", "Ol01lI1IlO", "101lO01O0O100IlOl11", "1ll00I0I11IlllOO", "00I1OI10Il11IlO0I0l0O10IOII1111IOOl1O1IOll", "1l0OllO1OOl11l001O1", "IOO11l", "O11l0lI111lIlO000l0I00011III", "1OOOll001l1011IO0OIIIlII0111l1Ol1", "I0Il0OO0OO1l00l100lI1IIIlIOO", "01OIllI0lOl1110I1I01l1I10lllO11O1l01l000", "lO0Ill100l", "I11lO1l", "lOI", "lII1IllIIlI1llOOI0Il110II111", "lO0llO", "lI011OO0OOl1I0O", "lOlI0lO0II10lIll1lO00I1O1IOOOOO00010l10IlII", "lIlII1llI1lOOlO", "011IOO11O01000IOOOlOOll", "O00OlI00OI00l00", "l0Oll0I0OO1IOO11O0O00Ol0O", "00ll1I1OI01101l0101IOl0I00O0O01O0I0lO01l0lIlllI0I", "l11OOOIO0Ol1IIll00Il11OOO0OOIl", "l10I0IOlOlOII011I0O10I1111", "lIl", "Il1Ol0l00l", "0Ol0l0II10", "IlOOl1Il1O1OIOO0O0101lOOll11lOO1lO1lI11lI11lI0I0O1", "OOlOlIOIlO1O10I0l1lIO11IlIlO1I0l0l1l", "OllI", "1l1IIOI1IOOOO11", "l00IOl0lI", "l10I0Ol0I0OII0lIOI0lIl0lOlI0ll", "OO10O0O1l0O000O11", "0l0", "IIOOI0Il11lOllOI1OlI101IllI", "llOIOIlO0OOlO0I1O", "1IlI111IIIl10O0OO00l"]))
