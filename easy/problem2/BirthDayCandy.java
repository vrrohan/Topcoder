import java.util.*;
/*
Problem Statement link :- https://community.topcoder.com/stat?c=problem_statement&pm=15213

Problem Statement
    Elisa is a primary school student. Tomorrow it's her birthday!  In Elisa's country it is customary that when it's your birthday, you are supposed to bring candy for everyone.
    Hence, Elisa's mother is now taking Elisa to buy a bag of candy for tomorrow.
    Social protocol dictates that candy is always given out to classmates using the following algorithm:

repeat:
    if there is still enough candy for everyone (including you):
        give everyone else one candy
        take one candy for yourself
    else:
        stop (and you get to keep the candy that remained in the bag)
You know that there are K other kids in Elisa's class.
The store carries different brands of candy. You are given their description in the int[] candy. Each element of candy is the number of pieces of candy in one of the bags available at the store.
Find out which bag should Elisa choose if she wants the most candy for herself.
Return the number of pieces of candy she will get to keep if she chooses the bag wisely.

Definition
Class:	BirthdayCandy
Method:	mostCandy
Parameters:	int, int[]
Returns:	int
Method signature:	int mostCandy(int K, int[] candy)
(be sure your method is public)

Constraints
-	K will be between 1 and 50, inclusive.
-	candy will have between 1 and 50 elements, inclusive.
-	Each element of candy will be between 1 and 1000, inclusive.

Examples
0)	9
{23, 7}
Returns: 7
If Elisa buys the bag with 23 candies, the following will happen:
23 is enough to give everyone a candy, so she gives everyone else a candy and then takes one herself.
13 is enough to give everyone a candy, so she gives everyone else a candy and then takes one herself.
3 is no longer enough to give everyone a candy, so she keeps the remaining 3 candies.
In total, she would have 1+1+3 = 5 candies. On the other hand, if she buys the bag with 7 candies, she will get to keep all of them.

1)	1
{1, 2}
Returns: 1
Here it does not matter which bag Elisa buys. In either case she will end with a single candy.

2)	4
{43, 81, 17, 1, 9}
Returns: 17

3)	6
{7}
Returns: 1
*/
public class BirthDayCandy {

  public static int mostCandy(int K, int[] candy) {
    int mostCandies = -1;
    int allCandies = K+1;
    for(int i=0; i<candy.length; i++) {
      int candiesForElisa = candy[i] % allCandies;
      int candiesForOthers = candy[i] / allCandies;
      int totalCandiesForElisa = candiesForElisa + candiesForOthers;
      mostCandies = (totalCandiesForElisa > mostCandies) ? totalCandiesForElisa : mostCandies;
    }
    return mostCandies;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int[] candies = {43, 81, 17, 1, 9};
      int K = 4;
      System.out.println("Maximum number of candies Elisa get are : " + mostCandy(K, candies));
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
