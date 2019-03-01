/*
problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=14628
Problem Statement
        You are given a positive integer x. Please check whether we can rearrange the digits of x (in base 10, without leading zeros) to produce a different number that is a multiple of x. 
        Return "Possible" if this can be done and "Impossible" otherwise. Note that the return value is case-sensitive.
 
Definition
        
Class:  Permutiple
Method: isPossible
Parameters: int
Returns:    String
Method signature:   String isPossible(int x)
(be sure your method is public)
    
 
Constraints
-   x will be between 1 and 1,000,000, inclusive.
 
Examples
0)  142857
Returns: "Possible"
One valid way of rearranging the digits of 142857 is to form the number 285714. This new number is a multiple of x: we have 285714 = 2 * 142857. 
Another valid way is to form the number 857142 (which is equal to 6 * 142857).

1)  14
Returns: "Impossible"
The only other number we can get by rearranging the digits of the number 14 is the number 41. As 41 is not a multiple of 14, there is no solution.

2)  1035
Returns: "Possible"
We can get 3105 = 3 * 1035.

3)  1000000
Returns: "Impossible"

4)  100035
Returns: "Possible"

5)  4
Returns: "Impossible"
*/

public class Permutiple {

    //this method takes integer & returns String result to tell where number is permutiple or not
    static String isPossible(int num) {
        //converting integer input back to string
        String numString = String.valueOf(num);
        String isPermutiple = "Impossible";

        for(int i=2; i<=9; i++) {
            //1st need to check if num*i has digits greater than input number
            //i.e. if 15 till multiple with 6 is 2 digits i.e. 90 hence can be permutiple. But 15*7 = 105 has 3 digits. hence no need to look furthur & break; 
            if(String.valueOf(num*i).length()>numString.length()) {
                break;
            }
            else {
                //mutiply input integer everytime from 2 till 9 & convert back it to string
                String str2 = String.valueOf(num*i);
                //totalDigits just to count if all digits of integer1 match with all digits of integer2
                int totalDigits = 0;
                for(int j=0; j<str2.length(); j++) {
                    //comparing every digit of resultant integer with input integer
                    //i.e. 1035*3 = 3105 . Hence, if "1035".contains(3), "1035".contains(1), "1035".contains(0), "1035".contains(5) ==> numDigits=4, hence break at this point.  
                    if(numString.contains(String.valueOf(str2.charAt(j)))) {
                        totalDigits++;
                    }
                }
                if(totalDigits==numString.length()) { isPermutiple = "Possible"; break; }
            }
        }
        return isPermutiple;
    }

    public static void main(String[] args) {
        //taking integer number from commandline, which returns input in string form. Hence, need parseInt to convert back to integer
        int num = Integer.parseInt(args[0]);
        System.out.println(num + " permutiple is : " + isPossible(num));
    }
}
