import java.util.*;
/*
Problem Statement link :- https://community.topcoder.com/stat?c=problem_statement&pm=15138

Problem Statement
    	For this task we have created a simple automated system. It was supposed to ask you a question by giving you a String question.
      You would have returned a String with the answer, and that would be all. Here is the entire conversation the way we planned it:

"Do you want to get accepted?"
"True."
Unluckily for you, a hacker got into our system and modified it by inserting negations into the sentence.
Each negation completely changes the meaning of the question to the opposite one, which means that you need to give us the opposite answer.
Write a program that will read the question and answer accordingly.
More precisely, your program must return either the string "True." if the question you are given has the same meaning as the one shown above or the string "False." if the question has the opposite meaning.

Definition
Class:	GetAccepted
Method:	answer
Parameters:	String
Returns:	String
Method signature:	String answer(String question)
(be sure your method is public)

Notes
-	All strings in this problem are case-sensitive. In particular, make sure the strings your program returns have correct uppercase and lowercase letters, as shown in the statement and examples.

Constraints
-	question will always have the following form: "Do you " + X + "want to " + Y + "get " + Z + "accepted?", where each of X, Y and Z is the concatenation of zero or more copies of the string "not ".
-	question will have at most 1000 characters.

Examples
0)	"Do you want to get accepted?"
Returns: "True."
This is the original question, you should give the original answer.

1)	"Do you not want to get accepted?"
Returns: "False."
This question has the opposite meaning from the original, you should give the opposite answer.

2)	"Do you want to not get accepted?"
Returns: "False."
This is another possible negation of the original question.

3)	"Do you want to get not not accepted?"
Returns: "True."
Two negations cancel each other out. The meaning of this question is the same as the meaning of the original question, so you should answer "True.".

4)	"Do you not want to not get not not not accepted?"
Returns: "False."
*/
public class GetAccepted {

  public static String answer(String question) {
    int numOfNots = 0;
    String[] notArray = question.split("[\\s+?]");
    for(int i=0; i<notArray.length; i++) {
      if(notArray[i].equals("not")) {
        numOfNots++;
      }
    }//for loop ends...
    return (numOfNots%2==0) ? "True" : "False";
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      System.out.print("Enter Question : ");
      String ques = sc.nextLine();
      System.out.println("\n" + answer(ques));
    }
    catch (Exception e) {
      e.printStackTrace();
    }

  }
}
