package PracticeArena.Easy;

/*
Problem Statement for PokerRound

Problem Statement
    	
	Two players are playing poker. At the beginning of the game, player 1 had X dollars and player 2 had Y dollars. You know that X and Y were nonnegative integers such that X + Y = 10,000.
	The players have already played three rounds of the game. Each round looked as follows:

		Player 1 bet all the money they had.
		Player 2 called. (That is, they bet the same amount of money.)
		They revealed their hands. Player 1 won and received both bets.
	You are given the int T. Can player 2 have exactly T dollars after the third round of the game? If they cannot, return -1. 
	Otherwise, compute and return Y: the amount of dollars player 2 had in the beginning. (This value is always unique.)

Definition    	
Class:	PokerRound
Method:	amount
Parameters:	int
Returns:	int
Method signature:	int amount(int T)
(be sure your method is public)
    
Notes
-	Player 2 cannot bet money they don't have. For example, X=9000 and Y=1000 is not possible because in the first round of the game player 2 does not have enough money to call player 1's bet.
 
Constraints
-	T will be between 0 and 10,000, inclusive.
 
Examples
0)	2000
Returns: 9000
Here's how the game played out:
In the beginning, player 1 had X = 1000 and player 2 had Y = 9000 dollars.
Player 1 bet 1000, player 2 called, player 1 won. Player 1 got back the 1000 dollars he bet + the 1000 dollars player 2 bet. Thus, after the first round, player 1 has 2000 dollars and player 2 has 8000 dollars.
In the second game player 1 bet 2000, player 2 called, and player 1 won. After round 2 player 1 has 4000 and player 2 has 6000 dollars.
In the third game player 1 bet 4000, player 2 called, and player 1 won again. Thus, at the end of the game player 1 has 8000 and player 2 has T = 2000 dollars.
You are given the value T = 2000 and you are supposed to compute and return the matching value Y = 9000.

1)	10000
Returns: 10000
Player 1 had no money and player 2 had all the money. Then they played three rounds. In each round, player 1 bet 0, player 2 called with 0, and player 1 won 0. Thus, in the end player 2 still has all the money.

2)	1722
Returns: -1
There is no pair (X,Y) such that player 2 ends up with T = 1722 dollars in the end.
*/

public class SRM752PokerRound {

	public static int amount(int T) {
		int initialPlayerTwoAmount = 0;
		int playerOneAmount = 10000 - T;
		int playerTwoAmount = T;
		int rounds = 3;
		while ((rounds--) > 0) {
			if (playerOneAmount % 2 != 0) {
				initialPlayerTwoAmount = -1;
				break;
			} else {
				playerOneAmount = playerOneAmount / 2;
				playerTwoAmount = 10000 - playerOneAmount;
				initialPlayerTwoAmount = playerTwoAmount;
			}
		}
		return initialPlayerTwoAmount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(amount(2789));
	}

}
