package PracticeArena.Easy;

/*
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
*/

public class SRM689SimilarUserDetection {

	private static boolean checkHandleContent(String handleOne, String handleTwo) {
		boolean isHandleContentSimilar = true;
		for (int i = 0; i < handleOne.length(); i++) {
			if ((handleOne.charAt(i) == 'O' & handleTwo.charAt(i) == '0')
					|| (handleOne.charAt(i) == '0' & handleTwo.charAt(i) == 'O')
					|| (handleOne.charAt(i) == '1' & (handleTwo.charAt(i) == 'l' | handleTwo.charAt(i) == 'I'))
					|| (handleOne.charAt(i) == 'l' & (handleTwo.charAt(i) == '1' | handleTwo.charAt(i) == 'I'))
					|| (handleOne.charAt(i) == 'I' & (handleTwo.charAt(i) == '1' | handleTwo.charAt(i) == 'l'))
					|| (handleOne.charAt(i) == handleTwo.charAt(i))) {
				isHandleContentSimilar = true;
			} else {
				isHandleContentSimilar = false;
				break;
			}
		}
		return isHandleContentSimilar;
	}

	public static String haveSimilar(String[] handles) {
		String similarHandles = "Similar handles not found";
		for (int i = 0; i < handles.length - 1; i++) {
			for (int j = i + 1; j < handles.length; j++) {
				// if handles are of similar content, then similar user handles
				// found
				if (handles[i].equals(handles[j])) {
					similarHandles = "Similar handles found";
					break;
				}
				// else if handles are of similar length but content may be
				// different
				else if (handles[i].length() == handles[j].length()) {
					if (checkHandleContent(handles[i], handles[j])) {
						similarHandles = "Similar handles found";
						break;
					}
				}
			}

			if (similarHandles.equals("Similar handles found")) {
				break;
			}
		}
		return similarHandles;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(haveSimilar(new String[] { "top", "coder", "TOPCODER", "TOPC0DER" }));
		System.out.println(haveSimilar(new String[] { "7gJefROEXb1obCbMPJhKUMrBEWaWC", "zOg7Xb382Ul",
				"3MK0TrTqwcVXdakCVTPztmGqW", "9htekCNt1zykmAMOMTkroVZUL6B", "pns0p5y5NhNTfWk1fi129x6Aac",
				"6BikFXnIaDeoz9kdue794f3M9QmvU", "iLWlq81DazDfDnqGrYv4rbO",
				"KSOZzjjuvMkyj2IocwEDhTWMtmZKoeM6FVJAXqqEyvrVS", "hQzwdwAZyW6",
				"5IjQdzi4JRt42ZpnWijuueWbTI6koW9erVD4pcuB5d3CmIhv8x", "wRVSEEUnFNfA2H456AUDfarKJe",
				"3r0tja9k8765BVrLwSu", "kl53SIazm", "AuOwFFfMY45k", "v1USwPSelsDysuRNqrhMFaBqlztD0RpMjNNjVe2w",
				"tJVT1oCRq8NFzCfrntpoFUJ9KmB", "fMuzri01ScGRUlDR5HFaB7gc", "D8bbdwkMAAcQaDjkt6CeG3",
				"fnXVeUAsyzvTCkL7YTk3umRgDI5w", "j5qP58rgRqxDz7Cm5bZb8nn33rvNKSHHD3gmV",
				"yAghCXqDtbti8ArgJFbEbxQ6nfOlRSiOsVLjV5FNYgRLPWZ0z", "zhV9VKt0IdFDaZE5j0wgB5QA4QeS", "MY77orsWhe1rH",
				"d5vltsg7n", "bh8d418N", "AZ8dM9INSlxWL", "MAeOEfzyYlVn0Jd0NvhKkUAby5dq6nSuuiaiyU66pf", "ZpUHbRnCQs1",
				"w0tVWbIWmWNrm6cCgs9QyVK", "lmej2Qb0nU3p0C", "QrURD0",
				"2KKacSDnEOQYIuUNj6eF2v6DY7zes8SijTMxNzxvIwXLsz4", "UvEh84icUlp5Yyr6c06bImNANIOPIsE0vVzV4oFO",
				"Eb104llhM9EdpuiFCNCpC4H", "NiBtZmHhx1FzusNDCdwasHOnC2qROyx9UzmWaESTROyvgYBY",
				"GTYpDmLdgDj7PYN3SiSt2MUbUbjzr9GXxebN", "VpnwyCxS68KQoF", "XO7dJRzPTJ1JMxNLHxLFBTnC3JI2quX80r",
				"0reLEjUgWMbs0VrNe6cfU", "ySfe22BxDhNuTQxYyiofH", "HZMU4PMX0vs4lmmdZ0EdzkE135PeXpHViiylgO1yAj7y" }));
		System.out.println(haveSimilar(new String[] { "IOlIl0I0OOIOlIOOOIO11IlOOI011O101", "l1Il0", "lOlII10OIll11ll1O",
				"OIIIlOI0O1OOIll11I1IlOllIOOO0l1O", "1IOl010lIIOOl0OII0I0I11lO",
				"1I0lI1I0Ol1OOlIlOO0IOOlOlO00OOIl10IOIlIOOO101I10l", "OI1l001OIl10l0OIOIII0l0l0ll1I0Ol1l0OllIO110II1O0",
				"O0O11O0O000OlIIlI0O10I0OO0lO1OlOOIl0", "l", "Il0Ol1lIOOlOOl011OOO1Ill0001lO1lI01lII1IOO01l",
				"O1O1OlII0IOO1III0lO00I0OII0O0l1I01lIO", "Il10ll1l001I11O0OOI0lI0lO1OIl00IIO0OIIOIIIII001Ol1",
				"lll10lIIO000IIlOIl00O01O10IlI0OOl1l11lIlO", "11l0OOl0O0O1OIl0OlII", "O0O1OOOI1I1llIII101OO0I1",
				"0llIO1llllOlOl1l0", "0O0l11O1I0I11ll1IlI1l1lIl0Oll0l0l1O", "O0O0O1IIl1II101l1IlOOlOIIl1O01Ol10lI1I",
				"O0I001lIIOlI11IIOO0l11O11III", "1", "10OI", "010O1I0l1II1lOO1O0lO0III10O0O0O11IO0l0011100llOO",
				"lIl1II0I0Ol1OIIlO1", "OO1II010OlO1I1OI0", "1O001IOlOlOIOl00lIIlII10lIIIO111I0O0Il1OOlOIIIOl", "1I11",
				"11IIOl0OIO00O1011l", "101IO010OIlO1IO1llOI1O00001lIl0II0l0l11I11l",
				"I001IIO1lIOl10lO0O01Il11I11IO0OOOlO11IIll0O0", "l001lOl10Ol0l1Olll0OO10ll1lOOIII00l1",
				"10l11OOO10IIOOOOIOlIl1ll1IIII1lll0OI11OlO", "II1I1Il1lI1I1O00O1Ol1llIl011lOOOIlll",
				"Ill10Ol0O0Illl1llOOl1IllOO1ll1l1l1l1IOI0l01l0l10II",
				"0IlllIl10OlIOIlIl11Il101IlIl0II0l00O1l0llIl0II1Ol0",
				"IO0OII0l0lll00OO1llOl0100llII1O0OOI1Ol110II1O0IO", "IIO00I1OI1OOOOl0lO1ll000Il",
				"Il01lI1IOll0O10lO1IOl1I00I001l1Ol1I001Il0l0O110l", "IlOI111O0IlIllll1ll0IIO10l0llOlI0",
				"l0lI1l00I001lO1I0l1OO1lI1I1IIIlO10IOIlOOI10l0Ill", "II", "l01I0OOI1O00Ol00O1lO10lOlI1OO11",
				"IIOO11001Il", "0I0IlO0lll10IIOlIlO11Oll0000", "100l100II", "lOO1l0l1OlO10IO10lOl00OO00OlOI",
				"0O111IO01O1OlO1lIlIll10O10IO11lO" }));
	}

}
