"""
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
"""
def getWinner(events) :
    uniqueEvents = set(events)
    maxSolvedContest = -1
    winner = 0
    minSolvedIndex = len(events)
    for i in uniqueEvents :
        freq = events.count(i)
        if freq > maxSolvedContest :
            maxSolvedContest = freq
            #To get last index - reverse the list, find its first occurence & then subtract with length of list -1 becus indexing starts with 0
            minSolvedIndex = len(events) - 1 - (events[::-1].index(i))
            winner = i
        elif freq == maxSolvedContest :
            currentLastIndex = len(events) - 1 - (events[::-1].index(i))
            if currentLastIndex < minSolvedIndex :
                minSolvedIndex = currentLastIndex
                maxSolvedContest = freq
                winner = i
    return winner

events = [473291, 868039, 954486, 232444, 954486, 151426, 984045, 10123, 322439, 530269, 274094, 10123,
				364754, 73740, 727540, 473291, 322439, 643151, 727540, 73740, 991, 530269, 124801, 746351, 746351,
				419846, 13986, 705833, 364754, 997267, 705833, 124801, 13986, 10123, 232444, 727540, 151426, 13986,
				274094, 73740, 868039, 419846, 991, 151426, 643151, 746351, 954486, 364754, 997267, 984045]
print(getWinner(events))
