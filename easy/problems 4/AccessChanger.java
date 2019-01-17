package PracticeArena.Easy;

/*
Problem Statement

You are converting old code for a new compiler version. Each "->" string should be replaced by ".", but this replacement shouldn't be done inside comments. 
A comment is a string that starts with "//" and terminates at the end of the line.
You will be given a program containing the old code. Return a containing the converted version of the code.

Definition
Class: AccessChanger
Method: convert
Parameters: String[]
Returns: String[]
Method signature: String[] convert(String[] program)
(be sure your method is public)

Limits
Time limit (s): 840.000
Memory limit (MB): 64

Constraints
- program will have between 1 and 50 elements, inclusive.
- Each element of program will contain between 1 and 50 characters, inclusive.
- Each character in program will have ASCII value between 32 and 127, inclusive.

Examples
0) {"Test* t = new Test();", "t->a = 1;", "t->b = 2;", "t->go(); // a=1, b=2 --> a=2, b=3"}
Returns: {"Test* t = new Test();", "t.a = 1;", "t.b = 2;", "t.go(); // a=1, b=2 --> a=2, b=3" }

1) {"---> // the arrow --->", "---", "> // the parted arrow"}
Returns: {"--. // the arrow --->", "---", "> // the parted arrow" }

2) {"->-> // two successive arrows ->->"}
Returns: {".. // two successive arrows ->->" }
 */

public class AccessChanger {

	public static String[] convert(String[] program) {
		String[] convertedProgram = new String[program.length];
		
		for(int i=0; i<program.length; i++) {
			String line = program[i];
			if(line.startsWith("//")) {
				convertedProgram[i] = line;
			}
			else if(line.contains("//") && (line.indexOf("//")>line.indexOf("->"))) {
				String subString = line.substring(0, line.indexOf("//"));
				subString = subString.replaceAll("->", ".");
				String finalLine = subString + line.substring(line.indexOf("//"));
				convertedProgram[i] = finalLine;
			}
			else if(!line.contains("//")) {
				convertedProgram[i] = line.replaceAll("->", "."); 
			}
		}
		return convertedProgram;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] prog = {"Test* t = new Test();", "t->a = 1;", "t->b = 2;", "t->go(); // a=1, b=2 --> a=2, b=3"};
		String[] prog2 = {"->-> // two successive arrows ->->"};
		String[] prog3 = {"--->// the arrow--->", "---", "> // the parted arrow"};
		
		String[] convertedProg = convert(prog3);
		for(String con:convertedProg) {
			System.out.println(con);
		}
	}

}
