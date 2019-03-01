package PracticeArena.Easy;

public class SRM652ValueOfString {

	public static int findValue(String s) {
		int stringValue = 0;
		
		for(int i=0; i<s.length(); i++) {
			int codePoint = s.codePointAt(i) % 96;
			int minSmallChars = 0;
			for(int j=0; j<s.length(); j++) {
				if(s.charAt(i)>=s.charAt(j)) {
					minSmallChars++;
				}
			}

			stringValue += (codePoint * minSmallChars);
		}
		return stringValue;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findValue("babca"));
		System.out.println(findValue("zz"));
		System.out.println(findValue("y"));
		System.out.println(findValue("thequickbrownfoxjumpsoverthelazydog"));
		System.out.println(findValue("zyxwvutsrqponmlkjihgfedcba"));
	}

}
