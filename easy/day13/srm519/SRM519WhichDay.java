package PracticeArena.Easy;

import java.util.Arrays;
import java.util.List;

/*
Problem Statement for WhichDay
Problem Statement
    	
	This week there will be an important meeting of your entire department. You clearly remember your boss telling you about it. The only thing you forgot is the day of the week when the meeting will take place.
	You asked six of your colleagues about the meeting. None of them knew the day when it will take place, but each of them remembered one day when it will not take place. The days they remembered were distinct. 
	For a clever programmer like you, this was enough to determine the day of the meeting.
	You are given a String[] notOnThisDay containing six weekdays when the meeting will not take place. Return the weekday of the meeting.

Definition    	
Class:	WhichDay
Method:	getDay
Parameters:	String[]
Returns:	String
Method signature:	String getDay(String[] notOnThisDay)
(be sure your method is public)
    
Notes
-	There are seven weekdays. Their names are: "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday".
 
Constraints
-	notOnThisDay will contain exactly 6 elements.
-	Each element of notOnThisDay will be a name of a weekday (in the exact form specified in the Note above).
-	No two elements of notOnThisDay will be equal.
 
Examples
0)	{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"}
Returns: "Saturday"

1)	{"Sunday", "Monday", "Tuesday", "Wednesday", "Friday", "Thursday"}
Returns: "Saturday"

2)	{"Sunday", "Monday", "Tuesday", "Thursday", "Friday", "Saturday"}
Returns: "Wednesday"

3)	{"Sunday", "Friday", "Tuesday", "Wednesday", "Monday", "Saturday"}
Returns: "Thursday"
*/

public class SRM519WhichDay {

	public static String getDay(String[] notOnThisDay) {
		String meetingDay = "";
		String[] weekDays = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		List<String> notMeetingDays = Arrays.asList(notOnThisDay);
		for (int i = 0; i < weekDays.length; i++) {
			if (!notMeetingDays.contains(weekDays[i])) {
				meetingDay = weekDays[i];
				break;
			}
		}
		return meetingDay;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getDay(new String[] { "Sunday", "Friday", "Tuesday", "Wednesday", "Monday", "Saturday" }));
	}

}
