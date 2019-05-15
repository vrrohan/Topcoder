package PracticeArena.Easy;

public class SRM403TheLargestLuckyNumber {

	public static int find(int n) {
		int number = n;
		boolean getNumber = false;
		if (String.valueOf(n).contains("0") || String.valueOf(n).contains("1") || String.valueOf(n).contains("2")
				|| String.valueOf(n).contains("3") || String.valueOf(n).contains("5") || String.valueOf(n).contains("6")
				|| String.valueOf(n).contains("8") || String.valueOf(n).contains("9")) {
			for (int i = n - 1; i >= 4; i--) {
				String num = String.valueOf(i);
				for (int j = 0; j < num.length(); j++) {
					if (num.charAt(j) != '7' && num.charAt(j) != '4') {
						getNumber = false;
						break;
					} else {
						getNumber = true;
					}
				}
				if (getNumber) {
					number = Integer.parseInt(num);
					break;
				}
			}
		}
		return number;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(find(118467));
	}

}
