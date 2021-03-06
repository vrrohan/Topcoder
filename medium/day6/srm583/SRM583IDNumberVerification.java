package PracticeArena.Medium;

/*
Problem Statement for IDNumberVerification
Problem Statement
    	
	This problem statement contains superscripts and/or subscripts. These may not display properly outside the applet.
	In People's Republic of China, every citizen has a unique ID string. The length of the ID is 18 characters. The first 17 characters (called the body code) are all digits, the last character (called the checksum code) can be either a digit or 'X'.
	The body code is then divided into three parts: from left to right, these are the region code, the birthday code, and the sequential code. They look as follows:
	The region code has 6 digits. Some 6-digit strings represent regions, other 6-digit strings are invalid. You are given the valid region codes as a String[] regionCodes.
	The birthday code has 8 digits. It gives the citizen's birthday in the form YYYYMMDD. That is, the first 4 digits is the year of birth, the next 2 is the month (01 to 12, with a leading zero if necessary), and the last 2 digits is the day. When verifying the birthday code, you should consider leap years (see the Notes). Additionally, a valid birthday code must represent a date between Jan 1, 1900 and Dec 31, 2011, inclusive.
	The sequential code has 3 digits. These 3 digits may be arbitrary, with one exception: the sequential code "000" is invalid. If the sequential code represents an odd number (e.g., "007"), the person is a male. Otherwise (e.g., "420") the person is a female.
	The last character of an ID string is the checksum code. This is derived from the first 17 digits. Let a1, a2, ..., a17 denote the body code from left to right. Consider the following modular equation: x + a1*217 + a2*216 + a3*215 + ... + a16*22 + a17*21 = 1 (mod 11). 
	This equation always has exactly one solution x such that 0 <= x <= 10. If x=10, the checksum code is 'X'. Otherwise, the checksum code is the corresponding digit. (E.g., if x=5, the checksum code is '5'.)
	You are given a String id. If this is not a valid ID string, return "Invalid" (quotes for clarity). If id represents a valid ID string of a male citizen, return "Male". Finally, if id represents a valid ID string of a female citizen, return "Female".

Definition    	
Class:	IDNumberVerification
Method:	verify
Parameters:	String, String[]
Returns:	String
Method signature:	String verify(String id, String[] regionCodes)
(be sure your method is public)
    
Notes
-	A year is a leap year if and only if it satisfies one of the following two conditions: A: It is a multiple of 4, but not a multiple of 100. B: It is a multiple of 400. Therefore, 1904 and 2000 are leap years, while 1900 and 2011 are not.
 
Constraints
-	id will be 18 characters long.
-	First 17 characters of id will be between '0' and '9', inclusive.
-	Last character of id will be 'X' or between '0' and '9', inclusive.
-	regionCodes will contain between 1 and 50 elements, inclusive.
-	Each element of regionCodes will be 6 characters long.
-	Each element of regionCodes will consist of characters between '0' and '9', inclusive.
-	For each element of regionCodes, its first character will not be '0'.
-	Elements of regionCodes will be pairwise distinct.
 
Examples
0)	"441323200312060636"
{"441323"}
Returns: "Male"
As you can see, region code, birthday code and sequential code are all valid. So we just need to check the equation of checksum code: 6 + 4*217 + 4*216 + 1*215 + 3*214 + 2*213 + 3*212 + 2*211 + 0*210 + 0*29 + 3*28 + 1*27 + 2*26 + 0*25 + 6*24 + 0*23 + 6*22 + 3*21 = 902276. It's easy to verify that 902276 mod 11 = 1. The sequential code ("063") is odd, thus this is a male.

1)	"62012319240507058X"
{"620123"}
Returns: "Female"

2)	"321669197204300886"
{"610111","659004"}
Returns: "Invalid"
Region code '321669' is invalid.

3)	"230231198306900162"
{"230231"}
Returns: "Invalid"
Birthday code '19830690' is invalid.

4)	"341400198407260005"
{"341400"}
Returns: "Invalid"
Sequential code '000' is invalid.

5)	"520381193206090891"
{"532922","520381"}
Returns: "Invalid"
Checksum code is incorrect.
*/

import java.time.Year;
import java.util.Arrays;
import java.util.List;

public class SRM583IDNumberVerification {

	public static String verify(String id, String[] regionCodes) {

		List<String> regionCodesList = Arrays.asList(regionCodes);
		// first check for region codes is present or not
		boolean validRegionCode = (regionCodesList.contains(id.substring(0, 6).toString())) ? true : false;

		boolean validBirthDate = false;
		// if region code is valid then only check for birth date
		if (validRegionCode) {
			// check for valid birth date
			String dateCheck = id.substring(6, 14);
			int year = Integer.parseInt(dateCheck.substring(0, 4));
			int month = (id.charAt(4) == '0') ? Integer.parseInt(dateCheck.substring(5, 6))
					: Integer.parseInt(dateCheck.substring(4, 6));
			int day = (id.charAt(6) == '0') ? Integer.parseInt(dateCheck.substring(7))
					: Integer.parseInt(dateCheck.substring(6));

			// check for leap year exception case
			if (Year.isLeap(year) && year >= 1900 && year <= 2011) {
				validBirthDate = (month == 2 && day >= 1
						&& day <= 29)
								? true
								: ((month == 4 || month == 6 || month == 9 || month == 11) && day >= 1
										&& day <= 30)
												? true
												: ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8
														|| month == 10 || month == 12) && day >= 1 && day <= 31) ? true
																: false;

			} else if (year >= 1900 && year <= 2011 && !Year.isLeap(year)) {
				validBirthDate = (month == 2 && day >= 1
						&& day <= 28)
								? true
								: ((month == 4 || month == 6 || month == 9 || month == 11) && day >= 1
										&& day <= 30)
												? true
												: ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8
														|| month == 10 || month == 12) && day >= 1 && day <= 31) ? true
																: false;
			}

		}

		String personValidity = "";
		// if birth date is valid, check whether person is male or female
		if (validBirthDate) {
			// if number is odd , then it is male
			personValidity = (Integer.parseInt(String.valueOf(id.charAt(16))) % 2 != 0 && id.charAt(16) != '0') ? "Male"
					: (Integer.parseInt(String.valueOf(id.charAt(16))) % 2 == 0 && id.charAt(16) != '0') ? "Female"
							: (id.charAt(16) == '0') ? "Invalid" : "";
		}

		// calculate equation
		if (!personValidity.equals("Invalid")) {
			int checkSumNumberX = (id.charAt(17) == 'X') ? 10 : Integer.parseInt(String.valueOf(id.charAt(17)));
			long sum = checkSumNumberX;
			int power = 17;
			for (int i = 0; i < id.length() - 1; i++) {
				sum += (Math.pow(2, power--)) * (Integer.parseInt(String.valueOf(id.charAt(i))));
			}
			if ((int) sum % 11 != 1) {
				personValidity = "Invalid";
			}
		}

		return personValidity;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(verify("441323200312060636", new String[] { "441323" }));
		System.out.println(verify("410222196212140076", new String[] { "410222", "610100", "500225", "211100", "450330",
				"340811", "530626", "131081", "450107", "420112" }));
		System.out.println(verify("450226191301030784",
				new String[] { "510901", "445101", "340604", "410801", "450226", "421002", "654002", "430381", "130683",
						"650204", "230112", "640221", "411624", "620824", "640301", "542128", "469029", "430525" }));
		System.out.println(verify("520381193206090891", new String[] { "532922", "520381" }));
	}

}
