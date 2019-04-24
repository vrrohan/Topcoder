"""
Problem Statement for EllysTSP
Problem Statement
    	Everybody who has lived in a village knows how expensive the things from the city are. And everybody who has lived in the city knows how expensive the things from the village are. Elly decided to use these observations to make some profit.
    	She will start at some city or village, buy cheap stuff there, go to a place of the opposite type (village if she started in a city, or city if she started in a village) and sell it at a profit there, buying new stuff for the next place (again of the opposite type) and so on.
    	Shortly after she leaves a city or village, the inhabitants realize how she tricked them and get angry at her, so she cannot go to the same place twice.
		Elly cannot predict the actual profits she will make while using this strategy. Therefore she decided that she simply wants to visit as many places as possible.
		Of course, she has to alternate between visiting a village and visiting a city, and she may not visit the same place twice.
		You are given a String places that describes all places Elly can visit. The i-th character of places is 'V' if the i-th place is a village, or 'C' if it is a city.
		Return the maximal number of places she can visit according to the rules above.

Definition
Class:	EllysTSP
Method:	getMax
Parameters:	String
Returns:	int
Method signature:	int getMax(String places)
(be sure your method is public)

Notes
-	Elly can travel directly between any two places.
-	The minimal answer is 1 as she can start by visiting any one of the available places.
-	The answer will never exceed the length of places, since she is not allowed to visit the same place more than once.

Constraints
-	places will contain between 1 and 50 characters, inclusive.
-	Each character of places will be either 'V' or 'C'.

Examples
0)	"CVVVC"
Returns: 5
It is possible to visit all 5 places.
One solution is to start at place 1 (a village), go to place 0 (a city), then to place 2 (a village), place 4 (a city), and finally to place 3 (a village).

1)	"VVV"
Returns: 1
She may start by visiting any of the three villages. As there are no cities, she cannot make any more travels.

2)	"VVVVCVV"
Returns: 3
There is only one city among the places. Elly can go to any of the villages, then go to the city, and then to one of the other villages. Thus, the optimal result is 3.

3)	"CVCVCVC"
Returns: 7
Just visit the locations in the order in which they are given.

4)	"V"
Returns: 1
With only one place there is not much choice what to do.
"""
def getMax(places) :
    #We used list comprehension to filter & create list of cities only, then get its length to calculate total cities
    numberOfCities = len([cityPlaces for cityPlaces in places if cityPlaces=='C'])
    numberOfVillages = len(places) - numberOfCities
    if ((numberOfCities > 0 and numberOfVillages == 0) or (numberOfVillages > 0 and numberOfCities == 0)) :
        return 1
    elif (numberOfCities == numberOfVillages) :
        return (numOfCities + numOfVillages)
    elif ((numberOfCities > numberOfVillages) and (numberOfVillages > 0)) :
        numberOfCities = numberOfVillages + 1
        return (numberOfCities + numberOfVillages)
    else :
        numberOfVillages = numberOfCities + 1
        return (numberOfVillages + numberOfCities)

print(getMax("VVCCCVCCCCCCCVVVVVVVCCVCCCVCCCVCVVCVC"))
print(getMax("CVVCVCVVCVVCCVVCCVVCVVCVCCVVVVCVCCCVCCCVCCCVCVVV"))
