package PracticeArena.Easy;

import java.util.stream.IntStream;

public class FilipTheFrogSRM659 {

	public static int countReachableIslands(int[] positions, int L) {
		int maxIslandsJump = 1;
		int[] sortedIslands = IntStream.of(positions).sorted().toArray();
		for (int islandNumber = 1; islandNumber < sortedIslands.length; islandNumber++) {
			if ((sortedIslands[islandNumber] - sortedIslands[islandNumber - 1]) <= L) {
				maxIslandsJump++;
			}
		}
		return maxIslandsJump;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] islands = { 17, 10, 22, 14, 6, 1, 2, 3 };
		int[] islands2 = { 100, 101, 103, 105, 107 };
		int[] islands3 = { 4, 7, 1, 3, 5 };
		System.out.println(countReachableIslands(islands3, 1));
	}

}
