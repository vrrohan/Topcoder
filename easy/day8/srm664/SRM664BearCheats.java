package PracticeArena.Easy;

/*
Problem Statement for BearCheats
Problem Statement

    Limak is an old brown bear. Because of his bad eyesight he sometimes has to visit his doctor, Dr. Carrot. Today is one such day.
    Dr. Carrot has a blackboard in his office. There is a number A written on the blackboard. In order to examine Limak's eyesight, Dr. Carrot asked him to read the number.
    Limak couldn't see the number really well. He could determine the number of digits correctly, but he was not sure what the individual digits are.
    Finally, he decided to announce the number B to the doctor. The doctor then left the office for a short while.
    Limak really doesn't want to wear glasses, so he has decided to cheat. As soon as the doctor left the room, Limak went to the blackboard to read the correct number A.
    Before the doctor returns, Limak has the time to change one of the digits of A to any different digit. (Note that he may not add any new digits to A and he may not completely erase any digits of A.
    He may only change at most one of the digits.) Limak hopes that he can deceive the doctor by changing the number A into his number B.

You are given the ints A and B. Return the String "happy" (quotes for clarity) if Limak can convince the doctor that his eyesight is good. Otherwise, return the String "glasses".

Definition
Class:	BearCheats
Method:	eyesight
Parameters:	int, int
Returns:	String
Method signature:	String eyesight(int A, int B)
(be sure your method is public)

Constraints
-	A and B will be between 1 and 999,999, inclusive.
-	A and B will have the same number of digits.

Examples
0)	8072
3072
Returns: "happy"
Limak wants to change 8072 into 3072. He can do that by changing the digit 8 to a 3.

1)	508
540
Returns: "glasses"
Limak would need to change two digits, but he only has the time to change at most one.

2)	854000
854000
Returns: "happy"
It is possible that Limak read the number correctly. If that happens, he will not change any digits.

3)	1
6
Returns: "happy"

4)	385900
123000
Returns: "glasses"
 */

public class SRM664BearCheats {

	public static String eyesight(int A, int B) {
		String isLimakGood = "happy";
		String digOne = String.valueOf(A);
		String digTwo = String.valueOf(B);
		int maxChange = 0;
		for(int i=0; i<digOne.length(); i++) {
			if(digOne.charAt(i)!=digTwo.charAt(i)) {
				maxChange++;
			}
			if(maxChange>1) {
				isLimakGood = "glasses";
				break;
			}
		}
		return isLimakGood;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(eyesight(8072, 3072));
	}

}
