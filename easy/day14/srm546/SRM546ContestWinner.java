package PracticeArena.Easy;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/*
Problem Statement for ContestWinner
Problem Statement
    	
	Exactly one million contestants, numbered 1 through 1,000,000, took part in a programming contest. The rules of the contest are simple: the winner is the contestant who solves the largest number of tasks. 
	If there are more contestants tied for most tasks solved, the winner is the one who was the first to have all of their tasks solved.
	During the contest the judges were keeping a log of all accepted solutions. You are given this log as a int[] events. 
	The i-th element of events is the number of the contestant who submitted the i-th accepted solution (both indices are 0-based).
	For example, if events = {4, 7, 4, 1}, this is what happened during the contest:

Contestant 4 solved her first task.
Contestant 7 solved his first task.
Contestant 4 solved her second task.
Contestant 1 solved his first task.
Compute and return the number of the contestant who won the contest.

Definition    	
Class:	ContestWinner
Method:	getWinner
Parameters:	int[]
Returns:	int
Method signature:	int getWinner(int[] events)
(be sure your method is public)
    
Constraints
-	events will contain between 1 and 50 elements, inclusive.
-	Each element of events will be between 1 and 1,000,000, inclusive.
 
Examples
0)	{4,7,4,1}
Returns: 4
Example from the problem statement.

1)	{10,20,30,40,50}
Returns: 10

2)	{123,123,456,456,456,123}
Returns: 456

3)	{1,2,2,3,3,3,4,4,4,4}
Returns: 4
*/

public class SRM546ContestWinner {

	public static int getWinner(int[] events) {
		// Linked list to store solved problems , so to maintain order of solved
		// problems
		LinkedList<Integer> contestList = new LinkedList<Integer>();
		for (int i = 0; i < events.length; i++) {
			contestList.add(events[i]);
		}

		int maxSolvedContest = -1;
		int winner = 0;
		int miniumIndexSolved = contestList.size();
		// set to store unique contestant
		// so that we can find each unique contestant from the set & no of
		// copies of that contestant in the linkedlist
		HashSet<Integer> uniqueContest = new HashSet<Integer>(contestList);
		Iterator<Integer> iter = uniqueContest.iterator();
		while (iter.hasNext()) {
			Integer con = iter.next();
			int freq = Collections.frequency(contestList, con);
			if (freq > maxSolvedContest) {
				maxSolvedContest = freq;
				miniumIndexSolved = contestList.lastIndexOf(con);
				winner = con;
			} else if (freq == maxSolvedContest) {
				int currentLastIndex = contestList.lastIndexOf(con);
				if (currentLastIndex < miniumIndexSolved) {
					miniumIndexSolved = currentLastIndex;
					maxSolvedContest = freq;
					winner = con;
				}
			}
		}
		return winner;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] events = { 473291, 868039, 954486, 232444, 954486, 151426, 984045, 10123, 322439, 530269, 274094, 10123,
				364754, 73740, 727540, 473291, 322439, 643151, 727540, 73740, 991, 530269, 124801, 746351, 746351,
				419846, 13986, 705833, 364754, 997267, 705833, 124801, 13986, 10123, 232444, 727540, 151426, 13986,
				274094, 73740, 868039, 419846, 991, 151426, 643151, 746351, 954486, 364754, 997267, 984045 };
		System.out.println(getWinner(events));
	}

}
